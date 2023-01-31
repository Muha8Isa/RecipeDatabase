package se.lexicon.recipedatabase.Enum;

public enum Measurement {
    TBSP("table spoon"),
    TSP("tea spoon"),
    G("grams"),
    HG("hectograms"),
    KG("kilograms"),
    ML("millilitre"),
    CL("centilitre"),
    DL("decilitre");

    private String measurement;

    Measurement(String measurement) {
    }

    public String getMeasurement() {
        return measurement;
    }
}
