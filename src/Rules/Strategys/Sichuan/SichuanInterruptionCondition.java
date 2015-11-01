package Rules.Strategys.Sichuan;

import Model.Hand;
import Model.Tile;
import java.util.List;
import Rules.Strategys.IInterruptionCondition;

/**
 * Created by Kreliou on 29/10/2015.
 */
public class SichuanInterruptionCondition implements IInterruptionCondition {
    public boolean checkInterruption(Tile tile, Hand hand){
        int numPair = 0;
        int suit1[] = {-1, -1, -1, -1};
        for (Tile currentTile : hand.getTileList()) {
            if (currentTile.type == tile.type) {
                if (currentTile.digit == tile.digit) {
                    numPair += 1;
                }
            }
            else if (currentTile.digit >= tile.digit - 2 && currentTile.digit < tile.digit) {
                suit1[(currentTile.digit == tile.digit - 2) ? 0 : 1)] = currentTile.digit;
            }
            else if (currentTile.digit <= tile.digit + 2 && currentTile.digit > tile.digit) {
                suit1[(currentTile.digit == tile.digit + 2) ? 2 : 3)] = currentTile.digit:
            }
        }
        if (numPair >= 2) {
            return true;
        }
        int numberSuit = 0;
        for (int indexSuit = 0; indexSuit < 4; indexSuit++) {
            if (suit1[indexSuit] == -1) {
                numberSuit = 0;
            }
            else {
                numberSuit += 1;
                if (numberSuit == 2) {
                    return true;
                }
            }
            numberSuit += 1;
        }
        return false;
    }
}
