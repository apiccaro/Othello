package Othello;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class GameMouseListener implements MouseListener {

	GameBoard board;

	public GameMouseListener(GameBoard board) {
		// TODO Auto-generated constructor stub
		this.board = board;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// keeps coordinates

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		// finds the X and Y coordinates of the circles
		int xAxis = e.getX() - board.width / 2;
		int yAxis = e.getY() - board.height / 2;

		// determines if it is a valid move
		// boolean turn = board.run1.getTurn();

		userTurn(xAxis, yAxis);

		computerTurn();
		
		isGameOver(xAxis, yAxis);

		board.run1.setTurn(true);

	}

	// game over
	// determine winner
	public void isGameOver(int x, int y) {
		if (!board.run1.isValidMove(board, x, y)) {
			board.run1.setTurn(false);
			if (!board.run1.isCompValid(board)) {

				board.run1.setGameOver(true);
				board.run1.setWinner(board);
			}
		}

	}

//this method sets the turn to white and completes a user turn
	public void userTurn(int x, int y) {
		board.run1.setTurn(true);

		if (board.run1.isValidMove(board, x, y)) {
			board.repaint();
		}

	}

//this method sets the turn to black and completes a computer turn
	public void computerTurn() {
		board.run1.setTurn(false);

		if (board.run1.isCompValid(board)) {
			board.run1.flip(board, board.run1.getRow(), board.run1.getCol());
			board.repaint();
		}
		board.run1.setTurn(true);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
