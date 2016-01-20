package org.acme.viewer.io.svg;

import org.acme.viewer.shape.Circle;
import org.acme.viewer.shape.Shape;
import org.jdom2.Element;

/**
 * 
 * Lecteur pour les balises "circle"
 * 
 * @author MBorne
 *
 */
public class SVGCircleReader implements SVGElementReader {

	public static final String ELEMENT_NAME = "circle" ;
	
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
		double centerX = Double.parseDouble(
			shapeElement.getAttributeValue("cx")
		);
		double centerY = Double.parseDouble(
			shapeElement.getAttributeValue("cy")
		);
		double radius = Double.parseDouble(
			shapeElement.getAttributeValue("r")
		);
		
		Circle circle = new Circle();
		circle.setCenterX(centerX);
		circle.setCenterY(centerY);	
		circle.setRadius(radius);		
		return circle ;
	}
	
}
