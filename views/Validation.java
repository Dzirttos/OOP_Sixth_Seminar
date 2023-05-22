package views;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    
    String patternName = "^\\S+$";
    Pattern pattern = Pattern.compile(patternName, Pattern.MULTILINE);

    public boolean checkHeadline(String firstName){
        Matcher matcher = pattern.matcher(firstName);
        return !matcher.find();
    }

    String patternDate = "^\\d{2}.\\d{2}.\\d{4}$";
    Pattern patternSecond = Pattern.compile(patternDate, Pattern.MULTILINE);
    
    public boolean checkDateOfFilling(String date){
        Matcher matcher = patternSecond.matcher(date);
        return !matcher.find();
    }




}
