package com.github.joncmak.deckOfCards;

import java.util.Arrays;
import java.util.List;

public class Card
{
	public static final List<String> sSuits = Arrays.asList("Diamond", "Club", "Heart", "Spade");
	public static final List<String> sStringValues = Arrays.asList("Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King");
	
	private String mSuit;
	private String mStringValue;
	private int mIntegerValue;
	
	public Card(CardBuilder pBuilder)
	{
		mSuit = pBuilder.getSuit();
		mStringValue = pBuilder.getStringValue();
		mIntegerValue = pBuilder.getIntValue();
	}
	
	public String getSuit()
	{
		return mSuit;
	}
	
	public String getStringValue()
	{
		return mStringValue;
	}
	
	public int getIntValue()
	{
		return mIntegerValue;
	}
	
	public String print()
	{
		return mStringValue + " of " + mSuit;
	}
}
