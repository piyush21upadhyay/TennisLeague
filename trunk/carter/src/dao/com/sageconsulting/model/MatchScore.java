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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MatchScore implements Serializable
{
    private static final long serialVersionUID = -8774336424375544471L;
    
    private static final Log log = LogFactory.getLog(MatchScore.class);
    
    private int player1set1;
    private int player1set2;
    private int player1set3;
    private int player2set1;
    private int player2set2;
    private int player2set3;
    
    private int player1set1Sup;
    private int player1set2Sup;
    private int player1set3Sup;
    private int player2set1Sup;
    private int player2set2Sup;
    private int player2set3Sup;
    
    private Long opponentRetired;
    
    /**
     * @hibernate.property column="p1set1" lazy="false"
     */
	public int getPlayer1set1() {
		return player1set1;
	}
	
	public void setPlayer1set1(int player1set1) {
		this.player1set1 = player1set1;
	}
	
	/**
     * @hibernate.property column="p1set2" lazy="false"
     */
	public int getPlayer1set2() {
		return player1set2;
	}
	public void setPlayer1set2(int player1set2) {
		this.player1set2 = player1set2;
	}
	
	/**
     * @hibernate.property column="p1set3" lazy="false"
     */
	public int getPlayer1set3() {
		return player1set3;
	}
	public void setPlayer1set3(int player1set3) {
		this.player1set3 = player1set3;
	}
	
	/**
     * @hibernate.property column="p2set1" lazy="false"
     */
	public int getPlayer2set1() {
		return player2set1;
	}
	public void setPlayer2set1(int player2set1) {
		this.player2set1 = player2set1;
	}
	
	/**
     * @hibernate.property column="p2set2" lazy="false"
     */
	public int getPlayer2set2() {
		return player2set2;
	}
	public void setPlayer2set2(int player2set2) {
		this.player2set2 = player2set2;
	}
	
	/**
     * @hibernate.property column="p2set3" lazy="false"
     */	
	public int getPlayer2set3() {
		return player2set3;
	}
	public void setPlayer2set3(int player2set3) {
		this.player2set3 = player2set3;
	}

	/**
     * @hibernate.property column="p1set1sup" lazy="false"
     */
	public int getPlayer1set1Sup() {
		return player1set1Sup;
	}

	public void setPlayer1set1Sup(int player1set1Sup) {
		this.player1set1Sup = player1set1Sup;
	}

	/**
     * @hibernate.property column="p1set2sup" lazy="false"
     */
	public int getPlayer1set2Sup() {
		return player1set2Sup;
	}

	public void setPlayer1set2Sup(int player1set2Sup) {
		this.player1set2Sup = player1set2Sup;
	}

	/**
     * @hibernate.property column="p1set3sup" lazy="false"
     */
	public int getPlayer1set3Sup() {
		return player1set3Sup;
	}

	public void setPlayer1set3Sup(int player1set3Sup) {
		this.player1set3Sup = player1set3Sup;
	}

	/**
     * @hibernate.property column="p2set1sup" lazy="false"
     */
	public int getPlayer2set1Sup() {
		return player2set1Sup;
	}

	public void setPlayer2set1Sup(int player2set1Sup) {
		this.player2set1Sup = player2set1Sup;
	}

	/**
     * @hibernate.property column="p2set2sup" lazy="false"
     */
	public int getPlayer2set2Sup() {
		return player2set2Sup;
	}

	public void setPlayer2set2Sup(int player2set2Sup) {
		this.player2set2Sup = player2set2Sup;
	}

	/**
     * @hibernate.property column="p2set3sup" lazy="false"
     */
	public int getPlayer2set3Sup() {
		return player2set3Sup;
	}

	public void setPlayer2set3Sup(int player2set3Sup) {
		this.player2set3Sup = player2set3Sup;
	}

	/**
     * @hibernate.property column="opponentRetired" lazy="false"
     */
	public Long getOpponentRetired() {
		return opponentRetired;
	}

	public void setOpponentRetired(Long opponentRetired) {
		this.opponentRetired = opponentRetired;
	}

    }

	

