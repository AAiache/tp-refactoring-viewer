package org.acme.viewer.shape;

import java.awt.Graphics;

/**
 * Représente une forme (un cercle, un rectangle, etc.)
 */
public interface Shape {

	/**
	 * Récupération du style de la forme
	 * @return
	 */
	public Style getStyle() ;
	
	/**
	 * Rendu de la forme
	 * @param g
	 */
	public void paint(Graphics g);
	
}
