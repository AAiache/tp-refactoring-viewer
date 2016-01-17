package org.acme.viewer;

import java.awt.Graphics;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import org.acme.viewer.io.SVGReader;
import org.acme.viewer.shape.Shape;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * Viewer de fichier SVG
 * 
 * @author MBorne
 *
 */
public class Viewer extends JFrame {
	private static Logger logger = LogManager.getLogger(Viewer.class); 

	/**
	 * La liste des formes à afficher
	 */
	private List<Shape> shapes = new ArrayList<Shape>();
	
	public Viewer(){
		super("Viewer");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void loadFile(File file){
		SVGReader reader = new SVGReader();
		this.shapes = reader.readSVG(file);
	}
	
	@Override
	public void paint(Graphics g) {
		for (Shape shape : shapes) {
			shape.paint(g);
		}
	}
	
	public static void main(String[] args) {
		if ( args.length < 1 ){
			System.err.println("viewer <path>");
			String examplePath = "${project_loc}/src/test/resources/svg/circle-rect.svg" ;
			System.err.println("dans eclipse : "+examplePath);
			System.exit(1);
		}
		String path = args[0] ;

		logger.info("Initialisation du viewer...");
		Viewer viewer = new Viewer();
		
		logger.info("Chargement du fichier {}...",path);
		File file = new File(path);
		viewer.loadFile(file);
		viewer.repaint();
	}

	
}
