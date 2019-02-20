package cz.cvut.fel.pjv;

import java.util.Locale;
import java.util.Scanner;

public class Lab01 {

    public void homework() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Vyber operaci (1-soucet, 2-rozdil, 3-soucin, 4-podil):");

        Integer operationNumber = scanner.nextInt();
        OperationType operation = OperationType.getByNumber(operationNumber);

        if (operation == null) {
            System.out.println("Chybna volba!");
            return;
        }

        System.out.println("Zadej " + operation.opName1 + ": ");

        double a = scanner.nextDouble();

        System.out.println("Zadej " + operation.opName2 + ": ");

        double b = scanner.nextDouble();

        if (operation == OperationType.DIVIDE && b == 0) {
            System.out.println("Pokus o deleni nulou!");
            return;
        }

        System.out.println("Zadej pocet desetinnych mist: ");

        int decimal = scanner.nextInt();
        if (decimal < 0) {
            System.out.println("Chyba - musi byt zadane kladne cislo!");
            return;
        }

        double c = operation.operation.fn(a, b);

        String format = "# %s # = #".replace("#", "%." + decimal + "f");

        System.out.println(String.format(Locale.US, format, a, operation.opChar, b, c));
    }


    enum OperationType {
        ADD((a, b) -> a + b, "+", "scitanec", "scitanec"),
        SUBTRACT((a, b) -> a - b, "-", "mensenec", "mensitel"),
        MULTIPLY((a, b) -> a * b, "*", "cinitel", "cinitel"),
        DIVIDE((a, b) -> a / b, "/", "delenec", "delitel");

        final Operation operation;
        final String opChar;
        final String opName1;
        final String opName2;

        OperationType(Operation op, String opChar, String opName1, String opName2) {
            this.operation = op;
            this.opChar = opChar;
            this.opName1 = opName1;
            this.opName2 = opName2;
        }

        static OperationType getByNumber(int number) {
            try {
                return values()[number - 1];
            } catch (ArrayIndexOutOfBoundsException e) {
                return null;
            }
        }
    }

    interface Operation {
        double fn(double a, double b);
    }
}