package View;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import Constants.Layout;
import Constants.Ressource;
import Model.Hand;
import Model.Tile;

public class HandView extends TileViewList implements Observer {
	private int selectedTile = -1;
	
	public void paint(Graphics g) {
		int k =0;
		for (TileView tileView:tileViewList) {
			tileView.paint(g, Layout.getInstance().getMargin() + k * Layout.getInstance().getHandStep(tileViewList.size()), Layout.getInstance().getHandHeight());
			if (selectedTile == k)
				paintFocus(g, Layout.getInstance().getMargin() + k * Layout.getInstance().getHandStep(tileViewList.size()), Layout.getInstance().getHandHeight());
			k++;
		}
	}
	
	private void paintFocus(Graphics g, int x, int y) {
		g.drawImage(Ressource.getInstance().getFocusTile(), x, y, null);
	}

	public void update(Observable o, Object arg1) {
		tileViewList.clear();
		for (Tile tile:((Hand)o).getTileList()) {
			tileViewList.add(new TileView(tile.getType(), tile.getDigit()));
		}
		selectedTile = ((Hand)o).getSelectedTile();
		PlayerView.getInstance().repaint();
	}
}
