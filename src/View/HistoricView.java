package View;

import java.awt.Font;
import java.awt.Graphics;
import java.util.Observable;

import Constants.Layout;
import Constants.Resource;
import Historic.Historic;

public class HistoricView implements IView {
	
	private String events = "";

	public void paint(Graphics g) {
		g.setFont(new Font(Resource.getInstance().getFontStyle(), Font.PLAIN, Layout.getInstance().getHistoricFontSize()));
		drawString(g, events, Layout.getInstance().getHistoricX(),
				Layout.getInstance().getHistoricY());
	}
	
	private void drawString(Graphics g, String text, int x, int y) {
	    for (String line : text.split("\n"))
	        g.drawString(line, x, y += g.getFontMetrics().getHeight());
	}

	public void mousseEvent(int x, int y) {
		
	}

	public void update(Observable o, Object arg1) {
		events = ((Historic) o).getEvents();
	}
}
