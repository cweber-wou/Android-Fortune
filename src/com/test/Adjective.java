package com.test;

public class Adjective implements Word
{
	private long ID;
	private String adjective;
	
	public String getWord() {
		
		return this.adjective;
	}

	public String setWord(String word) {
		this.adjective=word;
		return this.adjective;
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
		return adjective;
	}

}
