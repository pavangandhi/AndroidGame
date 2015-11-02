	import GUI.Component;
import GUI.Dialog;
import GUI.Window;
import Manager.Round;

public class Main {
	public static void main(String[] args) {
		new Round().start();
		Window.getInstance().show();
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Component.getInstance().repaint();
		}
	}
}
