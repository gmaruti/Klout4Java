package com.klout4java.vo;

public class InfluenceEntity {

	private String id;
	private KloutUser payload;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public KloutUser getPayload() {
		return payload;
	}

	public void setPayload(KloutUser payload) {
		this.payload = payload;
	}

}
