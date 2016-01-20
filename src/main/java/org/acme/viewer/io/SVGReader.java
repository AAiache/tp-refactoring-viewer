package org.acme.viewer.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.acme.viewer.io.svg.SVGElementReader;
import org.acme.viewer.io.svg.SVGElementReaderRegistry;
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
	
	private SVGElementReaderRegistry registry ;
	
	public SVGReader(){
		this.registry = new SVGElementReaderRegistry();
	}
	
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
			Shape shape = parseShapeElement(shapeElement) ;
			if ( null != shape ){
				result.add(shape);				
			}
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
		SVGElementReader reader = registry.getReader(shapeType);
		if ( null == reader ){
			logger.info("Unsupported type : {} (skipping)",shapeType);
			return null ;
		}
		return reader.read(shapeElement);
	}

	
}
