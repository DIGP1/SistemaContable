
package form;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import form.login;
import logic.CatalogoDeCuentasDatos;

/**
 *
 * @author Diego
 */
public class validarAdmin {
    public CatalogoDeCuentasDatos cc = new CatalogoDeCuentasDatos();
    private boolean validado = false;
    public void setValidacion(boolean a){
        this.validado = a;
    }
    public boolean getValidacion(){
        return this.validado;
    }
    public void mostrarDialogoConPanel(JFrame parentFrame) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));
        panel.add(new JLabel("Usuario:"));
        JTextField txtUsername = new JTextField();
        panel.add(txtUsername);
        panel.add(new JLabel("Contraseña:"));
        JPasswordField txtpass = new JPasswordField();
        panel.add(txtpass);

        JButton[] customButtons = {
            new JButton("Ingresar"),
            new JButton("Cancelar")
        };
        
        customButtons[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                char[] pass1 = txtpass.getPassword();
                String password = new String(pass1);
                setValidacion(cc.verificacionAdmin(txtUsername.getText(), password));
                if(getValidacion()){
                    parentFrame.dispose();
                    login loginFrame = new login();
                    loginFrame.setVisible(true);
                    loginFrame.pack();
                    loginFrame.setLocationRelativeTo(null);
                }
                System.out.println("Botón 'Ingresar' presionado");
            }
        });
        customButtons[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setValidacion(false);
                System.out.println("Botón 'Ingresar' presionado");
                parentFrame.dispose();
                login loginFrame = new login();
                loginFrame.setVisible(true);
                loginFrame.pack();
                loginFrame.setLocationRelativeTo(null);
                
            }
        });

        int opcion = JOptionPane.showOptionDialog(parentFrame, panel, "Ingrese Datos",
                JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, customButtons, customButtons[0]);
    }
    
}

