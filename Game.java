package Othello;

import java.awt.Color;
import java.util.ArrayList;
//this class keeps track of the turns, the validity of the 
//move, flipping the pieces, determining winners and converting 
//x and y coordinates to rows and cols

public class Game {

	private boolean whiteTurn = true;
	public boolean gameOver = false;
	private int compCol = -1;
	private int compRow = -1;

	public boolean getTurn() {
		return whiteTurn;
	}

	public void setTurn(boolean yOrN) {
		whiteTurn = yOrN;
	}

	public void setRow(int row) {
		compRow = row;

	}

	public void setGameOver(boolean isOver) {
		gameOver = isOver;

	}

	public void setCol(int col) {
		compCol = col;

	}

	public int getCol() {
		// TODO Auto-generated method stub
		return compCol;
	}

	public int getRow() {
		// TODO Auto-generated method stub
		return compRow;
	}

	// determines if move is valid given an x and y coord
	public boolean isValidMove(GameBoard board, int x, int y) {
		boolean isValid = false;
		boolean shouldFlip = false;

		int oppColor = 0;

		String coordColor = null;
		// finds the row and col of the click
		int col = xtoCol(x);
		int row = ytoRow(y);
		ArrayList<Square> flipThese = new ArrayList<Square>();
		// if square clicked is already occupied
		if (board.grid[row][col].isWhite() || board.grid[row][col].isBlack()) {
			return false;
		}
		// finds the turn color to compare squares around it
		if (board.run1.getTurn()) {
			coordColor = "white";
		} else {
			coordColor = "black";
		}
		System.out.println(coordColor);
		// Checks for valid moves on upper left diagonal
		oppColor = 0;

		if (row <= col) {
			for (int i = 1; i <= row; i++) {
				// if out of bounds
				if (row - i < 0 || col - i < 0) {
					break;
				}
				// if color next to is same
				if (i == 1 && board.grid[row - i][col - i].getColor().equals(coordColor)) {

					break;
				}
				// if empty
				if (!board.grid[row - i][col - i].isBlack() && !board.grid[row - i][col - i].isWhite()) {

					break;
				}
				// if there is a same color and there is at least one oppcolor the pieces should
				// flip
				if (board.grid[row - i][col - i].getColor().equals(coordColor) && oppColor > 0) {
					//
					shouldFlip = true;
					break;
				}
				// if the piece is an opposite color-increment
				else {
					oppColor++;
				}
				// add the square to arraylist
				flipThese.add(board.grid[row - i][col - i]);

			}
		} else {

			for (int i = 1; i <= col; i++) {
				// if out of bounds
				if (row - i < 0 || col - i < 0) {
					break;
				}
				// if same color
				if (i == 1 && board.grid[row - i][col - i].getColor().equals(coordColor)) {

					break;
				}
				// if empty
				if (!board.grid[row - i][col - i].isBlack() && !board.grid[row - i][col - i].isWhite()) {

					break;
				}
				// if more than one opposite color and another same color tile then should flip
				// in that direction
				if (board.grid[row - i][col - i].getColor().equals(coordColor) && oppColor > 0) {

					shouldFlip = true;
					break;
				} else {
					oppColor++;
				}

				flipThese.add(board.grid[row - i][col - i]);
			}
		}
		// if the move in that direction is valid
		if (shouldFlip) {
			board.grid[row][col].setColor(coordColor);
			for (int i = 0; i < flipThese.size(); i++) {
				flipThese.get(i).setColor(coordColor);
				isValid = true;

			}
		}
		// resets to make sure there are no duplicates
		flipThese.clear();
		shouldFlip = false;
		// upper right diagonal
		oppColor = 0;
		if (row == col) {
			if (row >= 4) {
				for (int i = 1; i < 8 - row; i++) {
					// if out of bounds
					if (row - i < 0 || col + i > 7) {
						break;
					}
					// if the one next to it is same color
					if (i == 1 && board.grid[row - i][col + i].getColor().equals(coordColor)) {

						break;
					}
					// if empty
					if (!board.grid[row - i][col + i].isBlack() && !board.grid[row - i][col + i].isWhite()) {

						break;
					}
					// if there is more than one opp color and another similar color is found
					if (board.grid[row - i][col + i].getColor().equals(coordColor) && oppColor > 0) {

						shouldFlip = true;
						break;
					} else {
						oppColor++;
					}

					flipThese.add(board.grid[row - i][col + i]);
				}
			} else {
				for (int i = 1; i <= row; i++) {
					// if out of bounds
					if (row - i < 0 || col + i > 7) {
						break;
					}
					// if the one next to it is same color
					if (i == 1 && board.grid[row - i][col + i].getColor().equals(coordColor)) {

						break;
					}
					// if empty
					if (!board.grid[row - i][col + i].isBlack() && !board.grid[row - i][col + i].isWhite()) {

						break;
					}
					// if there is more than one opp color and another similar color is found
					if (board.grid[row - i][col + i].getColor().equals(coordColor) && oppColor > 0) {

						shouldFlip = true;
						break;
					} else {
						oppColor++;
					}

					flipThese.add(board.grid[row - i][col + i]);
				}
			}
		} else if (row > col) {
			if (row > 4) {
				for (int i = 1; i < 8 - col; i++) {
					// if out of bounds
					if (row - i < 0 || col + i > 7) {
						break;
					}
					// if the one next to it is same color
					if (i == 1 && board.grid[row - i][col + i].getColor().equals(coordColor)) {

						break;
					}
					// if empty
					if (!board.grid[row - i][col + i].isBlack() && !board.grid[row - i][col + i].isWhite()) {

						break;
					}
					// if there is more than one opp color and another similar color is found
					if (board.grid[row - i][col + i].getColor().equals(coordColor) && oppColor > 0) {

						shouldFlip = true;
						break;
					} else {
						oppColor++;
					}

					flipThese.add(board.grid[row - i][col + i]);
				}
			} else {
				for (int i = 1; i <= row; i++) {
					// if out of bounds
					if (row - i < 0 || col + i > 7) {
						break;
					}
					// if the one next to it is same color
					if (i == 1 && board.grid[row - i][col + i].getColor().equals(coordColor)) {

						break;
					}
					// if empty
					if (!board.grid[row - i][col + i].isBlack() && !board.grid[row - i][col + i].isWhite()) {

						break;
					}
					// if there is more than one opp color and another similar color is found
					if (board.grid[row - i][col + i].getColor().equals(coordColor) && oppColor > 0) {

						shouldFlip = true;
						break;
					} else {
						oppColor++;
					}

					flipThese.add(board.grid[row - i][col + i]);
				}
			}

		} else {
			if (row > 3) {
				for (int i = 1; i < 8 - col; i++) {
					// if out of bounds
					if (row - i < 0 || col + i > 7) {
						break;
					}
					// if the one next to it is same color
					if (i == 1 && board.grid[row - i][col + i].getColor().equals(coordColor)) {

						break;
					}
					// if empty
					if (!board.grid[row - i][col + i].isBlack() && !board.grid[row - i][col + i].isWhite()) {

						break;
					}
					// if there is more than one opp color and another similar color is found
					if (board.grid[row - i][col + i].getColor().equals(coordColor) && oppColor > 0) {

						shouldFlip = true;
						break;
					} else {
						oppColor++;
					}

					flipThese.add(board.grid[row - i][col + i]);
				}
			} else {
				for (int i = 1; i <= row; i++) {// changed
					// if out of bounds
					if (row - i < 0 || col + i > 7) {
						break;
					}
					// if the one next to it is same color
					if (i == 1 && board.grid[row - i][col + i].getColor().equals(coordColor)) {

						break;
					}
					// if empty
					if (!board.grid[row - i][col + i].isBlack() && !board.grid[row - i][col + i].isWhite()) {

						break;
					}
					// if there is more than one opp color and another similar color is found
					if (board.grid[row - i][col + i].getColor().equals(coordColor) && oppColor > 0) {

						shouldFlip = true;
						break;
					} else {
						oppColor++;
					}

					flipThese.add(board.grid[row - i][col + i]);
				}

			}
		}
		// if the move in that direction is valid

		if (shouldFlip) {
			board.grid[row][col].setColor(coordColor);
			for (int i = 0; i < flipThese.size(); i++) {
				flipThese.get(i).setColor(coordColor);
				isValid = true;

			}
		}
		// resets
		shouldFlip = false;
		flipThese.clear();
		// lower left diagonal
		oppColor = 0;
		if (row < col) {
			if (col > 4) {
				for (int i = 1; i < 8 - row; i++) {
					// if out of bounds
					if (row + i > 7 || col - i < 0) {
						break;
					}
					// if the next square is the same color
					if (i == 1 && board.grid[row + i][col - i].getColor().equals(coordColor)) {

						break;
					}
					// if empty
					if (!board.grid[row + i][col - i].isBlack() && !board.grid[row + i][col - i].isWhite()) {

						break;
					}
					// if same color is found and there are at least one opposite color tiles
					if (board.grid[row + i][col - i].getColor().equals(coordColor) && oppColor > 0) {

						shouldFlip = true;
						break;
					} else {
						oppColor++;
					}

					flipThese.add(board.grid[row + i][col - i]);
				}
			} else {
				for (int i = 1; i <= col; i++) {
					// if out of bounds
					if (row + i > 7 || col - i < 0) {
						break;
					}
					// if the next square is the same color
					if (i == 1 && board.grid[row + i][col - i].getColor().equals(coordColor)) {

						break;
					}
					// if empty
					if (!board.grid[row + i][col - i].isBlack() && !board.grid[row + i][col - i].isWhite()) {

						break;
					}
					// if same color is found and there are at least one opposite color tiles
					if (board.grid[row + i][col - i].getColor().equals(coordColor) && oppColor > 0) {

						shouldFlip = true;
						break;
					} else {
						oppColor++;
					}

					flipThese.add(board.grid[row + i][col - i]);

				}
			}

		} else if (row > col) {
			if (row > 3) {
				for (int i = 1; i < 8 - row; i++) {
					// if out of bounds
					if (row + i > 7 || col - i < 0) {
						break;
					}
					// if the next square is the same color
					if (i == 1 && board.grid[row + i][col - i].getColor().equals(coordColor)) {

						break;
					}
					// if empty
					if (!board.grid[row + i][col - i].isBlack() && !board.grid[row + i][col - i].isWhite()) {

						break;
					}
					// if same color is found and there are at least one opposite color tiles
					if (board.grid[row + i][col - i].getColor().equals(coordColor) && oppColor > 0) {

						shouldFlip = true;
						break;
					} else {
						oppColor++;
					}
					flipThese.add(board.grid[row + i][col - i]);
				}
			} else {
				for (int i = 1; i <= row; i++) {// CHANGED
					// if out of bounds
					if (row + i > 7 || col - i < 0) {
						break;
					}
					// if the next square is the same color
					if (i == 1 && board.grid[row + i][col - i].getColor().equals(coordColor)) {

						break;
					}
					// if empty
					if (!board.grid[row + i][col - i].isBlack() && !board.grid[row + i][col - i].isWhite()) {

						break;
					}
					// if same color is found and there are at least one opposite color tiles
					if (board.grid[row + i][col - i].getColor().equals(coordColor) && oppColor > 0) {

						shouldFlip = true;
						break;
					} else {
						oppColor++;
					}

					flipThese.add(board.grid[row + i][col - i]);

				}
			}
		} else {
			if (row < 3) {
				for (int i = 1; i <= col; i++) {
					// if out of bounds
					if (row + i > 7 || col - i < 0) {
						break;
					}
					// if the next square is the same color
					if (i == 1 && board.grid[row + i][col - i].getColor().equals(coordColor)) {

						break;
					}
					// if empty
					if (!board.grid[row + i][col - i].isBlack() && !board.grid[row + i][col - i].isWhite()) {

						break;
					}
					// if same color is found and there are at least one opposite color tiles
					if (board.grid[row + i][col - i].getColor().equals(coordColor) && oppColor > 0) {

						shouldFlip = true;
						break;
					} else {
						oppColor++;
					}
					flipThese.add(board.grid[row + i][col - i]);
				}
			} else {
				for (int i = 1; i < 8 - row; i++) {
					// if out of bounds
					if (row + i > 7 || col - i < 0) {
						break;
					}
					// if the next square is the same color
					if (i == 1 && board.grid[row + i][col - i].getColor().equals(coordColor)) {

						break;
					}
					// if empty
					if (!board.grid[row + i][col - i].isBlack() && !board.grid[row + i][col - i].isWhite()) {

						break;
					}
					// if same color is found and there are at least one opposite color tiles
					if (board.grid[row + i][col - i].getColor().equals(coordColor) && oppColor > 0) {

						shouldFlip = true;
						break;
					} else {
						oppColor++;
					}

					flipThese.add(board.grid[row + i][col - i]);
				}
			}
		}
		// if that was a valid direction
		if (shouldFlip) {
			board.grid[row][col].setColor(coordColor);
			for (int i = 0; i < flipThese.size(); i++) {
				flipThese.get(i).setColor(coordColor);
				isValid = true;

			}
		}
		// resets
		shouldFlip = false;
		flipThese.clear();
		// lower right diagonal
		oppColor = 0;
		if (row <= col) {
			for (int i = 1; i < 8 - col; i++) {
				// if out of bounds
				if (row + i > 7 || col + i > 7) {
					break;
				}
				// if the one first next to it is same color
				if (i == 1 && board.grid[row + i][col + i].getColor().equals(coordColor)) {

					break;
				}
				// if empty
				if (!board.grid[row + i][col + i].isBlack() && !board.grid[row + i][col + i].isWhite()) {

					break;
				}
				// if there is a same color tile and at least one opposite color in between
				if (board.grid[row + i][col + i].getColor().equals(coordColor) && oppColor > 0) {

					shouldFlip = true;
					break;
				} else {
					oppColor++;
				}

				flipThese.add(board.grid[row + i][col + i]);
			}
		} else {
			for (int i = 1; i < 8 - row; i++) {
				// if out of bounds
				if (row + i > 7 || col + i > 7) {
					break;
				}
				// if the one first next to it is same color
				if (i == 1 && board.grid[row + i][col + i].getColor().equals(coordColor)) {

					break;
				}
				// if empty
				if (!board.grid[row + i][col + i].isBlack() && !board.grid[row + i][col + i].isWhite()) {

					break;
				}
				// if there is a same color tile and at least one opposite color in between
				if (board.grid[row + i][col + i].getColor().equals(coordColor) && oppColor > 0) {

					shouldFlip = true;
					break;
				} else {
					oppColor++;
				}

				flipThese.add(board.grid[row + i][col + i]);
			}
		}
		// if is valid move in that direction
		if (shouldFlip) {
			board.grid[row][col].setColor(coordColor);
			for (int i = 0; i < flipThese.size(); i++) {

				flipThese.get(i).setColor(coordColor);
				isValid = true;
			}

		}

		// resets
		shouldFlip = false;
		flipThese.clear();

		// up
		oppColor = 0;
		for (int i = 1; i <= row; i++) {
			// if the closest square is same color
			if (i == 1 && board.grid[row - i][col].getColor().equals(coordColor)) {

				break;
			}
			// if empty
			if ((!board.grid[row - i][col].isBlack() && !board.grid[row - i][col].isWhite())) {

				break;
			}
			// if a same color square is found and there is at least one opposite color
			// square in between
			if (board.grid[row - i][col].getColor().equals(coordColor) && oppColor > 0) {

				shouldFlip = true;
				break;
			} else {
				oppColor++;
			}

			flipThese.add(board.grid[row - i][col]);

		}
		// if valid move in that direction
		if (shouldFlip) {
			board.grid[row][col].setColor(coordColor);
			for (int i = 0; i < flipThese.size(); i++) {
				flipThese.get(i).setColor(coordColor);
				isValid = true;
			}

		}
		// resets
		flipThese.clear();
		shouldFlip = false;

		// down
		oppColor = 0;
		for (int i = 1; i < 8 - row; i++) {
			// if nearest square is same color
			if (i == 1 && board.grid[row + i][col].getColor().equals(coordColor)) {
				break;
			}
			// if empty
			if (!board.grid[row + i][col].isBlack() && !board.grid[row + i][col].isWhite()) {

				break;
			}
			// if same color square is found and there is at least one square of opposite
			// color between
			if (board.grid[row + i][col].getColor().equals(coordColor) && oppColor > 0) {
				shouldFlip = true;
				break;
			} else {
				oppColor++;
			}
			flipThese.add(board.grid[row + i][col]);

		}
		// if valid move in that direction
		if (shouldFlip) {
			board.grid[row][col].setColor(coordColor);
			for (int i = 0; i < flipThese.size(); i++) {
				flipThese.get(i).setColor(coordColor);
				isValid = true;
			}

		}
		// resets
		flipThese.clear();
		shouldFlip = false;
		// left

		oppColor = 0;
		for (int i = 1; i <= col; i++) {
			// if nearest square is same color
			if (i == 1 && board.grid[row][col - i].getColor().equals(coordColor)) {

				break;
			}
			// if empty
			if (!board.grid[row][col - i].isBlack() && !board.grid[row][col - i].isWhite()) {

				break;
			}
			// if same color square is found and there is at least one opposite color square
			// in between
			if (board.grid[row][col - i].getColor().equals(coordColor) && oppColor > 0) {
				shouldFlip = true;
				break;

			} else {
				oppColor++;
			}
			flipThese.add(board.grid[row][col - i]);
		}
		// if valid move in that direction
		if (shouldFlip) {
			board.grid[row][col].setColor(coordColor);
			for (int i = 0; i < flipThese.size(); i++) {
				flipThese.get(i).setColor(coordColor);
				isValid = true;

			}

		}
		// resets
		flipThese.clear();
		shouldFlip = false;

		// right

		oppColor = 0;
		for (int i = 1; i < 8 - col; i++) {
			// if nearest square is same color
			if (i == 1 && board.grid[row][col + i].getColor().equals(coordColor)) {

				break;
			}
			// if empty
			if (!board.grid[row][col + i].isBlack() && !board.grid[row][col + i].isWhite()) {
				break;
			}
			// if there is another similar color square found and at least one opposite
			// color square in between
			if (board.grid[row][col + i].getColor().equals(coordColor) && oppColor > 0) {
				shouldFlip = true;
				break;

			} else {
				oppColor++;

			}
			flipThese.add(board.grid[row][col + i]);

		}
		// if valid move in that direction
		if (shouldFlip) {
			board.grid[row][col].setColor(coordColor);
			for (int i = 0; i < flipThese.size(); i++) {
				flipThese.get(i).setColor(coordColor);
				isValid = true;

			}

		}

		// if any of the moves are valid--will return true
		return isValid;
	}

	// finds if there is a valid move by the computer on the board by looping
	// through entire grid
	public boolean isCompValid(GameBoard board) {
		boolean isValid = false;
		boolean shouldFlip = false;
		int oppColor = 0;
		int[] maxFlips = new int[3];
		int flips = 0;
		String coordColor = null;
		// finds the turn color to compare squares around it
		if (board.run1.getTurn()) {
			coordColor = "white";
		} else {
			coordColor = "black";
		}
		ArrayList<Square> flipThese = new ArrayList<Square>();

		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				shouldFlip = false;

				// Checks for valid moves on upper left diagonal
				oppColor = 0;

				if (row <= col) {
					for (int i = 1; i <= row; i++) {

						// if occupied
						if (board.grid[row][col].getColor().equalsIgnoreCase("white")
								|| board.grid[row][col].getColor().equalsIgnoreCase("black")) {
							break;
						}
						// if out of bounds{
						if (row - i < 0 || col - i < 0) {
							break;
						}
						// if color next to is same
						if (i == 1 && board.grid[row - i][col - i].getColor().equals(coordColor)) {

							break;
						}
						// if empty
						if (!board.grid[row - i][col - i].isBlack() && !board.grid[row - i][col - i].isWhite()) {

							break;
						}
						// if there is a same color and there is at least one oppcolor the pieces should
						// flip
						if (board.grid[row - i][col - i].getColor().equals(coordColor) && oppColor > 0) {
							//
							shouldFlip = true;
							break;
						}
						// if the piece is an opposite color-increment
						else {
							oppColor++;
						}
						// add the square to arraylist
						flipThese.add(board.grid[row - i][col - i]);

					}
				} else {

					for (int i = 1; i <= col; i++) {
						// if occupied
						if (board.grid[row][col].getColor().equalsIgnoreCase("white")
								|| board.grid[row][col].getColor().equalsIgnoreCase("black")) {
							break;
						}
						// if out of bounds
						if (row - i < 0 || col - i < 0) {
							break;
						}
						// if same color
						if (i == 1 && board.grid[row - i][col - i].getColor().equals(coordColor)) {

							break;
						}
						// if empty
						if (!board.grid[row - i][col - i].isBlack() && !board.grid[row - i][col - i].isWhite()) {

							break;
						}
						// if more than one opposite color and another same color tile then should flip
						// in that direction
						if (board.grid[row - i][col - i].getColor().equals(coordColor) && oppColor > 0) {

							shouldFlip = true;
							break;
						} else {
							oppColor++;
						}

						flipThese.add(board.grid[row - i][col - i]);
					}
				}
				// if that was a valid direction add to total flips
				if (shouldFlip) {
					// System.out.println("This direction is valid: upper left");
					flips += flipThese.size();
					isValid = true;

				}
				// resets to make sure there are no duplicates
				flipThese.clear();
				shouldFlip = false;
				// upper right diagonal
				oppColor = 0;
				if (row == col) {
					if (row >= 4) {
						for (int i = 1; i < 8 - row; i++) {
							// if already occupied
							if (board.grid[row][col].getColor().equalsIgnoreCase("white")
									|| board.grid[row][col].getColor().equalsIgnoreCase("black")) {
								break;
							}
							// if out of bounds
							if (row - i < 0 || col + i > 7) {
								break;
							}
							// if the one next to it is same color
							if (i == 1 && board.grid[row - i][col + i].getColor().equals(coordColor)) {

								break;
							}
							// if empty
							if (!board.grid[row - i][col + i].isBlack() && !board.grid[row - i][col + i].isWhite()) {

								break;
							}
							// if there is more than one opp color and another similar color is found
							if (board.grid[row - i][col + i].getColor().equals(coordColor) && oppColor > 0) {

								shouldFlip = true;
								break;
							} else {
								oppColor++;
							}

							flipThese.add(board.grid[row - i][col + i]);
						}
					} else {
						for (int i = 1; i <= row; i++) {
							// if already occupied
							if (board.grid[row][col].getColor().equalsIgnoreCase("white")
									|| board.grid[row][col].getColor().equalsIgnoreCase("black")) {
								break;
							}
							// if out of bounds
							if (row - i < 0 || col + i > 7) {
								break;
							}
							// if the one next to it is same color
							if (i == 1 && board.grid[row - i][col + i].getColor().equals(coordColor)) {

								break;
							}
							// if empty
							if (!board.grid[row - i][col + i].isBlack() && !board.grid[row - i][col + i].isWhite()) {

								break;
							}
							// if there is more than one opp color and another similar color is found
							if (board.grid[row - i][col + i].getColor().equals(coordColor) && oppColor > 0) {

								shouldFlip = true;
								break;
							} else {
								oppColor++;
							}

							flipThese.add(board.grid[row - i][col + i]);
						}
					}
				} else if (row > col) {
					if (row > 4) {
						for (int i = 1; i < 8 - col; i++) {
							// if already occupied
							if (board.grid[row][col].getColor().equalsIgnoreCase("white")
									|| board.grid[row][col].getColor().equalsIgnoreCase("black")) {
								break;
							}
							// if out of bounds
							if (row - i < 0 || col + i > 7) {
								break;
							}
							// if the one next to it is same color
							if (i == 1 && board.grid[row - i][col + i].getColor().equals(coordColor)) {

								break;
							}
							// if empty
							if (!board.grid[row - i][col + i].isBlack() && !board.grid[row - i][col + i].isWhite()) {

								break;
							}
							// if there is more than one opp color and another similar color is found
							if (board.grid[row - i][col + i].getColor().equals(coordColor) && oppColor > 0) {

								shouldFlip = true;
								break;
							} else {
								oppColor++;
							}

							flipThese.add(board.grid[row - i][col + i]);
						}
					} else {
						for (int i = 1; i <= row; i++) {
							// if already occupied
							if (board.grid[row][col].getColor().equalsIgnoreCase("white")
									|| board.grid[row][col].getColor().equalsIgnoreCase("black")) {
								break;
							}
							// if out of bounds
							if (row - i < 0 || col + i > 7) {
								break;
							}
							// if the one next to it is same color
							if (i == 1 && board.grid[row - i][col + i].getColor().equals(coordColor)) {

								break;
							}
							// if empty
							if (!board.grid[row - i][col + i].isBlack() && !board.grid[row - i][col + i].isWhite()) {

								break;
							}
							// if there is more than one opp color and another similar color is found
							if (board.grid[row - i][col + i].getColor().equals(coordColor) && oppColor > 0) {

								shouldFlip = true;
								break;
							} else {
								oppColor++;
							}

							flipThese.add(board.grid[row - i][col + i]);
						}
					}

				} else {
					if (row > 3) {
						for (int i = 1; i < 8 - col; i++) {
							// if already occupied
							if (board.grid[row][col].getColor().equalsIgnoreCase("white")
									|| board.grid[row][col].getColor().equalsIgnoreCase("black")) {
								break;
							}
							// if out of bounds
							if (row - i < 0 || col + i > 7) {
								break;
							}
							// if the one next to it is same color
							if (i == 1 && board.grid[row - i][col + i].getColor().equals(coordColor)) {

								break;
							}
							// if empty
							if (!board.grid[row - i][col + i].isBlack() && !board.grid[row - i][col + i].isWhite()) {

								break;
							}
							// if there is more than one opp color and another similar color is found
							if (board.grid[row - i][col + i].getColor().equals(coordColor) && oppColor > 0) {

								shouldFlip = true;
								break;
							} else {
								oppColor++;
							}

							flipThese.add(board.grid[row - i][col + i]);
						}
					} else {
						for (int i = 1; i <= row; i++) {
							// if already occupied
							if (board.grid[row][col].getColor().equalsIgnoreCase("white")
									|| board.grid[row][col].getColor().equalsIgnoreCase("black")) {
								break;
							}
							// if out of bounds
							if (row - i < 0 || col + i > 7) {
								break;
							}
							// if the one next to it is same color
							if (i == 1 && board.grid[row - i][col + i].getColor().equals(coordColor)) {

								break;
							}
							// if empty
							if (!board.grid[row - i][col + i].isBlack() && !board.grid[row - i][col + i].isWhite()) {

								break;
							}
							// if there is more than one opp color and another similar color is found
							if (board.grid[row - i][col + i].getColor().equals(coordColor) && oppColor > 0) {

								shouldFlip = true;
								break;
							} else {
								oppColor++;
							}

							flipThese.add(board.grid[row - i][col + i]);
						}

					}
				}
				// if that was a valid direction add to total flips
				if (shouldFlip) {
					// System.out.println("This direction is valid: upper right");
					flips += flipThese.size();
					isValid = true;

				}

				// resets
				shouldFlip = false;
				flipThese.clear();
				// lower left diagonal
				oppColor = 0;
				if (row < col) {
					if (col > 4) {
						for (int i = 1; i < 8 - row; i++) {
							// if already occupied
							if (board.grid[row][col].getColor().equalsIgnoreCase("white")
									|| board.grid[row][col].getColor().equalsIgnoreCase("black")) {
								break;
							}
							// if out of bounds
							if (row + i > 7 || col - i < 0) {
								break;
							}
							// if the next square is the same color
							if (i == 1 && board.grid[row + i][col - i].getColor().equals(coordColor)) {

								break;
							}
							// if empty
							if (!board.grid[row + i][col - i].isBlack() && !board.grid[row + i][col - i].isWhite()) {

								break;
							}
							// if same color is found and there are at least one opposite color tiles
							if (board.grid[row + i][col - i].getColor().equals(coordColor) && oppColor > 0) {

								shouldFlip = true;
								break;
							} else {
								oppColor++;
							}

							flipThese.add(board.grid[row + i][col - i]);
						}
					} else {
						for (int i = 1; i <= col; i++) {
							// if already occupied
							if (board.grid[row][col].getColor().equalsIgnoreCase("white")
									|| board.grid[row][col].getColor().equalsIgnoreCase("black")) {

								break;
							}
							// if out of bounds
							if (row + i > 7 || col - i < 0) {
								break;
							}
							// if the next square is the same color
							if (i == 1 && board.grid[row + i][col - i].getColor().equals(coordColor)) {

								break;
							}
							// if empty
							if (!board.grid[row + i][col - i].isBlack() && !board.grid[row + i][col - i].isWhite()) {

								break;
							}
							// if same color is found and there are at least one opposite color tiles
							if (board.grid[row + i][col - i].getColor().equals(coordColor) && oppColor > 0) {

								shouldFlip = true;
								break;
							} else {
								oppColor++;
							}

							flipThese.add(board.grid[row + i][col - i]);

						}
					}

				} else if (row > col) {
					if (row > 3) {
						for (int i = 1; i < 8 - row; i++) {
							// if already occupied
							if (board.grid[row][col].getColor().equalsIgnoreCase("white")
									|| board.grid[row][col].getColor().equalsIgnoreCase("black")) {

								break;
							}
							// if out of bounds
							if (row + i > 7 || col - i < 0) {
								break;
							}
							// if the next square is the same color
							if (i == 1 && board.grid[row + i][col - i].getColor().equals(coordColor)) {

								break;
							}
							// if empty
							if (!board.grid[row + i][col - i].isBlack() && !board.grid[row + i][col - i].isWhite()) {

								break;
							}
							// if same color is found and there are at least one opposite color tiles
							if (board.grid[row + i][col - i].getColor().equals(coordColor) && oppColor > 0) {

								shouldFlip = true;
								break;
							} else {
								oppColor++;
							}
							flipThese.add(board.grid[row + i][col - i]);
						}
					} else {
						for (int i = 1; i <= row; i++) {
							// if already occupied
							if (board.grid[row][col].getColor().equalsIgnoreCase("white")
									|| board.grid[row][col].getColor().equalsIgnoreCase("black")) {

								break;
							}
							// if out of bounds
							if (row + i > 7 || col - i < 0) {
								break;
							}
							// if the next square is the same color
							if (i == 1 && board.grid[row + i][col - i].getColor().equals(coordColor)) {

								break;
							}
							// if empty
							if (!board.grid[row + i][col - i].isBlack() && !board.grid[row + i][col - i].isWhite()) {

								break;
							}
							// if same color is found and there are at least one opposite color tiles
							if (board.grid[row + i][col - i].getColor().equals(coordColor) && oppColor > 0) {

								shouldFlip = true;
								break;
							} else {
								oppColor++;
							}

							flipThese.add(board.grid[row + i][col - i]);

						}
					}
				} else {
					if (row < 3) {
						for (int i = 1; i <= col; i++) {
							// if already occupied
							if (board.grid[row][col].getColor().equalsIgnoreCase("white")
									|| board.grid[row][col].getColor().equalsIgnoreCase("black")) {

								break;
							}
							// if out of bounds
							if (row + i > 7 || col - i < 0) {
								break;
							}
							// if the next square is the same color
							if (i == 1 && board.grid[row + i][col - i].getColor().equals(coordColor)) {

								break;
							}
							// if empty
							if (!board.grid[row + i][col - i].isBlack() && !board.grid[row + i][col - i].isWhite()) {

								break;
							}
							// if same color is found and there are at least one opposite color tiles
							if (board.grid[row + i][col - i].getColor().equals(coordColor) && oppColor > 0) {

								shouldFlip = true;
								break;
							} else {
								oppColor++;
							}
							flipThese.add(board.grid[row + i][col - i]);
						}
					} else {
						for (int i = 1; i < 8 - row; i++) {
							// if already occupied
							if (board.grid[row][col].getColor().equalsIgnoreCase("white")
									|| board.grid[row][col].getColor().equalsIgnoreCase("black")) {

								break;
							}
							// if out of bounds
							if (row + i > 7 || col - i < 0) {
								break;
							}
							// if the next square is the same color
							if (i == 1 && board.grid[row + i][col - i].getColor().equals(coordColor)) {

								break;
							}
							// if empty
							if (!board.grid[row + i][col - i].isBlack() && !board.grid[row + i][col - i].isWhite()) {

								break;
							}
							// if same color is found and there are at least one opposite color tiles
							if (board.grid[row + i][col - i].getColor().equals(coordColor) && oppColor > 0) {

								shouldFlip = true;
								break;
							} else {
								oppColor++;
							}

							flipThese.add(board.grid[row + i][col - i]);
						}
					}
				}
				// if that was a valid direction add to total flips
				if (shouldFlip) {
					// System.out.println("This direction is valid: lower left");
					flips += flipThese.size();
					isValid = true;

				}
				// resets
				shouldFlip = false;
				flipThese.clear();
				// lower right diagonal
				oppColor = 0;
				if (row <= col) {
					for (int i = 1; i < 8 - col; i++) {
						// if already occupied
						if (board.grid[row][col].getColor().equalsIgnoreCase("white")
								|| board.grid[row][col].getColor().equalsIgnoreCase("black")) {
							break;
						}
						// if out of bounds
						if (row + i > 7 || col + i > 7) {
							break;
						}
						// if the one first next to it is same color
						if (i == 1 && board.grid[row + i][col + i].getColor().equals(coordColor)) {

							break;
						}
						// if empty
						if (!board.grid[row + i][col + i].isBlack() && !board.grid[row + i][col + i].isWhite()) {

							break;
						}
						// if there is a same color tile and at least one opposite color in between
						if (board.grid[row + i][col + i].getColor().equals(coordColor) && oppColor > 0) {

							shouldFlip = true;
							break;
						} else {
							oppColor++;
						}

						flipThese.add(board.grid[row + i][col + i]);
					}
				} else {
					for (int i = 1; i < 8 - row; i++) {
						// if already occupied
						if (board.grid[row][col].getColor().equalsIgnoreCase("white")
								|| board.grid[row][col].getColor().equalsIgnoreCase("black")) {
							break;
						}
						// if out of bounds
						if (row + i > 7 || col + i > 7) {
							break;
						}
						// if the one first next to it is same color
						if (i == 1 && board.grid[row + i][col + i].getColor().equals(coordColor)) {

							break;
						}
						// if empty
						if (!board.grid[row + i][col + i].isBlack() && !board.grid[row + i][col + i].isWhite()) {

							break;
						}
						// if there is a same color tile and at least one opposite color in between
						if (board.grid[row + i][col + i].getColor().equals(coordColor) && oppColor > 0) {

							shouldFlip = true;
							break;
						} else {
							oppColor++;
						}

						flipThese.add(board.grid[row + i][col + i]);
					}
				}
				// if that was a valid direction add to total flips
				if (shouldFlip) {
					// System.out.println("This direction is valid: lower right");
					flips += flipThese.size();
					isValid = true;

				}
				// resets
				shouldFlip = false;
				flipThese.clear();

				// up
				oppColor = 0;
				for (int i = 1; i <= row; i++) {
					// if already occupied
					if (board.grid[row][col].getColor().equalsIgnoreCase("white")
							|| board.grid[row][col].getColor().equalsIgnoreCase("black")) {
						break;
					}
					// if the closest square is same color
					if (i == 1 && board.grid[row - i][col].getColor().equals(coordColor)) {

						break;
					}
					// if empty
					if ((!board.grid[row - i][col].isBlack() && !board.grid[row - i][col].isWhite())) {

						break;
					}
					// if a same color square is found and there is at least one opposite color
					// square in between
					if (board.grid[row - i][col].getColor().equals(coordColor) && oppColor > 0) {

						shouldFlip = true;
						break;
					} else {
						oppColor++;
					}

					flipThese.add(board.grid[row - i][col]);

				}
				// if that was a valid direction add to total flips
				if (shouldFlip) {
					// System.out.println("This direction is valid: up");
					flips += flipThese.size();
					isValid = true;

				}
				// resets
				flipThese.clear();
				shouldFlip = false;

				// down
				oppColor = 0;
				for (int i = 1; i < 8 - row; i++) {
					// if already occupied
					if (board.grid[row][col].getColor().equalsIgnoreCase("white")
							|| board.grid[row][col].getColor().equalsIgnoreCase("black")) {
						break;
					}
					// if nearest square is same color
					if (i == 1 && board.grid[row + i][col].getColor().equals(coordColor)) {
						break;
					}
					// if empty
					if (!board.grid[row + i][col].isBlack() && !board.grid[row + i][col].isWhite()) {

						break;
					}
					// if same color square is found and there is at least one square of opposite
					// color between
					if (board.grid[row + i][col].getColor().equals(coordColor) && oppColor > 0) {
						shouldFlip = true;
						break;
					} else {
						oppColor++;
					}
					flipThese.add(board.grid[row + i][col]);

				}
				// if that was a valid direction add to total flips
				if (shouldFlip) {
					// System.out.println("This direction is valid: down");
					flips += flipThese.size();
					isValid = true;

				}
				// resets
				flipThese.clear();
				shouldFlip = false;
				// left

				oppColor = 0;
				for (int i = 1; i <= col; i++) {
					// if already occupied
					if (board.grid[row][col].getColor().equalsIgnoreCase("white")
							|| board.grid[row][col].getColor().equalsIgnoreCase("black")) {
						break;
					}
					// if nearest square is same color
					if (i == 1 && board.grid[row][col - i].getColor().equals(coordColor)) {

						break;
					}
					// if empty
					if (!board.grid[row][col - i].isBlack() && !board.grid[row][col - i].isWhite()) {

						break;
					}
					// if same color square is found and there is at least one opposite color square
					// in between
					if (board.grid[row][col - i].getColor().equals(coordColor) && oppColor > 0) {
						shouldFlip = true;
						break;

					} else {
						oppColor++;
					}
					flipThese.add(board.grid[row][col - i]);
				}

				// if that was a valid direction add to total flips
				if (shouldFlip) {
					// System.out.println("This direction is valid: left");
					flips += flipThese.size();
					isValid = true;

				}
				// resets
				flipThese.clear();
				shouldFlip = false;

				// right

				oppColor = 0;
				for (int i = 1; i < 8 - col; i++) {
					// if already occupied
					if (board.grid[row][col].getColor().equalsIgnoreCase("white")
							|| board.grid[row][col].getColor().equalsIgnoreCase("black")) {
						break;
					}
					// if nearest square is same color
					if (i == 1 && board.grid[row][col + i].getColor().equals(coordColor)) {

						break;
					}
					// if empty
					if (!board.grid[row][col + i].isBlack() && !board.grid[row][col + i].isWhite()) {
						break;
					}
					// if there is another similar color square found and at least one opposite
					// color square in between
					if (board.grid[row][col + i].getColor().equals(coordColor) && oppColor > 0) {
						shouldFlip = true;
						break;

					} else {
						oppColor++;

					}
					flipThese.add(board.grid[row][col + i]);

				}
				// if that was a valid direction add to total flips
				if (shouldFlip) {
					// System.out.println("This direction is valid: right");
					flips += flipThese.size();
					isValid = true;

				}
				// System.out.println("Max Flip coordinates"+maxFlips[1]+" "+maxFlips[2]+"
				// Current Row Col"+row+col);
				if (flips > maxFlips[0]) {
					maxFlips[0] = flips;
					maxFlips[1] = row;
					maxFlips[2] = col;
				}

			}
		}

		// stores the max flip row and col
		if (isValid) {
			setRow(maxFlips[1]);
			setCol(maxFlips[2]);
		}

		return isValid;

	}

	// flips the pieces in all of the valid directions given a row and col
	public void flip(GameBoard board, int row, int col) {

		boolean shouldFlip = false;

		int oppColor = 0;

		String coordColor = null;
		ArrayList<Square> flipThese = new ArrayList<Square>();

		// finds the turn color to compare squares around it
		if (board.run1.getTurn()) {
			coordColor = "white";
		} else {
			coordColor = "black";
		}

		// Checks for valid moves on upper left diagonal
		oppColor = 0;

		if (row <= col) {
			for (int i = 1; i <= row; i++) {
				// if out of bounds
				if (row - i < 0 || col - i < 0) {
					break;
				}
				// if color next to is same
				if (i == 1 && board.grid[row - i][col - i].getColor().equals(coordColor)) {

					break;
				}
				// if empty
				if (!board.grid[row - i][col - i].isBlack() && !board.grid[row - i][col - i].isWhite()) {

					break;
				}
				// if there is a same color and there is at least one oppcolor the pieces should
				// flip
				if (board.grid[row - i][col - i].getColor().equals(coordColor) && oppColor > 0) {
					//
					shouldFlip = true;
					break;
				}
				// if the piece is an opposite color-increment
				else {
					oppColor++;
				}
				// add the square to arraylist
				flipThese.add(board.grid[row - i][col - i]);

			}
		} else {

			for (int i = 1; i <= col; i++) {
				// if out of bounds
				if (row - i < 0 || col - i < 0) {
					break;
				}
				// if same color
				if (i == 1 && board.grid[row - i][col - i].getColor().equals(coordColor)) {

					break;
				}
				// if empty
				if (!board.grid[row - i][col - i].isBlack() && !board.grid[row - i][col - i].isWhite()) {

					break;
				}
				// if more than one opposite color and another same color tile then should flip
				// in that direction
				if (board.grid[row - i][col - i].getColor().equals(coordColor) && oppColor > 0) {

					shouldFlip = true;
					break;
				} else {
					oppColor++;
				}

				flipThese.add(board.grid[row - i][col - i]);
			}
		}
		// if the move in that direction is valid
		if (shouldFlip) {
			board.grid[row][col].setColor(coordColor);
			for (int i = 0; i < flipThese.size(); i++) {
				flipThese.get(i).setColor(coordColor);

			}
		}
		// resets to make sure there are no duplicates
		flipThese.clear();
		shouldFlip = false;
		// upper right diagonal
		oppColor = 0;
		if (row == col) {
			if (row >= 4) {
				for (int i = 1; i < 8 - row; i++) {
					// if out of bounds
					if (row - i < 0 || col + i > 7) {
						break;
					}
					// if the one next to it is same color
					if (i == 1 && board.grid[row - i][col + i].getColor().equals(coordColor)) {

						break;
					}
					// if empty
					if (!board.grid[row - i][col + i].isBlack() && !board.grid[row - i][col + i].isWhite()) {

						break;
					}
					// if there is more than one opp color and another similar color is found
					if (board.grid[row - i][col + i].getColor().equals(coordColor) && oppColor > 0) {

						shouldFlip = true;
						break;
					} else {
						oppColor++;
					}

					flipThese.add(board.grid[row - i][col + i]);
				}
			} else {
				for (int i = 1; i <= row; i++) {
					// if out of bounds
					if (row - i < 0 || col + i > 7) {
						break;
					}
					// if the one next to it is same color
					if (i == 1 && board.grid[row - i][col + i].getColor().equals(coordColor)) {

						break;
					}
					// if empty
					if (!board.grid[row - i][col + i].isBlack() && !board.grid[row - i][col + i].isWhite()) {

						break;
					}
					// if there is more than one opp color and another similar color is found
					if (board.grid[row - i][col + i].getColor().equals(coordColor) && oppColor > 0) {

						shouldFlip = true;
						break;
					} else {
						oppColor++;
					}

					flipThese.add(board.grid[row - i][col + i]);
				}
			}
		} else if (row > col) {
			if (row > 4) {
				for (int i = 1; i < 8 - col; i++) {
					// if out of bounds
					if (row - i < 0 || col + i > 7) {
						break;
					}
					// if the one next to it is same color
					if (i == 1 && board.grid[row - i][col + i].getColor().equals(coordColor)) {

						break;
					}
					// if empty
					if (!board.grid[row - i][col + i].isBlack() && !board.grid[row - i][col + i].isWhite()) {

						break;
					}
					// if there is more than one opp color and another similar color is found
					if (board.grid[row - i][col + i].getColor().equals(coordColor) && oppColor > 0) {

						shouldFlip = true;
						break;
					} else {
						oppColor++;
					}

					flipThese.add(board.grid[row - i][col + i]);
				}
			} else {
				for (int i = 1; i <= row; i++) {
					// if out of bounds
					if (row - i < 0 || col + i > 7) {
						break;
					}
					// if the one next to it is same color
					if (i == 1 && board.grid[row - i][col + i].getColor().equals(coordColor)) {

						break;
					}
					// if empty
					if (!board.grid[row - i][col + i].isBlack() && !board.grid[row - i][col + i].isWhite()) {

						break;
					}
					// if there is more than one opp color and another similar color is found
					if (board.grid[row - i][col + i].getColor().equals(coordColor) && oppColor > 0) {

						shouldFlip = true;
						break;
					} else {
						oppColor++;
					}

					flipThese.add(board.grid[row - i][col + i]);
				}
			}

		} else {
			if (row > 3) {
				for (int i = 1; i < 8 - col; i++) {
					// if out of bounds
					if (row - i < 0 || col + i > 7) {
						break;
					}
					// if the one next to it is same color
					if (i == 1 && board.grid[row - i][col + i].getColor().equals(coordColor)) {

						break;
					}
					// if empty
					if (!board.grid[row - i][col + i].isBlack() && !board.grid[row - i][col + i].isWhite()) {

						break;
					}
					// if there is more than one opp color and another similar color is found
					if (board.grid[row - i][col + i].getColor().equals(coordColor) && oppColor > 0) {

						shouldFlip = true;
						break;
					} else {
						oppColor++;
					}

					flipThese.add(board.grid[row - i][col + i]);
				}
			} else {
				for (int i = 1; i <= row; i++) {// changed
					// if out of bounds
					if (row - i < 0 || col + i > 7) {
						break;
					}
					// if the one next to it is same color
					if (i == 1 && board.grid[row - i][col + i].getColor().equals(coordColor)) {

						break;
					}
					// if empty
					if (!board.grid[row - i][col + i].isBlack() && !board.grid[row - i][col + i].isWhite()) {

						break;
					}
					// if there is more than one opp color and another similar color is found
					if (board.grid[row - i][col + i].getColor().equals(coordColor) && oppColor > 0) {

						shouldFlip = true;
						break;
					} else {
						oppColor++;
					}

					flipThese.add(board.grid[row - i][col + i]);
				}

			}
		}
		// if the move in that direction is valid

		if (shouldFlip) {
			board.grid[row][col].setColor(coordColor);
			for (int i = 0; i < flipThese.size(); i++) {
				flipThese.get(i).setColor(coordColor);

			}
		}
		// resets
		shouldFlip = false;
		flipThese.clear();
		// lower left diagonal
		oppColor = 0;
		if (row < col) {
			if (col > 4) {
				for (int i = 1; i < 8 - row; i++) {
					// if out of bounds
					if (row + i > 7 || col - i < 0) {
						break;
					}
					// if the next square is the same color
					if (i == 1 && board.grid[row + i][col - i].getColor().equals(coordColor)) {

						break;
					}
					// if empty
					if (!board.grid[row + i][col - i].isBlack() && !board.grid[row + i][col - i].isWhite()) {

						break;
					}
					// if same color is found and there are at least one opposite color tiles
					if (board.grid[row + i][col - i].getColor().equals(coordColor) && oppColor > 0) {

						shouldFlip = true;
						break;
					} else {
						oppColor++;
					}

					flipThese.add(board.grid[row + i][col - i]);
				}
			} else {
				for (int i = 1; i <= col; i++) {
					// if out of bounds
					if (row + i > 7 || col - i < 0) {
						break;
					}
					// if the next square is the same color
					if (i == 1 && board.grid[row + i][col - i].getColor().equals(coordColor)) {

						break;
					}
					// if empty
					if (!board.grid[row + i][col - i].isBlack() && !board.grid[row + i][col - i].isWhite()) {

						break;
					}
					// if same color is found and there are at least one opposite color tiles
					if (board.grid[row + i][col - i].getColor().equals(coordColor) && oppColor > 0) {

						shouldFlip = true;
						break;
					} else {
						oppColor++;
					}

					flipThese.add(board.grid[row + i][col - i]);

				}
			}

		} else if (row > col) {
			if (row > 3) {
				for (int i = 1; i < 8 - row; i++) {
					// if out of bounds
					if (row + i > 7 || col - i < 0) {
						break;
					}
					// if the next square is the same color
					if (i == 1 && board.grid[row + i][col - i].getColor().equals(coordColor)) {

						break;
					}
					// if empty
					if (!board.grid[row + i][col - i].isBlack() && !board.grid[row + i][col - i].isWhite()) {

						break;
					}
					// if same color is found and there are at least one opposite color tiles
					if (board.grid[row + i][col - i].getColor().equals(coordColor) && oppColor > 0) {

						shouldFlip = true;
						break;
					} else {
						oppColor++;
					}
					flipThese.add(board.grid[row + i][col - i]);
				}
			} else {
				for (int i = 1; i <= row; i++) {// CHANGED
					// if out of bounds
					if (row + i > 7 || col - i < 0) {
						break;
					}
					// if the next square is the same color
					if (i == 1 && board.grid[row + i][col - i].getColor().equals(coordColor)) {

						break;
					}
					// if empty
					if (!board.grid[row + i][col - i].isBlack() && !board.grid[row + i][col - i].isWhite()) {

						break;
					}
					// if same color is found and there are at least one opposite color tiles
					if (board.grid[row + i][col - i].getColor().equals(coordColor) && oppColor > 0) {

						shouldFlip = true;
						break;
					} else {
						oppColor++;
					}

					flipThese.add(board.grid[row + i][col - i]);

				}
			}
		} else {
			if (row < 3) {
				for (int i = 1; i <= col; i++) {
					// if out of bounds
					if (row + i > 7 || col - i < 0) {
						break;
					}
					// if the next square is the same color
					if (i == 1 && board.grid[row + i][col - i].getColor().equals(coordColor)) {

						break;
					}
					// if empty
					if (!board.grid[row + i][col - i].isBlack() && !board.grid[row + i][col - i].isWhite()) {

						break;
					}
					// if same color is found and there are at least one opposite color tiles
					if (board.grid[row + i][col - i].getColor().equals(coordColor) && oppColor > 0) {

						shouldFlip = true;
						break;
					} else {
						oppColor++;
					}
					flipThese.add(board.grid[row + i][col - i]);
				}
			} else {
				for (int i = 1; i < 8 - row; i++) {
					// if out of bounds
					if (row + i > 7 || col - i < 0) {
						break;
					}
					// if the next square is the same color
					if (i == 1 && board.grid[row + i][col - i].getColor().equals(coordColor)) {

						break;
					}
					// if empty
					if (!board.grid[row + i][col - i].isBlack() && !board.grid[row + i][col - i].isWhite()) {

						break;
					}
					// if same color is found and there are at least one opposite color tiles
					if (board.grid[row + i][col - i].getColor().equals(coordColor) && oppColor > 0) {

						shouldFlip = true;
						break;
					} else {
						oppColor++;
					}

					flipThese.add(board.grid[row + i][col - i]);
				}
			}
		}
		// if that was a valid direction
		if (shouldFlip) {
			board.grid[row][col].setColor(coordColor);
			for (int i = 0; i < flipThese.size(); i++) {
				flipThese.get(i).setColor(coordColor);

			}
		}
		// resets
		shouldFlip = false;
		flipThese.clear();
		// lower right diagonal
		oppColor = 0;
		if (row <= col) {
			for (int i = 1; i < 8 - col; i++) {
				// if out of bounds
				if (row + i > 7 || col + i > 7) {
					break;
				}
				// if the one first next to it is same color
				if (i == 1 && board.grid[row + i][col + i].getColor().equals(coordColor)) {

					break;
				}
				// if empty
				if (!board.grid[row + i][col + i].isBlack() && !board.grid[row + i][col + i].isWhite()) {

					break;
				}
				// if there is a same color tile and at least one opposite color in between
				if (board.grid[row + i][col + i].getColor().equals(coordColor) && oppColor > 0) {

					shouldFlip = true;
					break;
				} else {
					oppColor++;
				}

				flipThese.add(board.grid[row + i][col + i]);
			}
		} else {
			for (int i = 1; i < 8 - row; i++) {
				// if out of bounds
				if (row + i > 7 || col + i > 7) {
					break;
				}
				// if the one first next to it is same color
				if (i == 1 && board.grid[row + i][col + i].getColor().equals(coordColor)) {

					break;
				}
				// if empty
				if (!board.grid[row + i][col + i].isBlack() && !board.grid[row + i][col + i].isWhite()) {

					break;
				}
				// if there is a same color tile and at least one opposite color in between
				if (board.grid[row + i][col + i].getColor().equals(coordColor) && oppColor > 0) {

					shouldFlip = true;
					break;
				} else {
					oppColor++;
				}

				flipThese.add(board.grid[row + i][col + i]);
			}
		}
		// if is valid move in that direction
		if (shouldFlip) {
			board.grid[row][col].setColor(coordColor);
			for (int i = 0; i < flipThese.size(); i++) {

				flipThese.get(i).setColor(coordColor);

			}

		}
		// resets
		shouldFlip = false;
		flipThese.clear();

		// up
		oppColor = 0;
		for (int i = 1; i <= row; i++) {
			// if the closest square is same color
			if (i == 1 && board.grid[row - i][col].getColor().equals(coordColor)) {

				break;
			}
			// if empty
			if ((!board.grid[row - i][col].isBlack() && !board.grid[row - i][col].isWhite())) {

				break;
			}
			// if a same color square is found and there is at least one opposite color
			// square in between
			if (board.grid[row - i][col].getColor().equals(coordColor) && oppColor > 0) {

				shouldFlip = true;
				break;
			} else {
				oppColor++;
			}

			flipThese.add(board.grid[row - i][col]);

		}
		// if valid move in that direction
		if (shouldFlip) {
			board.grid[row][col].setColor(coordColor);
			for (int i = 0; i < flipThese.size(); i++) {
				flipThese.get(i).setColor(coordColor);
			}

		}
		// resets
		flipThese.clear();
		shouldFlip = false;

		// down
		oppColor = 0;
		for (int i = 1; i < 8 - row; i++) {
			// if nearest square is same color
			if (i == 1 && board.grid[row + i][col].getColor().equals(coordColor)) {
				break;
			}
			// if empty
			if (!board.grid[row + i][col].isBlack() && !board.grid[row + i][col].isWhite()) {

				break;
			}
			// if same color square is found and there is at least one square of opposite
			// color between
			if (board.grid[row + i][col].getColor().equals(coordColor) && oppColor > 0) {
				shouldFlip = true;
				break;
			} else {
				oppColor++;
			}
			flipThese.add(board.grid[row + i][col]);

		}
		// if valid move in that direction
		if (shouldFlip) {
			board.grid[row][col].setColor(coordColor);
			for (int i = 0; i < flipThese.size(); i++) {
				flipThese.get(i).setColor(coordColor);

			}

		}
		// resets
		flipThese.clear();
		shouldFlip = false;
		// left

		oppColor = 0;
		for (int i = 1; i <= col; i++) {
			// if nearest square is same color
			if (i == 1 && board.grid[row][col - i].getColor().equals(coordColor)) {

				break;
			}
			// if empty
			if (!board.grid[row][col - i].isBlack() && !board.grid[row][col - i].isWhite()) {

				break;
			}
			// if same color square is found and there is at least one opposite color square
			// in between
			if (board.grid[row][col - i].getColor().equals(coordColor) && oppColor > 0) {
				shouldFlip = true;
				break;

			} else {
				oppColor++;
			}
			flipThese.add(board.grid[row][col - i]);
		}
		// if valid move in that direction
		if (shouldFlip) {
			board.grid[row][col].setColor(coordColor);
			for (int i = 0; i < flipThese.size(); i++) {
				flipThese.get(i).setColor(coordColor);

			}

		}
		// resets
		flipThese.clear();
		shouldFlip = false;

		// right

		oppColor = 0;
		for (int i = 1; i < 8 - col; i++) {
			// if nearest square is same color
			if (i == 1 && board.grid[row][col + i].getColor().equals(coordColor)) {

				break;
			}
			// if empty
			if (!board.grid[row][col + i].isBlack() && !board.grid[row][col + i].isWhite()) {
				break;
			}
			// if there is another similar color square found and at least one opposite
			// color square in between
			if (board.grid[row][col + i].getColor().equals(coordColor) && oppColor > 0) {
				shouldFlip = true;
				break;

			} else {
				oppColor++;

			}
			flipThese.add(board.grid[row][col + i]);

		}
		// if valid move in that direction
		if (shouldFlip) {
			board.grid[row][col].setColor(coordColor);
			for (int i = 0; i < flipThese.size(); i++) {
				flipThese.get(i).setColor(coordColor);

			}

		}

	}

	// returns true if white wins
	public boolean isWinner(GameBoard board) {
		int numWhite = 0;
		int numBlack = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board.grid[i][j].getColor().equalsIgnoreCase("white")) {
					numWhite++;
				} else if (board.grid[i][j].getColor().equalsIgnoreCase("black")) {
					numBlack++;
				}
			}
		}

		return numWhite > numBlack;
	}

	// changes the board to match winning colors
	public void setWinner(GameBoard board) {

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board.run1.isWinner(board)) {
					board.grid[i][j].setColor("white");
				} else {
					board.grid[i][j].setColor("black");
				}
			}
		}
	}

	// takes a coordinate and finds a column associated in the grid
	private int xtoCol(int x) {
		int col = (int) Math.floor(8 * x / 700);
		return col;
	}

	// takes a coordinate and finds a row associated in the grid
	private int ytoRow(int y) {
		int row = (int) Math.floor(8 * y / 700);
		return row;
	}

}
