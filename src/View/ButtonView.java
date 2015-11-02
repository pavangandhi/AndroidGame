package View;

import java.awt.Graphics;
import java.util.Observable;
import Constants.ButtonType;
import Constants.Layout;
import Constants.Resource;
import Controller.PlayerController;

public class ButtonView implements IView {
	ButtonType buttonType;
	int indice;
	private int x;
	private int y;

	public ButtonView(ButtonType buttonType, int indice) {
		this.buttonType = buttonType;
		this.indice = indice;
	}

	public void paint(Graphics g) {
		x = Layout.getInstance().getButtonX();
		y = Layout.getInstance().getButtonY()
				+ indice * (Layout.getInstance().getButtonSize() + Layout.getInstance().getMargin());
		g.drawImage(Resource.getInstance().getButton(buttonType), x, y, null);
	}

	public void mousseEvent(int x, int y) {
		if (x < this.x + Layout.getInstance().getButtonSize() && x > this.x
				&& y < this.y + Layout.getInstance().getButtonSize() && y > this.y) {
			PlayerController.getInstance().interpretInput(buttonType);
		}
	}
	
	public void update(Observable arg0, Object arg1) {

	}
}
