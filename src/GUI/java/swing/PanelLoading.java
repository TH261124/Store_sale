package GUI.java.swing;

import javax.swing.JPanel;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.geom.Path2D;
import java.awt.Color;
import javax.swing.SwingConstants;

import javax.swing.JButton;


public class PanelLoading extends JPanel {

	private static final long serialVersionUID = 1L;
	private boolean slideLeft;
	private float animate;
	private JButton return_btn;
	private JLabel lblLoading;

	/**
	 * Create the panel.
	 */
	public PanelLoading() {
		setOpaque(false);
		setLayout(null);
		
		lblLoading = new JLabel("Loading...");
		lblLoading.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoading.setForeground(new Color(0, 0, 0));
		lblLoading.setBackground(new Color(0, 255, 255));
		lblLoading.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblLoading.setBounds(0, 86, 400, 41);
		add(lblLoading);
		
		return_btn = new JButton("return");
		return_btn.setBackground(new Color(255, 255, 255));
		return_btn.setFont(new Font("Tahoma", Font.BOLD, 30));
		return_btn.setBounds(110, 301, 185, 47);
		add(return_btn);

	}
	
	public void setAnimate(boolean slideLeft,float animate) {
		this.slideLeft = slideLeft;
		this.animate = animate;
	}
	
	public void addEventBack(ActionListener event) {
		return_btn.addActionListener(event);
		
	}
    public void showError(String ms) {
    	lblLoading.setText(ms);
    }
	
	@Override
	public void paint(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int width = getWidth();
		int height = getHeight();
		int x = 0;
		int y = 0;
		if(slideLeft) {
			int centerY = height / 2;		
			Path2D.Double p = new Path2D.Double();
			p.moveTo(x, y);
			p.lineTo(width, y);
			p.lineTo(width, height);
			p.lineTo(x, height);
			p.curveTo(x, height, easeOutBounce(animate)* width, centerY, x, y);
			g2.fill(p);
		}else {
			g2.fillRect(x, y, width, height);
		}
		g2.dispose();
		super.paint(g);
	}
	 private float easeOutBounce(float x) {
	        float n1 = 7.5625f;
	        float d1 = 2.75f;
	        double v;
	        if (x < 1 / d1) {
	            v = n1 * x * x;
	        } else if (x < 2 / d1) {
	            v = n1 * (x -= 1.5 / d1) * x + 0.75;
	        } else if (x < 2.5 / d1) {
	            v = n1 * (x -= 2.25 / d1) * x + 0.9375;
	        } else {
	            v = n1 * (x -= 2.625 / d1) * x + 0.984375;
	        }
	        if (slideLeft) {
	            return (float) (1f - v);
	        } else {
	            return (float) v;
	        }
	    }
}
