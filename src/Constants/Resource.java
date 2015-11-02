package Constants;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

public class Resource {
	private static Resource instance = null;

	protected Resource() {

	}

	public static Resource getInstance() {
		if (instance == null) {
			instance = new Resource();
		}
		return instance;
	}

	public String getTitle() {
		return "title";
	}

	public Image getWallpaper() {
		return scale(Toolkit.getDefaultToolkit().getImage("image/wallpaper.jpg"), Layout.getInstance().getScreenWidth(),
				Layout.getInstance().getScreenHeight());
	}

	public Image getTileImage(TileType type, int digit) {
		switch (type) {
		case BAMBOO:
			return scaleTile(Toolkit.getDefaultToolkit().getImage("image/bamboo/" + digit + ".png"));
		case CIRCLE:
			return scaleTile(Toolkit.getDefaultToolkit().getImage("image/circle/" + digit + ".png"));
		case CHARACTER:
			return scaleTile(Toolkit.getDefaultToolkit().getImage("image/character/" + digit + ".png"));
		default:
			return scaleTile(Toolkit.getDefaultToolkit().getImage("image/face_down.png"));
		}
	}

	public Image getDeckImage() {
		return scale(Toolkit.getDefaultToolkit().getImage("image/face_down.png"), Layout.getInstance().getDeckSize(),
				Layout.getInstance().getDeckSize());
	}

	public Image getFocusTile() {
		return scaleTile(Toolkit.getDefaultToolkit().getImage("image/focus.png"));
	}

	public Image getFocusButton() {
		return scaleButton(Toolkit.getDefaultToolkit().getImage("image/focus.png"));
	}

	public Image getButton(ButtonType buttonType) {
		switch (buttonType) {
		case throwTile:
			return scaleButton(Toolkit.getDefaultToolkit().getImage("image/throw.png"));
		case take:
			return scaleButton(Toolkit.getDefaultToolkit().getImage("image/take.png"));
		case cantTake:
			return scaleButton(Toolkit.getDefaultToolkit().getImage("image/cant_take.png"));
		case pass:
			return scaleButton(Toolkit.getDefaultToolkit().getImage("image/pass.png"));
		default:
			return null;
		}
	}

	private Image scaleTile(Image source) {
		return scale(source, Layout.getInstance().getTileImageSize(), Layout.getInstance().getTileImageSize());
	}

	private Image scaleButton(Image source) {
		return scale(source, Layout.getInstance().getButtonSize(), Layout.getInstance().getButtonSize());
	}

	private Image scale(Image source, int width, int height) {
		BufferedImage buf = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

		Graphics2D g = buf.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.drawImage(source, 0, 0, width, height, null);
		g.dispose();

		return buf;
	}

	public String getFontStyle() {
		return "Impact";
	}
}
