package Othello;

import java.awt.Color;
import java.awt.Graphics2D;
//this class holds square objects that have a color, coordinates, and height/width
public class Square {
	private int x;
	private int y;
	private int width;
	private int height;
	private int dimensions = 8;
	private String squareColor;
	private static Color squares= Color.BLUE;

	public Square(int x, int y, int width, int height, String color) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		squareColor="empty";
	}
	public void setColor(String color) {
		squareColor=color;
	}
	public String getColor() {
		return squareColor;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	//draws the rectangle and corresponding circle if has a circle
	public void draw(Graphics2D g2) {
		g2.drawRect(x,y,height,width);
		if(squareColor.equals("white")) {
			g2.setColor(Color.white);
			g2.fillOval(y+(width/4),x+(height/4), width/2,height/2);
		}else if(squareColor.equals("black")) {
			g2.setColor(Color.black);
			g2.fillOval(y+(width/4),x+(height/4), width/2,height/2);
		}
		g2.setColor(Color.black);
	}
	//determines if the square is black
	public boolean isBlack() {
		if(squareColor==null)
			return false;
		else if(squareColor.equalsIgnoreCase("black"))
			return true;
		return false;
	}
	//determines if the square is white
	public boolean isWhite() {
		if(squareColor==null)
			return false;
		else if(squareColor.equalsIgnoreCase("white"))
			return true;
		return false;
	}
	
	
	

}
