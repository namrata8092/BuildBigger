package com.nds.gradle.master.buildbigger.free;

import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.nds.gradle.master.buildbigger.R;
import com.nds.jokesandroidlibrary.DisplayUtil;
import com.nds.jokeslibrary.WizardJoke;

/**
 * Created by Namrata Shah on 7/25/2017.
 */
public class MainActivity extends AppCompatActivity {
    private Button mDisplayManualJoke;
    private Button mDisplayWizardJoke;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(getApplicationContext(),this.getString(R.string.app_id));

        mInterstitialAd = new InterstitialAd(getApplicationContext());
        mInterstitialAd.setAdUnitId(this.getString(R.string.interstitial_ad_unit_id));

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                loadAdvert();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                super.onAdFailedToLoad(errorCode);
                fetchJokeFromLibrary();
            }

            @Override
            public void onAdClosed() {
                fetchJokeFromLibrary();
            }
        });


/*fetch joke from bakend system*/
        mDisplayManualJoke = (Button)findViewById(R.id.manualJoke);
        mDisplayManualJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInterstitial();

            }
        });

        /*fetch joke from java library system*/
        mDisplayWizardJoke = (Button)findViewById(R.id.wizardJoke);
        mDisplayWizardJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WizardJoke wizardJoke = new WizardJoke();
                DisplayUtil.displayJoke(wizardJoke.tellWizardJoke(), getApplicationContext());
            }
        });
    }

    private void loadAdvert() {
        if (!mInterstitialAd.isLoading() && !mInterstitialAd.isLoaded()) {
            AdRequest adRequest = new AdRequest.Builder().build();
            mInterstitialAd.loadAd(adRequest);
        }

    }

    private void showInterstitial() {
        if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Toast.makeText(getApplicationContext(), "Ad did not load", Toast.LENGTH_SHORT).show();
            loadAdvert();
        }
    }

    private void fetchJokeFromLibrary(){
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressbar);
        new EndpointsAsyncTask(getApplicationContext(), progressBar).execute();
    }

}
