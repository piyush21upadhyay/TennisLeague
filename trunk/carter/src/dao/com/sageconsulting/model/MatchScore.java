/*
 * MatchScore.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MatchScore implements Serializable
{
    private static final long serialVersionUID = -8774336424375544471L;
    
    private static final Log log = LogFactory.getLog(MatchScore.class);
    
    private static final Byte BYTE_ZERO = Byte.valueOf((byte)0);
    private static final Byte BYTE_ONE = Byte.valueOf((byte)1);
    private static final Byte BYTE_TWO = Byte.valueOf((byte)2);
    private static final Byte BYTE_MINUS1 = Byte.valueOf((byte)-1);
    private static final Byte BYTE_MINUS2 = Byte.valueOf((byte)-2);
    
    private static final String CSS_HOLE_SCORE = "hole"; //$NON-NLS-1$
    private static final String CSS_BIRDIE = "birdie"; //$NON-NLS-1$
    private static final String CSS_EAGLE = "eagle"; //$NON-NLS-1$
    private static final String CSS_DOUBLE_EAGLE = "dbleagle"; //$NON-NLS-1$
    private static final String CSS_NET_BIRDIE = "netbirdie"; //$NON-NLS-1$
    private static final String CSS_NET_EAGLE = "neteagle"; //$NON-NLS-1$
    private static final String CSS_NET_DOUBLE_EAGLE = "netdbleagle"; //$NON-NLS-1$
    
    private static final int BIRDIE_POINTS = 1;
    private static final int EAGLE_POINTS = 2;
    private static final int DOUBLE_EAGLE_POINTS = 3;

    private int golfer1Handicap;
    private int golfer2Handicap;
    private Byte[] player1Pars = new Byte[18];
    private Byte[] player1Strokes = new Byte[18];
    private Byte[] player1Scores = new Byte[18];
    private Byte[] player2Pars = new Byte[18];
    private Byte[] player2Strokes = new Byte[18];
    private Byte[] player2Scores = new Byte[18];
    private Byte[] strokes = new Byte[18];
    private Byte[] score = new Byte[18];
    //private int player1UnderParGross;
    //private int player1UnderParNet;
    //private int player2UnderParGross;
    //private int player2UnderParNet;
    private int player1Birdies;
    private int player1Eagles;
    private int player1DoubleEagles;
    private int player1NetBirdies;
    private int player1NetEagles;
    private int player1NetDoubleEagles;
    private int player2Birdies;
    private int player2Eagles;
    private int player2DoubleEagles;
    private int player2NetBirdies;
    private int player2NetEagles;
    private int player2NetDoubleEagles;
    
    /**
     * @hibernate.property column="golfer1handicap" lazy="false"
     */
    public int getGolfer1Handicap() { return this.golfer1Handicap; }
    
    /**
     * @hibernate.property column="golfer2handicap" lazy="false"
     */
    public int getGolfer2Handicap() { return this.golfer2Handicap; }
    
    public void setGolfer1Handicap(int h) { this.golfer1Handicap = h; }
    
    public void setGolfer2Handicap(int h) { this.golfer2Handicap = h; }
    
    /**
     * @hibernate.property column="p1h1par" lazy="false"
     */
    public Byte getPlayer1Hole1Par() { return this.player1Pars[0]; }
    
    /**
     * @hibernate.property column="p1h2par" lazy="false"
     */
    public Byte getPlayer1Hole2Par() { return this.player1Pars[1]; }
    
    /**
     * @hibernate.property column="p1h3par" lazy="false"
     */
    public Byte getPlayer1Hole3Par() { return this.player1Pars[2]; }
    
    /**
     * @hibernate.property column="p1h4par" lazy="false"
     */
    public Byte getPlayer1Hole4Par() { return this.player1Pars[3]; }
    
    /**
     * @hibernate.property column="p1h5par" lazy="false"
     */
    public Byte getPlayer1Hole5Par() { return this.player1Pars[4]; }
    
    /**
     * @hibernate.property column="p1h6par" lazy="false"
     */
    public Byte getPlayer1Hole6Par() { return this.player1Pars[5]; }
    
    /**
     * @hibernate.property column="p1h7par" lazy="false"
     */
    public Byte getPlayer1Hole7Par() { return this.player1Pars[6]; }
    
    /**
     * @hibernate.property column="p1h8par" lazy="false"
     */
    public Byte getPlayer1Hole8Par() { return this.player1Pars[7]; }
    
    /**
     * @hibernate.property column="p1h9par" lazy="false"
     */
    public Byte getPlayer1Hole9Par() { return this.player1Pars[8]; }
    
    /**
     * @hibernate.property column="p1h10par" lazy="false"
     */
    public Byte getPlayer1Hole10Par() { return this.player1Pars[9]; }
    
    /**
     * @hibernate.property column="p1h11par" lazy="false"
     */
    public Byte getPlayer1Hole11Par() { return this.player1Pars[10]; }
    
    /**
     * @hibernate.property column="p1h12par" lazy="false"
     */
    public Byte getPlayer1Hole12Par() { return this.player1Pars[11]; }
    
    /**
     * @hibernate.property column="p1h13par" lazy="false"
     */
    public Byte getPlayer1Hole13Par() { return this.player1Pars[12]; }
    
    /**
     * @hibernate.property column="p1h14par" lazy="false"
     */
    public Byte getPlayer1Hole14Par() { return this.player1Pars[13]; }
    
    /**
     * @hibernate.property column="p1h15par" lazy="false"
     */
    public Byte getPlayer1Hole15Par() { return this.player1Pars[14]; }
    
    /**
     * @hibernate.property column="p1h16par" lazy="false"
     */
    public Byte getPlayer1Hole16Par() { return this.player1Pars[15]; }
    
    /**
     * @hibernate.property column="p1h17par" lazy="false"
     */
    public Byte getPlayer1Hole17Par() { return this.player1Pars[16]; }
    
    /**
     * @hibernate.property column="p1h18par" lazy="false"
     */
    public Byte getPlayer1Hole18Par() { return this.player1Pars[17]; }
    
    /**
     * @hibernate.property column="p1h1stroke" lazy="false"
     */
    public Byte getPlayer1Hole1Stroke() { return this.player1Strokes[0]; }
    
    /**
     * @hibernate.property column="p1h2stroke" lazy="false"
     */
    public Byte getPlayer1Hole2Stroke() { return this.player1Strokes[1]; }
    
    /**
     * @hibernate.property column="p1h3stroke" lazy="false"
     */
    public Byte getPlayer1Hole3Stroke() { return this.player1Strokes[2]; }
    
    /**
     * @hibernate.property column="p1h4stroke" lazy="false"
     */
    public Byte getPlayer1Hole4Stroke() { return this.player1Strokes[3]; }
    
    /**
     * @hibernate.property column="p1h5stroke" lazy="false"
     */
    public Byte getPlayer1Hole5Stroke() { return this.player1Strokes[4]; }
    
    /**
     * @hibernate.property column="p1h6stroke" lazy="false"
     */
    public Byte getPlayer1Hole6Stroke() { return this.player1Strokes[5]; }
    
    /**
     * @hibernate.property column="p1h7stroke" lazy="false"
     */
    public Byte getPlayer1Hole7Stroke() { return this.player1Strokes[6]; }
    
    /**
     * @hibernate.property column="p1h8stroke" lazy="false"
     */
    public Byte getPlayer1Hole8Stroke() { return this.player1Strokes[7]; }
    
    /**
     * @hibernate.property column="p1h9stroke" lazy="false"
     */
    public Byte getPlayer1Hole9Stroke() { return this.player1Strokes[8]; }
    
    /**
     * @hibernate.property column="p1h10stroke" lazy="false"
     */
    public Byte getPlayer1Hole10Stroke() { return this.player1Strokes[9]; }
    
    /**
     * @hibernate.property column="p1h11stroke" lazy="false"
     */
    public Byte getPlayer1Hole11Stroke() { return this.player1Strokes[10]; }
    
    /**
     * @hibernate.property column="p1h12stroke" lazy="false"
     */
    public Byte getPlayer1Hole12Stroke() { return this.player1Strokes[11]; }
    
    /**
     * @hibernate.property column="p1h13stroke" lazy="false"
     */
    public Byte getPlayer1Hole13Stroke() { return this.player1Strokes[12]; }
    
    /**
     * @hibernate.property column="p1h14stroke" lazy="false"
     */
    public Byte getPlayer1Hole14Stroke() { return this.player1Strokes[13]; }
    
    /**
     * @hibernate.property column="p1h15stroke" lazy="false"
     */
    public Byte getPlayer1Hole15Stroke() { return this.player1Strokes[14]; }
    
    /**
     * @hibernate.property column="p1h16stroke" lazy="false"
     */
    public Byte getPlayer1Hole16Stroke() { return this.player1Strokes[15]; }
    
    /**
     * @hibernate.property column="p1h17stroke" lazy="false"
     */
    public Byte getPlayer1Hole17Stroke() { return this.player1Strokes[16]; }
    
    /**
     * @hibernate.property column="p1h18stroke" lazy="false"
     */
    public Byte getPlayer1Hole18Stroke() { return this.player1Strokes[17]; }
    
    /**
     * @hibernate.property column="p1h1score" lazy="false"
     */
    public Byte getPlayer1Hole1Score() { return this.player1Scores[0]; }
    
    /**
     * @hibernate.property column="p1h2score" lazy="false"
     */
    public Byte getPlayer1Hole2Score() { return this.player1Scores[1]; }
    
    /**
     * @hibernate.property column="p1h3score" lazy="false"
     */
    public Byte getPlayer1Hole3Score() { return this.player1Scores[2]; }
    
    /**
     * @hibernate.property column="p1h4score" lazy="false"
     */
    public Byte getPlayer1Hole4Score() { return this.player1Scores[3]; }
    
    /**
     * @hibernate.property column="p1h5score" lazy="false"
     */
    public Byte getPlayer1Hole5Score() { return this.player1Scores[4]; }
    
    /**
     * @hibernate.property column="p1h6score" lazy="false"
     */
    public Byte getPlayer1Hole6Score() { return this.player1Scores[5]; }
    
    /**
     * @hibernate.property column="p1h7score" lazy="false"
     */
    public Byte getPlayer1Hole7Score() { return this.player1Scores[6]; }
    
    /**
     * @hibernate.property column="p1h8score" lazy="false"
     */
    public Byte getPlayer1Hole8Score() { return this.player1Scores[7]; }
    
    /**
     * @hibernate.property column="p1h9score" lazy="false"
     */
    public Byte getPlayer1Hole9Score() { return this.player1Scores[8]; }
    
    /**
     * @hibernate.property column="p1h10score" lazy="false"
     */
    public Byte getPlayer1Hole10Score() { return this.player1Scores[9]; }
    
    /**
     * @hibernate.property column="p1h11score" lazy="false"
     */
    public Byte getPlayer1Hole11Score() { return this.player1Scores[10]; }
    
    /**
     * @hibernate.property column="p1h12score" lazy="false"
     */
    public Byte getPlayer1Hole12Score() { return this.player1Scores[11]; }
    
    /**
     * @hibernate.property column="p1h13score" lazy="false"
     */
    public Byte getPlayer1Hole13Score() { return this.player1Scores[12]; }
    
    /**
     * @hibernate.property column="p1h14score" lazy="false"
     */
    public Byte getPlayer1Hole14Score() { return this.player1Scores[13]; }
    
    /**
     * @hibernate.property column="p1h15score" lazy="false"
     */
    public Byte getPlayer1Hole15Score() { return this.player1Scores[14]; }
    
    /**
     * @hibernate.property column="p1h16score" lazy="false"
     */
    public Byte getPlayer1Hole16Score() { return this.player1Scores[15]; }
    
    /**
     * @hibernate.property column="p1h17score" lazy="false"
     */
    public Byte getPlayer1Hole17Score() { return this.player1Scores[16]; }
    
    /**
     * @hibernate.property column="p1h18score" lazy="false"
     */
    public Byte getPlayer1Hole18Score() { return this.player1Scores[17]; }
    
    /**
     * @hibernate.property column="p2h1par" lazy="false"
     */
    public Byte getPlayer2Hole1Par() { return this.player2Pars[0]; }
    
    /**
     * @hibernate.property column="p2h2par" lazy="false"
     */
    public Byte getPlayer2Hole2Par() { return this.player2Pars[1]; }
    
    /**
     * @hibernate.property column="p2h3par" lazy="false"
     */
    public Byte getPlayer2Hole3Par() { return this.player2Pars[2]; }
    
    /**
     * @hibernate.property column="p2h4par" lazy="false"
     */
    public Byte getPlayer2Hole4Par() { return this.player2Pars[3]; }
    
    /**
     * @hibernate.property column="p2h5par" lazy="false"
     */
    public Byte getPlayer2Hole5Par() { return this.player2Pars[4]; }
    
    /**
     * @hibernate.property column="p2h6par" lazy="false"
     */
    public Byte getPlayer2Hole6Par() { return this.player2Pars[5]; }
    
    /**
     * @hibernate.property column="p2h7par" lazy="false"
     */
    public Byte getPlayer2Hole7Par() { return this.player2Pars[6]; }
    
    /**
     * @hibernate.property column="p2h8par" lazy="false"
     */
    public Byte getPlayer2Hole8Par() { return this.player2Pars[7]; }
    
    /**
     * @hibernate.property column="p2h9par" lazy="false"
     */
    public Byte getPlayer2Hole9Par() { return this.player2Pars[8]; }
    
    /**
     * @hibernate.property column="p2h10par" lazy="false"
     */
    public Byte getPlayer2Hole10Par() { return this.player2Pars[9]; }
    
    /**
     * @hibernate.property column="p2h11par" lazy="false"
     */
    public Byte getPlayer2Hole11Par() { return this.player2Pars[10]; }
    
    /**
     * @hibernate.property column="p2h12par" lazy="false"
     */
    public Byte getPlayer2Hole12Par() { return this.player2Pars[11]; }
    
    /**
     * @hibernate.property column="p2h13par" lazy="false"
     */
    public Byte getPlayer2Hole13Par() { return this.player2Pars[12]; }
    
    /**
     * @hibernate.property column="p2h14par" lazy="false"
     */
    public Byte getPlayer2Hole14Par() { return this.player2Pars[13]; }
    
    /**
     * @hibernate.property column="p2h15par" lazy="false"
     */
    public Byte getPlayer2Hole15Par() { return this.player2Pars[14]; }
    
    /**
     * @hibernate.property column="p2h16par" lazy="false"
     */
    public Byte getPlayer2Hole16Par() { return this.player2Pars[15]; }
    
    /**
     * @hibernate.property column="p2h17par" lazy="false"
     */
    public Byte getPlayer2Hole17Par() { return this.player2Pars[16]; }
    
    /**
     * @hibernate.property column="p2h18par" lazy="false"
     */
    public Byte getPlayer2Hole18Par() { return this.player2Pars[17]; }
    
    /**
     * @hibernate.property column="p2h1stroke" lazy="false"
     */
    public Byte getPlayer2Hole1Stroke() { return this.player2Strokes[0]; }
    
    /**
     * @hibernate.property column="p2h2stroke" lazy="false"
     */
    public Byte getPlayer2Hole2Stroke() { return this.player2Strokes[1]; }
    
    /**
     * @hibernate.property column="p2h3stroke" lazy="false"
     */
    public Byte getPlayer2Hole3Stroke() { return this.player2Strokes[2]; }
    
    /**
     * @hibernate.property column="p2h4stroke" lazy="false"
     */
    public Byte getPlayer2Hole4Stroke() { return this.player2Strokes[3]; }
    
    /**
     * @hibernate.property column="p2h5stroke" lazy="false"
     */
    public Byte getPlayer2Hole5Stroke() { return this.player2Strokes[4]; }
    
    /**
     * @hibernate.property column="p2h6stroke" lazy="false"
     */
    public Byte getPlayer2Hole6Stroke() { return this.player2Strokes[5]; }
    
    /**
     * @hibernate.property column="p2h7stroke" lazy="false"
     */
    public Byte getPlayer2Hole7Stroke() { return this.player2Strokes[6]; }
    
    /**
     * @hibernate.property column="p2h8stroke" lazy="false"
     */
    public Byte getPlayer2Hole8Stroke() { return this.player2Strokes[7]; }
    
    /**
     * @hibernate.property column="p2h9stroke" lazy="false"
     */
    public Byte getPlayer2Hole9Stroke() { return this.player2Strokes[8]; }
    
    /**
     * @hibernate.property column="p2h10stroke" lazy="false"
     */
    public Byte getPlayer2Hole10Stroke() { return this.player2Strokes[9]; }
    
    /**
     * @hibernate.property column="p2h11stroke" lazy="false"
     */
    public Byte getPlayer2Hole11Stroke() { return this.player2Strokes[10]; }
    
    /**
     * @hibernate.property column="p2h12stroke" lazy="false"
     */
    public Byte getPlayer2Hole12Stroke() { return this.player2Strokes[11]; }
    
    /**
     * @hibernate.property column="p2h13stroke" lazy="false"
     */
    public Byte getPlayer2Hole13Stroke() { return this.player2Strokes[12]; }
    
    /**
     * @hibernate.property column="p2h14stroke" lazy="false"
     */
    public Byte getPlayer2Hole14Stroke() { return this.player2Strokes[13]; }
    
    /**
     * @hibernate.property column="p2h15stroke" lazy="false"
     */
    public Byte getPlayer2Hole15Stroke() { return this.player2Strokes[14]; }
    
    /**
     * @hibernate.property column="p2h16stroke" lazy="false"
     */
    public Byte getPlayer2Hole16Stroke() { return this.player2Strokes[15]; }
    
    /**
     * @hibernate.property column="p2h17stroke" lazy="false"
     */
    public Byte getPlayer2Hole17Stroke() { return this.player2Strokes[16]; }
    
    /**
     * @hibernate.property column="p2h18stroke" lazy="false"
     */
    public Byte getPlayer2Hole18Stroke() { return this.player2Strokes[17]; }
    
    /**
     * @hibernate.property column="p2h1score" lazy="false"
     */
    public Byte getPlayer2Hole1Score() { return this.player2Scores[0]; }
    
    /**
     * @hibernate.property column="p2h2score" lazy="false"
     */
    public Byte getPlayer2Hole2Score() { return this.player2Scores[1]; }
    
    /**
     * @hibernate.property column="p2h3score" lazy="false"
     */
    public Byte getPlayer2Hole3Score() { return this.player2Scores[2]; }
    
    /**
     * @hibernate.property column="p2h4score" lazy="false"
     */
    public Byte getPlayer2Hole4Score() { return this.player2Scores[3]; }
    
    /**
     * @hibernate.property column="p2h5score" lazy="false"
     */
    public Byte getPlayer2Hole5Score() { return this.player2Scores[4]; }
    
    /**
     * @hibernate.property column="p2h6score" lazy="false"
     */
    public Byte getPlayer2Hole6Score() { return this.player2Scores[5]; }
    
    /**
     * @hibernate.property column="p2h7score" lazy="false"
     */
    public Byte getPlayer2Hole7Score() { return this.player2Scores[6]; }
    
    /**
     * @hibernate.property column="p2h8score" lazy="false"
     */
    public Byte getPlayer2Hole8Score() { return this.player2Scores[7]; }
    
    /**
     * @hibernate.property column="p2h9score" lazy="false"
     */
    public Byte getPlayer2Hole9Score() { return this.player2Scores[8]; }
    
    /**
     * @hibernate.property column="p2h10score" lazy="false"
     */
    public Byte getPlayer2Hole10Score() { return this.player2Scores[9]; }
    
    /**
     * @hibernate.property column="p2h11score" lazy="false"
     */
    public Byte getPlayer2Hole11Score() { return this.player2Scores[10]; }
    
    /**
     * @hibernate.property column="p2h12score" lazy="false"
     */
    public Byte getPlayer2Hole12Score() { return this.player2Scores[11]; }
    
    /**
     * @hibernate.property column="p2h13score" lazy="false"
     */
    public Byte getPlayer2Hole13Score() { return this.player2Scores[12]; }
    
    /**
     * @hibernate.property column="p2h14score" lazy="false"
     */
    public Byte getPlayer2Hole14Score() { return this.player2Scores[13]; }
    
    /**
     * @hibernate.property column="p2h15score" lazy="false"
     */
    public Byte getPlayer2Hole15Score() { return this.player2Scores[14]; }
    
    /**
     * @hibernate.property column="p2h16score" lazy="false"
     */
    public Byte getPlayer2Hole16Score() { return this.player2Scores[15]; }
    
    /**
     * @hibernate.property column="p2h17score" lazy="false"
     */
    public Byte getPlayer2Hole17Score() { return this.player2Scores[16]; }
    
    /**
     * @hibernate.property column="p2h18score" lazy="false"
     */
    public Byte getPlayer2Hole18Score() { return this.player2Scores[17]; }
    
    /**
     * @hibernate.property column="stroke1" lazy="false"
     */
    public Byte getStroke1() { return this.strokes[0]; }
    
    /**
     * @hibernate.property column="stroke2" lazy="false"
     */
    public Byte getStroke2() { return this.strokes[1]; }
    
    /**
     * @hibernate.property column="stroke3" lazy="false"
     */
    public Byte getStroke3() { return this.strokes[2]; }
    
    /**
     * @hibernate.property column="stroke4" lazy="false"
     */
    public Byte getStroke4() { return this.strokes[3]; }
    
    /**
     * @hibernate.property column="stroke5" lazy="false"
     */
    public Byte getStroke5() { return this.strokes[4]; }
    
    /**
     * @hibernate.property column="stroke6" lazy="false"
     */
    public Byte getStroke6() { return this.strokes[5]; }
    
    /**
     * @hibernate.property column="stroke7" lazy="false"
     */
    public Byte getStroke7() { return this.strokes[6]; }
    
    /**
     * @hibernate.property column="stroke8" lazy="false"
     */
    public Byte getStroke8() { return this.strokes[7]; }
    
    /**
     * @hibernate.property column="stroke9" lazy="false"
     */
    public Byte getStroke9() { return this.strokes[8]; }
    
    /**
     * @hibernate.property column="stroke10" lazy="false"
     */
    public Byte getStroke10() { return this.strokes[9]; }
    
    /**
     * @hibernate.property column="stroke11" lazy="false"
     */
    public Byte getStroke11() { return this.strokes[10]; }
    
    /**
     * @hibernate.property column="stroke12" lazy="false"
     */
    public Byte getStroke12() { return this.strokes[11]; }
    
    /**
     * @hibernate.property column="stroke13" lazy="false"
     */
    public Byte getStroke13() { return this.strokes[12]; }
    
    /**
     * @hibernate.property column="stroke14" lazy="false"
     */
    public Byte getStroke14() { return this.strokes[13]; }
    
    /**
     * @hibernate.property column="stroke15" lazy="false"
     */
    public Byte getStroke15() { return this.strokes[14]; }
    
    /**
     * @hibernate.property column="stroke16" lazy="false"
     */
    public Byte getStroke16() { return this.strokes[15]; }
    
    /**
     * @hibernate.property column="stroke17" lazy="false"
     */
    public Byte getStroke17() { return this.strokes[16]; }
    
    /**
     * @hibernate.property column="stroke18" lazy="false"
     */
    public Byte getStroke18() { return this.strokes[17]; }
    
    /**
     * @hibernate.property column="score1" lazy="false"
     */
    public Byte getScore1() { return this.score[0]; }
    
    /**
     * @hibernate.property column="score2" lazy="false"
     */
    public Byte getScore2() { return this.score[1]; }
    
    /**
     * @hibernate.property column="score3" lazy="false"
     */
    public Byte getScore3() { return this.score[2]; }
    
    /**
     * @hibernate.property column="score4" lazy="false"
     */
    public Byte getScore4() { return this.score[3]; }
    
    /**
     * @hibernate.property column="score5" lazy="false"
     */
    public Byte getScore5() { return this.score[4]; }
    
    /**
     * @hibernate.property column="score6" lazy="false"
     */
    public Byte getScore6() { return this.score[5]; }
    
    /**
     * @hibernate.property column="score7" lazy="false"
     */
    public Byte getScore7() { return this.score[6]; }
    
    /**
     * @hibernate.property column="score8" lazy="false"
     */
    public Byte getScore8() { return this.score[7]; }
    
    /**
     * @hibernate.property column="score9" lazy="false"
     */
    public Byte getScore9() { return this.score[8]; }
    
    /**
     * @hibernate.property column="score10" lazy="false"
     */
    public Byte getScore10() { return this.score[9]; }
    
    /**
     * @hibernate.property column="score11" lazy="false"
     */
    public Byte getScore11() { return this.score[10]; }
    
    /**
     * @hibernate.property column="score12" lazy="false"
     */
    public Byte getScore12() { return this.score[11]; }
    
    /**
     * @hibernate.property column="score13" lazy="false"
     */
    public Byte getScore13() { return this.score[12]; }
    
    /**
     * @hibernate.property column="score14" lazy="false"
     */
    public Byte getScore14() { return this.score[13]; }
    
    /**
     * @hibernate.property column="score15" lazy="false"
     */
    public Byte getScore15() { return this.score[14]; }
    
    /**
     * @hibernate.property column="score16" lazy="false"
     */
    public Byte getScore16() { return this.score[15]; }
    
    /**
     * @hibernate.property column="score17" lazy="false"
     */
    public Byte getScore17() { return this.score[16]; }
    
    /**
     * @hibernate.property column="score18" lazy="false"
     */
    public Byte getScore18() { return this.score[17]; }
    
    /**
     * @hibernate.property column="p1birdies" lazy="false" 
     */
    public int getPlayer1Birdies() { return this.player1Birdies; }
    
    /**
     * @hibernate.property column="p1eagles" lazy="false" 
     */
    public int getPlayer1Eagles() { return this.player1Eagles; }
    
    /**
     * @hibernate.property column="p1dbleagles" lazy="false" 
     */
    public int getPlayer1DoubleEagles() { return this.player1DoubleEagles; }
    
    /**
     * @hibernate.property column="p1netbirdies" lazy="false" 
     */
    public int getPlayer1NetBirdies() { return this.player1NetBirdies; }
    
    /**
     * @hibernate.property column="p1neteagles" lazy="false" 
     */
    public int getPlayer1NetEagles() { return this.player1NetEagles; }
    
    /**
     * @hibernate.property column="p1netdbleagles" lazy="false" 
     */
    public int getPlayer1NetDoubleEagles() { return this.player1NetDoubleEagles; }
    
    /**
     * @hibernate.property column="p2birdies" lazy="false" 
     */
    public int getPlayer2Birdies() { return this.player2Birdies; }
    
    /**
     * @hibernate.property column="p2eagles" lazy="false" 
     */
    public int getPlayer2Eagles() { return this.player2Eagles; }
    
    /**
     * @hibernate.property column="p2dbleagles" lazy="false" 
     */
    public int getPlayer2DoubleEagles() { return this.player2DoubleEagles; }
    
    /**
     * @hibernate.property column="p2netbirdies" lazy="false" 
     */
    public int getPlayer2NetBirdies() { return this.player2NetBirdies; }
    
    /**
     * @hibernate.property column="p2neteagles" lazy="false" 
     */
    public int getPlayer2NetEagles() { return this.player2NetEagles; }
    
    /**
     * @hibernate.property column="p2netdbleagles" lazy="false" 
     */
    public int getPlayer2NetDoubleEagles() { return this.player2NetDoubleEagles; }
    
    public void setPlayer1Birdies(int b) { this.player1Birdies = b; }
    public void setPlayer1Eagles(int e) { this.player1Eagles  = e; }
    public void setPlayer1DoubleEagles(int e) { this.player1DoubleEagles  = e; }
    public void setPlayer1NetBirdies(int b) { this.player1NetBirdies = b; }
    public void setPlayer1NetEagles(int e) { this.player1NetEagles  = e; }
    public void setPlayer1NetDoubleEagles(int e) { this.player1NetDoubleEagles  = e; }
    public void setPlayer2Birdies(int b) { this.player2Birdies = b; }
    public void setPlayer2Eagles(int e) { this.player2Eagles  = e; }
    public void setPlayer2DoubleEagles(int e) { this.player2DoubleEagles  = e; }
    public void setPlayer2NetBirdies(int b) { this.player2NetBirdies = b; }
    public void setPlayer2NetEagles(int e) { this.player2NetEagles  = e; }
    public void setPlayer2NetDoubleEagles(int e) { this.player2NetDoubleEagles  = e; }
    
    public int getPlayer1UnderParGrossScore()
    {
    	return (getPlayer1Birdies() * BIRDIE_POINTS) +
    		   (getPlayer1Eagles() * EAGLE_POINTS) +
    		   (getPlayer1DoubleEagles() * DOUBLE_EAGLE_POINTS);
    }
    
    public int getPlayer1UnderParNetScore()
    {
    	return (getPlayer1NetBirdies() * BIRDIE_POINTS) +
    		   (getPlayer1NetEagles() * EAGLE_POINTS) +
    		   (getPlayer1NetDoubleEagles() * DOUBLE_EAGLE_POINTS);
    }
    
    public int getPlayer2UnderParGrossScore()
    {
    	return (getPlayer2Birdies() * BIRDIE_POINTS) +
    		   (getPlayer2Eagles() * EAGLE_POINTS) +
    		   (getPlayer2DoubleEagles() * DOUBLE_EAGLE_POINTS);
    }
    
    public int getPlayer2UnderParNetScore()
    {
    	return (getPlayer2NetBirdies() * BIRDIE_POINTS) +
    		   (getPlayer2NetEagles() * EAGLE_POINTS) +
    		   (getPlayer2NetDoubleEagles() * DOUBLE_EAGLE_POINTS);
    }
    
    public Byte[] getPlayer1Pars() { return this.player1Pars; }
    public void setPlayer1Pars(Byte[] pars) { this.player1Pars = pars; }
    
    public Byte[] getPlayer1Strokes() { return this.player1Strokes; }
    public void setPlayer1Strokes(Byte[] strks) { this.player1Strokes = strks; }
    
    public Byte[] getPlayer1Scores() { return this.player1Scores; }
    public void setPlayer1Scores(Byte[] scores) { this.player1Scores = scores; }
    
    public Byte[] getPlayer2Pars() { return this.player2Pars; }
    public void setPlayer2Pars(Byte[] pars) { this.player2Pars = pars; }
    
    public Byte[] getPlayer2Strokes() { return this.player2Strokes; }
    public void setPlayer2Strokes(Byte[] strks) { this.player2Strokes = strks; }
    
    public Byte[] getPlayer2Scores() { return this.player2Scores; }
    public void setPlayer2Scores(Byte[] scores) { this.player2Scores = scores; }
    
    public Byte[] getStrokes() { return this.strokes; }
    public void setStrokes(Byte[] strks) { this.strokes = strks; }
    
    public Byte[] getNet() { return this.score; }
    
    public void setPlayer1Hole1Par(Byte scr) { this.player1Pars[0] = scr; }
    public void setPlayer1Hole2Par(Byte scr) { this.player1Pars[1] = scr; }
    public void setPlayer1Hole3Par(Byte scr) { this.player1Pars[2] = scr; }
    public void setPlayer1Hole4Par(Byte scr) { this.player1Pars[3] = scr; }
    public void setPlayer1Hole5Par(Byte scr) { this.player1Pars[4] = scr; }
    public void setPlayer1Hole6Par(Byte scr) { this.player1Pars[5] = scr; }
    public void setPlayer1Hole7Par(Byte scr) { this.player1Pars[6] = scr; }
    public void setPlayer1Hole8Par(Byte scr) { this.player1Pars[7] = scr; }
    public void setPlayer1Hole9Par(Byte scr) { this.player1Pars[8] = scr; }
    public void setPlayer1Hole10Par(Byte scr) { this.player1Pars[9] = scr; }
    public void setPlayer1Hole11Par(Byte scr) { this.player1Pars[10] = scr; }
    public void setPlayer1Hole12Par(Byte scr) { this.player1Pars[11] = scr; }
    public void setPlayer1Hole13Par(Byte scr) { this.player1Pars[12] = scr; }
    public void setPlayer1Hole14Par(Byte scr) { this.player1Pars[13] = scr; }
    public void setPlayer1Hole15Par(Byte scr) { this.player1Pars[14] = scr; }
    public void setPlayer1Hole16Par(Byte scr) { this.player1Pars[15] = scr; }
    public void setPlayer1Hole17Par(Byte scr) { this.player1Pars[16] = scr; }
    public void setPlayer1Hole18Par(Byte scr) { this.player1Pars[17] = scr; }
    
    public void setPlayer1Hole1Stroke(Byte scr) { this.player1Strokes[0] = scr; }
    public void setPlayer1Hole2Stroke(Byte scr) { this.player1Strokes[1] = scr; }
    public void setPlayer1Hole3Stroke(Byte scr) { this.player1Strokes[2] = scr; }
    public void setPlayer1Hole4Stroke(Byte scr) { this.player1Strokes[3] = scr; }
    public void setPlayer1Hole5Stroke(Byte scr) { this.player1Strokes[4] = scr; }
    public void setPlayer1Hole6Stroke(Byte scr) { this.player1Strokes[5] = scr; }
    public void setPlayer1Hole7Stroke(Byte scr) { this.player1Strokes[6] = scr; }
    public void setPlayer1Hole8Stroke(Byte scr) { this.player1Strokes[7] = scr; }
    public void setPlayer1Hole9Stroke(Byte scr) { this.player1Strokes[8] = scr; }
    public void setPlayer1Hole10Stroke(Byte scr) { this.player1Strokes[9] = scr; }
    public void setPlayer1Hole11Stroke(Byte scr) { this.player1Strokes[10] = scr; }
    public void setPlayer1Hole12Stroke(Byte scr) { this.player1Strokes[11] = scr; }
    public void setPlayer1Hole13Stroke(Byte scr) { this.player1Strokes[12] = scr; }
    public void setPlayer1Hole14Stroke(Byte scr) { this.player1Strokes[13] = scr; }
    public void setPlayer1Hole15Stroke(Byte scr) { this.player1Strokes[14] = scr; }
    public void setPlayer1Hole16Stroke(Byte scr) { this.player1Strokes[15] = scr; }
    public void setPlayer1Hole17Stroke(Byte scr) { this.player1Strokes[16] = scr; }
    public void setPlayer1Hole18Stroke(Byte scr) { this.player1Strokes[17] = scr; }
    
    public void setPlayer1Hole1Score(Byte scr) { this.player1Scores[0] = scr; }
    public void setPlayer1Hole2Score(Byte scr) { this.player1Scores[1] = scr; }
    public void setPlayer1Hole3Score(Byte scr) { this.player1Scores[2] = scr; }
    public void setPlayer1Hole4Score(Byte scr) { this.player1Scores[3] = scr; }
    public void setPlayer1Hole5Score(Byte scr) { this.player1Scores[4] = scr; }
    public void setPlayer1Hole6Score(Byte scr) { this.player1Scores[5] = scr; }
    public void setPlayer1Hole7Score(Byte scr) { this.player1Scores[6] = scr; }
    public void setPlayer1Hole8Score(Byte scr) { this.player1Scores[7] = scr; }
    public void setPlayer1Hole9Score(Byte scr) { this.player1Scores[8] = scr; }
    public void setPlayer1Hole10Score(Byte scr) { this.player1Scores[9] = scr; }
    public void setPlayer1Hole11Score(Byte scr) { this.player1Scores[10] = scr; }
    public void setPlayer1Hole12Score(Byte scr) { this.player1Scores[11] = scr; }
    public void setPlayer1Hole13Score(Byte scr) { this.player1Scores[12] = scr; }
    public void setPlayer1Hole14Score(Byte scr) { this.player1Scores[13] = scr; }
    public void setPlayer1Hole15Score(Byte scr) { this.player1Scores[14] = scr; }
    public void setPlayer1Hole16Score(Byte scr) { this.player1Scores[15] = scr; }
    public void setPlayer1Hole17Score(Byte scr) { this.player1Scores[16] = scr; }
    public void setPlayer1Hole18Score(Byte scr) { this.player1Scores[17] = scr; }
    
    public void setPlayer2Hole1Par(Byte scr) { this.player2Pars[0] = scr; }
    public void setPlayer2Hole2Par(Byte scr) { this.player2Pars[1] = scr; }
    public void setPlayer2Hole3Par(Byte scr) { this.player2Pars[2] = scr; }
    public void setPlayer2Hole4Par(Byte scr) { this.player2Pars[3] = scr; }
    public void setPlayer2Hole5Par(Byte scr) { this.player2Pars[4] = scr; }
    public void setPlayer2Hole6Par(Byte scr) { this.player2Pars[5] = scr; }
    public void setPlayer2Hole7Par(Byte scr) { this.player2Pars[6] = scr; }
    public void setPlayer2Hole8Par(Byte scr) { this.player2Pars[7] = scr; }
    public void setPlayer2Hole9Par(Byte scr) { this.player2Pars[8] = scr; }
    public void setPlayer2Hole10Par(Byte scr) { this.player2Pars[9] = scr; }
    public void setPlayer2Hole11Par(Byte scr) { this.player2Pars[10] = scr; }
    public void setPlayer2Hole12Par(Byte scr) { this.player2Pars[11] = scr; }
    public void setPlayer2Hole13Par(Byte scr) { this.player2Pars[12] = scr; }
    public void setPlayer2Hole14Par(Byte scr) { this.player2Pars[13] = scr; }
    public void setPlayer2Hole15Par(Byte scr) { this.player2Pars[14] = scr; }
    public void setPlayer2Hole16Par(Byte scr) { this.player2Pars[15] = scr; }
    public void setPlayer2Hole17Par(Byte scr) { this.player2Pars[16] = scr; }
    public void setPlayer2Hole18Par(Byte scr) { this.player2Pars[17] = scr; }
    
    public void setPlayer2Hole1Stroke(Byte scr) { this.player2Strokes[0] = scr; }
    public void setPlayer2Hole2Stroke(Byte scr) { this.player2Strokes[1] = scr; }
    public void setPlayer2Hole3Stroke(Byte scr) { this.player2Strokes[2] = scr; }
    public void setPlayer2Hole4Stroke(Byte scr) { this.player2Strokes[3] = scr; }
    public void setPlayer2Hole5Stroke(Byte scr) { this.player2Strokes[4] = scr; }
    public void setPlayer2Hole6Stroke(Byte scr) { this.player2Strokes[5] = scr; }
    public void setPlayer2Hole7Stroke(Byte scr) { this.player2Strokes[6] = scr; }
    public void setPlayer2Hole8Stroke(Byte scr) { this.player2Strokes[7] = scr; }
    public void setPlayer2Hole9Stroke(Byte scr) { this.player2Strokes[8] = scr; }
    public void setPlayer2Hole10Stroke(Byte scr) { this.player2Strokes[9] = scr; }
    public void setPlayer2Hole11Stroke(Byte scr) { this.player2Strokes[10] = scr; }
    public void setPlayer2Hole12Stroke(Byte scr) { this.player2Strokes[11] = scr; }
    public void setPlayer2Hole13Stroke(Byte scr) { this.player2Strokes[12] = scr; }
    public void setPlayer2Hole14Stroke(Byte scr) { this.player2Strokes[13] = scr; }
    public void setPlayer2Hole15Stroke(Byte scr) { this.player2Strokes[14] = scr; }
    public void setPlayer2Hole16Stroke(Byte scr) { this.player2Strokes[15] = scr; }
    public void setPlayer2Hole17Stroke(Byte scr) { this.player2Strokes[16] = scr; }
    public void setPlayer2Hole18Stroke(Byte scr) { this.player2Strokes[17] = scr; }
    
    public void setPlayer2Hole1Score(Byte scr) { this.player2Scores[0] = scr; }
    public void setPlayer2Hole2Score(Byte scr) { this.player2Scores[1] = scr; }
    public void setPlayer2Hole3Score(Byte scr) { this.player2Scores[2] = scr; }
    public void setPlayer2Hole4Score(Byte scr) { this.player2Scores[3] = scr; }
    public void setPlayer2Hole5Score(Byte scr) { this.player2Scores[4] = scr; }
    public void setPlayer2Hole6Score(Byte scr) { this.player2Scores[5] = scr; }
    public void setPlayer2Hole7Score(Byte scr) { this.player2Scores[6] = scr; }
    public void setPlayer2Hole8Score(Byte scr) { this.player2Scores[7] = scr; }
    public void setPlayer2Hole9Score(Byte scr) { this.player2Scores[8] = scr; }
    public void setPlayer2Hole10Score(Byte scr) { this.player2Scores[9] = scr; }
    public void setPlayer2Hole11Score(Byte scr) { this.player2Scores[10] = scr; }
    public void setPlayer2Hole12Score(Byte scr) { this.player2Scores[11] = scr; }
    public void setPlayer2Hole13Score(Byte scr) { this.player2Scores[12] = scr; }
    public void setPlayer2Hole14Score(Byte scr) { this.player2Scores[13] = scr; }
    public void setPlayer2Hole15Score(Byte scr) { this.player2Scores[14] = scr; }
    public void setPlayer2Hole16Score(Byte scr) { this.player2Scores[15] = scr; }
    public void setPlayer2Hole17Score(Byte scr) { this.player2Scores[16] = scr; }
    public void setPlayer2Hole18Score(Byte scr) { this.player2Scores[17] = scr; }
    
    public void setStroke1(Byte scr) { this.strokes[0] = scr; }
    public void setStroke2(Byte scr) { this.strokes[1] = scr; }
    public void setStroke3(Byte scr) { this.strokes[2] = scr; }
    public void setStroke4(Byte scr) { this.strokes[3] = scr; }
    public void setStroke5(Byte scr) { this.strokes[4] = scr; }
    public void setStroke6(Byte scr) { this.strokes[5] = scr; }
    public void setStroke7(Byte scr) { this.strokes[6] = scr; }
    public void setStroke8(Byte scr) { this.strokes[7] = scr; }
    public void setStroke9(Byte scr) { this.strokes[8] = scr; }
    public void setStroke10(Byte scr) { this.strokes[9] = scr; }
    public void setStroke11(Byte scr) { this.strokes[10] = scr; }
    public void setStroke12(Byte scr) { this.strokes[11] = scr; }
    public void setStroke13(Byte scr) { this.strokes[12] = scr; }
    public void setStroke14(Byte scr) { this.strokes[13] = scr; }
    public void setStroke15(Byte scr) { this.strokes[14] = scr; }
    public void setStroke16(Byte scr) { this.strokes[15] = scr; }
    public void setStroke17(Byte scr) { this.strokes[16] = scr; }
    public void setStroke18(Byte scr) { this.strokes[17] = scr; }
    
    public void setScore1(Byte scr) { this.score[0] = scr; }
    public void setScore2(Byte scr) { this.score[1] = scr; }
    public void setScore3(Byte scr) { this.score[2] = scr; }
    public void setScore4(Byte scr) { this.score[3] = scr; }
    public void setScore5(Byte scr) { this.score[4] = scr; }
    public void setScore6(Byte scr) { this.score[5] = scr; }
    public void setScore7(Byte scr) { this.score[6] = scr; }
    public void setScore8(Byte scr) { this.score[7] = scr; }
    public void setScore9(Byte scr) { this.score[8] = scr; }
    public void setScore10(Byte scr) { this.score[9] = scr; }
    public void setScore11(Byte scr) { this.score[10] = scr; }
    public void setScore12(Byte scr) { this.score[11] = scr; }
    public void setScore13(Byte scr) { this.score[12] = scr; }
    public void setScore14(Byte scr) { this.score[13] = scr; }
    public void setScore15(Byte scr) { this.score[14] = scr; }
    public void setScore16(Byte scr) { this.score[15] = scr; }
    public void setScore17(Byte scr) { this.score[16] = scr; }
    public void setScore18(Byte scr) { this.score[17] = scr; }
    
    public Byte[] getScores1() { return this.player1Scores; }
    public void setScores1(Byte[] scores)
    {
        for (int i=0;  i<scores.length && i<18; i++)
        {
            this.player1Scores[i] = scores[i];
        }
    }
    
    public Byte[] getScores2() { return this.player2Scores; }
    public void setScores2(Byte[] scores)
    {
        for (int i=0;  i<scores.length && i<18; i++)
        {
            this.player2Scores[i] = scores[i];
        }
    }
    
    public void setStroke(int idx, Byte val)
    {
        if (idx > 17)
        {
            throw new IllegalArgumentException("Invalid index for setting stroke value: "+idx); //$NON-NLS-1$
        }
        this.strokes[idx] = val;
    }
    
    public void setScore(int idx, Byte val)
    {
        if (idx > 17)
        {
            throw new IllegalArgumentException("Invalid index for setting net value: "+idx); //$NON-NLS-1$
        }
        this.score[idx] = val;
    }
    
    private void computeUnderParScores()
    {
        for (int i=0; i<18; i++)
        {
            // First compute player ones score for the hole
            if (isBirdie(this.player1Scores[i], this.player1Pars[i]))
            {
                this.player1Birdies++;
            }
            if (isEagle(this.player1Scores[i], this.player1Pars[i]))
            {
                this.player1Eagles++;
            }
            if (isDoubleEagle(this.player1Scores[i], this.player1Pars[i]))
            {
                this.player1DoubleEagles++;
            }
            if (isNetBirdie(this.player1Scores[i], this.player1Pars[i], this.player1Strokes[i]))
            {
                this.player1NetBirdies++;
            }
            if (isNetEagle(this.player1Scores[i], this.player1Pars[i], this.player1Strokes[i]))
            {
                this.player1NetEagles++;
            }
            if (isNetDoubleEagle(this.player1Scores[i], this.player1Pars[i], this.player1Strokes[i]))
            {
                this.player1NetDoubleEagles++;
            }
            
            // Now player 2
            if (isBirdie(this.player2Scores[i], this.player2Pars[i]))
            {
                this.player2Birdies++;
            }
            if (isEagle(this.player2Scores[i], this.player2Pars[i]))
            {
                this.player2Eagles++;
            }
            if (isDoubleEagle(this.player2Scores[i], this.player2Pars[i]))
            {
                this.player2DoubleEagles++;
            }
            if (isNetBirdie(this.player2Scores[i], this.player2Pars[i], this.player2Strokes[i]))
            {
                this.player2NetBirdies++;
            }
            if (isNetEagle(this.player2Scores[i], this.player2Pars[i], this.player2Strokes[i]))
            {
                this.player2NetEagles++;
            }
            if (isNetDoubleEagle(this.player2Scores[i], this.player2Pars[i], this.player2Strokes[i]))
            {
                this.player2NetDoubleEagles++;
            }
        }
    }
    
    public void computeMatchScore()
    {
        int runningScore = 0;
        for (int i=0; i<18; i++)
        {
            fixupScores(i);
            runningScore += getHoleScore(this.player1Scores[i], this.player2Scores[i], this.strokes[i]);
            this.score[i] = Byte.valueOf((byte)runningScore);
            
            if (matchOver(runningScore, i))
            {
                for (int j=i+1; j<18; j++)
                {
                    this.score[j] = null;
                }
                break;
            }
        }
        
        computeUnderParScores();
        
        if (log.isDebugEnabled())
        {
            dumpMatchScore();
        }
    }
    
    private boolean matchOver(int currentScore, int hole)
    {
        if (Math.abs(currentScore) > (17-hole))
        {
            return true;
        }
        return false;
    }
    
    private void fixupScores(int i)
    {
        if ((this.player1Scores[i] == null) ||
            (this.player1Scores[i].intValue() < 0))
        {
            this.player1Scores[i] = Byte.valueOf((byte)0);
        }
        if ((this.player2Scores[i] == null) ||
            (this.player2Scores[i].intValue() < 0))
        {
            this.player2Scores[i] = Byte.valueOf((byte)0);
        }
    }
    
    private int getHoleScore(Byte score1, Byte score2, Byte stroke)
    {
        // First check for 0 values because those were the holes that an x was taken.
        if ((score1.intValue() == 0) && (score2.intValue() == 0))
        {
            return 0;
        }
        else if (score1.intValue() == 0)
        {
            return -1;
        }
        else if (score2.intValue() == 0)
        {
            return 1;
        }
        
        int iscore1 = score1.byteValue() + stroke.byteValue();
        int iscore2 = score2.byteValue();
        if (iscore1 > iscore2)
        {
            return -1;
        }
        else if (iscore1 < iscore2)
        {
            return 1;
        }
        return 0;
    }
    
    public void dumpMatchScore()
    {
        ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE);
        
        StringBuilder sb1 = new StringBuilder();
        for (int i=0; i<18; i++)
        {
            sb1.append(this.player1Pars[i]).append(" "); //$NON-NLS-1$
        }
        sb.append("golfer1 par", sb1.toString()); //$NON-NLS-1$
        
        sb1.setLength(0);
        for (int i=0; i<18; i++)
        {
            sb1.append(this.player1Strokes[i]).append(" "); //$NON-NLS-1$
        }
        sb.append("golfer1 strokes", sb1.toString()); //$NON-NLS-1$
        
        sb1.setLength(0);
        for (int i=0; i<18; i++)
        {
            sb1.append(this.player1Scores[i]).append(" "); //$NON-NLS-1$
        }
        sb.append("golfer1 scores", sb1.toString()); //$NON-NLS-1$
        
        sb1.setLength(0);
        for (int i=0; i<18; i++)
        {
            sb1.append(this.player2Pars[i]).append(" "); //$NON-NLS-1$
        }
        sb.append("golfer2 par", sb1.toString()); //$NON-NLS-1$
        
        sb1.setLength(0);
        for (int i=0; i<18; i++)
        {
            sb1.append(this.player2Strokes[i]).append(" "); //$NON-NLS-1$
        }
        sb.append("golfer2 strokes", sb1.toString()); //$NON-NLS-1$
        
        sb1.setLength(0);
        for (int i=0; i<18; i++)
        {
            sb1.append(this.player2Scores[i]).append(" "); //$NON-NLS-1$
        }
        sb.append("golfer2 score", sb1.toString()); //$NON-NLS-1$
        
        sb1.setLength(0);
        for (int i=0; i<18; i++)
        {
            sb1.append(this.strokes[i]).append(" "); //$NON-NLS-1$
        }
        sb.append("strokes", sb1.toString()); //$NON-NLS-1$
        
        sb1.setLength(0);
        for (int i=0; i<18; i++)
        {
            sb1.append(this.score[i]).append(" "); //$NON-NLS-1$
        }
        sb.append("score", sb1.toString()); //$NON-NLS-1$
        
        sb.append("player 1 under par score (gross) ", this.getPlayer1UnderParGrossScore()); //$NON-NLS-1$
        sb.append("player 1 under par score (net) ", this.getPlayer1UnderParNetScore()); //$NON-NLS-1$
        sb.append("player 2 under par score (gross) ", this.getPlayer2UnderParGrossScore()); //$NON-NLS-1$
        sb.append("player 2 under par score (net) ", this.getPlayer2UnderParNetScore()); //$NON-NLS-1$

        log.debug(sb.toString());
    }
    
    /**
     * Compute the strokes given/received in the match.  The strokes are computed using the users
     * handicaps and the course ratings of the course they played.  The values in the strokes array
     * are relative to golfer 1.  So, if the value of strokes[4] is 1 then golfer1 gets 1 stroke on
     * hole 5.  If the value is -1 then golfer 1 is giving 1 stroke on hole 5.  If the value is 0
     * then no strokes are given on that hole.
     *
     */
    public void computeStrokes(Course course, User golfer1, User golfer2)
    {
        this.golfer1Handicap = computeCourseHandicap(golfer1, course);
        this.golfer2Handicap = computeCourseHandicap(golfer2, course);
        updateGolferInfo(golfer1, course, this.golfer1Handicap, this.player1Pars, this.player1Strokes);
        updateGolferInfo(golfer2, course, this.golfer2Handicap, this.player2Pars, this.player2Strokes);
        int diff = this.golfer2Handicap - this.golfer1Handicap;
        Byte[] holeHandicaps = getHoleHandicapsToUse(golfer1, golfer2, this.golfer1Handicap, this.golfer2Handicap, course);
        
        for (int i=0; i<18; i++)
        {
            if (null == holeHandicaps)
            {
                this.strokes[i] = BYTE_ZERO;
            }
            else
            {
                int holeHandicap = holeHandicaps[i].intValue();
                if (diff == 0)
                {
                    this.strokes[i] = BYTE_ZERO;
                }
                else if (holeHandicap <= (Math.abs(diff)-18))
                {
                    if (diff < 0)
                    {
                        this.strokes[i] = BYTE_MINUS2;
                    }
                    else
                    {
                        this.strokes[i] = BYTE_TWO;
                    }
                }
                else if (holeHandicap <= Math.abs(diff))
                {
                    if (diff < 0)
                    {
                        this.strokes[i] = BYTE_MINUS1;
                    }
                    else
                    {
                        this.strokes[i] = BYTE_ONE;
                    }
                }
                else
                {
                    this.strokes[i] = BYTE_ZERO;
                }
            }
        }
        
        if (log.isDebugEnabled())
        {
            dumpStrokes(golfer1, golfer2, this.golfer1Handicap, this.golfer2Handicap, course);
        }
    }
    
    private void dumpStrokes(User golfer1, User golfer2, int handicap1, int handicap2, Course course)
    {
        ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE);
        sb.append("course", course.getName()); //$NON-NLS-1$
        sb.append("mens slope", course.getMensSlope()); //$NON-NLS-1$
        sb.append("womens slope", course.getMensSlope()); //$NON-NLS-1$
        if (null != golfer1)
        {
            sb.append("golfer1", golfer1.getFullName()); //$NON-NLS-1$
            //sb.append("golfer1 index", golfer1.getHandicap()); //$NON-NLS-1$
            sb.append("golfer1 male?", golfer1.getMale()); //$NON-NLS-1$
            sb.append("golfer1 handicap", handicap1); //$NON-NLS-1$
        }
        if (null != golfer2)
        {
            sb.append("golfer2", golfer2.getFullName()); //$NON-NLS-1$
            //sb.append("golfer2 index", golfer2.getHandicap()); //$NON-NLS-1$
            sb.append("golfer2 male?", golfer2.getMale()); //$NON-NLS-1$
            sb.append("golfer2 handicap", handicap2); //$NON-NLS-1$
        }
        
        StringBuilder sb2 = new StringBuilder();
        for (int i=0; i<18; i++)
        {
            sb2.append(this.strokes[i]).append(" "); //$NON-NLS-1$
        }
        sb.append("strokes", sb2.toString()); //$NON-NLS-1$
        log.debug(sb.toString());
    }
    
    private int computeCourseHandicap(User golfer, Course course)
    {
        if (null == golfer)
        {
            return 0;
        }
        Integer slope = (golfer.getMale()) ? course.getMensSlope() : course.getWomensSlope();
        //int h = (int)Math.round(golfer.getHandicap().doubleValue() * slope.doubleValue() / 113.0);
        return 0;
    }
    
    private Byte[] getHoleHandicapsToUse(User golfer1, User golfer2, int handicap1, int handicap2, Course course)
    {
        if ((null == golfer1) || (null == golfer2))
        {
            return null;
        }
        
        if (golfer1.getMale() && golfer2.getMale())
        {
            return course.getMensHandicaps(); 
        }
        else if (!golfer1.getMale() && !golfer2.getMale())
        {
            return course.getWomensHandicaps();
        }
        
        if (handicap1 < handicap2)
        {
            return (golfer2.getMale()) ? course.getMensHandicaps() : course.getWomensHandicaps();
        }
        
        return (golfer1.getMale()) ? course.getMensHandicaps() : course.getWomensHandicaps();
        
    }
    
    private void updateGolferInfo(User golfer, Course course, int handicap, Byte[] playerPars, Byte[] playerStrokes)
    {
        if (null == golfer)
        {
            return;
        }
        
        Byte[] handicaps;
        if (golfer.getMale())
        {
            System.arraycopy(course.getMensPars(), 0, playerPars, 0, 18);
            handicaps = course.getMensHandicaps();
        }
        else
        {
            System.arraycopy(course.getWomensPars(), 0, playerPars, 0, 18);
            handicaps = course.getWomensHandicaps();
        }
        
        // Compute how many strokes the user gets on each hole.
        for (int i=0; i<18; i++)
        {
            int holeStrokes = 0;
            int curHandicap = handicap;
            while (curHandicap > 18)
            {
                holeStrokes++;
                curHandicap -= 18;
            }
            int holeHandicap = handicaps[i].intValue();
            if (holeHandicap <= curHandicap)
            {
                holeStrokes++;
            }
            playerStrokes[i] = Byte.valueOf(Integer.valueOf(holeStrokes).byteValue());
        }
    }
    
    public String getPlayer1Hole1CSSClass() { return getPlayerHoleCSSClass(1, 1); }
    public String getPlayer1Hole2CSSClass() { return getPlayerHoleCSSClass(1, 2); }
    public String getPlayer1Hole3CSSClass() { return getPlayerHoleCSSClass(1, 3); }
    public String getPlayer1Hole4CSSClass() { return getPlayerHoleCSSClass(1, 4); }
    public String getPlayer1Hole5CSSClass() { return getPlayerHoleCSSClass(1, 5); }
    public String getPlayer1Hole6CSSClass() { return getPlayerHoleCSSClass(1, 6); }
    public String getPlayer1Hole7CSSClass() { return getPlayerHoleCSSClass(1, 7); }
    public String getPlayer1Hole8CSSClass() { return getPlayerHoleCSSClass(1, 8); }
    public String getPlayer1Hole9CSSClass() { return getPlayerHoleCSSClass(1, 9); }
    public String getPlayer1Hole10CSSClass() { return getPlayerHoleCSSClass(1, 10); }
    public String getPlayer1Hole11CSSClass() { return getPlayerHoleCSSClass(1, 11); }
    public String getPlayer1Hole12CSSClass() { return getPlayerHoleCSSClass(1, 12); }
    public String getPlayer1Hole13CSSClass() { return getPlayerHoleCSSClass(1, 13); }
    public String getPlayer1Hole14CSSClass() { return getPlayerHoleCSSClass(1, 14); }
    public String getPlayer1Hole15CSSClass() { return getPlayerHoleCSSClass(1, 15); }
    public String getPlayer1Hole16CSSClass() { return getPlayerHoleCSSClass(1, 16); }
    public String getPlayer1Hole17CSSClass() { return getPlayerHoleCSSClass(1, 17); }
    public String getPlayer1Hole18CSSClass() { return getPlayerHoleCSSClass(1, 18); }
    
    public String getPlayer2Hole1CSSClass() { return getPlayerHoleCSSClass(2, 1); }
    public String getPlayer2Hole2CSSClass() { return getPlayerHoleCSSClass(2, 2); }
    public String getPlayer2Hole3CSSClass() { return getPlayerHoleCSSClass(2, 3); }
    public String getPlayer2Hole4CSSClass() { return getPlayerHoleCSSClass(2, 4); }
    public String getPlayer2Hole5CSSClass() { return getPlayerHoleCSSClass(2, 5); }
    public String getPlayer2Hole6CSSClass() { return getPlayerHoleCSSClass(2, 6); }
    public String getPlayer2Hole7CSSClass() { return getPlayerHoleCSSClass(2, 7); }
    public String getPlayer2Hole8CSSClass() { return getPlayerHoleCSSClass(2, 8); }
    public String getPlayer2Hole9CSSClass() { return getPlayerHoleCSSClass(2, 9); }
    public String getPlayer2Hole10CSSClass() { return getPlayerHoleCSSClass(2, 10); }
    public String getPlayer2Hole11CSSClass() { return getPlayerHoleCSSClass(2, 11); }
    public String getPlayer2Hole12CSSClass() { return getPlayerHoleCSSClass(2, 12); }
    public String getPlayer2Hole13CSSClass() { return getPlayerHoleCSSClass(2, 13); }
    public String getPlayer2Hole14CSSClass() { return getPlayerHoleCSSClass(2, 14); }
    public String getPlayer2Hole15CSSClass() { return getPlayerHoleCSSClass(2, 15); }
    public String getPlayer2Hole16CSSClass() { return getPlayerHoleCSSClass(2, 16); }
    public String getPlayer2Hole17CSSClass() { return getPlayerHoleCSSClass(2, 17); }
    public String getPlayer2Hole18CSSClass() { return getPlayerHoleCSSClass(2, 18); }
    
    private StringBuilder cssBuilder = new StringBuilder();
    private String getPlayerHoleCSSClass(int player, int hole)
    {
        this.cssBuilder.setLength(0);
        this.cssBuilder.append(CSS_HOLE_SCORE);
        Byte playerScore = (player == 1) ? this.player1Scores[hole-1] : this.player2Scores[hole-1];
        Byte playerPar = (player == 1) ? this.player1Pars[hole-1] : this.player2Pars[hole-1];
        Byte playerStrokes = (player == 1) ? this.player1Strokes[hole-1] : this.player2Strokes[hole-1];
        
        if (playerScore.intValue() > 0)
        {
            if (isBirdie(playerScore, playerPar))
            {
                this.cssBuilder.append(' ').append(CSS_BIRDIE);
            }
            if (isEagle(playerScore, playerPar))
            {
                this.cssBuilder.append(' ').append(CSS_EAGLE);
            }
            if (isDoubleEagle(playerScore, playerPar))
            {
                this.cssBuilder.append(' ').append(CSS_DOUBLE_EAGLE);
            }
            if (isNetBirdie(playerScore, playerPar, playerStrokes))
            {
                this.cssBuilder.append(' ').append(CSS_NET_BIRDIE);
            }
            if (isNetEagle(playerScore, playerPar, playerStrokes))
            {
                this.cssBuilder.append(' ').append(CSS_NET_EAGLE);
            }
            if (isNetDoubleEagle(playerScore, playerPar, playerStrokes))
            {
                this.cssBuilder.append(' ').append(CSS_NET_DOUBLE_EAGLE);
            }
        }
        return this.cssBuilder.toString();
    }
    
    private boolean isBirdie(Byte playerScore, Byte playerPar)
    {
        return (playerPar.byteValue() - playerScore.byteValue()) == 1;
    }
    
    private boolean isEagle(Byte playerScore, Byte playerPar)
    {
        return (playerPar.byteValue() - playerScore.byteValue()) == 2;
    }
    
    private boolean isDoubleEagle(Byte playerScore, Byte playerPar)
    {
        return (playerPar.byteValue() - playerScore.byteValue()) == 3;
    }
    
    private boolean isNetBirdie(Byte playerScore, Byte playerPar, Byte playerStrokes)
    {
        //if (playerStrokes.byteValue() <= 0) return false;
        return ((playerPar.byteValue() == (playerScore.byteValue() - playerStrokes.byteValue() + 1)) &&
        	(playerStrokes > 0));
    }
    
    private boolean isNetEagle(Byte playerScore, Byte playerPar, Byte playerStrokes)
    {
        //if (playerStrokes.byteValue() <= 0) return false;
        return ((playerPar.byteValue() == (playerScore.byteValue() - playerStrokes.byteValue() + 2)) &&
        	(playerStrokes > 0));
    }
    
    private boolean isNetDoubleEagle(Byte playerScore, Byte playerPar, Byte playerStrokes)
    {
        //if (playerStrokes.byteValue() <= 0) return false;
        return ((playerPar.byteValue() == (playerScore.byteValue() - playerStrokes.byteValue() + 3)) &&
       		(playerStrokes > 0));
    }
}
