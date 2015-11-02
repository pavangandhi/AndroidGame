package Rules.Strategys;

import Model.Hand;
import Model.Tile;

/**
 * Created by Kreliou on 29/10/2015.
 */
public interface IInterruptionCondition {

	public boolean checkInterruption(Tile tile, Hand hand);

}
