public class Round {

	private TurnManager turnManager;
	private Player player1 = new Player("1");
	private Player player2 = new Player("2");
	private Player player3 = new Player("3");
	private Player player4 = new Player("4");

	public Round(){
		turnManager = new TurnManager(player1,player2,player3,player4);
	}

	public void start() {
		turnManager.on();
	}

}