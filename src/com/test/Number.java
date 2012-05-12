package com.test;

public class Number implements Word
{
	private long ID;
	private String number;
	
	public String getWord() {
		
		return this.number;
	}

	public String setWord(String word) {
		this.number=word;
		return this.number;
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
		return number;
	}

}
