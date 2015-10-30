package View.Button;

import java.awt.Graphics;

import Constants.Layout;
import Constants.Ressource;

public class ThrowButton implements IPaintButton {
	public void paint(Graphics g) {
		g.drawImage(Ressource.getInstance().getThrowButton(), Layout.getInstance().getButtonX(), Layout.getInstance().getButtonY(), null);
	}
}
