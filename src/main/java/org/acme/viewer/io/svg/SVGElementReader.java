package org.acme.viewer.io.svg;

import org.acme.viewer.shape.Shape;
import org.jdom2.Element;

/**
 * 
 * Interface pour la lecture d'un élément SVG
 * 
 * @author MBorne
 * 
 */
public interface SVGElementReader {

	/**
	 * Renvoie le nom de l'élément XML
	 * @return
	 */
	public String getElementName();
	
	/**
	 * Lecture de l'élément
	 * @param shapeElement
	 * @return
	 */
	public Shape read(Element shapeElement) ;


}
