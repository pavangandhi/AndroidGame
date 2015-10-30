package View;
import java.awt.Graphics;
import java.awt.Image;

import Constants.Ressource;
import Constants.TileType;

public class TileView {
	private TileType type;
	private int digit;
	public TileView(TileType type, int digit) {
		this.type = type;
		this.digit = digit;
	}
	
	public void paint(Graphics g, int x, int y){
		g.drawImage(Ressource.getInstance().getTileImage(type, digit), x, y, null);
	}
}
