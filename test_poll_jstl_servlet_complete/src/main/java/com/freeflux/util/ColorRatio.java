package com.freeflux.util;

import java.util.Random;

public class ColorRatio {

	public ColorRatio() {
		// TODO Auto-generated constructor stub
	}

	public static String hexColor() {
		Random r = new Random();
		
		int rgb = r.nextInt(255 * 255 * 255);
		String rgbt = Integer.toHexString(rgb);
		String hRGB = "#" + rgbt;
		
		return hRGB;
	}
	
	public static int ratio(int count, int sum) {
		int ratio = (new Double(Math.ceil((double) count / sum * 100))).intValue();
		return ratio;
	}
}
