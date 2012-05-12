package com.test;

public class Verb implements Word
{
	private long ID;
	private String verb;
	
	public String getWord() {
		
		return this.verb;
	}

	public String setWord(String word) {
		this.verb=word;
		return this.verb;
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
		return verb;
	}

}
