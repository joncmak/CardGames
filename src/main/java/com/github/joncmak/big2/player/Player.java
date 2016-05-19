package com.github.joncmak.big2.player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.github.joncmak.big2.HandEvaluator;
import com.github.joncmak.deckOfCards.Card;

public class Player extends AbstractPlayer
{
	private ArrayList<Card> mPlay = new ArrayList<Card>();
	private List<Integer> mCmdList = new ArrayList<Integer>();

	public List<Card> playerTurn(Scanner pInputScanner, boolean pPass, HandEvaluator pEval)
	{
		printHand(mHand);

		System.out.println("Enter card index: (-1 to pass)");
		
		while(pInputScanner.hasNextInt())
		{
			mCmdList.add(pInputScanner.nextInt());
		}
		
		if(mCmdList.contains(-1))
		{
			return null;
		}
		
		if(!pPass)
		{
			if(mCmdList.size() == 1)
			{
				for(Integer integer : mCmdList)
				{
					mPlay.add(mHand.remove(integer.intValue()));
				}
				
				pEval.addHand(mPlay);
			}
			else
			{
				//too many cards
				System.out.println("too many cards");	
			}
		}
		else
		{
			if(mCmdList.size() <= 5)
			{
				for(Integer integer : mCmdList)
				{
					mPlay.add(mHand.remove(integer.intValue()));
				}
				
				pEval.addHand(mPlay);
			}
			else
			{
				//too many cards
				System.out.println("too many cards");
			}
		}
		mCmdList.clear();
		return mPlay;
	}

}
