import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TurnManager {

	private List<Player> listOfPlayer = new ArrayList<>();
	private Iterator<Player> playerIterator;
	private Player currentPlayer = null;

	public TurnManager(Player... players)
	{
		for (Player p : players)
			listOfPlayer.add(p);
			playerIterator = listOfPlayer.iterator();
			currentPlayer= playerIterator.next();
	}

	private void nextPlayer()
	{
		if (currentPlayer == null || !playerIterator.hasNext())
			playerIterator = listOfPlayer.iterator();
		currentPlayer = playerIterator.next();
	}

	public void on() {
		//TODO : Replace the while
		while (true){
			UI.focusPlayer(currentPlayer);
			nextPlayer();
		}
	}


}