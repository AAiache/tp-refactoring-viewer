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

	static public final Color DEFAULT_STROKE_COLOR = Color.BLACK ;
	static public final Color DEFAULT_FILL_COLOR = Color.BLACK ;

	/**
	 * Couleur du contour
	 */
	private Color strokeColor ;
	/**
	 * Couleur de remplissage
	 */
	private Color fillColor ;
	
	public Style(){
		this.strokeColor = DEFAULT_STROKE_COLOR ;
		this.fillColor = DEFAULT_FILL_COLOR ;
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
