package edu.jsu.mcis;

import java.util.*;

public class Assignment{
	
	private ArrayList<String> studentIDs;
	private ArrayList<Integer> scores;
	private String name;
	
	public Assignment(String name){
		studentIDs = new ArrayList<>();
		scores = new ArrayList<>();
		this.name = name;
	}
	
	public void addStudentAndScore(String id, int score){
		if (scores.size() == 0){
			scores.add(score);
			studentIDs.add(id);
		}
		else{
			boolean added = false;
			for (int i = 0; i < scores.size() && !added; i++){
				if (scores.get(i) <= score){
					scores.add(i, score);
					studentIDs.add(i, id);
					added = true;
				}
			}
			if (!added){
				scores.add(score);
				studentIDs.add(id);
			}
		}
	}
	
	public String getTopStudentID(){
		if (studentIDs.size() > 0){
			return studentIDs.get(0);
		}
		throw new AssignmentException();
	}
	
	public int getTopScore(){
		if (scores.size() > 0){
			return scores.get(0);
		}
		throw new AssignmentException();
	}
	
	public ArrayList<String> getStudents(){
		return studentIDs;
	}
	
	public ArrayList<Integer> getScores(){
		return scores;
	}
	
	public String getName(){
		return name;
	}
	
}