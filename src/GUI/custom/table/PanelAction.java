package GUI.custom.table;

import javax.swing.JPanel;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelAction extends JPanel {

	private static final long serialVersionUID = 1L;
	private ActionButton actionButton_delete;
	private ActionButton actionButton_view_details;
	private Cursor cursor,cursor_Pressed;
	private long milis = 200;

	/**
	 * Create the panel.
	 */
	public void initEvent(TableActionEvent event, int row) {
		actionButton_delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				event.onDelete(row);
			}
			
		});
		actionButton_view_details.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				event.onView(row);
			}
			
		});
	}
	public PanelAction() {
		setLayout(null);
		cursor = Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon(getClass().getResource("/GUI/Image/finger.png")).getImage(), new Point(0,0),"Custom Cursor");
		cursor_Pressed = Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon(getClass().getResource("/GUI/Image/finger_removed.png")).getImage(), new Point(0,0),"Custom Cursor Remove");
		setCursor(cursor);
		actionButton_delete = new ActionButton();
		actionButton_delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setCursor(cursor_Pressed);
				try {
					Thread.sleep(milis);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				setCursor(cursor);
			}
		});
		actionButton_delete.setIcon(new ImageIcon(PanelAction.class.getResource("/GUI/Image/Cancel-Symbol-icon.png")));
		actionButton_delete.setBounds(0, 0, 39, 32);
		add(actionButton_delete);
		
		actionButton_view_details = new ActionButton();
		actionButton_view_details.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setCursor(cursor_Pressed);
				try {
					Thread.sleep(milis);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				setCursor(cursor);
			}
		});
		actionButton_view_details.setIcon(new ImageIcon(PanelAction.class.getResource("/GUI/Image/view-fullscreen-icon.png")));
		actionButton_view_details.setBounds(49, 0, 39, 32);
		add(actionButton_view_details);

	}

}
