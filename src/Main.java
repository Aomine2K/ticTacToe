// A simple program to demonstrate 
// Tic-Tac-Toe Game.
import java.util.*;

public class Main {

    static String[] tablica;
    static String kolej;


    static String checkWinner()
    {
        for (int a = 0; a < 8; a++) {
            String linia = null;

            switch (a) {
                case 0:
                    linia = tablica[0] + tablica[1] + tablica[2];
                    break;
                case 1:
                    linia = tablica[3] + tablica[4] + tablica[5];
                    break;
                case 2:
                    linia = tablica[6] + tablica[7] + tablica[8];
                    break;
                case 3:
                    linia = tablica[0] + tablica[3] + tablica[6];
                    break;
                case 4:
                    linia = tablica[1] + tablica[4] + tablica[7];
                    break;
                case 5:
                    linia = tablica[2] + tablica[5] + tablica[8];
                    break;
                case 6:
                    linia = tablica[0] + tablica[4] + tablica[8];
                    break;
                case 7:
                    linia = tablica[2] + tablica[4] + tablica[6];
                    break;
            }

            if (linia.equals("XXX")) {
                return "X";
            }


            else if (linia.equals("OOO")) {
                return "O";
            }
        }

        for (int a = 0; a < 9; a++) {
            if (Arrays.asList(tablica).contains(
                    String.valueOf(a + 1))) {
                break;
            }
            else if (a == 8) {
                return "Remis";
            }
        }

        // To enter the X Or O at the exact place on tablica.
        System.out.println(
                kolej + " kolej; wybierz cyfre");
        return null;
    }


    static void rysujTablica()
    {
        System.out.println("|---|---|---|");
        System.out.println("| " + tablica[0] + " | "
                + tablica[1] + " | " + tablica[2]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + tablica[3] + " | "
                + tablica[4] + " | " + tablica[5]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + tablica[6] + " | "
                + tablica[7] + " | " + tablica[8]
                + " |");
        System.out.println("|---|---|---|");
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        tablica = new String[9];
        kolej = "X";
        String zwyciezca = null;

        for (int a = 0; a < 9; a++) {
            tablica[a] = String.valueOf(a + 1);
        }

        System.out.println("Witaj w grze Tic-Tac-Toe");
        rysujTablica();

        System.out.println(
                "Gracz X zaczyna, wybierz cyfre aby zajac miejsce:");

        while (zwyciezca == null) {
            int numInput;


            try {
                numInput = in.nextInt();
                if (!(numInput > 0 && numInput <= 9)) {
                    System.out.println(
                            "Nieprawidłowa cyfra; spróbuj ponownie wybrać cyfrę:");
                    continue;
                }
            }
            catch (InputMismatchException e) {
                System.out.println(
                        "Nieprawidłowa cyfra; spróbuj ponownie wybrać cyfrę:");
                continue;
            }


            if (tablica[numInput - 1].equals(
                    String.valueOf(numInput))) {
                tablica[numInput - 1] = kolej;

                if (kolej.equals("X")) {
                    kolej = "O";
                }
                else {
                    kolej = "X";
                }

                rysujTablica();
                zwyciezca = checkWinner();
            }
            else {
                System.out.println(
                        "Miejsce zajęte; spróbuj ponownie wybrać cyfrę:");
            }
        }


        if (zwyciezca.equalsIgnoreCase("draw")) {
            System.out.println(
                    "To był zacięty pojedynek! Gratulacje Remisu");
        }


        else {
            System.out.println(
                    "Gratulacje! " + zwyciezca
                            + " wygrał!");
        }
    }
}