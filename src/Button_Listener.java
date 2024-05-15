import javax.swing.*;
import java.awt.event.*;
public class Button_Listener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        JOptionPane .showMessageDialog(button, button.getText() + " button has been pressed");
    }
}
