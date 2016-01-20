package org.acme.viewer.io.svg;

import org.acme.viewer.shape.Line;
import org.acme.viewer.shape.Shape;
import org.jdom2.Element;

/**
 * 
 * Lecteur pour les balises "circle"
 * 
 * @author MBorne
 *
 */
public class SVGLineReader implements SVGElementReader {

	public static final String ELEMENT_NAME = "line" ;
	
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
		double x1 = Double.parseDouble(
			shapeElement.getAttributeValue("x1")
		);
		double y1 = Double.parseDouble(
			shapeElement.getAttributeValue("y1")
		);
		double x2 = Double.parseDouble(
			shapeElement.getAttributeValue("x2")
		);
		double y2 = Double.parseDouble(
			shapeElement.getAttributeValue("y2")
		);
		
		Line line = new Line();
		line.setX1(x1);
		line.setY1(y1);
		
		line.setX2(x2);
		line.setY2(y2);
		return line ;
	}
	
}
