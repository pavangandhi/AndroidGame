package Model;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	private static volatile Hand instance = new Hand();

			private Tile selectedTile;
	private List<Tile> listTiles = new ArrayList<>();

	public void setSelectedTile() {
		selectedTile = listTiles.stream().findFirst().get();
	}

	/**
	 * 
	 * @param tile
	 */
	public void addTile(Tile tile) {
		listTiles.add(tile);
		this.checkVictory();
	}

	public Tile removeTile() {
		listTiles.remove(selectedTile);

		return selectedTile;
	}

	public void checkVictory() {

	}

	public List<Tile> getListTiles() {
		return listTiles;
	}

	public void setListTiles(List<Tile> listTiles) {
		this.listTiles = listTiles;
	}

	public Tile getSelectedTile() {
		return selectedTile;
	}

	public void setSelectedTile(Tile selectedTile) {
		this.selectedTile = selectedTile;
	}
}