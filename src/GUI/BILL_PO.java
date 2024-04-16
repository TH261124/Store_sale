package GUI;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JProgressBar;

import net.miginfocom.swing.MigLayout;
import javax.swing.JTable;

import GUI.custom.table.TableActionCellEditor;
import GUI.custom.table.TableActionCellRender;
import GUI.custom.table.TableActionEvent;
import GUI.java.swing.GlassPanePopup;
import GUI.java.swing.Message;
import GUI.java.swing.PanelRound;
import javax.swing.JLabel;
import javax.swing.JButton;
import GUI.java.swing.TextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BILL_PO extends JPanel {


	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public BILL_PO() {
		setBackground(new Color(85, 142, 249));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(130, 135, 144), 2, true));
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setOpaque(false);
		scrollPane.setBounds(0, 0, 793, 373);
		add(scrollPane);
		
		table = new JTable();
		table.setRowHeight(35);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 H\u00F3a \u0110\u01A1n", "M\u00E3 Nh\u00E2n Vi\u00EAn", "M\u00E3 Kh\u00E1ch H\u00E0ng", "Ng\u00E0y L\u1EADp", "Action"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(77);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		table.getColumnModel().getColumn(2).setPreferredWidth(103);
		table.getColumnModel().getColumn(3).setPreferredWidth(86);
		table.getColumnModel().getColumn(4).setPreferredWidth(40);
		scrollPane.setViewportView(table);
		TableActionEvent event = new TableActionEvent() {
			
			@Override
			public void onView(int row) {
				GlassPanePopup.showPopup(new Message());
			}
			
			@Override
			public void onDelete(int row) {
				if(table.isEditing()) {
					table.getCellEditor().stopCellEditing();
				}
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				model.removeRow(row);
				
			}
			
		};
		table.getColumnModel().getColumn(4).setCellRenderer(new  TableActionCellRender());
		table.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditor(event));
	}
}
