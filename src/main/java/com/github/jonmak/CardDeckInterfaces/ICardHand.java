package com.github.jonmak.CardDeckInterfaces;

import java.util.List;

import com.github.joncmak.deckOfCards.Card;

public interface ICardHand
{
	public String name();
	public int getValue();
	public void addCards(List<Card> pCards);
}
