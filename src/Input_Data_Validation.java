import javax.swing.*;

public class Input_Data_Validation {
    public static void main(String[] args) {
        String n1 = JOptionPane.showInputDialog(null, "First number to add");
        while (isNumber(n1)) {
            n1 = JOptionPane.showInputDialog(null, "Invalid first number. Please insert another number");
        }
        String n2 = JOptionPane.showInputDialog(null, "Second number to add");
        while (isNumber(n2)) {
            n2 = JOptionPane.showInputDialog(null, "Invalid second number. Please insert another number");
        }
        int sum = Integer.parseInt(n1) + Integer.parseInt(n2);
        JOptionPane.showMessageDialog(null, "The sum of " + n1 + " and " + n2 + " is " + sum);
    }

    public static boolean isNumber(String n) {
        try{
            Integer.parseInt(n);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }
}
