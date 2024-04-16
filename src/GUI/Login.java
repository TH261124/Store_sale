package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import GUI.java.swing.PanelSlide;


public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private static JPanel contentPane;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}


	/**
	 * Create the frame.
	 */
	public Login() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setBackground(new Color(255,255,255));
		setLocationRelativeTo(null);

		PanelSlide panelSlide = new PanelSlide();
		panelSlide.setFram(Login.this);
		panelSlide.setBounds(0, 0, 384, 378);
		contentPane.add(panelSlide);
		
	}
}
