package creation.sahif.tictactoegui;

import javax.swing.JFrame;

/*
 *This program to test TicTacToe
 *create frame to visible
 *@author Khoerudin
 */

public class TicTacToeTest{
	public static void main(String[] args) {
		TicTacToe ttt = new TicTacToe();
		ttt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ttt.setSize(220, 340);
		ttt.setResizable(false);
		ttt.setVisible(true);
	}
}
