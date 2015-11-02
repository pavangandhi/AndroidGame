package View;

import java.awt.Font;
import java.awt.Graphics;
import java.util.Observable;
import Constants.Layout;
import Constants.Resource;
import Model.Player;

public class PlayerView implements IView {

	private String name = "Unknown";

	private IView[] viewTab = {};

	public void paint(Graphics g) {
		paintName(g);
		if (viewTab.length > 0)
			for (IView view : viewTab) {
				view.paint(g);
			}
	}

	private void paintName(Graphics g) {
		g.setFont(new Font(Resource.getInstance().getFontStyle(), Font.PLAIN, Layout.getInstance().getNameFontSize()));
		g.drawString("  " + name, Layout.getInstance().getMargin(),
				Layout.getInstance().getMargin() + Layout.getInstance().getNameFontSize());
	}

	public void setButtonView(ButtonView[] viewTab) {
		this.viewTab = viewTab;
	}

	public void mousseEvent(int x, int y) {
		for (IView view : viewTab) {
			view.mousseEvent(x, y);
		}
	}

	public void update(Observable o, Object arg1) {
		name = ((Player) o).getName();
	}
}
