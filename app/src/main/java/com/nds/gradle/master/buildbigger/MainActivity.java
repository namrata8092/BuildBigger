package com.nds.gradle.master.buildbigger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.nds.jokesandroidlibrary.DisplayUtil;
import com.nds.jokeslibrary.ManualJoke;
import com.nds.jokeslibrary.WizardJoke;

/**
 * Created by Namrata Shah on 7/25/2017.
 */
public class MainActivity extends AppCompatActivity {
    private Button mDisplayManualJoke;
    private Button mDisplayWizardJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDisplayManualJoke = (Button)findViewById(R.id.manualJoke);
        mDisplayManualJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressbar);
                new EndpointsAsyncTask(getApplicationContext(), progressBar).execute();
//                ManualJoke wizardJoke = new ManualJoke();
//                DisplayUtil.displayJoke(wizardJoke.tellJoke(), getApplicationContext());
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
