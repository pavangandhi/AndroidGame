package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import Model.TileList.TileList;

public class Board extends TileList {

	private static volatile Board instance = new Board();

	public static Board getInstance() {
		return instance;
	}

	private Board() {
	}

	public void initializeBoard() {
		tileList.clear();
		update();
	}

	public Tile getLastTile() {
		return tileList.get(tileList.size()-1);
	}

	public Tile pickLastTile() {
		Tile tempTile = getLastTile();
		removeTile(tempTile);
		return tempTile;
	}
}