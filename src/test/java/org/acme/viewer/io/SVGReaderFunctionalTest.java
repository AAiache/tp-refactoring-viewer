package org.acme.viewer.io;

import java.awt.Color;
import java.io.File;
import java.util.List;
import java.util.logging.Logger;

import org.acme.viewer.shape.Circle;
import org.acme.viewer.shape.Line;
import org.acme.viewer.shape.Rectangle;
import org.acme.viewer.shape.Shape;
import org.acme.viewer.shape.Style;
import org.junit.Test;
import junit.framework.TestCase;

/**
 * Test fonctionnel sur la classe SVGReader
 */
public class SVGReaderFunctionalTest extends TestCase
{
	
    private File circleRectFile ;
    private File shapesFile ;
    
	@Override
	protected void setUp() throws Exception {
		this.circleRectFile = new File(
			getClass().getResource("/svg/circle-rect.svg").toURI()
		);
		this.shapesFile = new File(
			getClass().getResource("/svg/shapes.svg").toURI()
		);
	}
	
	@Test
	public void testSvgFileShapes(){
		SVGReader reader = new SVGReader();
		List<Shape> shapes = reader.readSVG(circleRectFile);
		assertEquals(2,shapes.size());
		
		//<circle cx="20" cy="30" r="10" stroke="black" stroke-width="3" fill="red" />		
		{
			Shape shape = shapes.get(0);
			assertTrue(shape instanceof Circle);
			
			Circle circle = (Circle)shape;
			assertEquals(20.0,circle.getCenterX());
			assertEquals(30.0,circle.getCenterY());
			assertEquals(10.0,circle.getRadius());
			
			assertEquals(
				Color.BLACK, 
				shape.getStyle().getStrokeColor()
			);
			assertEquals(
				Color.RED, 
				shape.getStyle().getFillColor()
			);			
		}
		
		//<rect x="40" y="30" width="50" height="60" />
		{
			Shape shape = shapes.get(1);
			assertTrue(shape instanceof Rectangle);
			Rectangle circle = (Rectangle)shape;
			assertEquals(40.0,circle.getX());
			assertEquals(30.0,circle.getY());
			assertEquals(50.0,circle.getWidth());
			assertEquals(60.0,circle.getHeight());
			
			assertEquals(
				Style.DEFAULT_STROKE_COLOR,
				shape.getStyle().getStrokeColor()
			);
			assertEquals(
				Style.DEFAULT_FILL_COLOR, 
				shape.getStyle().getFillColor()
			); 
		}
	}
	

	@Test
	public void testShapesFile(){
		SVGReader reader = new SVGReader();
		List<Shape> shapes = reader.readSVG(shapesFile);
		assertEquals(3,shapes.size());
		
		//<rect width="100" height="80" x="0" y="70" fill="green" />
		{
			Shape shape = shapes.get(0);
			assertTrue(shape instanceof Rectangle);
			Rectangle rectangle = (Rectangle)shape;
			assertEquals(0.0,rectangle.getX());
			assertEquals(70.0,rectangle.getY());
			assertEquals(100.0,rectangle.getWidth());
			assertEquals(80.0,rectangle.getHeight());
			
			assertEquals(
				Style.DEFAULT_STROKE_COLOR,
				shape.getStyle().getStrokeColor()
			);
			assertEquals(
				Color.GREEN,
				shape.getStyle().getFillColor()
			);
		}
		
		//<line x1="5" y1="5" x2="250" y2="95" stroke="red" />
		{
			Shape shape = shapes.get(1);
			assertTrue(shape instanceof Line);
			Line line = (Line)shape;
			assertEquals(5.0,line.getX1());
			assertEquals(5.0,line.getY1());
			assertEquals(250.0,line.getX2());
			assertEquals(95.0,line.getY2());
			
			assertEquals(
				Color.RED,
				shape.getStyle().getStrokeColor()
			);
			assertEquals(
				Style.DEFAULT_FILL_COLOR, 
				shape.getStyle().getFillColor()
			);
		}
	 	
		//<circle cx="90" cy="80" r="50" fill="blue" />
		{
			Shape shape = shapes.get(2);
			assertTrue(shape instanceof Circle);
			Circle circle = (Circle)shape;
			assertEquals(90.0,circle.getCenterX());
			assertEquals(80.0,circle.getCenterY());
			assertEquals(50.0,circle.getRadius());
			
			assertEquals(
				Style.DEFAULT_STROKE_COLOR,
				shape.getStyle().getStrokeColor()
			);
			assertEquals(
				Color.BLUE, 
				shape.getStyle().getFillColor()
			);
		}
		
		//<text x="180" y="60">Un texte</text>
		//skipped... On ne traite pas les textes.
	}
	
}
