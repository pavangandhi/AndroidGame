package Model;

import java.util.Observable;
import Constants.TileType;

public class Tile extends Observable {
	private TileType type;
	private int digit;
	private boolean selected;

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

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
		setChanged();
		notifyObservers();
	}

}
