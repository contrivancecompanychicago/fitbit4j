/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nilsding.util;

import com.fitbit.api.FitbitAPIException;
import com.fitbit.api.client.oauth.FitbitOAuthApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.oauth.OAuth20Service;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author nilsding
 */
public class Utils {

    public static OAuth20Service buildOAuthInstance(String clientId, String clientSecret) {
        return new ServiceBuilder()
                .apiKey(clientId)
                .apiSecret(clientSecret)
                .scope("profile activity")
                .build(FitbitOAuthApi.instance());
    }

    public static JSONObject toJsonObject(Response res) throws FitbitAPIException, JSONException {
        String responseBody = null;
        try {
            responseBody = res.getBody();
        } catch (IOException e) {
            throw new FitbitAPIException("Failed to read response body", e);
        }
        
        return Utils.toJsonObject(responseBody);
    }

    public static JSONObject toJsonObject(String s) throws JSONException {
        return new JSONObject(s);
    }

    public static JSONArray toJsonArray(Response res) throws FitbitAPIException, JSONException {
        String responseBody = null;
        try {
            responseBody = res.getBody();
        } catch (IOException e) {
            throw new FitbitAPIException("Failed to read response body", e);
        }
        
        return Utils.toJsonArray(responseBody);
    }

    public static JSONArray toJsonArray(String s) throws JSONException {
        return new JSONArray(s);
    }
}
