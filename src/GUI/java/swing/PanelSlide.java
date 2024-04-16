package GUI.java.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Path2D;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine.Info;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import GUI.Main;
import net.miginfocom.swing.MigLayout;

import static javax.sound.sampled.AudioSystem.getAudioInputStream;
import static javax.sound.sampled.AudioFormat.Encoding.PCM_SIGNED;


public class PanelSlide extends JLayeredPane {
	

	private static final long serialVersionUID = 1L;
	private final Animator animator;
	private float animate = 1f;
	private boolean slideLeft;
	private MigLayout layout;
	private final PanelLoading loading;
	private final PanelLogin login;
	private Thread th;
	 private JFrame fram;
	
	public void setFram(JFrame fram) {
        this.fram = fram;
    }
	
	public PanelSlide() {
		layout = new MigLayout("inset 0", "[grow,fill]", "[fill][grow]");
		setLayout(layout);
		login = new PanelLogin();
		loading = new PanelLoading();
		loading.setForeground(new Color(2,156,73));
		loading.setVisible(false);
		setPreferredSize(new  Dimension(300,300));
		Color color = new Color(2,156,73);
		setBackground(color);
		loading.setBackground(color);
		TimingTarget target = new TimingTargetAdapter() {
			@Override
			public void begin() {
				if(slideLeft) {
					loading.setVisible(true);
				}else {
					login.setVisible(true);
				}
			}
			@Override
			public void timingEvent(float fraction) {
				double witdh = getWidth();
				double height = getHeight();
				animate = fraction;
				float a = easeOutQuint(fraction);
				int  x = (int)(a*witdh);
				int y = (int)(a*height);
				loading.setAnimate(slideLeft, fraction);				
				layout.setComponentConstraints(loading, "pos" + x + " 0 100% 100%");
				revalidate();
				repaint();
			}
			@Override
			public void end() {
				if(slideLeft) {
					login.setVisible(false);
				}else {
					loading.setVisible(false);
				}
			}
		};
		animator = new Animator(1000,target);
		animator.setResolution(0);
		add(loading, " pos 0 0 0 0, w 0!");
		add(login, "cell 0 0 1 2,grow");
		 login.addEventLogin(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent ae) {
	                if (!animator.isRunning()) {
	                    if (login.checkUser()) {
	                        showSlide(true);
	                        loading.showError("Loading...");
	                        login(login.getUserName(), login.getPassword());
	                    }
	                }
	            }
	        });
		 loading.addEventBack(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent ae) {
	                if (!animator.isRunning()) {
	                    th.interrupt();
	                    showSlide(false);
	                }
	            }
	        });

	}
	public void showSlide(boolean show) {
		slideLeft = show;
		animator.start(); 
	}
	
	public void login(String username, String password) {
		th = new Thread(new Runnable() {


			@Override
			public void run() {
				try {
					Thread.sleep(1000);
					if(Username.equals(login.getUserName()) && (Password.equals(login.getPassword()))) {
						Main main = new Main();
						loading.showError("Welcome My Daddy!");
						
//						final AudioFilePlayer player = new AudioFilePlayer ();
//				        player.play("soundHowl.mp3");

		                Thread.sleep(2000);
		                main.frmMain.setVisible(true);
		                //  Close login form
		                fram.setVisible(false);
					}else {
						loading.showError("Youre not ADMIN");
					}
				} catch (Exception e) {
					loading.showError("Error");
				}
				
			}
			
				
		});
		th.start();
	}
	
	public class AudioFilePlayer {
	public void play(String filePath) {
        final File file = new File(filePath);
 
        try (final AudioInputStream in = getAudioInputStream(file)) {
             
            final AudioFormat outFormat = getOutFormat(in.getFormat());
            final Info info = new Info(SourceDataLine.class, outFormat);
 
            try (final SourceDataLine line =
                     (SourceDataLine) AudioSystem.getLine(info)) {
 
                if (line != null) {
                    line.open(outFormat);
                    line.start();
                    stream(getAudioInputStream(outFormat, in), line);
                    line.drain();
                    line.stop();
                }
            }
 
        } catch (UnsupportedAudioFileException 
               | LineUnavailableException 
               | IOException e) {
            throw new IllegalStateException(e);
        }
    }
 
    private AudioFormat getOutFormat(AudioFormat inFormat) {
        final int ch = inFormat.getChannels();

        final float rate = inFormat.getSampleRate();
        return new AudioFormat(PCM_SIGNED, rate, 16, ch, ch * 2, rate, false);
    }
 
    private void stream(AudioInputStream in, SourceDataLine line) 
        throws IOException {
        final byte[] buffer = new byte[4096];
        for (int n = 0; n != -1; n = in.read(buffer, 0, buffer.length)) {
            line.write(buffer, 0, n);
        }
    }
}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(slideLeft == false) {
			Graphics2D g2 = (Graphics2D) g.create();
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			int width = getWidth();
			int height = getHeight();
			float x = easeOutQuint(animate) * width;
			float y = 0;
			int centerY = height / 2;		
			Path2D.Float p = new Path2D.Float();
			p.moveTo(x, y);
			p.lineTo(x, height);
			p.curveTo(x, height, easeOutBounce(animate)* width, centerY, x, y);
			g2.setColor(getBackground());
			g2.fill(p);
			g2.dispose();
		}
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

	    private float easeOutQuint(float x) {
	        double v = 1 - Math.pow(1 - x, 5);
	        if (slideLeft) {
	            return (float) (1f - v);
	        } else {
	            return (float) v;
	        }
	    }
		private  String Username = "admin";
		private String Password = "admin";
}
