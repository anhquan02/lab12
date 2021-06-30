/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XHelper;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Mypc
 */
public class XHelper {

    public XHelper() {
    }
    
    
    public static boolean checkRong(JTextField tf) {
        if (tf.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Không được để trống");
            tf.requestFocus();
            return true;
        }
        return false;
    }

    public static boolean checkSoNguyen(JTextField tf) {
        try {
            int x = Integer.parseInt(tf.getText());
            if (x > 0) {
                return true;
            } else {
                JOptionPane.showMessageDialog(tf, "Làm ơn điền số nguyên dương");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Làm ơn điền số nguyên");
            return false;
        }
    }
}
