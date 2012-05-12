package com.test;

public class Time implements Word
{
	private long ID;
	private String time;
	
	public String getWord() {
		
		return this.time;
	}

	public String setWord(String word) {
		this.time=word;
		return this.time;
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
		return time;
	}

}
