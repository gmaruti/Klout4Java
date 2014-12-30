Java wrapper for Klout Partner API

Added some utility methods along with 8 API methods. Below are the list of methods

API Methods (Identity and User methods)
   
   kloutIDForTwitterID(String twitterID)
   kloutIDForGooglePID(String googlePID)
   kloutIDForTwScreenName(String twScreenName)
   twIDForKloutID(String kloutID)
   showUser(String kloutID)
   score(String kloutID)
   topics(String kloutID)
   influence(String kloutID)
 
Utility Methods: All User methods require klout ID. These utility calls combines Identity methods and User methods.

   showUserForTwID(String twitterID) : gets Klout ID for given twitterID and invokes showUser for that Klout ID
   showUserForTwScreenName(String twitterScreenName)
   showUserForGooglePID(String googlePID)
   scoreForTwID(String twitterID)
   scoreForTwScreenName(String twitterScreenName)
   scoreForGooglePID(String googlePID)
   topicsForTwID(String twitterID)
   topicsForTwScreenName(String twitterScreenName)
   topicsForGooglePID(String googlePID)
   influenceForTwID(String twitterID)
   influenceForTwScreenName(String twitterScreenName)
   influenceForGooglePID(String googlePID)

Sample
                // set config. 
                KloutConfig config = new KloutConfig();
                //set API Key
                config.setApiKey("");
                //Proxy info need be set to this if behind firewall
                //config.setSetProxy(true);
                //config.setProxyHost("");
                //config.setProxyPort("");

                Klout4Java klout = new Klout4Java();
                klout.setConfig(config);
                try {
                        String kloutID = klout.kloutIDForTwitterID("500042487");
                        System.out.println(kloutID);
                } catch (Klout4JavaException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }

Refer http://klout.com/s/developers/home and http://klout.com/s/developers/v2 for licensing, rate limits and API keys.

Refer class Klout4JavaTest for code samples.