public class Player {

    private PlayerState state;
    private String name;
    private Hand hand;

    public Player(String name) {
        this.name = name;
        this.state = NormalPlayerState.getInstance();
        this.hand = new Hand();
    }

    public void play() {
        state.pickupTile(this.hand);
        state.throwTile(this.hand);
    }

    public boolean askInterrupt() {
        if (state.askInterrupt() == true) {
            this.state = InterruptionPlayerState.getInstance();
            return true;
        }
        else
        {
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerState getState() {
        return state;
    }

    public void setState(PlayerState state) {
        this.state = state;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }
}

