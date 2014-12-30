package com.klout4java.vo;

import java.util.List;

public class InfluenceResponse {

	private List<Influencer> myInfluencers;
	private List<Influencer> myInfluencees;
	private long myInfluencersCount;
	private long myInfluenceesCount;

	public List<Influencer> getMyInfluencers() {
		return myInfluencers;
	}

	public void setMyInfluencers(List<Influencer> myInfluencers) {
		this.myInfluencers = myInfluencers;
	}

	public List<Influencer> getMyInfluencees() {
		return myInfluencees;
	}

	public void setMyInfluencees(List<Influencer> myInfluencees) {
		this.myInfluencees = myInfluencees;
	}

	public long getMyInfluencersCount() {
		return myInfluencersCount;
	}

	public void setMyInfluencersCount(long myInfluencersCount) {
		this.myInfluencersCount = myInfluencersCount;
	}

	public long getMyInfluenceesCount() {
		return myInfluenceesCount;
	}

	public void setMyInfluenceesCount(long myInfluenceesCount) {
		this.myInfluenceesCount = myInfluenceesCount;
	}

}
