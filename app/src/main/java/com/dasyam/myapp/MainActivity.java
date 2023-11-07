package com.dasyam.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    String[] BLOAT_APPS = {"com.snapchat.android", "com.facebook.katana",
            "com.spotify.music", "com.osp.app.signin",
            "com.truecaller", "com.eterno", "com.netflix.mediaclient",
            "com.samsung.android.game.gamehome", "com.opera.max.global",
            "com.samsung.android.spay"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hideUselessApps();
    }

    private void hideUselessApps() {
        DevicePolicyManager dpm
                = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);
        ComponentName deviceAdmin
                = new ComponentName(this, MyDeviceAdminReceiver.class);
        for (String bloatApp : BLOAT_APPS) {
            dpm.setApplicationHidden(deviceAdmin, bloatApp, true);
        }

    }
}