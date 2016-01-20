package org.acme.viewer.shape;

import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * 
 * Un segment modélisé par deux points
 * 
 * @author MBorne
 *
 */
public class Line implements Shape {
	
	private double x1 ;
	private double y1 ;
	
	private double x2 ;
	private double y2 ;
	
	public Line(){
		this.x1 = 0.0 ;
		this.y1 = 0.0 ;
		
		this.x2 = 0.0 ;
		this.y2 = 0.0 ;
	}
	
	
	public double getX1() {
		return x1;
	}

	public void setX1(double x1) {
		this.x1 = x1;
	}


	public double getY1() {
		return y1;
	}

	public void setY1(double y1) {
		this.y1 = y1;
	}

	
	public double getX2() {
		return x2;
	}

	public void setX2(double x2) {
		this.x2 = x2;
	}


	public double getY2() {
		return y2;
	}

	public void setY2(double y2) {
		this.y2 = y2;
	}


	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
	}

}
