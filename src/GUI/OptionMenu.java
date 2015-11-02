package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

import Manager.Round;

public class OptionMenu extends JDialog {

	public OptionMenu(JFrame parent) {
		super(parent, "menu", true);
		this.setSize(550, 270);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

		this.setLayout(new GridLayout(2, 1));

		JButton play = new JButton("Resume");
		JButton close = new JButton("Close");
		this.getContentPane().add(play);
		this.getContentPane().add(close);
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(DISPOSE_ON_CLOSE);
			}
		});

		this.setVisible(true);
	}
}
