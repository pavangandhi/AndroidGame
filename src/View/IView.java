package View;

import java.awt.Graphics;
import java.util.Observer;

public interface IView extends Observer {
	public void paint(Graphics g);

	public void mousseEvent(int x, int y);
}
