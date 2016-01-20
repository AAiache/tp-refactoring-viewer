package org.acme.viewer.shape;

import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * 
 * Un cercle définit par son centre et un rayon
 * 
 * @author MBorne
 *
 */
public class Circle extends AbstractShape {
	
	/**
	 * Centre du cercle
	 */
	private double centerX ;
	
	/**
	 * Centre du cercle
	 */
	private double centerY ;
	
	/**
	 * Rayon du cercle
	 */
	private double radius ;
	
	
	public Circle(){
		this.centerX = 0.0 ;
		this.centerY = 0.0 ;
		this.radius = 1.0 ;
	}


	/**
	 * @return the centerX
	 */
	public double getCenterX() {
		return centerX;
	}

	/**
	 * @param centerX the centerX to set
	 */
	public void setCenterX(double centerX) {
		this.centerX = centerX;
	}


	/**
	 * @return the centerY
	 */
	public double getCenterY() {
		return centerY;
	}


	/**
	 * @param centerY the centerY to set
	 */
	public void setCenterY(double centerY) {
		this.centerY = centerY;
	}


	/**
	 * @return the radius
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * @param radius the radius to set
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawOval((int)centerX, (int)centerY, (int)radius, (int)radius);
	}
}
