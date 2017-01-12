import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.MessageFormat;

import javax.swing.JApplet;

public class TicTacToeUI extends JApplet {
	ButtonWithIndex[] buttons = new ButtonWithIndex[9];
	BoardLogic boardlogic = new BoardLogic();
	ButtonPressedCounter btnPressCounter = new ButtonPressedCounter();
	
	
	public TicTacToeUI(){
		buttons = new ButtonWithIndex[9];
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new ButtonWithIndex(i, " ");
			buttons[i].setPreferredSize(new Dimension(70, 70));
		}
	}
		
    public void init() {
    	this.setLayout(new GridLayout(3, 3));

    	for (int i = 0; i < buttons.length; i++) {
    		ButtonWithIndex currentButton = buttons[i];
    		currentButton.setFont(new Font("Arial", Font.PLAIN, 40));
    		currentButton.addActionListener(new ActionListener() {
    		    public void actionPerformed(ActionEvent e) {
    		    	boolean playerOnePlays = btnPressCounter.timesPressed % 2 == 0;
    		    	if (playerOnePlays)
    		    	{
    		    		currentButton.setText("X");
    		    	}
    		    	else
    		    	{
    		    		currentButton.setText("O");
    		    	}    		    	
    		    	currentButton.setEnabled(false);
    		    	boardlogic.fillSquare(currentButton.index, playerOnePlays);
    		    	boardlogic.checkIfWinner(btnPressCounter.timesPressed);
    		    	btnPressCounter.pressButton();
    		    }
    		});
    	}
    	
		for (int i = 0; i < buttons.length; i++) {
			getContentPane().add(buttons[i]);
		}
  }
}
