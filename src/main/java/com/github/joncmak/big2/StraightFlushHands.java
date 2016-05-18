package com.github.joncmak.big2;

import java.util.List;

import com.github.joncmak.deckOfCards.Card;

public class StraightFlushHands extends AbstractCardHand
{
	public String name()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validateHand(List<Card> pCards)
	{
		SameSuitHands suitValidate = new SameSuitHands();
		boolean suit = suitValidate.validateHand(pCards);
		
		SequenceHands seqValidate = new SequenceHands();
		boolean seq = seqValidate.validateHand(pCards);
		
		return suit && seq? true : false;
	}

}
