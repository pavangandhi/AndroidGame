package Constants;

import java.awt.Toolkit;

public class Layout {
	private static Layout instance = null;

	protected Layout() {

	}

	public static Layout getInstance() {
		if (instance == null) {
			instance = new Layout();
		}
		return instance;
	}

	private int screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	private int screenHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

	public int getTileImageSize() {
		return this.screenWidth / 18 * 4 / 3;
	}

	public int getMargin() {
		return screenWidth / 40;
	}

	private int handSize;

	public int getHandSize() {
		return handSize;
	}

	public int getHandStep() {
		return screenWidth - getMargin() * 2 - getTileImageSize();
	}

	public int getHandStep(int handSize) {
		this.handSize = handSize;
		return getHandStep();
	}

	public int getHandHeight() {
		return screenHeight - getMargin() - getTileImageSize();
	}

	public int getNameFontSize() {
		return screenHeight / 10;
	}

	public int getDeckFontSize() {
		return screenHeight / 10;
	}

	public int getDeckFontX() {
		return screenWidth - getDeckSize();
	}

	public int getDeckFontY() {
		return getDeckSize() / 2 + getDeckFontSize();
	}

	public int getDeckSize() {
		return screenHeight / 5;
	}

	public int getDeckX() {
		return screenWidth - getDeckSize() - getMargin();
	}

	public int getDeckY() {
		return getMargin();
	}

	public int getButtonSize() {
		return screenHeight / 5;
	}

	public int getButtonX() {
		return getDeckX();
	}

	public int getButtonY() {
		return getDeckY() + getDeckSize() + getMargin();
	}

	public int getScreenWidth() {
		return screenWidth;
	}

	public void setScreenWidth(int screenWidth) {
		this.screenWidth = screenWidth;
	}

	public int getScreenHeight() {
		return screenHeight;
	}

	public void setScreenHeight(int screenHeight) {
		this.screenHeight = screenHeight;
	}

	public int getHistoricFontSize() {
		return screenHeight / 50;
	}

	public int getHistoricX() {
		return getButtonX() - screenWidth/5;
	}

	public int getHistoricY() {
		return getHandHeight() - screenHeight/5;
	}

}
