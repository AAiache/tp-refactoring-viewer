package org.acme.viewer.utils;

import java.awt.Color;

import junit.framework.TestCase;

public class ColorUtilsTest extends TestCase {
	
	public void testParseColorRedHexa(){
		Color color = ColorUtils.parseColor("#ff0000");
		assertEquals(Color.RED,color);
	}
	
	public void testParseColorRedbyName(){
		Color color = ColorUtils.parseColor("red");
		assertEquals(Color.RED,color);
	}
	
	public void testParseFailing(){
		boolean exceptionThrown = false ;
		try {
			ColorUtils.parseColor("iamnotacolor");
			
		}catch(IllegalArgumentException e){
			assertEquals(
				"Invalid color iamnotacolor",
				e.getMessage()
			);
			exceptionThrown = true ;
		}
		assertTrue(exceptionThrown);
	}
}
