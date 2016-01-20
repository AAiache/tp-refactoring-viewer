package org.acme.viewer.shape;

/**
 * 
 * Classe abstraite "Shape" implémentant les parties communes
 * aux classes concrètes.
 * 
 * @author MBorne
 *
 */
public abstract class AbstractShape implements Shape {
	/**
	 * Le style de rendu
	 */
	private Style style ;
	
	public AbstractShape(){
		this.style = new Style();
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.acme.viewer.shape.Shape#getStyle()
	 */
	public Style getStyle() {
		return this.style ;
	}
	
}
