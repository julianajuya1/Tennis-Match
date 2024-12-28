import java.util.Scanner;

public class TennisMatch {

    private int p1, p2 = 0;

    public TennisMatch(String secuence_match) {
        System.out.println(
                "NOTA IMPORTANTE: \n El programa muestra el transcurso de un juego de tennis, para ello el programa debe recibir una secuencia formada por 'P1' o 'P2' según quien gane cada punto del juego. \n");
        calculateScore(secuence_match);
    }

    private int logicPoints(int point_match) {
        if (point_match < 30) {
            return point_match += 15;
        } else if (point_match == 30) {
            return point_match += 10;
        } else {
            return point_match += 1;
        }
    }

    private void calculateScore(String secuence_match) {
        String[] secuence_split = secuence_match.split(" ");
        for (String point_winner : secuence_split) {
            if (point_winner.equalsIgnoreCase("P1")) {
                p1 = logicPoints(p1);
            } else {
                p2 = logicPoints(p2);
            }
            if (p1 == 41 && p2 == 41) {
                p1 -= 1;
                p2 -= 1;
            }
            if (p1 == 40 && p2 == 40) {
                System.out.println("Deuce");
                if (p1 == 41) {
                    System.out.println("Ventaja P1");
                } else if (p2 == 41) {
                    System.out.println("Ventaja P2");
                } else if (p1 == 42) {
                    System.out.println("");
                    System.out.println("Ha ganado el jugador P1");
                } else if (p2 == 42) {
                    System.out.println("");
                    System.out.println("Ha ganado el jugador P2");
                }
            } else if (p1 < 41 && p2 < 41) {
                if (p1 == 0) {
                    System.out.println("Love - " + p2);
                } else if (p2 == 0) {
                    System.out.println(p1 + " - Love");
                } else {
                    System.out.println(p1 + " - " + p2);
                }
            } else if (p1 >= 40 && p2 < 40) {
                System.out.println("");
                System.out.println("Ha ganado el jugador P1");
            } else if (p1 < 40 && p2 >= 40) {
                System.out.println("");
                System.out.println("Ha ganado el jugador P2");
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner console = new Scanner(System.in)) {
            System.out.println("Escribe la secuencia de puntos del partido actual: ");
            new TennisMatch(console.nextLine());
        }
    }
}