import java.awt.Dimension;
import java.awt.Menu;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import Constants.Ressource;
import Controller.PlayerController;
import View.PlayerView;

public class Window extends JFrame{
	private Ressource ressource = Ressource.getInstance();
	
	private PlayerView playerView;
	
	public Window() {        
        this.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == 27) {
					menu();
				}
			}
			public void keyTyped(KeyEvent e) {}        	
        });
        
        this.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {
				PlayerController.getInstance().interpretInput(e.getX(), e.getY());
			}
        });
        
		this.setTitle(ressource.getTitle());
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize((int)screenSize.getWidth(), (int)screenSize.getHeight());
        
        this.getContentPane().add(PlayerView.getInstance());
        
        //this.setSize(100,100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setUndecorated(true);
        this.setVisible(true);
	}
	
	public void menu(){	
		new OptionMenu(this);
	}
}
