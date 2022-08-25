package Othello;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//send mouse messages to the game board
public class GameBoard extends JComponent {
	// class variables for the location of the mouse and circle size and main panel
	// and creates a new game

	int width = 40;
	int height = 40;
	int dimensions = 8;
	int panelHt = 700;
	int panelWh = 700;

	Game run1 = new Game();
	Square[][] grid;
	//constructor that initializes the game board
	public GameBoard() {
		int squareWidth = panelWh / dimensions;
		int squareHeight = panelHt / dimensions;
		grid = new Square[dimensions][dimensions];
		// initializes an 8x8 grid based on sized of size of panel
		for (int i = 0; i < dimensions; i++) {
			for (int j = 0; j < dimensions; j++) {
				grid[i][j] = new Square(i * squareWidth, j * squareHeight, squareWidth, squareHeight, null);
			}

		}
		// initializes the starting othello pieces
		grid[3][3].setColor("white");
		grid[3][4].setColor("black");
		grid[4][4].setColor("white");
		grid[4][3].setColor("black");

	}

	// paints the board during and when a winner is declared
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
	//	g2.setColor(Color.WHITE);
		
		drawGrid(g2);
		if (run1.gameOver) {
			if (grid[0][0].isWhite()) {
				g2.setColor(Color.BLACK);
				g2.setFont(new Font("BOLD", Font.PLAIN, 50));
				g2.drawString("WHITE WINS", 250, 325);
				//JOptionPane.showMessageDialog(null,"WHITE WINS");
				
			} else {
				g2.setColor(Color.WHITE);
				g2.setFont(new Font("BOLD", Font.PLAIN, 50));
				g2.drawString("BLACK WINS", 250, 325);
			//	JOptionPane.showMessageDialog(null,"BLACK WINS");
				
			}
		}
		
		
		

	}

	// draws the grid of squares
	public void drawGrid(Graphics2D g2) {
		g2.setColor(Color.BLACK);
		for (int row = 0; row < dimensions; row++) {
			for (int col = 0; col < dimensions; col++) {
				// x,y,width,height
				grid[row][col].draw(g2);

			}
		}

	}

}
