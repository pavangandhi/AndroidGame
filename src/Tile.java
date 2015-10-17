import Constants.TileType;

public class Tile {
    private TileType type;
    private int digit;

    public Tile(TileType type, int digit) {
        this.digit = digit;
        this.type = type;
    }

    public TileType getType() {
        return type;
    }

    public void setType(TileType type) {
        this.type = type;
    }

    public int getDigit() {
        return digit;
    }

    public void setDigit(int digit) {
        this.digit = digit;
    }

}
