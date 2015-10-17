import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TurnManager {

    private List<Player> listOfPlayer = new ArrayList<>();
    private Iterator<Player> playerIterator;
    private Player currentPlayer = null;

    public TurnManager(Player... players) {
        for (Player p : players)
            listOfPlayer.add(p);
        playerIterator = listOfPlayer.iterator();
        currentPlayer = playerIterator.next();
    }

    public void on() {
        //TODO : Replace the while
        while (true) {

            System.out.print("It is player " + currentPlayer.getName() + " turn\nDECK ");
            UI.showList(Deck.getInstance().getListTiles());
            System.out.print("BOARD ");
            UI.showList(Board.getInstance().getListTiles());
            System.out.print("HAND ");
            UI.showList(currentPlayer.getHand().getListTiles());

            UI.focusPlayer(currentPlayer);
            currentPlayer.play();
            System.out.print("BOARD AFTER ");
            UI.showList(Board.getInstance().getListTiles());
            System.out.print("HAND AFTER ");
            UI.showList(currentPlayer.getHand().getListTiles());
            askAllPlayerForInterruption();

        }
    }

    public void askAllPlayerForInterruption() {
        Iterator<Player> tempPlayerIterator = listOfPlayer.iterator();
        Player tempCurrentPlayer = tempPlayerIterator.next();

        resetPlayerSate();
        while (currentPlayer != tempCurrentPlayer) {
            tempCurrentPlayer = tempPlayerIterator.next();
        }
        for (int i = 0; i < listOfPlayer.size() - 1; i++) {
            if (!tempPlayerIterator.hasNext())
                tempPlayerIterator = listOfPlayer.iterator();
            tempCurrentPlayer = tempPlayerIterator.next();
            System.out.print("Asking player -> " + tempCurrentPlayer.getName() + "\n");
            if (tempCurrentPlayer.askInterrupt() == true) {
                System.out.print("      Player -> " + tempCurrentPlayer.getName() + " interrupted\n");
                currentPlayer = tempCurrentPlayer;
                return;
            }
        }
        nextPlayer();
    }

    public void distributeTiles() {
        listOfPlayer.stream().forEach(e -> {
            for (int i = 0; i < 13; i++)
                e.getHand().addTile(Deck.getInstance().drawTile());
        });
    }

    private void resetPlayerSate() {
        listOfPlayer.stream().filter(e -> e.getState() == InterruptionPlayerState.getInstance())
                .forEach(e -> {
                    e.setState(NormalPlayerState.getInstance());
                });
    }

    private void nextPlayer() {
        if (currentPlayer == null || !playerIterator.hasNext())
            playerIterator = listOfPlayer.iterator();
        currentPlayer = playerIterator.next();
    }
}