package Rules.Strategys.Sichuan;

import Model.Hand;
import Model.Tile;
import Rules.Strategys.IInterruptionCondition;

/**
 * Created by Kreliou on 29/10/2015.
 */
public class SichuanInterruptionCondition implements IInterruptionCondition {
	public boolean checkInterruption(Tile deckTile, Hand hand) {
		int numPair = 0;
		for (Tile tile : hand.getTileList()) {
			if (deckTile.getType() == tile.getType() && deckTile.getDigit() == tile.getDigit()) {
				numPair++;
			}
		}
		if (numPair > 1)
			return true;
		else
			return false;
	}
}
