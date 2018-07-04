package com.sageconsulting.webapp.util;

import java.lang.Math;

public class CustomRandBean
{
	public int min		= 0;
	public int max		= 0;
	public int random	= 0;

	public void setMin( int pMin )
	{
		this.min		= pMin;
	}

	public void setMax( int pMax )
	{
		this.max		= pMax;
	}	

	public void setRandom( int pDum )
	{
		this.random		= (int)(Math.random() * this.getMax()) + this.getMin() + pDum;
	}

	public int getMin()
	{
		return this.min;
	}

	public int getMax()
	{
		return this.max;
	}

	public int getRandom()
	{
		return this.random;
	}
}
