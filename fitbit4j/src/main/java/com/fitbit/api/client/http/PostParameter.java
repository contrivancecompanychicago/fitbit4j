/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fitbit.api.client.http;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author nilsding
 */
public class PostParameter implements Serializable, Comparable {

    private String key;
    private String value;
    
    public static Map<String, String> postParameterArrayToMap(PostParameter[] params) {
        Map<String, String> map = new HashMap<String, String>();
        for (PostParameter param : params) {
            map.put(param.key, param.value);
        }
        return map;
    }
    
    public PostParameter(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public PostParameter(String key, double value) {
        this.key = key;
        this.value = String.valueOf(value);
    }

    public PostParameter(String key, long value) {
        this.key = key;
        this.value = String.valueOf(value);
    }

    public PostParameter(String key, int value) {
        this.key = key;
        this.value = String.valueOf(value);
    }

    /**
     * @deprecated Use <tt>getKey()</tt> instead
     */
    public String getName() {
        return key;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        int result = key.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof PostParameter) {
            PostParameter that = (PostParameter) obj;
            return this.key.equals(that.key) && this.value.equals(that.value);
        }
        return false;
    }

    @Override
    public int compareTo(Object o) {
        int compared;
        PostParameter that = (PostParameter) o;
        compared = key.compareTo(that.key);
        if (0 == compared) {
            compared = value.compareTo(that.value);
        }
        return compared;
    }
}
