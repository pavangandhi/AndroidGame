package View;

import java.awt.Font;
import java.awt.Graphics;
import java.util.Observable;
import Constants.Layout;
import Constants.Resource;
import Model.Deck;

public class DeckView implements IView {
	private int deckSize;

	public void paint(Graphics g) {
		g.drawImage(Resource.getInstance().getDeckImage(), Layout.getInstance().getDeckX(),
				Layout.getInstance().getDeckY(), null);
		g.setFont(new Font(Resource.getInstance().getFontStyle(), Font.PLAIN, Layout.getInstance().getDeckFontSize()));
		g.drawString("" + deckSize, Layout.getInstance().getDeckFontX(), Layout.getInstance().getDeckFontY());
	}

	public void mousseEvent(int x, int y) {

	}

	public void update(Observable o, Object arg) {
		deckSize = ((Deck) o).getTileList().size();
	}
}
