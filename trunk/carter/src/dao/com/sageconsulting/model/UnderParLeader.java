/*
 * UnderParLeader.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.model;


public class UnderParLeader
{
	private static final int BIRDIE_POINTS = 1;
	private static final int EAGLE_POINTS = 2;
	private static final int DBLEAGLE_POINTS = 3;
	
    private User user;
    private Season season;
    private int round;
    private int netBirdies;
    private int netEagles;
    private int netDoubleEagles;
    private int grossBirdies;
    private int grossEagles;
    private int grossDoubleEagles;
	
	public int totBirdiePoints	= 0;
	public int cntBirdieWeek1	= 0;
	public int cntBirdieWeek2	= 0;
	public int cntBirdieWeek3	= 0;
	public int cntBirdieWeek4	= 0;
	public int cntBirdieWeek5	= 0;
	public int cntBirdieWeek6	= 0;

    public UnderParLeader(User u, Season s, int r, int nb, int ne, int nd,
    		int gb, int ge, int gd)
    {
        this.user = u;
        this.season = s;
        this.round = r;
        this.netBirdies = nb;
        this.netEagles = ne;
        this.netDoubleEagles = nd;
        this.grossBirdies = gb;
        this.grossEagles = ge;
        this.grossDoubleEagles = gd;
    }
    
    public User getUser() { return this.user; }
    public Season getSeason() { return this.season; }
    public int getRound() { return this.round; }
    public int getNetBirdies() { return this.netBirdies; }
    public int getNetEagles() { return this.netEagles; }
    public int getNetDoubleEagles() { return this.netDoubleEagles; }
    public int getGrossBirdies() { return this.grossBirdies; }
    public int getGrossEagles() { return this.grossEagles; }
    public int getGrossDoubleEagles() { return this.grossDoubleEagles; }
 
    public int getTotBirdiePoints() { return this.totBirdiePoints; }
	public int getCntBirdieWeek1() { return this.cntBirdieWeek1; }
	public int getCntBirdieWeek2() { return this.cntBirdieWeek2; }
	public int getCntBirdieWeek3() { return this.cntBirdieWeek3; }
	public int getCntBirdieWeek4() { return this.cntBirdieWeek4; }
	public int getCntBirdieWeek5() { return this.cntBirdieWeek5; }
	public int getCntBirdieWeek6() { return this.cntBirdieWeek6; }
 
    public int getGrossPoints()
    {
    	return (this.grossBirdies*BIRDIE_POINTS) + (this.grossEagles*EAGLE_POINTS) +
    		(this.grossDoubleEagles*DBLEAGLE_POINTS);
    }
    
    public int getNetPoints()
    {
    	return (this.netBirdies*BIRDIE_POINTS) + (this.netEagles*EAGLE_POINTS) +
    		(this.netDoubleEagles*DBLEAGLE_POINTS);
    }
}
