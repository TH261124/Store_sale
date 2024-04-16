package GUI.java.swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.util.ArrayList;
import java.util.List;
import javax.swing.GroupLayout.Alignment;

public class PanelGradient extends javax.swing.JPanel {
	private ModelColor color1 = new ModelColor(Color.decode("#6FE3E1"),0f);
	private ModelColor color2 = new ModelColor(Color.decode("#5257E5"),1f);
    public PanelGradient() {
        initComponents();
        //  Set false to make background panel as transparent
        setOpaque(false);
        colors = new ArrayList<>();
        colors.add(color1);
        colors.add(color2);
    }
    private final List<ModelColor> colors;

    public void addColor(ModelColor... color) {
        for (ModelColor c : color) {
            colors.add(c);
        }
    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(26)
        			.addContainerGap(728, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(27)
        			.addContainerGap(39, Short.MAX_VALUE))
        );
        this.setLayout(layout);
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {
        if (!colors.isEmpty()) {
            int width = getWidth();
            int height = getHeight();
            Graphics2D g2 = (Graphics2D) grphcs;
            Color color[] = new Color[colors.size()];
            float position[] = new float[colors.size()];
            for (int i = 0; i < colors.size(); i++) {
                color[i] = colors.get(i).getColor();
                position[i] = colors.get(i).getPosition();
            }
            int sx = 0; //  as Start x
            int sy = 0; //  as Start y
            int ex = width; //  as End x
            int ey = 0; //  as End y
            LinearGradientPaint g = new LinearGradientPaint(sx, sy, ex, ey, position, color);
            g2.setPaint(g);
            g2.fillRect(0, 0, width, height);
        }
        super.paintComponent(grphcs);
    }
}