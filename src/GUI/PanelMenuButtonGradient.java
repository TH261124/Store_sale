package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;

import GUI.java.swing.ModelColor;

import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import java.awt.Font;
import net.miginfocom.swing.MigLayout;

public class PanelMenuButtonGradient extends javax.swing.JPanel {
	private ModelColor color1 = new ModelColor(Color.decode("#6FE3E1"),0f);
	private ModelColor color2 = new ModelColor(Color.decode("#5257E5"),1f);
	private final List<ModelColor> colors;

    public PanelMenuButtonGradient() {
        initComponents();
        //  Set false to make background panel as transparent
        setOpaque(false);
        setLayout(null);
        colors = new ArrayList<>();
        colors.add(color1);
        colors.add(color2);
    }
 

    public void addColor(ModelColor... color) {
        for (ModelColor c : color) {
            colors.add(c);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
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