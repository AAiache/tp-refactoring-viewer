package org.acme.viewer.io.svg;

import org.acme.viewer.shape.Circle;
import org.acme.viewer.shape.Rectangle;
import org.acme.viewer.shape.Shape;
import org.jdom2.Element;

/**
 * 
 * Lecteur pour les balises "rect"
 * 
 * @author MBorne
 *
 */
public class SVGRectReader implements SVGElementReader {

	public static final String ELEMENT_NAME = "rect" ;
	
	/*
	 * (non-Javadoc)
	 * @see org.acme.viewer.io.svg.SVGElementReader#getElementName()
	 */
	public String getElementName() {
		return ELEMENT_NAME ;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.acme.viewer.io.svg.SVGElementReader#read(org.jdom2.Element)
	 */
	public Shape read(Element shapeElement) {
		double x = Double.parseDouble(shapeElement.getAttributeValue("x"));
		double y = Double.parseDouble(shapeElement.getAttributeValue("y"));
		double width  = Double.parseDouble(shapeElement.getAttributeValue("width"));
		double height = Double.parseDouble(shapeElement.getAttributeValue("height"));
		
		Rectangle rectangle = new Rectangle();
		rectangle.setX(x);
		rectangle.setY(y);
		rectangle.setWidth(width);
		rectangle.setHeight(height);
		return rectangle ;
	}
	
}
