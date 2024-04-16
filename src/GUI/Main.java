package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import GUI.java.swing.PanelRound;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import org.w3c.dom.events.EventTarget;
import org.w3c.dom.views.AbstractView;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import GUI.java.swing.GlassPanePopup;
import GUI.java.swing.PanelGradient;
import javax.swing.border.MatteBorder;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;

public class Main  {
	private boolean check = false;

	public JFrame frmMain;
	/**
	 * @wbp.nonvisual location=-10,209
	 */
	private JPanel panelNavBar;
	private PanelRound menuButton;
	private PanelNavBarGradient menuIcon;
	private PanelRound panelPage;
	int wDef = 240;
	private Cursor cursor,cursor_Pressed;
	private long milis = 200;
	/**
	 * @wbp.nonvisual location=-12,319
	 */
	
	/**
	 * @wbp.nonvisual location=-49,249
	 */
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmMain.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
		Home home = new Home();
		JPanelLoader.jPanelLoader(panelPage,home);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	void initialize() {
		frmMain = new JFrame();
		frmMain.setTitle("Main");
		frmMain.getContentPane().setBackground(new Color(118, 186, 226));
		frmMain.setLocationRelativeTo(null);
		cursor = Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon(getClass().getResource("/GUI/Image/finger.png")).getImage(), new Point(0,0),"Custom Cursor");
		cursor_Pressed = Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon(getClass().getResource("/GUI/Image/finger_removed.png")).getImage(), new Point(0,0),"Custom Cursor Remove");
		frmMain.setCursor(cursor);
		GlassPanePopup.install(frmMain);
		
		JPanel panelCenter = new JPanel();
		panelNavBar = new JPanel();
		frmMain.getContentPane().add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new MigLayout("insets 0", "[grow]", "[grow]"));
		frmMain.getContentPane().add(panelNavBar, BorderLayout.WEST);
		panelNavBar.setPreferredSize(new Dimension(40,540));
		panelNavBar.setLayout(new BorderLayout(0, 0));
		
		menuIcon = new PanelNavBarGradient();
		menuIcon.setPreferredSize(new Dimension(40,540));
		
		JLabel open_close_menu = new JLabel("");
		open_close_menu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(check == true) {
					hideshow(panelNavBar,check);
					check = false;
				}
				else {
					hideshow(panelNavBar,check);
					check = true;
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				if(check == false) {
					open_close_menu.setIcon(new ImageIcon(Main.class.getResource("/GUI/Image/menu-right-outline-icon.png")));

				}
				else {
					open_close_menu.setIcon(new ImageIcon(Main.class.getResource("/GUI/Image/menu-left-outline-icon.png")));
				}

			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(check == true) {
					open_close_menu.setIcon(new ImageIcon(Main.class.getResource("/GUI/Image/menu-open-icon.png")));
				}else {
					open_close_menu.setIcon(new ImageIcon(Main.class.getResource("/GUI/Image/bx-menu-icon.png")));
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {
				frmMain.setCursor(cursor_Pressed);
				try {
					Thread.sleep(milis);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				frmMain.setCursor(cursor);
			}
		});
		open_close_menu.setHorizontalAlignment(SwingConstants.CENTER);
		if(check == true) {
			open_close_menu.setIcon(new ImageIcon(Main.class.getResource("/GUI/Image/menu-open-icon.png")));
			menuIcon.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(144, 144, 144)));
		}else {
			open_close_menu.setIcon(new ImageIcon(Main.class.getResource("/GUI/Image/bx-menu-icon.png")));
			menuIcon.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(144, 144, 144)));
		}
		open_close_menu.setBounds(0, 0, 40, 33);
		menuIcon.add(open_close_menu);
		
		menuButton = new PanelRound();
		menuButton.setBackground(new Color(0, 64, 0));
		panelNavBar.add(menuIcon,BorderLayout.WEST);
		panelNavBar.add(menuButton,BorderLayout.CENTER);
		menuButton.setLayout(new BorderLayout(0, 0));
		
		PanelMenuButtonGradient panelMenuButtonGradient = new PanelMenuButtonGradient();
		menuButton.add(panelMenuButtonGradient, BorderLayout.CENTER);
		panelMenuButtonGradient.setLayout(new BorderLayout(0, 0));
		
		JLabel btnLogOut = new JLabel("");
		btnLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmMain.setVisible(false);
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
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogOut.setIcon(new ImageIcon(Main.class.getResource("/GUI/Image/Button/buttonLogOutAfterHover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnLogOut.setIcon(new ImageIcon(Main.class.getResource("/GUI/Image/Button/buttonLogOut.png")));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				frmMain.setCursor(cursor_Pressed);
				try {
					Thread.sleep(milis);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				frmMain.setCursor(cursor);
			}
		});
		btnLogOut.setHorizontalAlignment(SwingConstants.CENTER);
		btnLogOut.setIcon(new ImageIcon(Main.class.getResource("/GUI/Image/Button/buttonLogOut.png")));
		panelMenuButtonGradient.add(btnLogOut, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panelMenuButtonGradient.add(panel, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));
		
		JLabel lblNewLabel_Home = new JLabel("");
		lblNewLabel_Home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Home home = new Home();
				JPanelLoader.jPanelLoader(panelPage,home);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_Home.setIcon(new ImageIcon(Main.class.getResource("/GUI/Image/Button/buttonHomeAfterHover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_Home.setIcon(new ImageIcon(Main.class.getResource("/GUI/Image/Button/buttonHome.png")));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				frmMain.setCursor(cursor_Pressed);
				try {
					Thread.sleep(milis);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				frmMain.setCursor(cursor);
			}
		});
		lblNewLabel_Home.setIcon(new ImageIcon(Main.class.getResource("/GUI/Image/Button/buttonHome.png")));
		panel.add(lblNewLabel_Home);
		
		
		JLabel lblNewLabel_Sale = new JLabel("");
		lblNewLabel_Sale.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sale home = new Sale();
				JPanelLoader.jPanelLoader(panelPage,home);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_Sale.setIcon(new ImageIcon(Main.class.getResource("/GUI/Image/Button/buttonSaleAfterHover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_Sale.setIcon(new ImageIcon(Main.class.getResource("/GUI/Image/Button/buttonSale.png")));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				frmMain.setCursor(cursor_Pressed);
				try {
					Thread.sleep(milis);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				frmMain.setCursor(cursor);
			}
		});
		lblNewLabel_Sale.setIcon(new ImageIcon(Main.class.getResource("/GUI/Image/Button/buttonSale.png")));
		panel.add(lblNewLabel_Sale);
		
		JLabel lblNewLabel_BILL_PO = new JLabel("");
		lblNewLabel_BILL_PO.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BILL_PO billpo = new BILL_PO();
				JPanelLoader.jPanelLoader(panelPage,billpo);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_BILL_PO.setIcon(new ImageIcon(Main.class.getResource("/GUI/Image/Button/buttonBillPOAfterHover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_BILL_PO.setIcon(new ImageIcon(Main.class.getResource("/GUI/Image/Button/buttonBillPO.png")));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				frmMain.setCursor(cursor_Pressed);
				try {
					Thread.sleep(milis);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				frmMain.setCursor(cursor);
			}
		});
		lblNewLabel_BILL_PO.setIcon(new ImageIcon(Main.class.getResource("/GUI/Image/Button/buttonBillPO.png")));
		panel.add(lblNewLabel_BILL_PO);
		
		JLabel lblNewLabel_Product = new JLabel("");
		lblNewLabel_Product.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Product product = new Product();
				JPanelLoader.jPanelLoader(panelPage,product);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_Product.setIcon(new ImageIcon(Main.class.getResource("/GUI/Image/Button/buttonProductAfterHover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_Product.setIcon(new ImageIcon(Main.class.getResource("/GUI/Image/Button/buttonProduct.png")));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				frmMain.setCursor(cursor_Pressed);
				try {
					Thread.sleep(milis);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				frmMain.setCursor(cursor);
			}
		});
		lblNewLabel_Product.setIcon(new ImageIcon(Main.class.getResource("/GUI/Image/Button/buttonProduct.png")));
		panel.add(lblNewLabel_Product);
		int wMB = menuButton.getWidth();
		int hMB = menuButton.getHeight();
		panelPage = new PanelRound();
		panelPage.setBackground(new Color(0, 0, 160));
		panelCenter.add(panelPage, "cell 0 0,grow");
		panelPage.setPreferredSize(new Dimension(500,540));
		panelPage.setLayout(new BorderLayout(0, 0));
		PanelHeaderGradient panelHeaderGradient = new PanelHeaderGradient();
		frmMain.getContentPane().add(panelHeaderGradient, BorderLayout.NORTH);
		frmMain.setForeground(new Color(73, 73, 73));
		frmMain.setBackground(new Color(73, 73, 73));
		frmMain.setBounds(100, 100, 1000, 650);
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

	public void hideshow(JPanel panel, boolean check) {
		if(check == true) {
			Thread th = new Thread() {
				public void run() {
					for(int i = panel.getWidth(); i >=menuIcon.getWidth(); i--) {
						panel.setPreferredSize(new Dimension(i,menuButton.getHeight()));
						SwingUtilities.updateComponentTreeUI(panel);
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			};
			th.start();
		}
		else {
			Thread th1 = new Thread() {
				public void run() {
					for(int i = panel.getWidth(); i <= wDef; i++) {
						panel.setPreferredSize(new Dimension(i,menuButton.getHeight()));
						SwingUtilities.updateComponentTreeUI(panel);
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			};
			th1.start();
		}
	}
	private MouseListener getListener() {
	    return new MouseAdapter() {
	      @Override
	      public void mousePressed(MouseEvent e) {
	        super.mousePressed(e);
	        frmMain.setCursor(cursor_Pressed);
	      }
	      @Override
	      public void mouseReleased(MouseEvent e) {
	        super.mouseReleased(e);
	        frmMain.setCursor(cursor);
	      }
	    };
	  }
}
