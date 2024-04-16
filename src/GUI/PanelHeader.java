package GUI;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import net.miginfocom.swing.MigLayout;
import GUI.java.swing.ModelColor;
import GUI.java.swing.PanelGradient;
import java.awt.Rectangle;
import javax.swing.JLabel;

public class PanelHeader extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelHeader() {
		setBounds(new Rectangle(0, 0, 0, 80));
		setLayout(new MigLayout("insets 0", "[grow]", "[grow]"));
		
		PanelGradient panelGradient = new PanelGradient();
		add(panelGradient, "cell 0 0,grow");
		panelGradient.addColor(new ModelColor(Color.decode("#5257E5"),0f),new ModelColor(Color.decode("#6FE3E1"),1f));

	}

}
