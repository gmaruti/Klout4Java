package com.klout4java.test;

import java.util.List;

import com.klout4java.Klout4Java;
import com.klout4java.Klout4JavaException;
import com.klout4java.KloutConfig;
import com.klout4java.vo.InfluenceResponse;
import com.klout4java.vo.KloutUser;
import com.klout4java.vo.ScoreResponse;
import com.klout4java.vo.TopicItem;

public class Klout4JavaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Klout4JavaTest().test();
	}

	public void test(){
		KloutConfig config = new KloutConfig();
		config.setApiKey(""); //set the API key

//		config.setSetProxy(true);
//		config.setProxyHost("");
//		config.setProxyPort("");


		//testKloutIDForTwitterID(config);
		//testKloutIDForGooglePID(config);
		for (int i =0; i <100; i++)
			testKloutIDForTwScreenName(config);
		//testTwIDForKloutID(config);
		//testShowUser(config);
		//testScore(config);
		//testTopics(config);
		//testInfluence(config);

		//testInfluenceForTwitterID(config);
	}

	private void testKloutIDForTwitterID(KloutConfig config){

		Klout4Java klout = new Klout4Java();
		klout.setConfig(config);
		try {
			String kloutID = klout.kloutIDForTwitterID("500042487");
			System.out.println(kloutID);
		} catch (Klout4JavaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void testKloutIDForGooglePID(KloutConfig config){

		Klout4Java klout = new Klout4Java();
		klout.setConfig(config);
		try {
			String kloutID = klout.kloutIDForGooglePID("112620727907435773834");
			System.out.println(kloutID);
		} catch (Klout4JavaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void testKloutIDForTwScreenName(KloutConfig config){

		Klout4Java klout = new Klout4Java();
		klout.setConfig(config);
		try {
			String kloutID = klout.kloutIDForTwScreenName("jtimberlake");
			//System.out.println(kloutID);
		} catch (Klout4JavaException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.isRateLimitError());
			System.out.println(e.getMessage());
			
		}
	}

	private void testTwIDForKloutID(KloutConfig config){

		Klout4Java klout = new Klout4Java();
		klout.setConfig(config);
		try {
			String kloutID = klout.twIDForKloutID("635263");
			System.out.println(kloutID);
		} catch (Klout4JavaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void testShowUser(KloutConfig config){

		Klout4Java klout = new Klout4Java();
		klout.setConfig(config);
		try {
			KloutUser kloutUser = klout.showUser("635263");
			System.out.println(kloutUser.getNick());
			System.out.println(kloutUser.getScore().getScore());
			System.out.println(kloutUser.getScoreDeltas().getDayChange());
		} catch (Klout4JavaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void testScore(KloutConfig config){

		Klout4Java klout = new Klout4Java();
		klout.setConfig(config);
		try {
			ScoreResponse score = klout.score("635263");
			System.out.println(score.getScore());
			System.out.println(score.getBucket());
			System.out.println(score.getScoreDelta().getDayChange());
		} catch (Klout4JavaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void testTopics(KloutConfig config){

		Klout4Java klout = new Klout4Java();
		klout.setConfig(config);
		try {
			List<TopicItem> topics = klout.topics("635263");
			System.out.println(topics.size());
			if (topics.size() > 0) {
				TopicItem topic = topics.get(0);
				System.out.println(topic.getDisplayName());
				System.out.println(topic.getId());
			}
		} catch (Klout4JavaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void testInfluence(KloutConfig config){

		Klout4Java klout = new Klout4Java();
		klout.setConfig(config);
		try {
			InfluenceResponse influences = klout.influence("635263");
			System.out.println(influences.getMyInfluenceesCount());
			System.out.println(influences.getMyInfluencees().get(0).getEntity().getId());
			System.out.println(influences.getMyInfluencees().get(0).getEntity().getPayload().getNick());
			System.out.println(influences.getMyInfluencers().get(0).getEntity().getId());
			System.out.println(influences.getMyInfluencers().get(0).getEntity().getPayload().getNick());
		} catch (Klout4JavaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void testInfluenceForTwitterID(KloutConfig config){

		Klout4Java klout = new Klout4Java();
		klout.setConfig(config);
		try {
			InfluenceResponse influences = klout.influenceForTwID("500042487");
			System.out.println(influences.getMyInfluenceesCount());
			System.out.println(influences.getMyInfluencees().get(0).getEntity().getId());
			System.out.println(influences.getMyInfluencees().get(0).getEntity().getPayload().getNick());
			System.out.println(influences.getMyInfluencers().get(0).getEntity().getId());
			System.out.println(influences.getMyInfluencers().get(0).getEntity().getPayload().getNick());
		} catch (Klout4JavaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
