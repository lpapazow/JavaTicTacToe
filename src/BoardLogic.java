import java.text.MessageFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class BoardLogic {
	static final String PLAYER_ONE_SIGN = "X";
	static final String PLAYER_TWO_SIGN = "O";
	
	private String[][] board = new String[3][3];
	
	public void fillSquare(int idx, boolean playerOnePlays)
	{
		String playerSign = playerOnePlays ? PLAYER_ONE_SIGN : PLAYER_TWO_SIGN;
		ArrayList<Integer> indexes2d = indexTo2DIndexes(idx);
		board[indexes2d.get(0)][indexes2d.get(1)] = playerSign;
	}
	
	public void checkIfWinner(int timesPressed){
		checkDiagonalWinner(timesPressed);
		checkRowWinner(timesPressed);
		checkColWinner(timesPressed);
		if (timesPressed == 8)
		{
			JOptionPane.showMessageDialog(null, "Nobody wins");
			System.exit(0);
		}
	}
	
	private void checkColWinner(int timesPressed) {
		boolean playerOnePlays = timesPressed % 2 == 0;
		for (int i = 0; i < 3; i++) {
			if (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] != null)
			{
				String winnerIdx = playerOnePlays ? "1" : "2";
				JOptionPane.showMessageDialog(null, MessageFormat.format("Player {0} wins", winnerIdx));
				System.exit(0);
			}
		}
	}

	private void checkDiagonalWinner(int timesPressed) {
		boolean playerOnePlays = timesPressed % 2 == 0;
		if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != null)
		{
			String winnerIdx = playerOnePlays ? "1" : "2";
			JOptionPane.showMessageDialog(null, MessageFormat.format("Player {0} wins", winnerIdx));
			System.exit(0);
		}
		if (board[2][0] == board[1][1] && board[2][0] == board[0][2] && board[2][0] != null)
		{
			String winnerIdx = playerOnePlays ? "1" : "2";
			JOptionPane.showMessageDialog(null, MessageFormat.format("Player {0} wins", winnerIdx));
			System.exit(0);
		}
	}
	
	private void checkRowWinner(int timesPressed) {
		boolean playerOnePlays = timesPressed % 2 == 0;
		for (int i = 0; i < 3; i++) {
			String[] row = board[i];
			if (row[0] == row[1] && row[0] == row[2] && row[0] != null)
			{
				String winnerIdx = playerOnePlays ? "1" : "2";
				JOptionPane.showMessageDialog(null, MessageFormat.format("Player {0} wins", winnerIdx));
				System.exit(0);
			}
		}
	}

	public ArrayList<Integer> indexTo2DIndexes(int idx)
	{
		ArrayList<Integer> coordinates = new ArrayList<Integer>();
		coordinates.add(idx / 3);
		coordinates.add(idx % 3);
		return coordinates;
	}
}
