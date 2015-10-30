package Rules;

import Model.Hand;
import Model.Board;
import Rules.Strategys.IInterruptionCondition;
import Rules.Strategys.IVictoryCondition;

/**
 * Created by Kreliou on 29/10/2015.
 */
public class SetOfRules {
	private IInterruptionCondition interruptionCondition;
	private IVictoryCondition victoryCondition;

	private SetOfRules() {
	}

	public boolean checkInterruption(Hand hand) {
		return interruptionCondition.checkInterruption(Board.getInstance().getLastTile(), hand);
	}

	public boolean checkVictory(Hand hand) {
		return victoryCondition.checkVictory(hand);
	}

	public IInterruptionCondition getInterruptionCondition() {
		return interruptionCondition;
	}

	public void setInterruptionCondition(IInterruptionCondition interruptionCondition) {
		this.interruptionCondition = interruptionCondition;
	}

	public IVictoryCondition getVictoryCondition() {
		return victoryCondition;
	}

	public void setVictoryCondition(IVictoryCondition victoryCondition) {
		this.victoryCondition = victoryCondition;
	}

	private static SetOfRules ourInstance = new SetOfRules();

	public static SetOfRules getInstance() {
		return ourInstance;
	}

}
