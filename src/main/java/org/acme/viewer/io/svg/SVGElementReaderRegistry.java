package org.acme.viewer.io.svg;

import java.util.HashMap;
import java.util.Map;

/**
 * Permet de récupérer les lecteurs pour les balises
 */
public class SVGElementReaderRegistry {

	private Map<String, SVGElementReader> readers ;
	
	/**
	 * Constructeur initialisation la map des readers
	 */
	public SVGElementReaderRegistry(){
		this.readers = new HashMap<String, SVGElementReader>();
		registerReaders();
	}

	/**
	 * 
	 * Récupération d'un lecteur en fonction d'un type d'élément
	 * SVG.
	 * 
	 * @param shapeType
	 * @return
	 */
	public SVGElementReader getReader(String shapeType) {
		return readers.get(shapeType);
	}
	
	/**
	 * Ajout d'un lecteur
	 * @param elementName
	 * @param reader
	 */
	protected void addReader(SVGElementReader reader){
		this.readers.put(reader.getElementName(), reader) ;
	}
	
	/**
	 * Chargement des readers
	 */
	protected void registerReaders() {
		addReader( new SVGCircleReader() );
		addReader( new SVGRectReader() );
		addReader( new SVGLineReader() );
	}
	
}
