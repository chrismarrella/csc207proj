# csc207proj

# Problem domain
Food waste management using recommended recipes 

# High-level description
- User inputs groceries and their corresponding expiration dates
- Inputs will be then sent to a database to keep track of user’s current grocery inventory
- The program will receive the classified ingredients from the database, and will identify which grocery items will expire soon
- The program will use those grocery items as a metric to search for recipes that include those items as to minimize food waste
- The program will return a list of recipes that the user can cook using their ingredients and potentially additional items
- The user will also be able to filter recipes by dietary preferences (restrictions, calorie intake, macros, etc.)
- Once the user has selected a recipe, the required ingredients for that recipe will be removed from the database to match the user’s current inventory
- The program will also automatically remove expired grocies from the database and notify the user about their expiration

# Documentation
- [Recipes API](https://spoonacular.com/food-api/docs)

# Screenshot of using Hoppscotch
![alt text](https://github.com/samlukas/csc207proj/blob/main/hoppscotch_screenshot.jpg)

# Example of calling API from Java
![alt text](https://github.com/samlukas/csc207proj/blob/main/api_demo.jpeg)
![alt text](https://github.com/samlukas/csc207proj/blob/main/api_demo_output.jpeg)

# Core Use Case
- Return recipes based on avaliable ingredients and soon to expire ingredients, and user preferences.
