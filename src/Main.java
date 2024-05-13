import java.util.Scanner;
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
                    System.out.println("Cola Machine");
                    System.out.println();
                    break;
                }
                case 3: {
                    System.out.println("While");
                    System.out.println();
                    break;
                }
                case 4: {
                    System.out.println("PanCake");
                    System.out.println();
                    break;
                }
                case 5: {
                    System.out.println("TicTacToe");
                    System.out.println();
                    break;
                }
                case 6: {
                    System.exit(0);
                    break;
                }
                default:
                    System.out.println("Invalid Choice. Try Again.");
                    System.out.println();
                    break;
            }
        } while (choose < 0 || choose > 6);
    }
    // menu choose game
    static int menu(){
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
        do{
            score = input.nextInt();
            if (score < 0 || score > 100)
                System.out.println("Invalid Score. Try Again.");
        } while (score < 0 || score > 100);
        if(score >= 90){
            System.out.println("You got an A");
        } else if(score >= 80) {
            System.out.println("You got an B");
        }
        else if(score >= 70) {
            System.out.println("You got an C");
        }
        else if(score >= 60) {
            System.out.println("You got an D");
        }
        else {
            System.out.println("You got an F");
        }
    }

}