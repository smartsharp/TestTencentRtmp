package com.test.testtencentrtmp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLivePushConfig;
import com.tencent.rtmp.TXLivePusher;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "zhanghb/MainActivity";
    private Button btnScrnRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnScrnRecord = (Button)findViewById(R.id.btnScrnRecord);
        btnScrnRecord.setOnClickListener(this);

        String sdkver = TXLiveBase.getSDKVersionStr();
        Log.d(TAG, "liteav sdk version is : " + sdkver);
    }

    @Override
    public void onClick(View v) {
        TXLivePusher mLivePusher = new TXLivePusher(this);
        TXLivePushConfig mLivePushConfig = new TXLivePushConfig();
        mLivePusher.setConfig(mLivePushConfig);

        String rtmpUrl = "rtmp://192.168.30.113/live/livestream";
        mLivePusher.startPusher(rtmpUrl);
        mLivePusher.startScreenCapture();
        Log.d(TAG, "start push "+rtmpUrl);
    }
}
