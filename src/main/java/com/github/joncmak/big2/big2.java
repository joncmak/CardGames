package com.github.joncmak.big2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.github.joncmak.big2.player.Player;
import com.github.joncmak.big2.player.PlayerAI;
import com.github.joncmak.deckOfCards.Card;
import com.github.joncmak.deckOfCards.Deck;

public class big2
{	
	private ArrayList<Card> currentHand;
	Player mPlayer;
	PlayerAI mOpponent;
	
	private Deck mDeck;
	
	public big2(Deck pDeck)
	{
		mDeck = pDeck;
		
		mPlayer = new Player();
		mOpponent = new PlayerAI();
		
		currentHand = new ArrayList<Card>();
	}
	
	public void gameStart(Scanner pInputScanner)
	{
		mDeck.shuffle();
		
		mPlayer.addHand(mDeck.draw(13));
		
		boolean pass = false;
		HandEvaluator eval = new HandEvaluator();
		
		while(!mPlayer.emptyHand() || !mOpponent.emptyHand())
		{
			List<Card> hand = mPlayer.playerTurn(pInputScanner, pass, eval);
			
			
		}
		
		if(mPlayer.emptyHand() && !mOpponent.emptyHand())
		{
			//win
			System.out.println("You win!");
		}
		else if(mOpponent.emptyHand() && !mPlayer.emptyHand())
		{
			//lose
			System.out.println("You lose!");
		}
		else
		{
			//err
		}
	}
	
	public void newRound()
	{
		mPlayer.clearHand();
		mOpponent.clearHand();
	}
}
