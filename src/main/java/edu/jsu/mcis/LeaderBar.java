package edu.jsu.mcis;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.*;

public class LeaderBar{

	private Point[] points;
	private Shape shape;
	private Color color;
	private JLabel label;
	private int height;
	
	public LeaderBar(double scaleFactor, int width, int height, int score){
		points = new Point[4];
		points[0] = new Point(0,0);
		points[1] = new Point((int) (width * scaleFactor), 0);
		points[2] = new Point((int) (width * scaleFactor), height);
		points[3] = new Point(0, height);
		updateShape();
		color = Color.black;
		label= new JLabel("");
		this.height = height;
	}
	
	public Shape getShape(){
		return shape;
	}
	
	private void updateShape(){
		int[] x = new int[points.length];
		int[] y = new int[points.length];
		for(int i = 0; i < points.length; i++) {
			x[i] = points[i].x;
			y[i] = points[i].y;
		}
		shape = new Polygon(x, y, points.length);
	}
	
	public void offsetPoints(int widthOffset, int heightOffset){
		for (int i = 0; i < points.length; i++){
			points[i].setLocation(widthOffset + points[i].x, heightOffset + points[i].y);
		}
		updateShape();
		
		//label.setBounds(widthOffset + 55 + points[i].x, heightOffset + points[i].y, 50, height);
	}
	
	public void setColor(Color color){
		this.color = color;
	}
	
	public Color getColor(){
		return color;
	}
	
	public void setLabelBounds(int widthOffset, int heightOffset, int width, int height){
		label.setBounds(widthOffset, heightOffset, width, height);
		System.out.println(widthOffset);
		System.out.println(heightOffset);
		System.out.println(width);
		System.out.println(height);
		System.out.println();
	}
	public JLabel getLabel(){
		return label;
	}
	public void setLabelText(String score){
		label.setText(score);
	}
}
