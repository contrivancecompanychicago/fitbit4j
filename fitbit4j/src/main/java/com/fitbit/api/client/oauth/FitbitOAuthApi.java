/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fitbit.api.client.oauth;

import com.github.scribejava.core.builder.api.DefaultApi20;
import com.github.scribejava.core.model.OAuthConfig;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;

/**
 * OAuth 2 API for Fitbit.
 *
 * @see <a href="https://dev.fitbit.com/docs/oauth2/">Fitbit API</a>
 * @author nilsding
 */
public class FitbitOAuthApi extends DefaultApi20 {

    public static final String API_BASE_URL = "https://api.fitbit.com";
    public static final String SITE_BASE_URL = "https://www.fitbit.com";

    protected FitbitOAuthApi() {
    }

    private static class InstanceHolder {

        private static final FitbitOAuthApi INSTANCE = new FitbitOAuthApi();
    }

    public static FitbitOAuthApi instance() {
        return InstanceHolder.INSTANCE;
    }

    @Override
    public Verb getAccessTokenVerb() {
        return Verb.POST;
    }

    @Override
    public String getAccessTokenEndpoint() {
        return API_BASE_URL + "/oauth2/token";
    }

    @Override
    protected String getAuthorizationBaseUrl() {
        return SITE_BASE_URL + "/oauth2/authorize";
    }

    @Override
    public OAuth20Service createService(OAuthConfig config) {
        return new FitbitOAuthService(this, config);
    }
}
