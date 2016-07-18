/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fitbit.api.client.oauth;

import com.github.scribejava.core.builder.api.DefaultApi20;
import com.github.scribejava.core.model.AbstractRequest;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthConfig;
import com.github.scribejava.core.model.OAuthConstants;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.github.scribejava.core.services.Base64Encoder;
import com.github.scribejava.core.services.DatatypeConverterEncoder;


/**
 *
 * @author nilsding
 */
public class FitbitOAuthService extends OAuth20Service {

    public FitbitOAuthService(DefaultApi20 api, OAuthConfig config) {
        super(api, config);
    }

    @Override
    public void signRequest(OAuth2AccessToken accessToken, AbstractRequest request) {
        request.addHeader("Authorization", "Bearer " + accessToken.getAccessToken());
    }

    @Override
    protected <T extends AbstractRequest> T createRefreshTokenRequest(String refreshToken, T request) {
        if (refreshToken == null || refreshToken.isEmpty()) {
            throw new IllegalArgumentException("The refreshToken cannot be null or empty");
        }
        final Base64Encoder enc = new DatatypeConverterEncoder();
        final OAuthConfig config = getConfig();
        request.addParameter("grant_type", "refresh_token");
        request.addParameter("refresh_token", refreshToken);
        request.addParameter("expires_in", "28800");
        request.addHeader("Authorization", "Basic " + enc.encode(String.format("%s:%s", config.getApiKey(), config.getApiSecret()).getBytes()));
        return request;
    }

}
