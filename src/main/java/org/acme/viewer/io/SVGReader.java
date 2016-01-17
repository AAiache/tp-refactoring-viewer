package org.acme.viewer.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.acme.viewer.shape.Circle;
import org.acme.viewer.shape.Rectangle;
import org.acme.viewer.shape.Shape;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 * 
 * Classe de chargement d'un fichier SVG
 * 
 * @author MBorne
 *
 */
public class SVGReader {
	private static Logger logger = LogManager.getLogger(SVGReader.class);
	
	/**
	 * Chargement du fichier
	 * @param file
	 * @return
	 */
	public List<Shape> readSVG(File file){
		logger.info("Chargement du fichier {}",file);
		
		SAXBuilder sxb = new SAXBuilder();
		try {
			Document document = sxb.build(file);
			return parseDocument(document);
		} catch (JDOMException e) {
			logger.error(
				"Erreur de structuration du fichier XML : {}",
				e.getMessage()
			);
			throw new RuntimeException(e);
		} catch (IOException e) {
			logger.error(
				"Problème dans la lecture du fichier : {}",
				e.getMessage()
			);	
			throw new RuntimeException(e);
		}
	}

	/**
	 * Lecture d'un document SVG
	 * @param document
	 * @return
	 */
	private List<Shape> parseDocument(Document document) {
		List<Shape> result = new ArrayList<Shape>();
		
		Element rootElement = document.getRootElement();
		for ( Element shapeElement : rootElement.getChildren() ){
			result.add(parseShapeElement(shapeElement));
		}

		return result;
	}

	/**
	 * Lecture d'une balise de forme (circle, rect, etc.)
	 * @param shapeElement
	 * @return
	 */
	private Shape parseShapeElement(Element shapeElement) {
		String shapeType = shapeElement.getName();
		if ( shapeType.equals("circle") ){
			return parseCircleElement(shapeElement);
		}else if ( shapeType.equals("rect") ){
			return parseRectElement(shapeElement);
		}else{
			throw new RuntimeException("unsupported type : "+shapeType);
		}
	}

	/**
	 * Lecture de la balise circle
	 * @param shapeElement
	 * @return
	 */
	private Shape parseCircleElement(Element shapeElement) {
		double centerX = Double.parseDouble(shapeElement.getAttributeValue("cx"));
		double centerY = Double.parseDouble(shapeElement.getAttributeValue("cy"));
		double radius = Double.parseDouble(shapeElement.getAttributeValue("r"));
		
		Circle circle = new Circle();
		circle.setCenterX(centerX);
		circle.setCenterY(centerY);	
		circle.setRadius(radius);		
		return circle ;
	}
	
	/**
	 * Lecture de la balise rect
	 * @param shapeElement
	 * @return
	 */
	private Shape parseRectElement(Element shapeElement) {
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
