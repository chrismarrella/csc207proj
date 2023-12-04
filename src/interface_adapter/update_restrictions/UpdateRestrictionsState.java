package interface_adapter.update_restrictions;

public class UpdateRestrictionsState {
    private String restriction = null;
    private Float value = null;
    private String error = null;
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


    /**
     * Initializes the Constructor for UpdateRestrictionsState.
     * @param copy
     */
    public UpdateRestrictionsState(UpdateRestrictionsState copy) {
        restriction = copy.restriction;
        value = copy.value;
        error = copy.error;
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

    /**
     * Because of the previous copy constructor, the default constructor must be explicit.
     */
    public UpdateRestrictionsState() {

    }

    /**
     * Gets the maxcals.
     * @return The maxcals.
     */
    public Float getMaxcals() {
        return maxcals; }
    /**
     * Sets the maxcals.
     * @param maxcals The maxcals float.
     */
    public void setMaxcals(Float maxcals) { this.maxcals
            = maxcals; }

     /**
     * Gets the mincals.
     * @return The mincals float.
     */
    public Float getMincals() { return mincals; }

    /**
     * Sets the mincals.
     * @param mincals The mincals float.
     */
    public void setMincals(Float mincals) { this.mincals = mincals; }

    /**
     * Gets the maxprotein.
     * @return The maxprotein float.
     */
    public Float getMaxprotein() { return maxprotein; }

    /**
     * Sets the maxprotein.
     * @param maxprotein the max protein float.
     */
    public void setMaxprotein(Float maxprotein) { this.maxprotein = maxprotein; }

    /**
     * Gets the minprotein.
     * @return The minprotein float.
     */
    public Float getMinprotein() { return minprotein; }

    /**
     * Sets the minprotein.
     * @param minprotein the min protein float.
     */
    public void setMinprotein(Float minprotein) { this.minprotein = minprotein; }

    /**
     * Gets the maxfat.
     * @return The maxfat float.
     */
    public Float getMaxfat() { return maxfat; }

    /**
     * Sets the maxfat.
     * @param maxfat The max fat float.
     */
    public void setMaxfat(Float maxfat) { this.maxfat = maxfat; }

    /**
     * Gets the minfat.
     * @return The minfat float.
     */
    public Float getMinfat() { return minfat; }

    /**
     * Sets the minfat.
     * @param minfat The min fat float.
     */
    public void setMinfat(Float minfat) { this.minfat = minfat; }

    /**
     * Gets the maxcarbs.
     * @return The maxcarbs float.
     */
    public Float getMaxcarbs() { return maxcarbs; }

    /**
     * Sets the maxcarbs.
     * @param maxcarbs The max carbs float.
     */
    public void setMaxcarbs(Float maxcarbs) { this.maxcarbs = maxcarbs; }
    /**
     * Gets the mincarbs.
     * @return The mincarbs float.
     */

    public Float getMincarbs() { return mincarbs; }
    /**
     * Sets the mincarbs.
     * @param mincarbs The min carbs float.
     */
    public void setMincarbs(Float mincarbs) { this.mincarbs = mincarbs; }
    /**
     * Gets the keto.
     * @return The keto float.
     */
    public Float getKeto() { return keto; }

    /**
     * Sets the keto.
     * @param keto The keto float.
     */
    public void setKeto(Float keto) { this.keto = keto; }
    /**
     * Gets the vegan.
     * @return The vegan float.
     */
    public Float getVegan() { return vegan; }
    /**
     * Sets the vegan.
     * @param vegan The vegan float.
     */
    public void setVegan(Float vegan) { this.vegan = vegan; }
    /**
     * Gets the vegetarian.
     * @return The vegetarian float.
     */
    public Float getVegetarian() { return vegetarian; }
    /**
     * Sets the vegetarian.
     * @param vegetarian The vegetarian float.
     */
    public void setVegetarian(Float vegetarian) { this.vegetarian = vegetarian; }
    /**
     * Gets the restriction.
     * @return The restriction string.
     */
    public String getRestriction() {return restriction;}
    /**
     * Sets the restriction.
     * @param restriction The restriction string.
     */
    public void setRestriction(String restriction) {this.restriction = restriction;}
    /**
     * Gets the value.
     * @return The value float.
     */

    public Float getValue() {return value;}
    /**
     * Sets the value.
     * @param value The value float.
     */
    public void setValue (Float value)  {this.value = value;}
    /**
     * Gets the error.
     * @return The error string.
     */

    public String getError() {return error;}
    /**
     * Sets the error.
     * @param error The error string.
     */
    public void setError(String error) {this.error = error;}

}
