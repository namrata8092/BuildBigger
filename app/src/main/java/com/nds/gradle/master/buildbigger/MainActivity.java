package com.nds.gradle.master.buildbigger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.nds.jokeslibrary.WizardJoke;

/**
 * Created by Namrata Shah on 7/25/2017.
 */
public class MainActivity extends AppCompatActivity {

    private Button mDisplayJokeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDisplayJokeButton = (Button)findViewById(R.id.displayJoke);
        mDisplayJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WizardJoke wizardJoke = new WizardJoke();
                Toast.makeText(getApplicationContext(), "Paid joke "+wizardJoke.tellWizardJoke(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
