package GUI;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Home extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField_GhiChu;

	/**
	 * Create the panel.
	 */
	public Home() {
		setLayout(null);
		
		JLabel lblNewLabel_GhiChu = new JLabel("Ghi Chú:");
		lblNewLabel_GhiChu.setBounds(10, 11, 46, 14);
		add(lblNewLabel_GhiChu);
		
		textField_GhiChu = new JTextField();
		textField_GhiChu.setBounds(63, 9, 387, 17);
		add(textField_GhiChu);
		textField_GhiChu.setColumns(10);

	}
}
