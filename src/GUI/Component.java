package GUI;

import java.awt.Graphics;
import javax.swing.JComponent;
import Constants.Resource;
import View.BoardView;
import View.DeckView;
import View.HandView;
import View.HistoricView;
import View.IView;
import View.PlayerView;

public class Component extends JComponent {
	private static Component instance = null;

	protected Component() {
		handView = new HandView();
		boardView = new BoardView();
		deckView = new DeckView();
		playerView = new PlayerView();
		historicView = new HistoricView();
		IView[] viewTab = { handView, boardView, deckView, playerView, historicView };
		this.viewTab = viewTab;
	}

	public static Component getInstance() {
		if (instance == null) {
			instance = new Component();
		}
		return instance;
	}

	private HandView handView;
	private BoardView boardView;
	private DeckView deckView;
	private PlayerView playerView;
	private HistoricView historicView;
	private IView[] viewTab;

	public void paint(Graphics g) {
		paintWallpaper(g);
		for (IView view : viewTab)
			view.paint(g);
	}

	private void paintWallpaper(Graphics g) {
		g.drawImage(Resource.getInstance().getWallpaper(), 0, 0, null);
	}

	public void mouseEvent(int x, int y) {
		for (IView view : viewTab)
			view.mousseEvent(x, y);
	}

	public HandView getHandView() {
		return handView;
	}

	public void setHandView(HandView handView) {
		this.handView = handView;
	}

	public BoardView getBoardView() {
		return boardView;
	}

	public void setBoardView(BoardView boardView) {
		this.boardView = boardView;
	}

	public DeckView getDeckView() {
		return deckView;
	}

	public void setDeckView(DeckView deckView) {
		this.deckView = deckView;
	}

	public PlayerView getPlayerView() {
		return playerView;
	}

	public HistoricView getHistoricView() {
		return historicView;
	}

	public void setHistoricView(HistoricView historicView) {
		this.historicView = historicView;
	}

	public void setPlayerView(PlayerView playerView) {
		this.playerView = playerView;
	}
}
