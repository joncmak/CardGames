package com.github.joncmak.big2.interfaces;

import java.util.List;
import java.util.Scanner;

import com.github.joncmak.big2.HandEvaluator;
import com.github.joncmak.deckOfCards.Card;

public interface IPlayer
{
	public abstract List<Card> playerTurn(Scanner pInputScanner, boolean pPass, HandEvaluator pEval);
	public void printHand(List<Card> pHand);
	
	public void addHand(List<Card> pHand);
	public void clearHand();
}
