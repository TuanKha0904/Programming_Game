import javax.swing.*;

public class Dialog_Boxes {
    public static void main(String[] args) {
        String user = JOptionPane.showInputDialog(null,"user");
        String pass = JOptionPane.showInputDialog(null,"password");
        if(user.equals("admin") && pass.equals("admin")){
            JOptionPane.showMessageDialog(null,"login ok");
        }else{
            JOptionPane.showMessageDialog(null,"login failed");
        }
    }
}
