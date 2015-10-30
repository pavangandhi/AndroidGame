package View;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JComponent;
import Constants.Layout;
import Constants.Ressource;
import Model.Player;
import View.Button.IPaintButton;
import View.Button.NoButton;

public class PlayerView extends JComponent implements Observer {
	private static PlayerView instance = null;
	protected PlayerView() {
		
	}
	public static PlayerView getInstance() {
		if (instance == null) {
			instance = new PlayerView();
		}
		return instance;
	}
	
	private HandView handView;
	private BoardView boardView;
	private DeckView deckView;
	
	private String name = "Unknown";
	
	public void init(){
		handView = new HandView();
		boardView = new BoardView();
		deckView = new DeckView();
	}
	
	public void paint(Graphics g) {
		paintWallpaper(g);
		deckView.paint(g);
		handView.paint(g);
		boardView.paint(g);
		paintName(g);
		paintButton(g);
	}
	
	private void paintWallpaper(Graphics g) {
		g.drawImage(Ressource.getInstance().getWallpaper(), 0, 0, null);
	}
	
	private void paintName(Graphics g) {
		g.setFont(new Font(Ressource.getInstance().getFontStyle(), Font.PLAIN, Layout.getInstance().getNameFontSize()));
		g.drawString(name, Layout.getInstance().getMargin(), Layout.getInstance().getMargin() + Layout.getInstance().getNameFontSize());
	}
	private IPaintButton paintButton = new NoButton();
	public void setIPaintButton(IPaintButton paintButton){
		this.paintButton = paintButton;
		repaint();
	}
	private void paintButton(Graphics g) {
		paintButton.paint(g);
	}

	public void update(Observable o, Object arg1) {
		name = ((Player) o).getName();
		repaint();
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
}
