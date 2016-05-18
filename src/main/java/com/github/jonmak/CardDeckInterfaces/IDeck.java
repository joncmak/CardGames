package com.github.jonmak.CardDeckInterfaces;

import java.util.List;

import com.github.joncmak.deckOfCards.Card;

public interface IDeck
{
	public void generate();
	
	public void add(List<Card> pCards);
	public void shuffle();
	public Card draw();
	public List<Card> draw(int numberOfCards);
}
