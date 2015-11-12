package com.example.jand6944.soundandvideo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.Button;
import android.view.View;

public class Sound_andVideo extends AppCompatActivity {


    private Button videoButton;
    private Button soundButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_and_video);

        soundButton =(Button) findViewById(R.id.soundButton);
        videoButton =(Button) findViewById(R.id.videoButton);

        setupListeners();
    }
    private void setupListeners()
    {
        //sound screen
        soundButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
        public void onClick(View currentView)
            {
                Intent myIntent = new Intent(currentView.getContext(), SoundActivity.class);
                startActivityForResult(myIntent, 0);
            }


        });

        //videoScreen
        videoButton.setOnClickListener(new View.OnClickListener()
        {
           @Override
        public void onClick(View currentView)
           {
               Intent vIntent = new Intent(currentView.getContext(), VideoActivity.class);
               startActivityForResult(vIntent, 0);
           }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sound_and_video, menu);
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
}
