package data_access;

import entities.*;

import java.io.*;
import java.util.*;

public class FileUserDataAccessObject {
    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<Integer, User> accounts = new HashMap<>();

    private UserFactory userFactory;

    public FileUserDataAccessObject(String csvPath, UserFactory userFactory) throws IOException {
        this.userFactory = userFactory;

        csvFile = new File(csvPath);
        headers.put("inventory", 0);
        headers.put("dietaryRestrictions", 1);

        if (csvFile.length() == 0) {
            save();
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
                String row;
                int numUsers = 0;
                while ((row = reader.readLine()) != null) {
                    // set up user object
                    String[] col = row.split(",");
                    Map<String, Boolean> dietaryRestrictions = new HashMap<>();
                    User user = userFactory.create(dietaryRestrictions);

                    // split inventory column like Name:Year:Month:Date:Amount/Name:Year:Month:Date:Amount...
                    // split the rows based on slashes for each element of the queue and then by colon for foodItem
                    String tempInv = String.valueOf(col[headers.get("inventory")]);
                    String[] invItems = tempInv.split("/");

                    for (String item: invItems) {
                        String[] details = item.split(":");
                        FoodItem newItem = new FoodItem(details[0],
                                Integer.parseInt(details[1]),
                                Integer.parseInt(details[2]),
                                Integer.parseInt(details[3]),
                                Integer.parseInt(details[4]));
                        user.addItem(newItem);
                    }

                    // split dietary restrictions column like String:Boolean/String:Boolean...
                    // similar format to inventory
                    String tempRest = String.valueOf(col[headers.get("dietaryRestrictions")]);
                    String[] restItems = tempRest.split("/");

                    for (String item: restItems) {
                        String[] details = item.split(":");
                        user.addRestriction(details[0], Boolean.parseBoolean(details[1]));
                    }
                    this.accounts.put(numUsers, user);
                    numUsers += 1;
                }
            }
        }
    }

    public void save(User user) {
        accounts.put(accounts.size() + 1, user);
        this.save();
    }

    public User get(int userNum) {
        return accounts.get(userNum);
    }

    public List<User> getAllUsers() {
        List<User> res = new ArrayList<>();
        for (int key: accounts.keySet()) {
            res.add(accounts.get(key));
        }
        return res;
    }

    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (User user : accounts.values()) {
                // handle inventory
                StringBuilder inv = new StringBuilder();
                for (FoodItem item : user.getQueue()) {
                    // year/month/day
                    String[] expDate = item.getExpirationDate().split("/");
                    String food = String.format("%s:%s:%s:%s:%s",
                            item.getName(), expDate[0], expDate[1], expDate[2], String.valueOf(item.getAmount()));
                    inv.append(food);
                    inv.append("/");
                }
                inv.deleteCharAt(inv.length() - 1);
                String newInv = inv.toString();

                // handle DietaryRestrictions
                StringBuilder rest = new StringBuilder();
                for (String key : user.getAllKeys()) {
                    String restriction = String.format("%s:%s",
                            key, String.valueOf(user.getRestriction(key)));
                    rest.append(restriction);
                    rest.append("/");
                }
                rest.deleteCharAt(rest.length() - 1);
                String newRest = rest.toString();

                String line = String.format("%s,%s", newInv, newRest);
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
