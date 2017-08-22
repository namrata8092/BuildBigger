package com.nds.gradle.master.buildbigger.free;

import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.nds.gradle.master.buildbigger.free.EndpointsAsyncTask;
import com.nds.gradle.master.buildbigger.R;
import com.nds.jokesandroidlibrary.DisplayUtil;
import com.nds.jokeslibrary.ManualJoke;
import com.nds.jokeslibrary.WizardJoke;

/**
 * Created by Namrata Shah on 7/25/2017.
 */
public class MainActivity extends AppCompatActivity {
    private AdView mAdView;
    private Button mDisplayManualJoke;
    private Button mDisplayWizardJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Test","onCreate of free activity");
        MobileAds.initialize(getApplicationContext(),"ca-app-pub-4040673918923224~1497867780");
        String android_id = Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID);
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(android_id)
                .build();
        mAdView.loadAd(adRequest);
        mDisplayManualJoke = (Button)findViewById(R.id.manualJoke);
        mDisplayManualJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ManualJoke wizardJoke = new ManualJoke();
//                DisplayUtil.displayJoke(wizardJoke.tellJoke(), getApplicationContext());

                ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressbar);
                new EndpointsAsyncTask(getApplicationContext(), progressBar).execute();
            }
        });

        mDisplayWizardJoke = (Button)findViewById(R.id.wizardJoke);
        mDisplayWizardJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WizardJoke wizardJoke = new WizardJoke();
                DisplayUtil.displayJoke(wizardJoke.tellWizardJoke(), getApplicationContext());
            }
        });
    }
}
