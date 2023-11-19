package use_case.update_restrictions;

public class UpdateRestrictionsInputData {
    final private Float maxprotein;
    final private Float maxcarbs;
    final private Float maxfats;
    final private Float maxcalories;
    final private Float minprotein;
    final private Float mincarbs;
    final private Float minfats;
    final private Float mincalories;
    final private String fooditem;
    final private Float vegan;
    final private Float vegetarian;
    final private Float keto;

        public UpdateRestrictionsInputData(Float maxprotein, Float minprotein, Float maxcarbs, Float mincarbs,
                                           Float maxfats, Float minfats, Float maxcalories, Float mincalories,
                                           String fooditem, Float vegan, Float vegetarian, Float keto) {
            this.maxcalories = maxcalories;
            this.maxprotein = maxprotein;
            this.maxcarbs = maxcarbs;
            this.maxfats = maxfats;
            this.mincalories = mincalories;
            this.minprotein = minprotein;
            this.mincarbs = mincarbs;
            this.minfats = minfats;
            this.fooditem = fooditem;
            this.vegan = vegan;
            this.vegetarian = vegetarian;
            this.keto = keto;
        }

        public Float getMaxCalories() {
            return maxcalories;
        }

        public Float getMinCalories() {
            return mincalories;
        }

        public Float getMaxProtein() {
            return maxprotein;
        }

        public Float getMinProtein() {
            return minprotein;
        }

        public Float getMaxCarbs() {
            return maxcarbs;
        }

        public Float getMinCarbs() {
            return mincarbs;
        }

        public Float getMaxFats() {
            return maxfats;
        }

        public Float getMinFats() {
            return minfats;
        }

        public String getFooditem() {
            return fooditem;
        }

        public Float getVegan() {
            return vegan;
        }

        public Float getVegetarian() {
            return vegetarian;
        }

        public Float getKeto() {
            return keto;
        }
    }
