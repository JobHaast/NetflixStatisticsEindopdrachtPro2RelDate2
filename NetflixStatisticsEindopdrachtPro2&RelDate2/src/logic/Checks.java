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

    public static boolean checkifPostalCode(String string) {
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
}