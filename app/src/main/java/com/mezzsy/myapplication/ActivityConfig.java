package com.mezzsy.myapplication;

import com.mezzsy.myapplication.hello.HelloActivity;
import com.mezzsy.myapplication.zcommon.BaseActivity;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author mezzsy
 * @date 2019-12-07
 */
@SuppressWarnings("ALL")
public final class ActivityConfig {
    public static final HashMap<String, Class<? extends BaseActivity>> ACTIVITY_MAP = new LinkedHashMap<>();

    static {
        ACTIVITY_MAP.put("0.hello", HelloActivity.class);
    }
}
