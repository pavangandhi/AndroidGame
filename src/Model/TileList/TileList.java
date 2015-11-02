package Model.TileList;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import Model.Tile;

/**
 * Created by Kreliou on 15/10/2015.
 */
public class TileList extends Observable {

	protected List<Tile> tileList = new ArrayList<>();

	public void addTile(Tile tile) {
		tileList.add(tile);
		update();
	}

	public void removeTile(Tile tile) {
		tileList.remove(tile);
		update();
	}

	public void update() {
		this.setChanged();
		this.notifyObservers();
	}

	public List<Tile> getTileList() {
		return tileList;
	}

	public void setTileList(List<Tile> tileList) {
		this.tileList = tileList;
	}

}
