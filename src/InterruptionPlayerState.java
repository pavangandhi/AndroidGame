public class InterruptionPlayerState extends PlayerState {

    private static volatile InterruptionPlayerState instance = new InterruptionPlayerState();

    public static InterruptionPlayerState getInstance() {
        return instance;
    }

    public void pickupTile(Hand hand) {

    }

    public void throwTile(Hand hand) {

    }

    public boolean askInterrupt() {

        return false;
    }
}
