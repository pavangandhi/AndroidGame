package View.Button;

import java.awt.Graphics;

import Constants.Layout;
import Constants.Ressource;

public class UnallowedInterruptionButton implements IPaintButton {
	public void paint(Graphics g) {
		g.drawImage(Ressource.getInstance().getCantTakeButton(), Layout.getInstance().getButtonX(), Layout.getInstance().getButtonY(), null);
		g.drawImage(Ressource.getInstance().getPassButton(), Layout.getInstance().getButtonX(), Layout.getInstance().getButtonY() + Layout.getInstance().getButtonSize() + Layout.getInstance().getMargin(), null);
	}
}
