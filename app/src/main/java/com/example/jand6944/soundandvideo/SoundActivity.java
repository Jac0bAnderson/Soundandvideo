package com.example.jand6944.soundandvideo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;
import android.view.View;
import android.content.Intent;
import android.media.MediaPlayer;


public class SoundActivity extends AppCompatActivity {
    private Button soundHome;
    private Button playButton;
    private Button pauseButton;
    private Button stopButton;
    private SeekBar soundSeekBar;
    private Thread soundThread;
    private MediaPlayer soundPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound);

        soundHome =(Button) findViewById(R.id.soundHome);
        playButton = (Button) findViewById(R.id.playButton);
        pauseButton =(Button) findViewById(R.id.pauseButton);
        stopButton =(Button) findViewById(R.id.stopButton);
        soundSeekBar =(SeekBar) findViewById(R.id.soundSeekBar);
        soundPlayer = MediaPlayer.create(this.getBaseContext(),R.raw.eraser);


        setupListeners();

        soundThread = new Thread(this);
        soundThread.start();
    }

    private void setupListeners()
    {
        soundHome.setOnClickListener(new View.OnClickListener()
        {
           @Override
        public void onClick(View currentView)
           {
               Intent returnIntent = new Intent();
               setResult(RESULT_OK, returnIntent);
               finish();
           }

        });

        playButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
        public void onClick(View v)
            {
                soundPlayer.start();
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener()
        {
           @Override
        public void onClick(View v)
           {
               soundPlayer.pause();
           }

        });

        stopButton.setOnClickListener(new View.OnClickListener()
        {
                                 @Override
        public void onClick(View currentView)
                                 {
                                     soundPlayer.stop();
                                     soundPlayer = MediaPlayer.create(getBaseContext(),R.raw.eraser);
                                 }

                                      });

        soundSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStartTackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onProgressChanel(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    soundPlayer.seekTo(progress);
                }
            }


        });



    }
@Override
public void run()
{
    int currentPostition =0;
    int soundTotal = soundPlayer.getDuration();
    soundSeekBar.setMax(soundTotal);

    while(soundPlayer !=null && currentPostition < soundTotal)
    {
        try
        {
            Thread.sleep(300);
            currentPostition = soundPlayer.getCurrentPosition();
        }
        catch(InterruptedException soundException)
        {
            return;
        }
        catch (Exception otherException)
        {
            return;
        }
        soundSeekBar.setProgress(currentPostition);
    }


}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sound, menu);
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
