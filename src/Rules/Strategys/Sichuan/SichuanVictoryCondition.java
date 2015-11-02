package Rules.Strategys.Sichuan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import Constants.TileType;
import Model.Hand;
import Model.Tile;
import Rules.Strategys.IVictoryCondition;

/**
 * Created by Kreliou on 29/10/2015.
 */
public class SichuanVictoryCondition implements IVictoryCondition {
	public boolean checkVictory(Hand hand) {
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
		List<Tile> bamboo = new ArrayList();
		List<Tile> circle = new ArrayList();
		List<Tile> character = new ArrayList();

		for (Tile tile : hand.getTileList()) {
			if (tile.getType() == TileType.BAMBOO)
				bamboo.add(tile);
			if (tile.getType() == TileType.CIRCLE)
				circle.add(tile);
			if (tile.getType() == TileType.CHARACTER)
				character.add(tile);
		}

		/*for (int k = 0; k < bamboo.size(); k++) {
			if (bamboo.get(k) == bamboo.get(k + 1) && k < bamboo.size() - 1) {
				
			}
		}*/

		return false;
	}
}
