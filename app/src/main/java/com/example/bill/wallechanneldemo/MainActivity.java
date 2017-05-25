package com.example.bill.wallechanneldemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.meituan.android.walle.WalleChannelReader;

public class MainActivity extends AppCompatActivity {

    private TextView pkgTestView;
    private TextView environmentTestView;
    private TextView channelTestView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pkgTestView = (TextView) findViewById(R.id.tv_pkg);
        environmentTestView = (TextView) findViewById(R.id.tv_environment);
        channelTestView = (TextView) findViewById(R.id.tv_channel);
        pkgTestView.setText(getAppInfo());
        environmentTestView.setText(getEnvironment());
        channelTestView.setText(getChannel());
    }

    private String getAppInfo() {
        try {
            String pkName = this.getPackageName();
            String versionName = this.getPackageManager().getPackageInfo(pkName, 0).versionName;
            int versionCode = this.getPackageManager().getPackageInfo(pkName, 0).versionCode;
            return pkName + "   " + versionName + "  " + versionCode;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    private String getChannel() {
        String channel = WalleChannelReader.getChannel(getApplicationContext());
        return channel;
    }

    private String getEnvironment() {
        String environment;
        int envType = BuildConfig.ENV_TYPE;
//        int envType = 1;
        if (envType == 2) {
            environment = "Test";
        } else if (envType == 3) {
            environment = "Release";
        } else {
            environment = "Debug";
        }
        return environment;
    }

}
