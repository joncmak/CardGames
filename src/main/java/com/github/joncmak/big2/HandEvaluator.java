package com.github.joncmak.big2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.github.joncmak.deckOfCards.Card;
import com.github.joncmak.deckOfCards.CardBuilder;
import com.github.joncmak.deckOfCards.DummyCard;

public class HandEvaluator
{
	public class SequenceComparator implements Comparator<Card>
	{
		public int compare(Card o1, Card o2)
		{
			return Integer.compare(calculateValue(o1), calculateValue(o2));
		}
	}
	
	List<Card> mHand;
	private int mHandValue;
	
	public HandEvaluator()
	{
		mHand = new ArrayList<Card>();
	}
	
	public void addHand(List<Card> pCards)
	{
		mHand.addAll(pCards);
		int rank = evaluateHand();
		mHandValue = calculateHand(rank);
	}
	
	public int getHandValue()
	{
		return mHandValue;
	}

	public void clear()
	{
		mHand.clear();
		mHandValue = 0;
	}
	
	private int calculateHand(int pRank)
	{
		int result = 0;
		
		for(Card card : mHand)
		{
			if(!(card instanceof DummyCard))
			{
				result += calculateValue(card);
			}
		}
		
		return result * pRank;
	}
	
	private int evaluateHand()
	{
		Collections.sort(mHand, new SequenceComparator());
		while(mHand.size() < 5)
		{
			mHand.add(new DummyCard(new CardBuilder()));
		}
		
		Card[] handArray = mHand.toArray(new Card[5]);
		
		int handRank = PokerHand.DEFAULT_RANK;

		//Pair
		for(int i = 0; i < 4; i++)
		{
			if(!(handArray[i] instanceof DummyCard) && handArray[i].getIntValue() == handArray[i+1].getIntValue())
			{
				handRank = PokerHand.PAIR;
				break;
			}
		}
		
		//3 of a kind
		for(int i = 0; i < 3; i++)
		{
			if(!(handArray[i] instanceof DummyCard) && handArray[i].getIntValue() == handArray[i+1].getIntValue() 
					&& handArray[i+1].getIntValue() == handArray[i+2].getIntValue())
			{
				handRank = PokerHand.THREE_OF_KIND;
				
				if(!(handArray[3] instanceof DummyCard) && i == 0 && handArray[3].getIntValue() == handArray[4].getIntValue()
						|| !(handArray[0] instanceof DummyCard) && i == 2 && handArray[0].getIntValue() == handArray[1].getIntValue())
				{
					handRank = PokerHand.FULL_HOUSE;
				}
				break;
			}
		}
		
		//4 of a kind
		for(int i = 0; i < 2; i++)
		{
			if(!(handArray[i] instanceof DummyCard)
					&& handArray[i].getIntValue() == handArray[i+1].getIntValue() 
					&& handArray[i+1].getIntValue() == handArray[i+2].getIntValue()
					&& handArray[i+2].getIntValue() == handArray[i+3].getIntValue())
			{
				handRank = PokerHand.FOUR_OF_KIND;
				break;
			}
		}
		
		//Non-Pair hands
		if(handRank == PokerHand.DEFAULT_RANK)
		{
			boolean isFlush = true;
			
			for(int i = 0; i < 4; i++)
			{
				if(!(handArray[i] instanceof DummyCard) && handArray[i].getIntValue() + 1 == handArray[i+1].getIntValue()
						|| !(handArray[i] instanceof DummyCard) && handArray[i].getIntValue() == 13 && handArray[i+1].getIntValue() == 1)
				{
					handRank = PokerHand.STRAIGHT;		

				}
				else
				{
					break;
				}
			}
			
			for(int i = 0; i < 4; i++)
			{
				if((handArray[i] instanceof DummyCard) || handArray[i].getSuit() != handArray[i+1].getSuit())
				{
					isFlush = false;
					break;
				}
			}
			
			if(isFlush)
			{
				if(handRank == PokerHand.STRAIGHT)
				{
					handRank = PokerHand.STRAIGHT_FLUSH;
					
					if(handArray[0].getIntValue() == 11 && handArray[4].getIntValue() == 2)
					{
						handRank = PokerHand.ROYAL_FLUSH;
					}
				}
				else
				{
					handRank = PokerHand.FLUSH;
				}
			}
		}	
		
		return handRank;
	}
	
	private int calculateValue(Card pCard)
	{
		int result = 0;
		
		//Calculate card number value
		if(pCard.getIntValue() == 1)
		{
			//game value for Ace
			result = 14;
		}
		else if(pCard.getIntValue() == 2)
		{
			//game value for 2
			result = 15;
		}
		else
		{
			result = pCard.getIntValue();
		}
		
		//Calculate suit value
		if(pCard.getSuit() == "Diamond")
		{
			result += 1;
		}
		else if(pCard.getSuit() == "Club")
		{
			result += 2;
		}
		else if(pCard.getSuit() == "Heart")
		{
			result += 3;
		}
		else if(pCard.getSuit() == "Spade")
		{
			result += 4;
		}
		return result;
	}
}
