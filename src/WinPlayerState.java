public class WinPlayerState extends PlayerState {

  private static volatile WinPlayerState instance = new WinPlayerState();

  public static WinPlayerState getInstance() {
    return instance;
  }

  public  void pickupTile(Hand hand) {

  }
  public  void throwTile(Hand hand) {

  }
  public  boolean askInterrupt() {
    return false;
  }
}
