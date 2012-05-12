package com.test;

public class Adverb implements Word
{
	private long ID;
	private String adverb;
	
	public String getWord() {
		
		return this.adverb;
	}

	public String setWord(String word) {
		this.adverb=word;
		return this.adverb;
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
		return adverb;
	}

}
