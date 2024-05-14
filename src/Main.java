import java.util.*;

public class Main {
    public static void main(String[] args) {
        int choose;
        do {
            choose = menu();
            switch (choose) {
                case 1: {
                    Grading_Program();
                    break;
                }
                case 2: {
                    Cola_Machine();
                    break;
                }
                case 3: {
                    While();
                    break;
                }
                case 4: {
                    PanCake();
                    break;
                }
                case 5: {
                    TicTacToe();
                    break;
                }
                case 6: {
                    System.exit(0);
                    break;
                }
                default:
                    System.out.println("Invalid Choice. Try Again.");
                    System.out.println();
            }
        } while (choose < 0 || choose > 6);
    }
    // menu choose game
    static int menu() {
        Scanner input = new Scanner(System.in);
        int choose;
        System.out.println("Please choose one of the following options: ");
        System.out.println("1. Grading Program");
        System.out.println("2. Cola Machine");
        System.out.println("3. While");
        System.out.println("4. PanCake");
        System.out.println("5. TicTacToe");
        System.out.println("6. Exit");
        System.out.println("Enter your choice: ");
        choose = input.nextInt();
        return choose;
    }
    // 1. Grading Program
    static void Grading_Program() {
        Scanner input = new Scanner(System.in);
        int score;
        System.out.println("Enter the grade scored: ");
        do {
            score = input.nextInt();
            if (score < 0 || score > 100)
                System.out.println("Invalid Score. Try Again.");
        } while (score < 0 || score > 100);
        if (score >= 90) {
            System.out.println("You got an A");
        } else if (score >= 80) {
            System.out.println("You got an B");
        } else if (score >= 70) {
            System.out.println("You got an C");
        } else if (score >= 60) {
            System.out.println("You got an D");
        } else {
            System.out.println("You got an F");
        }
    }
    // 2.  Cola Machine
    static void Cola_Machine() {
        Scanner input = new Scanner(System.in);
        int choose;
        System.out.println("Please choose one of the following options: ");
        System.out.println("1. Coke");
        System.out.println("2. Water");
        System.out.println("3. Sprite");
        System.out.println("4. Pepsi");
        System.out.println("5. Beer");
        choose = input.nextInt();
        switch (choose) {
            case 1: {
                System.out.println("You have chosen Coke");
                break;
            }
            case 2: {
                System.out.println("You have chosen Water");
                break;
            }
            case 3: {
                System.out.println("You have chosen Sprite");
                break;
            }
            case 4: {
                System.out.println("You have chosen Pepsi");
                break;
            }
            case 5: {
                System.out.println("You have chosen Beer");
                break;
            }
            default:
                System.out.println("Error. choice was not valid, here is your money back.");
                break;
        }
    }
    // 3. While
    static void While(){
        Scanner input = new Scanner(System.in);
        int enter;
        for(int i = 0; i < 10 ;i++){
            System.out.println("Please enter any number other than " + i);
            enter = input.nextInt();
            if(enter == i){
                System.out.println("Hey! you weren't supposed to enter " + i +"!");
                System.exit(0);
            }
            if(i == 9)
                System.out.println("Wow, you're more patient then I am, you win.");
        }
    }
    // 4. PanCake
    static void PanCake() {
        Scanner input = new Scanner(System.in);
        int enter;
        int[][] array = new int [10][2];
        for(int i = 0; i < 10; i++){
            System.out.println("Person " + (i + 1));
            enter = input.nextInt();
            array[i][0] = i + 1;
            array[i][1] = enter;
        }
        for (int i = 0; i < 10; i++){
            for(int j = i + 1; j < 10; j++){
                if(array[i][1] < array[j][1]){
                    int temp0 = array[i][0];
                    int temp1 = array[i][1];
                    array[i][0] = array[j][0];
                    array[i][1] = array[j][1];
                    array[j][0] = temp0;
                    array[j][1] = temp1;
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("Person " + array[i][0] + " ate " + array[i][1] + " pancakes");
        }
    }
    // 5. TicTacToe
    static void TicTacToe() {
        String[] board;
        String turn;
        Scanner in = new Scanner(System.in);
        board = new String[9];
        turn = "X";
        String winner = null;
        for (int a = 0; a < 9; a++) {
            board[a] = String.valueOf(a + 1);
        }
        System.out.println("Welcome to 3x3 Tic Tac Toe.");
        printBoard(board);
        System.out.println("X will play first. Enter a slot number to place X in:");
        while (winner == null) {
            int numInput;
            try {
                numInput = in.nextInt();
                if (!(numInput > 0 && numInput <= 9)) {
                    System.out.println(
                            "Invalid input; re-enter slot number:");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println(
                        "Invalid input; re-enter slot number:");
                continue;
            }
            if (board[numInput - 1].equals(
                    String.valueOf(numInput))) {
                board[numInput - 1] = turn;
                if (turn.equals("X")) {
                    turn = "O";
                } else {
                    turn = "X";
                }
                printBoard(board);
                winner = checkWinner(board, turn);
            } else {
                System.out.println("Slot already taken; re-enter slot number:");
            }
        }
        if (winner.equalsIgnoreCase("draw")) {
            System.out.println("It's a draw! Thanks for playing.");
        }
        else {
            System.out.println("Congratulations! " + winner + "'s have won! Thanks for playing.");
        }
        in.close();
    }
    static String checkWinner(String[] board, String turn) {
        for (int a = 0; a < 8; a++) {
            String line = switch (a) {
                case 0 -> board[0] + board[1] + board[2];
                case 1 -> board[3] + board[4] + board[5];
                case 2 -> board[6] + board[7] + board[8];
                case 3 -> board[0] + board[3] + board[6];
                case 4 -> board[1] + board[4] + board[7];
                case 5 -> board[2] + board[5] + board[8];
                case 6 -> board[0] + board[4] + board[8];
                case 7 -> board[2] + board[4] + board[6];
                default -> null;
            };
            if (line.equals("XXX")) {
                return "X";
            }
            else if (line.equals("OOO")) {
                return "O";
            }
        }
        for (int a = 0; a < 9; a++) {
            if (Arrays.asList(board).contains(
                    String.valueOf(a + 1))) {
                break;
            }
            else if (a == 8) {
                return "draw";
            }
        }
        System.out.println(turn + "'s turn; enter a slot number to place " + turn + " in:");
        return null;
    }
    static void printBoard(String[] board) {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | "
                + board[1] + " | " + board[2]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | "
                + board[4] + " | " + board[5]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | "
                + board[7] + " | " + board[8]
                + " |");
        System.out.println("|---|---|---|");
    }
}