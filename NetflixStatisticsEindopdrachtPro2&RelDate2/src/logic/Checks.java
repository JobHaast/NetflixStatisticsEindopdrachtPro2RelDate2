package logic;

public class Checks {

    public static boolean checkIfNotNullOrEmptyString(String string) {
        //checks if the string is null or empty, if it is null or empty it returns false, else it returns true.
        if (string == null) {
            return false;
        }
        return !string.isEmpty();
    }

    public static boolean checkIfLettersOnly(String string) {
        int letterCounter = 0;
        int spaceCounter = 0;
        int specialSymbolCounter = 0;

        // this for-loop counts all the letters, spaces, apostrophes, dashes and dots in a string
        for (int i = 0; i < string.length(); i++) {
            if (Character.isLetter(string.charAt(i))) {
                letterCounter++;
            } else if (string.charAt(i) == ' ') {
                spaceCounter++;
            } else if (string.charAt(i) == '\'' || string.charAt(i) == '-' || string.charAt(i) == '.') {
                specialSymbolCounter++;
            }
        }
        // returns true if the string only consists out of letters, spaces, apostrophes, dashes and dots.
        return (letterCounter + spaceCounter + specialSymbolCounter == string.length());
    }

    public static boolean checkIfNumbersOnly(String string) {
        int digitCounter = 0;
        int spaceCounter = 0;

        // this for-loop counts all the digits and spaces in a string
        for (int i = 0; i < string.length(); i++) {
            if (Character.isDigit(string.charAt(i))) {
                digitCounter++;
            } else if (string.charAt(i) == ' ') {
                spaceCounter++;
            }
        }
        // returns true if the string only consists out of digits and spaces.
        return (digitCounter + spaceCounter == string.length());
    }

    public static boolean checkIfPostalCode(String string) {
        // returns true if the string is a Dutch postalCode, so if the first 4 characters are numbers and the last two are letters.

        boolean check = true;
        for (int i = 0; i < 4; i++) {
            if (!Character.isDigit(string.charAt(i))) {
                check = false;
            }
        }
        if (!(Character.isLetter(string.charAt(4)) && Character.isLetter(string.charAt(5)) || Character.isLetter(string.charAt(5)) && Character.isLetter(string.charAt(6)))) {
            check = false;
        }
        return check;
    }

    public static boolean checkIfCorrectBirthdayFormat(String string) {
        //Checks if The birthday is in a correct format
        if (string.length() < 10) {
            //If the string is smaller than 10 the format is always incorrect
            return false;
        }

        if (!(Character.isDigit(string.charAt(0)) && Character.isDigit(string.charAt(1)) && Character.isDigit(string.charAt(2)) && Character.isDigit(string.charAt(3)))) {
            //The first 4 characters have to be numbers, because they are the birthyear
            return false;
        }

        if ((string.charAt(4) != '-')) {
            //The dash between the year and the month
            return false;
        }

        if (!(Character.isDigit(string.charAt(5)) && Character.isDigit(string.charAt(6)))) {
            //The month exists out of two chars that must be digits
            return false;
        }

        if (!(string.charAt(7) == '-')) {
            //The dash between the month and the day
            return false;
        }

        if (!(Character.isDigit(string.charAt(8)) && Character.isDigit(string.charAt(9)))) {
            //The birthday must always consist of two digits.
            return false;
        }

        if ((Integer.parseInt(String.valueOf(string.charAt(5))) > 1)) {
            //The months first character is always a one or a zero.
            return false;
        }

        if (string.charAt(5) == '0') {
            if ((Integer.parseInt(String.valueOf(string.charAt(6))) == 0)) {
                //If the first character is a 0 the second be any number from 1 to 9 but no 0.
                return false;
            }
        }

        if (string.charAt(5) == '1') {
            if (!(Integer.parseInt(String.valueOf(string.charAt(6))) <= 2)) {
                //If the month starts with a one, the second character can only be a 0, 1 and a 2.
                return false;
            }
        }

        if ((Integer.parseInt(String.valueOf(string.charAt(8))) > 3)) {
            //The month does never start with a number higher than a 3.
            return false;
        }

        if (string.charAt(8) == '0') {
            if (string.charAt(9) == '0') {
                //The Day may not be 00
                return false;
            }
        } else if (string.charAt(8) == '3') {
            if ((Integer.parseInt(String.valueOf(string.charAt(9))) > 1)) {
                //The day can not be larger than 31
                return false;
            }
        }
        return true;
    }

}