package GUI.java.swing;

import javax.swing.JPanel;
import GUI.java.swing.TextField;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import GUI.java.swing.PasswordField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;

public class PanelLogin extends JPanel {
	private JButton btn_login;

	public TextField txtUser;

	public PasswordField txtPass;

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelLogin() {
		setOpaque(false);
		setLayout(null);
		
		
		JLabel lblSignIn = new JLabel("Sign In");
		lblSignIn.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblSignIn.setBounds(145, 5, 109, 37);
		add(lblSignIn);
		
		txtUser = new TextField();
		txtUser.setLabelText("User Name");
		txtUser.setBounds(40, 90, 300, 57);
		add(txtUser);
		
		txtPass = new PasswordField();
		txtPass.setLabelText("Password");
		txtPass.setBounds(40, 175, 300, 57);
		add(txtPass);
		
		btn_login = new JButton("Login");
		btn_login.setBackground(new Color(0, 128, 255));
		btn_login.setBounds(40, 314, 300, 37);
		add(btn_login);
	}
	
	public void addEventLogin(ActionListener event) {
		btn_login.addActionListener(event);
	}
	 public boolean checkUser() {
	        boolean action = true;
	        if (txtUser.getText().trim().equals("")) {
	            txtUser.setHelperText("Please input user name");
	            action = false;
	        }
	        if (String.valueOf(txtPass.getPassword()).trim().equals("")) {
	            txtPass.setHelperText("Please input password");
	            action = false;
	        }
	        return action;
	    }

	    public String getUserName() {
	        return txtUser.getText().trim();
	    }

	    public String getPassword() {
	        return String.valueOf(txtPass.getPassword());
	    }
	
}
