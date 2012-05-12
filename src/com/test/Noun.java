package com.test;

public class Noun implements Word
{
	private long ID;
	private String noun;
	
	public String getWord() {
		
		return this.noun;
	}

	public String setWord(String word) {
		this.noun=word;
		return this.noun;
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
		return noun;
	}

}
