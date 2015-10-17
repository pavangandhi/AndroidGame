import java.util.Random;

public class NormalPlayerState extends PlayerState {

    private static volatile NormalPlayerState instance = new NormalPlayerState();
    public static NormalPlayerState getInstance() {
        return instance;
    }

    public void pickupTile(Hand hand) {
        hand.addTile(Deck.getInstance().drawTile());
    }

    public void throwTile(Hand hand) {
        UI.selectTile();
        Board.getInstance().addTile(hand.removeTile());
    }

    private int i = 0;

    public boolean askInterrupt() {
        Random test = new Random();

        i++;
//        if (test.nextInt(3) == 0)
        if (i == 7) {
            i = 0;
            return true;
        }
        return false;
    }

}
