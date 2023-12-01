package interface_adapter.update_restrictions;

public class UpdateRestrictionsState {
    private String restriction = null;
    private Float value = null;
    private String error = null;
    private String success = null;
    private String view_name = null;
    private Float maxcals = null;
    private Float mincals = null;
    private Float maxprotein = null;
    private Float minprotein = null;
    private Float maxfat = null;
    private Float minfat = null;
    private Float maxcarbs = null;
    private Float mincarbs = null;
    private Float keto = null;
    private Float vegan = null;
    private Float vegetarian = null;


    public UpdateRestrictionsState(UpdateRestrictionsState copy) {
        restriction = copy.restriction;
        value = copy.value;
        error = copy.error;
        success = copy.success;
        view_name = copy.view_name;
        maxcals = copy.maxcals;
        mincals = copy.mincals;
        maxprotein = copy.maxprotein;
        minprotein = copy.minprotein;
        maxfat = copy.maxfat;
        minfat = copy.minfat;
        maxcarbs = copy.maxcarbs;
        mincarbs = copy.mincarbs;
        keto = copy.keto;
        vegan = copy.vegan;
        vegetarian = copy.vegetarian;
    }

    public UpdateRestrictionsState() {

    }

    public Float getMaxcals() { return maxcals; }
    public void setMaxcals(Float maxcals) { this.maxcals = maxcals; }

    public Float getMincals() { return mincals; }
    public void setMincals(Float mincals) { this.mincals = mincals; }

    public Float getMaxprotein() { return maxprotein; }
    public void setMaxprotein(Float maxprotein) { this.maxprotein = maxprotein; }

    public Float getMinprotein() { return minprotein; }
    public void setMinprotein(Float minprotein) { this.minprotein = minprotein; }

    public Float getMaxfat() { return maxfat; }
    public void setMaxfat(Float maxfat) { this.maxfat = maxfat; }

    public Float getMinfat() { return minfat; }
    public void setMinfat(Float minfat) { this.minfat = minfat; }

    public Float getMaxcarbs() { return maxcarbs; }
    public void setMaxcarbs(Float maxcarbs) { this.maxcarbs = maxcarbs; }

    public Float getMincarbs() { return mincarbs; }
    public void setMincarbs(Float mincarbs) { this.mincarbs = mincarbs; }

    public Float getKeto() { return keto; }
    public void setKeto(Float keto) { this.keto = keto; }

    public Float getVegan() { return vegan; }
    public void setVegan(Float vegan) { this.vegan = vegan; }

    public Float getVegetarian() { return vegetarian; }
    public void setVegetarian(Float vegetarian) { this.vegetarian = vegetarian; }

    public String getRestriction() {return restriction;}
    public void setRestriction(String restriction) {this.restriction = restriction;}

    public Float getValue() {return value;}
    public void setValue (Float value)  {this.value = value;}

    public String getError() {return error;}

    public void setError(String error) {this.error = error;}

    public String getSuccess() { return success; }

    public void setSuccess(String success) { this.success = success; }

    public void setView_name(String getRecipe) { this.view_name = view_name; }
    public String getView_name() { return view_name;}
}
