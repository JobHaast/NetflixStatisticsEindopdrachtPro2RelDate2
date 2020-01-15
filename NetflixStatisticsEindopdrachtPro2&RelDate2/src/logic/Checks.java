package logic;

public class Checks {
    private int letterCounter;
    private int spaceCounter;
    private int specialSymbolCounter;
    private String string;

    public Checks(String string) {
        this.string = string;
        letterCounter = 0;
        spaceCounter = 0;
        specialSymbolCounter = 0;
    }


    public void letterCounterUpper() {
        letterCounter++;
    }

    public void spaceCounterUpper() {
        spaceCounter++;
    }

    public void specialSymbolCounterUpper() {
        specialSymbolCounter++;
    }


    public boolean checkIfNotNull() {
        //checks if the string is null, if it is null, it returns false, else it returns true
        return (!(string == null));
    }

    public boolean checkIfLettersOnly() {
        //first it checks if it the string is not null

        //!!!string.checkIfNotNull(); !!!

        // this for-loop counts all the letters, spaces, apostrophes, dashes and dots in a string
        for (int i = 0; i < string.length(); i++) {
            if (Character.isLetter(string.charAt(i))) {
                letterCounterUpper();
            } else if (string.charAt(i) == ' ') {
                spaceCounterUpper();
            } else if (string.charAt(i) == '\'' || string.charAt(i) == '-' || string.charAt(i) == '.') {
                specialSymbolCounterUpper();
            }
        }
        // returns true if the string only consists out of letters, spaces, apostrophes, dashes and dots.
        return (letterCounter + spaceCounter + specialSymbolCounter == string.length());
    }

    public boolean checkIfNumbersOnly() {
        if (string == null) {
            return false;
        }
        for (int i = 0; i < string.length(); i++) {
            if (!Character.isDigit(string.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean checkifPostalCode(String string) {
        return true;
    }

}
