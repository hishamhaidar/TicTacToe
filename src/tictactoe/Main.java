package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

class Main {
    static Scanner scanner = new Scanner(System.in);
    static GameRules rule = new GameRules();

    public static void main(String[] args) {
        int row, column;
        rule.initializeBasicGame(rule.userInputs);
        do {
            try {
                System.out.println("Please enter position");
                System.out.println("[1][2] [1][4] [1][6]\n" +
                        "[2][2] [2][4] [2][6]\n" +
                        "[3][2] [3][4] [3][6]");
                row = scanner.nextInt();
                column = scanner.nextInt();

                if (rule.validCoordinates(row, column)) {
                    rule.changeDrawing(row, column);
                    rule.printGame(rule.userInputs);
                    rule.check(rule.userInputs);
                } else
                    System.out.println("You entered invalid coordinates.Same player retry");
            } catch (InputMismatchException e) {
                System.out.println("No characters allowed");
                scanner.next();
            } catch (Exception e) {
                System.out.println("Enter numbers only please");
                scanner.next();
            }

        } while (!rule.isGameFinished());

    }


}


