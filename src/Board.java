import java.util.ArrayList;
import java.util.List;

public class Board{

	private static volatile Board instance = new Board();
	public static Board getInstance() {
		return instance;
	}

	private List<Tile> listTiles = new ArrayList<>();
	private Tile lastTile;

	private Board(){}

	public void initializeBoard()
	{
		lastTile = null;
		listTiles.clear();
	}

	public void addTile(Tile tile) {
		listTiles.add(tile);
	}

	public Tile getLastTile() {
		return listTiles.get(listTiles.size());
	}

	public Tile pickLastTile() {
		// TODO - implement Board.pickLastTile
		throw new UnsupportedOperationException();
	}

	public List<Tile> getListTiles() {
		return listTiles;

	}

	public void setListTiles(List<Tile> listTiles) {
		this.listTiles = listTiles;
	}

}