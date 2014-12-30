package com.klout4java;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.klout4java.vo.InfluenceResponse;
import com.klout4java.vo.KloutIdentityResponse;
import com.klout4java.vo.KloutUser;
import com.klout4java.vo.ScoreResponse;
import com.klout4java.vo.TopicItem;

public class KloutInvoker {

	public static Map<String, Class> responseMap = new HashMap<String, Class>();
	private KloutConfig config;
	private Map<String, String> errorMessages = new HashMap<String, String>() {
		{
			put(
					"400",
					"Parameter check failed - indicates that a required "
							+ "parameter is missing or a parameter has a value that is out of bounds. ");
			put("403", "Unauthorized");
			put("404", "Resource Not Found");
			put("500", "Unexpected internal error");
			put("503", "Service Unavailable");
			put("504", "Service Unavailable");
		}
	};

	public KloutInvoker() {
		responseMap.put("idSearch", KloutIdentityResponse.class);
		responseMap.put("showUser", KloutUser.class);
		responseMap.put("score", ScoreResponse.class);
		responseMap.put("influence", InfluenceResponse.class);
	}

	public KloutConfig getConfig() {
		return config;
	}

	public void setConfig(KloutConfig config) {
		this.config = config;
	}

	public Object fetchData(String urlStr, String resource)
			throws Klout4JavaException {
		if (config.isSetProxy()) {
			System.setProperty("http.proxyHost", config.getProxyHost());
			System.setProperty("http.proxyPort", config.getProxyPort());
		}

        //-------below code is modified to accept proxy username and password.
        if(config.isSetPassword()){
                Authenticator.setDefault(
                                new Authenticator() {
                                        public PasswordAuthentication getPasswordAuthentication() {
                                                return new PasswordAuthentication(
                                                                config.getProxyUser(), config.getProxyPassword().toCharArray());
                                        }
                                }
                                );
                System.setProperty("http.proxyUser", config.getProxyUser());
                System.setProperty("http.proxyPassword", config.getProxyPassword());
        }
        //-------End of Modification

		URL url = null;

		urlStr += urlStr.contains("?") ? "&" : "?";
		//System.out.println(urlStr + config.getApiKeyStr());
		try {
			url = new URL(urlStr + config.getApiKeyStr());
		} catch (java.net.MalformedURLException e) {
			e.printStackTrace();
			throw new Klout4JavaException(e.getMessage(), e);
		}

		HttpURLConnection conn = null;
		String json = "";
		try {
			conn = (HttpURLConnection) url.openConnection();

			if (conn.getResponseCode() != 200) {
//				System.out.println("Failed to get profile detail for \""
//						+ urlStr  + config.getApiKeyStr() + "\", HTTP status: " + conn.getResponseCode() + " "
//						+ conn.getResponseMessage());
				String message = errorMessages.get(conn.getResponseCode());
				if (message == null) {
					message = "Unknown error occured";
				}
				String rateLimitLimit = conn
						.getHeaderField("X-APIKey-Quota-Allotted");
				String rateLimitLimitRemaining = conn
						.getHeaderField("X-APIKey-Quota-Current");
				String rateLimitLimitReset = conn
						.getHeaderField("X-RateLimit-Reset");
				String errorMessage = conn
						.getHeaderField("X-Mashery-Error-Code");
				message += "X-RateLimit-Limit=" + rateLimitLimit
						+ " X-RateLimit-Remaining=" + rateLimitLimitRemaining
						+ " X-RateLimit-Reset=" + rateLimitLimitReset;
				Klout4JavaException e = new Klout4JavaException(message);
				if ("ERR_403_DEVELOPER_OVER_RATE".equals(errorMessage))
					e.setRateLimitError(true);
				throw e;
			}

			InputStream obj = (InputStream) conn.getContent();

			BufferedReader br = new BufferedReader(new InputStreamReader(obj));
			String str = "";

			while ((str = br.readLine()) != null) {
				json += str;
			}
		} catch (java.io.IOException e) {
			//e.printStackTrace();
			throw new Klout4JavaException(e.getMessage(), e);
		}
		// System.out.println(json);
		Gson gson = new Gson();
		if ("topics".equalsIgnoreCase(resource))
			return gson.fromJson(json.trim(), new TypeToken<List<TopicItem>>() {
			}.getType());
		return gson.fromJson(json.trim(), responseMap.get(resource));
	}
}
