package Othello;

import java.awt.Color;

import javax.swing.JFrame;
/*
 * This class assembles and runs the Othello application
 * The Mouselistener is connected to the board
 */
public class GameWindow {
	public static void main(String[] args) {
		GameWindow run1=new GameWindow();
		run1.run();
	}
	public void run() {
		//object represents a window
		JFrame frame = new JFrame("Game Board");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700,720);
		frame.setLocation(600,300);
		frame.getContentPane().setBackground(Color.BLUE);
		GameBoard board=new GameBoard();
	
		frame.add(board);
		GameMouseListener listener=new GameMouseListener(board);
		//connects listener to board
		board.addMouseListener(listener);
		frame.setVisible(true);
		
	}
}
