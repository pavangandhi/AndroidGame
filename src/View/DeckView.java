package View;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import Constants.Layout;
import Constants.Ressource;
import Model.Deck;

public class DeckView implements Observer {
	private int deckSize;
	public void paint(Graphics g) {
		g.drawImage(Ressource.getInstance().getDeckImage(), Layout.getInstance().getDeckX(), Layout.getInstance().getDeckY(), null);
		g.setFont(new Font(Ressource.getInstance().getFontStyle(), Font.PLAIN, Layout.getInstance().getDeckFontSize()));
		g.drawString("" + deckSize, Layout.getInstance().getDeckFontX(), Layout.getInstance().getDeckFontY());
	}

	public void update(Observable o, Object arg) {
		deckSize = ((Deck)o).getTileList().size();
	}
}
