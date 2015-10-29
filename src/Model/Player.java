package Model;

import java.util.Observable;

public class Player extends Observable {
    private Hand hand;

    private Player next = null;
    enum Status {tilePicked, turnEnded, interruptionAllowed, interruptionRefused, doNotInterrupt};
    private Status status = Status.tilePicked;

    String name;

    public Player(String name) {
        this.hand = new Hand();
        this.name = name;
    }

    public Player getNext() {
        return next;
    }

    public void setNext(Player next) {
        this.next = next;
    }

/*    public void play() {
        System.out.println(name + " pickup tile");
        status = Status.tilePicked;
        update();
    }*/

    public void pickUpFromDeck()
    {
         hand.addTile(Deck.getInstance().drawTile());
        ch
    }

    public void pickUpFromBoard()
    {
        hand.addTile(Board.getInstance().getLastTile());
    }

    public void throwTile() {
        System.out.println(name + " throw tile");
        status = Status.turnEnded;
        update();
    }

    public void checkInterruption() {
        System.out.println(name + " check interruption");
        status = Status.interruptionRefused;
        update();
    }

    public void doNotInterrupt() {
        System.out.println(name + " do not want to interrupt");
        status = Status.doNotInterrupt;
        update();
    }

    public void update() {
        setChanged();
        notifyObservers(status);
    }

    public void selectTile(Tile tile)
    {
        hq
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }3
}

