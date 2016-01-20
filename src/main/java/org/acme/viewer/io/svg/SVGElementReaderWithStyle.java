package org.acme.viewer.io.svg;

import java.awt.Color;

import org.acme.viewer.shape.Shape;
import org.acme.viewer.utils.ColorUtils;
import org.jdom2.Element;

/**
 * 
 * Décorateur sur les lecteurs pour lire les styles
 * 
 * @author MBorne
 *
 */
public class SVGElementReaderWithStyle implements SVGElementReader {

	private SVGElementReader original;

	public SVGElementReaderWithStyle(SVGElementReader original){
		this.original = original ;
	}
	
	public String getElementName() {
		return original.getElementName();
	}

	public Shape read(Element shapeElement) {
		Shape shape = original.read(shapeElement);
		
		readStrokeColor(shape,shapeElement) ;
		readFillColor(shape,shapeElement) ;
		
		return shape;
	}

	private void readFillColor(Shape shape, Element shapeElement) {
		String fill = shapeElement.getAttributeValue("fill");
		if ( null != fill ){
			Color fillColor = ColorUtils.parseColor(fill);
			shape.getStyle().setFillColor(fillColor);
		}
	}


	private void readStrokeColor(Shape shape, Element shapeElement) {
		String stroke = shapeElement.getAttributeValue("stroke");
		if ( null != stroke ){
			Color strokeColor = ColorUtils.parseColor(stroke);
			shape.getStyle().setStrokeColor(strokeColor);
		}
	}
	
}
