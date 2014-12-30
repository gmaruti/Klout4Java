package com.klout4java.vo;

public class ScoreResponse {

	private String score;
	private ScoreDelta scoreDelta;
	private String bucket;

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public ScoreDelta getScoreDelta() {
		return scoreDelta;
	}

	public void setScoreDelta(ScoreDelta scoreDelta) {
		this.scoreDelta = scoreDelta;
	}

	public String getBucket() {
		return bucket;
	}

	public void setBucket(String bucket) {
		this.bucket = bucket;
	}

}
