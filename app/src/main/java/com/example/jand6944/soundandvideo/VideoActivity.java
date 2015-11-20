package com.example.jand6944.soundandvideo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;
import android.widget.VideoView;
import android.widget.MediaController;

public class VideoActivity extends AppCompatActivity {
private Button videoHome;
    private Uri videoLocation;
    private VideoView videoView;
    private MediaController videoDirector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);


        videoView =(VideoView) findViewById(R.id.videoView);
        videoHome =(Button) findViewById(R.id.videoHome);

        videoLocation = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.badrats);
        videoDirector = new MediaController(this);
        setupMedia();
        setupListeners();
    }
   private void setupMedia()
    {
        videoView.setMediaController(videoDirector);
        videoView.setVideoURI(videoLocation);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_video, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void setupListeners()
    {
        videoHome.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View currentView)
            {
                Intent returnIntent = new Intent();
                setResult(RESULT_OK, returnIntent);
                finish();
            }

        });
    }

}
