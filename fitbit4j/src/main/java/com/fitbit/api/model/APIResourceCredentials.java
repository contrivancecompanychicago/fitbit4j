package com.fitbit.api.model;

public class APIResourceCredentials {
    String tempToken;
    String tempTokenSecret;
    /**
     * From http://tools.ietf.org/html/draft-hammer-oauth-10#section-2.2:
     *
     * [During authorization,] to make sure that the resource owner granting access is the same resource owner
     * returning back to the client to complete the process, the server MUST generate a verification code: an
     * unguessable value passed to the client via the resource owner and REQUIRED to complete the process.
     */
    String tempTokenVerifier;
    String accessToken;
    String refreshToken;
    String scope;
    String tokenType = "bearer";
    String resourceId;
    int expiresIn;

    String resourceURL;
    String localUserId;

    public APIResourceCredentials(String localUserId, String tempToken, String tempTokenSecret) {
        this.localUserId = localUserId;
        this.tempToken = tempToken;
        this.tempTokenSecret = tempTokenSecret;
    }

    public String getTempToken() {
        return tempToken;
    }

    public void setTempToken(String tempToken) {
        this.tempToken = tempToken;
    }

    public String getTempTokenSecret() {
        return tempTokenSecret;
    }

    public void setTempTokenSecret(String tempTokenSecret) {
        this.tempTokenSecret = tempTokenSecret;
    }

    public String getTempTokenVerifier() {
        return tempTokenVerifier;
    }

    public void setTempTokenVerifier(String tempTokenVerifier) {
        this.tempTokenVerifier = tempTokenVerifier;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
    
    /**
     * @deprecated use getRefreshToken instead
     * @return 
     */
    public String getAccessTokenSecret() {
        return getRefreshToken();
    }
    
    /**
     * @deprecated use setRefreshToken instead
     * @param refreshToken 
     */
    public void setAccessTokenSecret(String refreshToken) {
        setRefreshToken(refreshToken);
    }
    
    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }
    
    public String getLocalUserId() {
        return localUserId;
    }

    public void setLocalUserId(String localUserId) {
        this.localUserId = localUserId;
    }

    public String getResourceURL() {
        return resourceURL;
    }

    public void setResourceURL(String resourceURL) {
        this.resourceURL = resourceURL;
    }

    public boolean isAuthorized() {
        return accessToken != null;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }
}