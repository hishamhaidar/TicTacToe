package tictactoe;

public class GameRules {
    String[][] userInputs = new String[5][9];
    private boolean gameFinished = false, gameDraw=false,gameWinner=false;
    private String currentLetter = "X";

    public String getCurrentLetter() {
        return currentLetter;
    }

    public void setCurrentLetter(String currentLetter) {
        this.currentLetter = currentLetter;
    }


    public void changeDrawing(int row, int column) {

        if (userInputs[row][column].isBlank())
            userInputs[row][column] = getCurrentLetter();
        else
            System.out.println("sorry current position is occupied by " + userInputs[row][column]);
    }

    public void setGameDraw(boolean gameDraw) {
        this.gameDraw = gameDraw;
    }

    public void setGameWinner(boolean gameWinner) {
        this.gameWinner = gameWinner;
    }

    /*
               for(int i = 1;i<4;i++) {
                  for (int j = 2; j < 7; j += 2)
                  [1][2] [1][4] [1][6]
                  [2][2] [2][4] [2][6]
                  [3][2] [3][4] [3][6]
           */
    public void check(String[][] a) {
        if (isWin(userInputs))
        {
            setGameFinished(true);
            setGameWinner(true);
        }
        else if (isDraw(userInputs))
        {
            setGameFinished(true);
            setGameDraw(true);
        } else {
            if (getCurrentLetter().equals("X"))
                setCurrentLetter("O");
            else if (getCurrentLetter().equals("O")) {
                setCurrentLetter("X");
            }
        }
        if (gameWinner) {
            if (getCurrentLetter().equals("X")) {
                xWin();

            } else if (getCurrentLetter().equals("O")) {
                oWin();

            }


        } else if (gameDraw) {
            draw();
        }


    }

    public void xWin() {
        System.out.println("X has won the game");
    }

    public void oWin() {
        System.out.println("O has won the game");
    }
    public void draw()
    {
        System.out.println("Draw");
    }
    public boolean isGameFinished() {
        return gameFinished;
    }

    public void setGameFinished(boolean gameFinished) {
        this.gameFinished = gameFinished;
    }

    public void initializeBasicGame(String[][] a) {
        for (int i = 0; i < 9; i++) {
            a[0][i] = "-";
            a[4][i] = "-";
        }
        for (int i = 1; i < 4; i++) {
            a[i][0] = "|";
            a[i][8] = "|";
        }
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 8; j++)
                a[i][j] = " ";
        }
    }

    public void printGame(String[][] a) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++)
                System.out.print(a[i][j] + "");
            System.out.println();
        }
    }

    public boolean isDraw(String[][] a){
        return !a[1][2].isBlank() &&
                !a[1][4].isBlank() &&
                !a[1][6].isBlank() &&
                !a[2][2].isBlank() &&
                !a[2][4].isBlank() &&
                !a[2][6].isBlank() &&
                !a[3][2].isBlank() &&
                !a[3][4].isBlank() &&
                !a[3][6].isBlank();

    }
    public boolean validCoordinates(int row, int column) {
        return (row == 1 && column == 2) ||
                (row == 1 && column == 4) ||
                (row == 1 && column == 6) ||
                (row == 2 && column == 2) ||
                (row == 2 && column == 4) ||
                (row == 2 && column == 6) ||
                (row == 3 && column == 2) ||
                (row == 3 && column == 4) ||
                (row == 3 && column == 6);
    }
    public boolean isWin(String[][] a)
    {
        return (a[1][2].equals("X") && a[1][4].equals("X") && a[1][6].equals("X"))
                || (a[2][2].equals("X") && a[2][4].equals("X") && a[2][6].equals("X"))
                || (a[3][2].equals("X") && a[3][4].equals("X") && a[3][6].equals("X"))
                || (a[1][2].equals("X") && a[2][4].equals("X") && a[3][6].equals("X"))
                || (a[1][6].equals("X") && a[2][4].equals("X") && a[3][2].equals("X"))
                || (a[1][2].equals("X") && a[2][2].equals("X") && a[3][2].equals("X"))
                || (a[1][4].equals("X") && a[2][4].equals("X") && a[3][4].equals("X"))
                || (a[1][6].equals("X") && a[2][6].equals("X") && a[3][6].equals("X"))
                ||
                (a[1][2].equals("O") && a[1][4].equals("O") && a[1][6].equals("O"))
                || (a[2][2].equals("O") && a[2][4].equals("O") && a[2][6].equals("O"))
                || (a[3][2].equals("O") && a[3][4].equals("O") && a[3][6].equals("O"))
                || (a[1][2].equals("O") && a[2][4].equals("O") && a[3][6].equals("O"))
                || (a[1][6].equals("O") && a[2][4].equals("O") && a[3][2].equals("O"))
                || (a[1][2].equals("O") && a[2][2].equals("O") && a[3][2].equals("O"))
                || (a[1][4].equals("O") && a[2][4].equals("O") && a[3][4].equals("O"))
                || (a[1][6].equals("O") && a[2][6].equals("O") && a[3][6].equals("O"));
    }
}
