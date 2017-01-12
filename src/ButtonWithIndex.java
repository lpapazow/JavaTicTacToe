import javax.swing.JButton;

public class ButtonWithIndex extends JButton {
	int index;
	
	ButtonWithIndex(int idx, String text) {
		super(text);
		index = idx;
	}
}
