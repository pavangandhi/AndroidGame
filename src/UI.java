import Model.Player;
import Model.Tile;

import java.util.List;

public final class UI {

	static private Player currentPlayer;

	/**
	 * Private constructor since the class does not need to be instantiated
	 */
	private UI(){
		System.out.print("UI constructor called");
	}

	public static void selectTile() {
	currentPlayer.getHand().setSelectedTile();
	}

	public static boolean askInterrupt() {
		// TODO - implement UI.askInterrupt
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param player
	 */
	public static void focusPlayer(Player player) {
		currentPlayer = player;
		System.out.print("focusPlayer on -> " + player.getName() + "\n");
	}

	public static void showList(List<Tile> list){
		System.out.print("LIST--\n");
		list.stream().forEach(e ->{
			System.out.print(e.getType() + " - " + e.getDigit() + "\n");
		});
	}

}