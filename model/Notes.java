package model;

public class Notes {
    private String id = "";
    private String headline;
    private String text;
    private String dateOfFilling;

    public Notes(String headline, String text, String dateOfFilling) {
        this.headline = headline;
        this.text = text;
        this.dateOfFilling = dateOfFilling;
    }


    public Notes(String id, String headline, String text, String dateOfFilling) {
        this(headline, text, dateOfFilling);
        this.id = id;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

   
    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDateOfFilling() {
        return dateOfFilling;
    }

    public void setDateOfFilling(String dateOfFilling) {
        this.dateOfFilling = dateOfFilling;
    }



    @Override
    public String toString() {
        return String.format("Idenification Number: %s\nHeadlline: %s\nText: %s\nDate of filling the note: %s", id, headline, text, dateOfFilling);
    }

}
