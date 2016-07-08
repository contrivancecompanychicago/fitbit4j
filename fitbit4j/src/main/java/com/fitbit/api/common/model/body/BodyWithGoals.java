package com.fitbit.api.common.model.body;

import com.fitbit.api.FitbitAPIException;
import org.nilsding.util.Utils;
import com.github.scribejava.core.model.Response;
import org.json.JSONException;
import org.json.JSONObject;

public class BodyWithGoals {

    private Body body;
    private BodyGoals bodyGoals;

    public BodyWithGoals(Body body, BodyGoals bodyGoals) {
        this.body = body;
        this.bodyGoals = bodyGoals;
    }

    public static BodyWithGoals constructBodyWithGoals(Response res) throws FitbitAPIException, JSONException {
        Body body = new Body(Utils.toJsonObject(res).getJSONObject("body"));
        JSONObject goalsJson = Utils.toJsonObject(res).optJSONObject("goals");
        BodyGoals bodyGoals = goalsJson != null ? new BodyGoals(goalsJson) : null;
        return new BodyWithGoals(body, bodyGoals);
    }

    public Body getBody() {
        return body;
    }

    public BodyGoals getBodyGoals() {
        return bodyGoals;
    }
}
