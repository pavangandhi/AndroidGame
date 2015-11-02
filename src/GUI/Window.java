package GUI;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import Constants.Resource;
import View.BoardView;
import View.DeckView;
import View.HandView;
import View.HistoricView;
import View.IView;
import View.PlayerView;

public class Window extends JFrame {
	private static Window instance = null;

	public static Window getInstance() {
		if (instance == null) {
			instance = new Window();
		}
		return instance;
	}
	
	protected Window() {
		this.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
			}

			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == 27) {
					menu();
				}
			}

			public void keyTyped(KeyEvent e) {
			}
		});

		this.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseReleased(MouseEvent e) {
				Component.getInstance().mouseEvent(e.getX(), e.getY());
			}
		});

		this.setTitle(Resource.getInstance().getTitle());
		this.setSize((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(),
				(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());

		this.getContentPane().add(Component.getInstance());

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setUndecorated(true);
		this.setVisible(true);
	}

	public void menu() {
		new OptionMenu(this);
	}
}
