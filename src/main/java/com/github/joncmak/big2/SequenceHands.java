package com.github.joncmak.big2;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import com.github.joncmak.deckOfCards.Card;

public class SequenceHands extends AbstractCardHand
{
	public class SequenceComparator implements Comparator<Card>
	{
		public int compare(Card o1, Card o2)
		{
			return Integer.compare(big2.calculateValue(o1), big2.calculateValue(o2));
		}
	}
	public String name()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validateHand(List<Card> pCards)
	{
		Collections.sort(pCards, new SequenceComparator());
		
		int value = big2.calculateValue(pCards.get(0));
		
		int index = 0;
		for(Iterator<Card> iter = pCards.iterator(); iter.hasNext(); index++)
		{
			if(big2.calculateValue(iter.next()) != value)
			{
				return false;
			}
			value = big2.calculateValue(pCards.get(index));
		}
		return true;
	}

}
