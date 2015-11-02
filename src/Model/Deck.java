package Model;

import Constants.TileType;
import Model.TileList.TileList;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck extends TileList {
	private static volatile Deck instance = new Deck();

	private Random randomGenerator = new Random();

	// private constructor
	private Deck() {
	}

	public static Deck getInstance() {
		return instance;
	}

	public void initializeDeck() {
		tileList.clear();
		for (TileType types : TileType.values()) {
			for (int i = 1; i < 10; i++) {
				tileList.add(new Tile(types, i));
				tileList.add(new Tile(types, i));
				tileList.add(new Tile(types, i));
				tileList.add(new Tile(types, i));
			}
		}
		update();
	}

	public Tile drawTile() {
		Tile randomTile;
		randomTile = tileList.get(randomGenerator.nextInt(tileList.size()));
		removeTile(randomTile);

		return randomTile;
	}
}