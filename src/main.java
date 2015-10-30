import Constants.TileType;
import View.PlayerView;
import Model.Board;
import Model.Deck;
import Model.Hand;
import Model.Player;
import Model.Tile;

public class Main {
	public static void main(String[] args) {
		PlayerView.getInstance().init();
		Round round = new Round();
		round.start();
		new Window();
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			PlayerView.getInstance().repaint();
		}
	}
}
