public class DniException {
    private int number;
    private char letter;

    private char correctLetter(int number) {
        return DniException.LetterForDni(number);
    }
    private static final char[] LETTERS = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X','B', 'N', 'J', 'Z', 'S', 'Q',
            'V', 'H', 'L', 'C', 'K', 'E'};

    public static char LetterForDni(int number) {
        return LETTERS[number%23];
    }

    public DniException() {
        number = 0;
        letter = LETTERS[0];
    }

    public DniException(int number, char letter) {
        this.number = number;
        this.letter =  toUppercase(letter);
        markErrorIfWrong(number, this.letter);
    }

    private void markErrorIfWrong(int number, char letter) {
        if (letter != correctLetter(number)) {
            this.number = -number;
        }
    }

    public DniException(int number) {
        this.number = number;
        letter = correctLetter(number);
    }


    @Override
    public String toString() {
        return number + "" + letter ;
    }

    public String toFormattedString(String s) {
        String numS = "" + number;
        String s1 = "";
        int counter = 0;
        for (int i = numS.length() - 1; i >= 0; i--) {
            s1 = numS.charAt(i) + s1;
            counter ++;

            if (counter == 3) {
                if (i != 0) {
                    s1 = "." + s1;
                    counter = 0;
                }
            }
        }
        s1 = s1 + "-" + letter;
        return s1;
    }

    public DniException(String s) {
        String numberString = s.substring(0, s.length()-1);
        number = Integer.parseInt(numberString);
        letter = s.charAt(s.length()-1);
        letter = toUppercase(letter);
        markErrorIfWrong(number, letter);
    }

    private char toUppercase(char letter) {
        return ("" + letter).toUpperCase().charAt(0);
    }
    public boolean isCorrect() {
        return  number >= 0;
    }
}

