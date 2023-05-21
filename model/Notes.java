package model;

public class Notes {
    private String id = "";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String headline;
    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    private String text;
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private String dateOfFilling;

    public String getDateOfFilling() {
        return dateOfFilling;
    }

    public void setDateOfFilling(String dateOfFilling) {
        this.dateOfFilling = dateOfFilling;
    }

    public Notes(String headline, String text, String dateOfFilling) {
        this.headline = headline;
        this.text = text;
        this.dateOfFilling = dateOfFilling;
    }

    public Notes(String id, String headline, String text, String dateOfFilling) {
        this(headline, text, dateOfFilling);
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("Idenification Number: s%, Headlline: s%, Text: s%, Date of filling the note: s%", id, headline, text, dateOfFilling);
    }
}
