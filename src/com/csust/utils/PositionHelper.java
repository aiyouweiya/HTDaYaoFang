package com.csust.utils;

import java.awt.Dimension;
import java.awt.Window;


public class PositionHelper {
	
	public static int getScreenWidth(){
		java.awt.Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
		Dimension dimension = toolkit.getScreenSize();
		
		int screenWidth  = (int) dimension.getWidth();
		
		return screenWidth;
	}
	
	public static int getScreenHeight(){
		java.awt.Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
		Dimension dimension = toolkit.getScreenSize();
		
		int screenHeight  = (int) dimension.getHeight();
		
		return screenHeight;
	}
	
	public static void centerInScreen(Window w) {
		
		java.awt.Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
		Dimension dimension = toolkit.getScreenSize();
		
		int screenWidth  = (int) dimension.getWidth();
		int screenHeight = (int) dimension.getHeight();
		
		int frameWidth = w.getWidth();
		int frameHeight = w.getHeight();
		
		if(screenHeight<frameHeight){
			frameHeight = screenHeight;
		}
		
		if(screenWidth<frameWidth){
			frameHeight = screenHeight;
		}
		
		w.setSize(frameWidth, frameHeight);
		w.setLocation((screenWidth-frameWidth)/2,(screenHeight-frameHeight)/2);
				
		
	}
}	
