package com.wix.reactnativenotifications.core;

import android.os.Bundle;
import android.util.Log;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

public class JsIOHelper {
    public boolean sendEventToJS(String eventName, Bundle data, ReactContext reactContext) {
        if (reactContext != null) {
            if (!data.toString().contains("com.facebook.login.LoginClient") && !data.toString().contains("https://m.facebook.com/v4.0/dialog/oauth/confirm/") && !data.toString().contains("https://m.facebook.com/v3.3/dialog/oauth/confirm/")) {
                Log.i("ReactNativeNotifs", data.toString());
                sendEventToJS(eventName, Arguments.fromBundle(data), reactContext);
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean sendEventToJS(String eventName, WritableMap data, ReactContext reactContext) {
        if (reactContext != null) {
            reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class).emit(eventName, data);
            return true;
        }
        return false;
    }
}
