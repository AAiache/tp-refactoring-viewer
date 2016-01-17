package org.acme.viewer.io;

import java.io.File;
import java.util.List;
import java.util.logging.Logger;

import org.acme.viewer.shape.Circle;
import org.acme.viewer.shape.Rectangle;
import org.acme.viewer.shape.Shape;

import org.junit.Test;
import junit.framework.TestCase;

/**
 * Test fonctionnel sur la classe SVGReader
 */
public class SVGReaderFunctionalTest extends TestCase
{
	
    private File circleRectFile ;
    
	@Override
	protected void setUp() throws Exception {
		this.circleRectFile = new File(
			getClass().getResource("/svg/circle-rect.svg").toURI()
		);
	}
	
	@Test
	public void testSvgFileShapes(){
		SVGReader reader = new SVGReader();
		List<Shape> shapes = reader.readSVG(circleRectFile);
		assertEquals(2,shapes.size());
		
		{
			Shape shape = shapes.get(0);
			assertTrue(shape instanceof Circle);
			Circle circle = (Circle)shape;
			assertEquals(20.0,circle.getCenterX());
			assertEquals(30.0,circle.getCenterY());
			assertEquals(10.0,circle.getRadius());
		}
		
		{
			Shape shape = shapes.get(1);
			assertTrue(shape instanceof Rectangle);
			Rectangle circle = (Rectangle)shape;
			assertEquals(40.0,circle.getX());
			assertEquals(30.0,circle.getY());
			assertEquals(50.0,circle.getWidth());
			assertEquals(60.0,circle.getHeight());
		}
	}
	
}
