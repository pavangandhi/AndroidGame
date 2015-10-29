package Model;

import Constants.TileType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
    private static volatile Deck instance = new Deck();

    private Random randomGenerator = new Random();
    private List<Tile> listTiles = new ArrayList<>();

    // private constructor
    private Deck() {
    }

    public static Deck getInstance() {
        return instance;
    }

    public void initializeDeck() {
        listTiles.clear();
        for (TileType types : TileType.values()) {
            for (int i = 0; i <= 9; i++) {
                listTiles.add(new Tile(types, i));
                listTiles.add(new Tile(types, i));
                listTiles.add(new Tile(types, i));
                listTiles.add(new Tile(types, i));
            }
        }
    }

    public Tile drawTile() {
        int randomIndex;
        Tile randomTile;

        randomIndex = randomGenerator.nextInt(listTiles.size());
        randomTile = listTiles.get(randomIndex);
        listTiles.remove(randomIndex);

        return randomTile;
    }

    public List<Tile> getListTiles() {
        return listTiles;
    }

    public void setListTiles(List<Tile> listTiles) {
        this.listTiles = listTiles;
    }

}