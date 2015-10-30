package View;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import Constants.Layout;
import Model.Board;
import Model.Tile;

public class BoardView extends TileViewList implements Observer {

	public void paint(Graphics g) {		
		int k =0;
		for (TileView tileView:tileViewList){
			tileView.paint(g,
					Layout.getInstance().getMargin() + k % 16 * Layout.getInstance().getTileImageSize() * 2/3,
					Layout.getInstance().getMargin()*2 + Layout.getInstance().getNameFontSize()
					+ ((int)k/16) * (Layout.getInstance().getTileImageSize() + 3));
			k++;
		}
	}
	
	public void update(Observable o, Object arg) {
		tileViewList.clear();
		for (Tile tile:((Board)o).getTileList()) {
			tileViewList.add(new TileView(tile.getType(), tile.getDigit()));
		}
		PlayerView.getInstance().repaint();
	}
}
