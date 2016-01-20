package org.acme.viewer.utils;

import java.awt.Color;
import java.lang.reflect.Field;

/**
 * 
 * Utilitaire sur les couleurs
 * 
 * @author MBorne
 *
 */
public class ColorUtils {

	/**
	 * Parse une couleur par nom ou code hexa
	 * @param nameOrHexa
	 * @return
	 */
	public static Color parseColor(String nameOrHexa){
		// Tentative par nom...
		Color result = parseColorName(nameOrHexa);
		if ( null != result ){
			return result ;
		}
		// Tentative par hexa
		result = parseColorHexa(nameOrHexa);
		if ( null == result ){
			throw new IllegalArgumentException(
				"Invalid color "+nameOrHexa
			);
		}
		return result ;
	}
	
	/**
	 * Décodage d'un code hexadécimal
	 * @param hexa #ff0000
	 * @return
	 */
	private static Color parseColorHexa(String hexa){
		try {
			return Color.decode(hexa);
		}catch(Exception e){
			return null;
		}
	}
	
	/**
	 * Parse une couleur par son nom
	 * @param name nom de la couleur (ex : "red")
	 * @return
	 */
	private static Color parseColorName(String name){
		try {
			Field field = Color.class.getField(name);
			return (Color)field.get(null);
		} catch (Exception e) {
			return null ;
		}
	}
	
}
