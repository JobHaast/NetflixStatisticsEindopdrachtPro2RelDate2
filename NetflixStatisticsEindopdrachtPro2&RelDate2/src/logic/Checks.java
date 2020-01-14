package logic;

public class Checks {
    public boolean checkIfLettersOnly(String string) {
        if (string == null) {
            return false;
        }
        for (int i = 0; i < string.length(); i++) {
            if (!Character.isLetter(string.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean checkIfNumbersOnly(String string) {
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


}
