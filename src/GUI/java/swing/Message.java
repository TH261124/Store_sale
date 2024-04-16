package GUI.java.swing;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.Color;
import java.awt.Dimension;

import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;

public class Message extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	/**
	 * @wbp.nonvisual location=410,239
	 */
	private JPanel panel_1 = new JPanel();

	/**
	 * Create the panel.
	 */
	public Message() {
		setOpaque(false);
		setLayout(new BorderLayout(0, 0));
		
		PanelRound panelRound = new PanelRound();
		panelRound.setBackground(new Color(192, 192, 192));
		panelRound.setRoundTopRight(50);
		panelRound.setRoundTopLeft(50);
		add(panelRound, BorderLayout.CENTER);
		panelRound.setLayout(new BorderLayout(0, 0));
		
		JLabel title_Bill = new JLabel("Chi Tiết Hóa Đơn");
		title_Bill.setHorizontalAlignment(SwingConstants.CENTER);
		title_Bill.setFont(new Font("Tahoma", Font.PLAIN, 30));
		title_Bill.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(0, 0, 0)));
		panelRound.add(title_Bill, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panelRound.add(panel, BorderLayout.CENTER);
		panel_1.setOpaque(false);
		panelRound.add(panel_1, BorderLayout.SOUTH);
		panel_1.setPreferredSize(new Dimension(panelRound.getWidth(),60));
		panel_1.setLayout(new MigLayout("", "[][][][][][][][][grow]", "[grow][grow]"));
		
		JLabel lblTngTin = new JLabel("Tổng tiền:");
		lblTngTin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_1.add(lblTngTin, "cell 0 0");
		
		JTextArea textArea_TongTien = new JTextArea();
		textArea_TongTien.setText("5000000");
		textArea_TongTien.setOpaque(false);
		textArea_TongTien.setEditable(false);
		panel_1.add(textArea_TongTien, "cell 8 0,grow");
		
		JLabel lblNgyLp = new JLabel("Ngày  Lập:");
		lblNgyLp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_1.add(lblNgyLp, "cell 0 1");
		
		JTextArea textArea_NgayLap = new JTextArea();
		textArea_NgayLap.setText("16/4/2024");
		textArea_NgayLap.setEditable(false);
		textArea_NgayLap.setOpaque(false);
		panel_1.add(textArea_NgayLap, "cell 8 1,grow");
		panel.setLayout(new MigLayout("insets 0", "[fill]", "[fill]"));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		panel.add(scrollPane, "cell 0 0,grow");
		
		table = new JTable();
		table.setRowHeight(30);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"STT", "T\u00EAn S\u1EA3n Ph\u1EA9m", "S\u1ED1 L\u01B0\u1EE3ng", "Th\u00E0nh Ti\u1EC1n"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(43);
		table.getColumnModel().getColumn(1).setPreferredWidth(110);
		table.getColumnModel().getColumn(3).setPreferredWidth(76);
		scrollPane.setViewportView(table);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 =(Graphics2D)g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(getBackground());
		g2.fill(new RoundRectangle2D.Double(0,0,getWidth(),getHeight(),15,15));
		g2.dispose();
		super.paintComponent(g);
	}
}
