package com.klout4java.vo;

public class KloutUser {

	private String kloutId;
	private String nick;
	private Score score;
	private ScoreDelta scoreDeltas;
	public String getKloutId() {
		return kloutId;
	}
	public void setKloutId(String kloutId) {
		this.kloutId = kloutId;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public Score getScore() {
		return score;
	}
	public void setScore(Score score) {
		this.score = score;
	}
	public ScoreDelta getScoreDeltas() {
		return scoreDeltas;
	}
	public void setScoreDeltas(ScoreDelta scoreDeltas) {
		this.scoreDeltas = scoreDeltas;
	}


}
