package com.fitbit.api.model;

import com.fitbit.api.FitbitAPIException;
import org.nilsding.util.Utils;
import com.github.scribejava.core.model.Response;
import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;
import org.json.JSONException;
import org.json.JSONObject;

public class ApiRateLimitStatus {
    int remainingHits;
    int hourlyLimit;
    DateTime resetTime;

    public ApiRateLimitStatus(int remainingHits, int hourlyLimit, DateTime resetTime) {
        this.remainingHits = remainingHits;
        this.hourlyLimit = hourlyLimit;
        this.resetTime = resetTime;
    }

    public ApiRateLimitStatus(Response res) throws FitbitAPIException {
        try {
            JSONObject rateLimitStatus = Utils.toJsonObject(res).getJSONObject("rateLimitStatus");
            remainingHits = rateLimitStatus.getInt("remainingHits");
            hourlyLimit = rateLimitStatus.getInt("hourlyLimit");
            resetTime = ISODateTimeFormat.dateTime().parseDateTime(rateLimitStatus.getString("resetTime"));
         } catch (JSONException e) {
            throw new FitbitAPIException(e.getMessage() + ':' + res.getMessage(), e);
        }
    }
    
    public int getRemainingHits() {
        return remainingHits;
    }

    public int getHourlyLimit() {
        return hourlyLimit;
    }

    public DateTime getResetTime() {
        return resetTime;
    }
}
