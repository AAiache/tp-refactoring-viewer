package org.acme.viewer.shape;

import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * 
 * Un rectangle
 * 
 * @author MBorne
 *
 */
public class Rectangle extends AbstractShape {
	
	private double x ;
	private double y ;
	private double width ;
	private double height ; 
	
	public Rectangle(){
		this.x = 0.0;
		this.y = 0.0;
		this.width  = 1.0;
		this.height = 1.0;
	}

	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}

	/**
	 * @return the width
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(double y) {
		this.y = y;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(double width) {
		this.width = width;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(getStyle().getFillColor());
		g2d.fillRect((int)x, (int)y, (int)width, (int)height);
		
		g2d.setColor(getStyle().getStrokeColor());
		g2d.drawRect((int)x, (int)y, (int)width, (int)height);
	}
}
