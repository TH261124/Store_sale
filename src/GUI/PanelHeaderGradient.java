package GUI;

import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;
import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import GUI.java.swing.PanelRound;
import javax.swing.JPanel;

public class PanelHeaderGradient extends javax.swing.JPanel {
	private ModelColor color1 = new ModelColor(Color.decode("#5257E5"),0f);
	private ModelColor color2 = new ModelColor(Color.decode("#6FE3E1"),.7f);
	private final List<ModelColor> colors;
	private JLabel logo_Store;

    public PanelHeaderGradient() {
    	setBorder(new LineBorder(new Color(0, 128, 255), 3, true));
        initComponents();
        //  Set false to make background panel as transparent
        setOpaque(false);
        setLayout(new MigLayout("", "[187px][][grow][grow]", "[74px,grow]"));
        add(logo_Store, "cell 0 0,grow");
        
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        add(panel, "cell 2 0,grow");
        panel.setLayout(new MigLayout("", "[][]", "[][]"));
        
        JLabel labelMaNV = new JLabel("Mã Nhân Viên :");
        labelMaNV.setFont(new Font("Tahoma", Font.PLAIN, 19));
        panel.add(labelMaNV, "cell 0 0");
        
        JLabel labelXuatMaNV = new JLabel("Slim Shady");
        labelXuatMaNV.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panel.add(labelXuatMaNV, "cell 1 0");
        
        JLabel labelTenNV = new JLabel("Tên Nhân Viên:");
        labelTenNV.setFont(new Font("Tahoma", Font.PLAIN, 19));
        panel.add(labelTenNV, "cell 0 1");
        
        JLabel labelXuatTenNV = new JLabel("123456789");
        labelXuatTenNV.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panel.add(labelXuatTenNV, "cell 1 1");
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
        
        logo_Store = new JLabel("MemeK");
        logo_Store.setBorder(new MatteBorder(0, 0, 0, 5, (Color) new Color(85, 85, 85)));
        logo_Store.setHorizontalAlignment(SwingConstants.CENTER);
        logo_Store.setFont(new Font("Snap ITC", Font.PLAIN, 30));
        logo_Store.setIcon(new ImageIcon(PanelHeaderGradient.class.getResource("/GUI/Image/store-icon.png")));
       
    }
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