package View;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import Constants.Layout;
import Model.Board;
import Model.Tile;

public class BoardView implements IView {
	private List<TileView> tileViewList = new ArrayList<TileView>();

	public void paint(Graphics g) {
		for (TileView tileView : tileViewList) {
			tileView.paint(g);
		}
	}

	public void mousseEvent(int x, int y) {

	}

	public void update(Observable o, Object arg) {
		tileViewList.clear();
		int k = 0;

		for (Tile tile : ((Board) o).getTileList()) {
			tileViewList.add(new TileView(tile,
					Layout.getInstance().getMargin() + k % 16 * Layout.getInstance().getTileImageSize() * 2 / 3,
					Layout.getInstance().getMargin() * 2 + Layout.getInstance().getNameFontSize()
							+ ((int) k / 16) * (Layout.getInstance().getTileImageSize() + 3)));
			k++;

		}
	}
}
