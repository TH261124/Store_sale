package GUI.java.swing;

import javax.swing.JPanel;
import GUI.java.swing.PanelRound;
import java.awt.Color;

public class PanelTest extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelTest() {
		setLayout(null);
		
		PanelRound panelRound = new PanelRound();
		panelRound.setRoundTopRight(100);
		panelRound.setRoundTopLeft(100);
		panelRound.setRoundBottomRight(100);
		panelRound.setRoundBottomLeft(100);
		panelRound.setBackground(new Color(255, 255, 0));
		panelRound.setBounds(10, 5, 430, 353);
		add(panelRound);

	}

}
