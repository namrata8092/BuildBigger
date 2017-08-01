package com.nds.gradle.master.buildbigger.free;

import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.nds.gradle.master.buildbigger.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.nds.jokeslibrary.WizardJoke;

/**
 * Created by Namrata Shah on 7/25/2017.
 */
public class MainActivity extends AppCompatActivity {
    private AdView mAdView;
    private Button mDisplayJokeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        MobileAds.initialize(getApplicationContext(),"ca-app-pub-4040673918923224~1497867780");
        String android_id = Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID);
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(android_id)
                .build();
        mAdView.loadAd(adRequest);
        mDisplayJokeButton = (Button)findViewById(R.id.displayJoke);
        mDisplayJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WizardJoke wizardJoke = new WizardJoke();
                Toast.makeText(getApplicationContext(), "Free joke "+wizardJoke.tellWizardJoke(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
