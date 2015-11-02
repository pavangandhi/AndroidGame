package View;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Observable;
import Constants.Layout;
import Constants.TileType;
import Model.Hand;
import Model.Tile;

public class HandView implements IView {
	private List<TileView> tileViewList = new ArrayList<TileView>();

	public void paint(Graphics g) {
		for (TileView tileView : tileViewList) {
			tileView.paint(g);
		}
	}

	public void mousseEvent(int x, int y) {
		if (x < Layout.getInstance().getScreenWidth() - Layout.getInstance().getMargin()
				&& x > Layout.getInstance().getMargin()
				&& y < Layout.getInstance().getHandHeight() + Layout.getInstance().getTileImageSize()
				&& y > Layout.getInstance().getHandHeight()) {
			for (TileView tileView : tileViewList) {
				tileView.mousseEvent(x, y);
			}
		}

	}

	public void update(Observable o, Object arg1) {
		tileViewList.clear();
		int k = 0;
		Hand hand = (Hand) o;

		Collections.sort(hand.getTileList(), new Comparator<Tile>() {
			public int compare(Tile tile0, Tile tile1) {
				if (tile0.getType() == tile1.getType()) {
					if (tile0.getDigit() < tile1.getDigit())
						return -1;
					else
						return 1;
				} else if (tile0.getType() == TileType.BAMBOO) {
					return -1;
				} else if (tile1.getType() == TileType.BAMBOO) {
					return 1;
				} else if (tile0.getType() == TileType.CIRCLE) {
					return -1;
				} else
					return 1;
			}
		});

		if (hand.getTileList().size() - 1 > 0) {
			for (Tile tile : ((Hand) o).getTileList()) {
				TileView tileView = new TileView(tile,
						(int) (Layout.getInstance().getMargin() + ((double) k / (hand.getTileList().size() - 1))
								* Layout.getInstance().getHandStep(tileViewList.size())),
						Layout.getInstance().getHandHeight());
				k++;
				tile.addObserver(tileView);
				tileViewList.add(tileView);
			}
		}
	}
}
