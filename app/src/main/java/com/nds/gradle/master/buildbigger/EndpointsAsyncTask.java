package com.nds.gradle.master.buildbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.nds.buildbigger.backend.jokeApi.JokeApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.nds.jokesandroidlibrary.DisplayJokeActivity;

import java.io.IOException;

/**
 * Created by Namrata on 8/9/2017.
 */

public class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static JokeApi myApiService = null;
    private Context mContext;
    private String mResult;
    private ProgressBar mProgressBar;

    public EndpointsAsyncTask(Context context, ProgressBar progressBar) {
        this.mContext = context;
        this.mProgressBar = progressBar;
    }

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if(myApiService == null) {
            String endpointUrl = mContext != null ? mContext.getString(R.string.endpoint_url) : "http://nanodegree-164817.appspot.com/_ah/api/";
            JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl(endpointUrl)
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            myApiService = builder.build();
        }

        try {
            return myApiService.getManualJoke().execute().getManualJoke();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (mProgressBar != null) {
            mProgressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if (mProgressBar != null) {
            mProgressBar.setVisibility(View.GONE);
        }
        mResult = result;
        startJokeDisplayActivity();
    }

    private void startJokeDisplayActivity() {
        if(mContext!=null){
            Intent intent = new Intent(mContext, DisplayJokeActivity.class);
            intent.putExtra(DisplayJokeActivity.JOKE_KEY, mResult);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mContext.startActivity(intent);
        }
    }
}