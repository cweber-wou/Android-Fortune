package com.test;

public class Color implements Word
{
	private long ID;
	private String color;
	
	public String getWord() {
		
		return this.color;
	}

	public String setWord(String word) {
		this.color=word;
		return this.color;
	}

	public long setID(long ID) {
		this.ID=ID;
		return this.ID;
	}

	public long getID()
	{
		return ID;
	}
	
	
	
	
	@Override
	public String toString()
	{
		return color;
	}

}
