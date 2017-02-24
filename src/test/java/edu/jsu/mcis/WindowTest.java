package edu.jsu.mcis;

import org.junit.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import static org.junit.Assert.*;


public class WindowTest{
	
	@Test
	public void testWindowOpensOnRuntime(){
		Database testDatabase = new Database();
		boolean windowOpened = false;

		try{
			JFrame testWindow = new GUI(testDatabase);
			testWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			testWindow.setSize(new Dimension(300,300));
			testWindow.setResizable(false);
			testWindow.setVisible(true);
			windowOpened = true;
		}
		catch(IOException e){}

		assertTrue(windowOpened);
	}	
}