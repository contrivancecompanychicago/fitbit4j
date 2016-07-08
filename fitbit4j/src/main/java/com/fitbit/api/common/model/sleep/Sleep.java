package com.fitbit.api.common.model.sleep;

import com.fitbit.api.FitbitAPIException;
import org.nilsding.util.Utils;
import com.github.scribejava.core.model.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Sleep {

    private SleepSummary summary;

    private List<SleepLog> sleepLogs;

    public Sleep() {
    }

    public Sleep(SleepSummary summary, List<SleepLog> sleepLogs) {
        this.summary = summary;
        this.sleepLogs = sleepLogs;
    }

    public static Sleep constructSleep(Response res) throws FitbitAPIException {
        try {
            SleepSummary summary = new SleepSummary(Utils.toJsonObject(res).getJSONObject("summary"));
            List<SleepLog> sleepLogs = jsonArrayToSleepLogList(Utils.toJsonObject(res).getJSONArray("sleep"));
            return new Sleep(summary, sleepLogs);
         } catch (JSONException e) {
            throw new FitbitAPIException(e.getMessage() + ':' + res.getMessage(), e);
        }
    }

    private static List<SleepLog> jsonArrayToSleepLogList(JSONArray array) throws JSONException {
        List<SleepLog> sleepLogList = new ArrayList<SleepLog>(array.length());
        for (int i = 0; i < array.length(); i++) {
            JSONObject sleepLog = array.getJSONObject(i);
            sleepLogList.add(new SleepLog(sleepLog));
        }
        return sleepLogList;
    }


    public SleepSummary getSummary() {
        return summary;
    }

    public void setSummary(SleepSummary summary) {
        this.summary = summary;
    }

    public List<SleepLog> getSleepLogs() {
        return sleepLogs;
    }

    public void setSleepLogs(List<SleepLog> sleepLogs) {
        this.sleepLogs = sleepLogs;
    }
}
