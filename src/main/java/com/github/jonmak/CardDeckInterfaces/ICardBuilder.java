package com.github.jonmak.CardDeckInterfaces;

import com.github.joncmak.deckOfCards.Card;
import com.github.joncmak.deckOfCards.CardBuilder;

public interface ICardBuilder
{
	public CardBuilder setSuit(String pSuit);
	public CardBuilder setStringValue(String pStringValue);
	public CardBuilder setIntegerValue (int pIntValue);
	
	public String getSuit();
	public String getStringValue();
	public int getIntValue();
	
	public Card build();
}
