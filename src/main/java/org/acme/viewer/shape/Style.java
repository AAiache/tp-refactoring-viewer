package org.acme.viewer.shape;

import java.awt.Color;

/**
 * 
 * 
 * 
 * @author MBorne
 *
 */
public class Style {
	/**
	 * Couleur du contour
	 */
	private Color strokeColor ;
	/**
	 * Couleur de remplissage
	 */
	private Color fillColor ;
	
	public Style(){
		this.strokeColor = Color.BLACK ;
		this.fillColor = Color.WHITE ;
	}
	
	public Color getStrokeColor() {
		return strokeColor;
	}
	public void setStrokeColor(Color strokeColor) {
		this.strokeColor = strokeColor;
	}

	public Color getFillColor() {
		return fillColor;
	}
	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}
	
}
