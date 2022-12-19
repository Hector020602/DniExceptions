import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            System.out.println( "Enter a DNI");
            String s = input.next();

            DniException dni = new DniException(s);
            if (dni.isCorrect()) {
                System.out.println("DNI is correct");
            } else {
                System.out.println("DNI is wrong");
            }

            System.out.println(dni.toFormattedString(s));
        }
    }

