package com.klout4java;

import java.util.List;

import com.klout4java.vo.InfluenceResponse;
import com.klout4java.vo.KloutIdentityResponse;
import com.klout4java.vo.KloutUser;
import com.klout4java.vo.ScoreResponse;
import com.klout4java.vo.TopicItem;

public class Klout4Java {

	private KloutConfig config;

	public KloutConfig getConfig() {
		return config;
	}

	/**
	 * @param config
	 * set required configurations
	 */
	public void setConfig(KloutConfig config) {
		this.config = config;
	}

	/**
	 * Returns klout ID for given numeric twitter ID
	 * @param twitterID - numeric twitter ID
	 * @return - Klout ID
	 * @throws Klout4JavaException
	 */
	public String kloutIDForTwitterID(String twitterID)
			throws Klout4JavaException {
		KloutInvoker invoker = new KloutInvoker();
		invoker.setConfig(config);

		KloutIdentityResponse response = (KloutIdentityResponse) invoker
				.fetchData(KloutConstants.kIDForTwIDURL + twitterID, "idSearch");

		return response.getId();
	}

	public String kloutIDForGooglePID(String googlePID)
			throws Klout4JavaException {
		KloutInvoker invoker = new KloutInvoker();
		invoker.setConfig(config);

		KloutIdentityResponse response = (KloutIdentityResponse) invoker
				.fetchData(KloutConstants.kIDForGPIDURL + googlePID, "idSearch");

		return response.getId();
	}

	public String kloutIDForTwScreenName(String twScreenName)
			throws Klout4JavaException {
		KloutInvoker invoker = new KloutInvoker();
		invoker.setConfig(config);

		KloutIdentityResponse response = (KloutIdentityResponse) invoker
				.fetchData(KloutConstants.kIDForTwSNIDURL + twScreenName,
						"idSearch");

		return response.getId();
	}

	public String twIDForKloutID(String kloutID) throws Klout4JavaException {
		KloutInvoker invoker = new KloutInvoker();
		invoker.setConfig(config);

		KloutIdentityResponse response = (KloutIdentityResponse) invoker
				.fetchData(KloutConstants.twIDForKIDURL + kloutID + "/tw",
						"idSearch");

		return response.getId();
	}

	public KloutUser showUser(String kloutID) throws Klout4JavaException {
		KloutInvoker invoker = new KloutInvoker();
		invoker.setConfig(config);

		KloutUser response = (KloutUser) invoker.fetchData(
				KloutConstants.userURL + kloutID, "showUser");

		return response;
	}

	public ScoreResponse score(String kloutID) throws Klout4JavaException {
		KloutInvoker invoker = new KloutInvoker();
		invoker.setConfig(config);

		ScoreResponse response = (ScoreResponse) invoker.fetchData(
				KloutConstants.scoreURL + kloutID + "/score", "score");

		return response;
	}

	public List<TopicItem> topics(String kloutID) throws Klout4JavaException {
		KloutInvoker invoker = new KloutInvoker();
		invoker.setConfig(config);

		List<TopicItem> response = (List<TopicItem>) invoker.fetchData(
				KloutConstants.topicsURL + kloutID + "/topics", "topics");

		return response;
	}

	public InfluenceResponse influence(String kloutID)
			throws Klout4JavaException {
		KloutInvoker invoker = new KloutInvoker();
		invoker.setConfig(config);

		InfluenceResponse response = (InfluenceResponse) invoker.fetchData(
				KloutConstants.influenceURL + kloutID + "/influence",
				"influence");

		return response;
	}

	public KloutUser showUserForTwID(String twitterID)
			throws Klout4JavaException {
		return showUser(kloutIDForTwitterID(twitterID));
	}

	public KloutUser showUserForTwScreenName(String twitterScreenName)
			throws Klout4JavaException {
		return showUser(kloutIDForTwScreenName(twitterScreenName));
	}

	public KloutUser showUserForGooglePID(String googlePID)
			throws Klout4JavaException {
		return showUser(kloutIDForGooglePID(googlePID));
	}

	public ScoreResponse scoreForTwID(String twitterID)
			throws Klout4JavaException {
		return score(kloutIDForTwitterID(twitterID));
	}

	public ScoreResponse scoreForTwScreenName(String twitterScreenName)
			throws Klout4JavaException {
		return score(kloutIDForTwScreenName(twitterScreenName));
	}

	public ScoreResponse scoreForGooglePID(String googlePID)
			throws Klout4JavaException {
		return score(kloutIDForGooglePID(googlePID));
	}

	public List<TopicItem> topicsForTwID(String twitterID)
			throws Klout4JavaException {
		return topics(kloutIDForTwitterID(twitterID));
	}

	public List<TopicItem> topicsForTwScreenName(String twitterScreenName)
			throws Klout4JavaException {
		return topics(kloutIDForTwScreenName(twitterScreenName));
	}

	public List<TopicItem> topicsForGooglePID(String googlePID)
			throws Klout4JavaException {
		return topics(kloutIDForGooglePID(googlePID));
	}

	public InfluenceResponse influenceForTwID(String twitterID)
			throws Klout4JavaException {
		return influence(kloutIDForTwitterID(twitterID));
	}

	public InfluenceResponse influenceForTwScreenName(String twitterScreenName)
			throws Klout4JavaException {
		return influence(kloutIDForTwScreenName(twitterScreenName));
	}

	public InfluenceResponse influenceForGooglePID(String googlePID)
			throws Klout4JavaException {
		return influence(kloutIDForGooglePID(googlePID));
	}
}
