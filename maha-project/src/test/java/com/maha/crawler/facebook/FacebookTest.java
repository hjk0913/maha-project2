package com.maha.crawler.facebook;


import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;

public class FacebookTest {

	@Before
	public void setUp() throws Exception {

	}

	@Test 
	public void test() {
		Long st = Calendar.getInstance().getTimeInMillis();
		ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
		registry.addConnectionFactory(new FacebookConnectionFactory("235862589916712", "3bf8c2bc25b31846532609d1ee52b728"));
		String accessToken = "7fe881439d033e383d1500400e219690"; // access token received from Facebook after OAuth authorization
		Facebook facebook = new FacebookTemplate(accessToken);
		FacebookProfile profile = facebook.userOperations().getUserProfile();
		String myid = profile.getId();
		String myname = profile.getName();
		System.out.println("my id is '" + myid + "' and my name is '" + myname + ".");
		System.out.println("============= timestamp : " + (Calendar.getInstance().getTimeInMillis() - st));
		st = Calendar.getInstance().getTimeInMillis();
		List<FacebookProfile> friends = facebook.friendOperations().getFriendProfiles();
		for (FacebookProfile fp : friends) {
			System.out.println("Friend name => " + fp.getName());
		}

		System.out.println("============= timestamp : " + (Calendar.getInstance().getTimeInMillis() - st));

		st = Calendar.getInstance().getTimeInMillis();

		List<String> fids = facebook.friendOperations().getFriendIds();

		for (String id : fids) {
			System.out.println("friend id => " + id);
		}

		System.out.println("============= timestamp : " + (Calendar.getInstance().getTimeInMillis() - st));
		st = Calendar.getInstance().getTimeInMillis();
		/*
		String appId = "235862589916712";
        String appSecret = "3bf8c2bc25b31846532609d1ee52b728";
        String appToken = fetchApplicationAccessToken(appId, appSecret);
        AppDetails appDetails = fetchApplicationData(appId, appToken);
        System.out.println("\n   APPLICATION DETAILS");
        System.out.println("=========================");
        System.out.println("ID:             " + appDetails.getId());
        System.out.println("Name:           " + appDetails.getName());
        System.out.println("Namespace:      " + appDetails.getNamespace());
        System.out.println("Contact Email:  " + appDetails.getContactEmail());
        System.out.println("Website URL:    " + appDetails.getWebsiteUrl());
	}
	
	private static String fetchApplicationAccessToken(String appId, String appSecret) {
        OAuth2Operations oauth = new FacebookConnectionFactory(appId, appSecret).getOAuthOperations();
        return oauth.authenticateClient().getAccessToken();
    } 
	
	private static AppDetails fetchApplicationData(String appId, String appToken) {
        Facebook facebook = new FacebookTemplate(appToken);
        return facebook.restOperations().getForObject("https://graph.facebook.com/{appId}?fields=name,namespace,contact_email,website_url", AppDetails.class, appId);
    }
	
	private static final class AppDetails {
        private long id;

        private String name;
        
        private String namespace;
        
        @JsonProperty("contact_email")
        private String contactEmail;
        
        @JsonProperty("website_url")
        private String websiteUrl;
        
        public long getId() {
            return id;
        }
        public String getName() {
            return name;
        }
        public String getNamespace() {
            return namespace;
        }
        public String getContactEmail() {
            return contactEmail;
        }
        public String getWebsiteUrl() {
            return websiteUrl;
        }
		 */
    }
}
