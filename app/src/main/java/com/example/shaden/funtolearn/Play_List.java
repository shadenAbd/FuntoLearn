package com.example.shaden.funtolearn;

import android.content.res.AssetFileDescriptor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import java.util.concurrent.TimeUnit;

/**
 * Created by Shaden on 1/5/2016.
 */
public class Play_List extends AppCompatActivity {
    private Button b1,b2,b3,b4,next;
    ImageView [] image_view;
    private double startTime = 0;
    private double finalTime = 0;
    private Handler myHandler = new Handler();;
    private int forwardTime = 5000;
    private int backwardTime = 5000;
    private SeekBar seekbar;
    private TextView tx1,tx2,tx3;

    private static final Integer[] images_id = {R.id.imageView,R.id.imageView1,R.id.imageView3,R.id.imageView4,
            R.id.imageView5,R.id.imageView6,
            R.id.imageView7};

    public static int oneTimeOnly = 0;
    MediaPlayer mediaPlayer;
    int current_index = 0;
    final int[] myMusic = {R.raw.sound1, R.raw.sound2, R.raw.sound3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_list);
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);
        next=(Button)findViewById(R.id.next);

        image_view=new ImageView[7];

        tx1=(TextView)findViewById(R.id.textView2);
        tx2=(TextView)findViewById(R.id.textView3);
        tx3=(TextView)findViewById(R.id.textView4);
        tx3.setText("Old Macdonald");

        mediaPlayer = MediaPlayer.create(getApplicationContext(), myMusic[0]);

        for (int i = 0; i < 7; i++) {
            //int constant = images_id[i];
            image_view[i] = (ImageView) findViewById(images_id[i]);
            image_view[i].setVisibility(View.INVISIBLE);
        }
//Animation
        final Animation an= AnimationUtils.loadAnimation(getBaseContext(), R.anim.abc_fade_in);
        an.setDuration(3000);

        for (int i = 0; i < 7; i++) {

            image_view[i].setVisibility(View.VISIBLE);
            image_view[i].startAnimation(an);
        }

        /*mediaPlayer.setOnCompletionListener(new  MediaPlayer.OnCompletionListener() {
            public  void  onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), myMusic[1]);
                tx1.setText("00:00");
                tx2.setText("00:00");
                seekbar.setProgress(0);
                b2.setEnabled(true);
                mediaPlayer.start();
            }

        });*/

          next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tx3.getText()== "Old Macdonald") {
                    mediaPlayer.release(); // release any previously played / held resources
                    tx1.setText("");
                    tx2.setText("");
                    tx3.setText("ABC");
                    seekbar.setProgress(0);
                    b2.setEnabled(true);
                    mediaPlayer = MediaPlayer.create(Play_List.this, myMusic[1]);
                    mediaPlayer.start();
                }
                else if(tx3.getText()== "ABC") {
                    mediaPlayer.release(); // release any previously played / held resources
                    tx1.setText("");
                    tx2.setText("");
                    tx3.setText("Numbers 123");
                    seekbar.setProgress(0);
                    b2.setEnabled(true);
                    mediaPlayer = MediaPlayer.create(Play_List.this, myMusic[2]);
                    mediaPlayer.start();
                }
                else {
                    mediaPlayer.release(); // release any previously played / held resources
                    tx1.setText("");
                    tx2.setText("");
                    tx3.setText("Old Macdonald");
                    seekbar.setProgress(0);
                    b2.setEnabled(true);
                    mediaPlayer = MediaPlayer.create(Play_List.this, myMusic[0]);
                    mediaPlayer.start();
                }

                }

        });

        seekbar=(SeekBar)findViewById(R.id.seekBar);
        seekbar.setClickable(false);
        b2.setEnabled(false);

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Playing sound",Toast.LENGTH_SHORT).show();
                mediaPlayer.start();

                finalTime = mediaPlayer.getDuration();
                startTime = mediaPlayer.getCurrentPosition();

                if (oneTimeOnly == 0) {
                    seekbar.setMax((int) finalTime);
                    oneTimeOnly = 1;
                }
                tx2.setText(String.format("%d min, %d sec",
                                TimeUnit.MILLISECONDS.toMinutes((long) finalTime),
                                TimeUnit.MILLISECONDS.toSeconds((long) finalTime) -
                                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) finalTime)))
                );

                tx1.setText(String.format("%d min, %d sec",
                                TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                                TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) startTime)))
                );

                seekbar.setProgress((int)startTime);
                myHandler.postDelayed(UpdateSongTime,100);
                b2.setEnabled(true);
                b3.setEnabled(false);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Pausing sound",Toast.LENGTH_SHORT).show();
                mediaPlayer.pause();
                b2.setEnabled(false);
                b3.setEnabled(true);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = (int)startTime;

                if((temp+forwardTime)<=finalTime){
                    startTime = startTime + forwardTime;
                    mediaPlayer.seekTo((int) startTime);
                    Toast.makeText(getApplicationContext(),"You have Jumped forward 5 seconds",Toast.LENGTH_SHORT).show();
                }
                else{

                    Toast.makeText(getApplicationContext(),"Cannot jump forward 5 seconds",Toast.LENGTH_SHORT).show();
                }
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = (int)startTime;

                if((temp-backwardTime)>0){
                    startTime = startTime - backwardTime;
                    mediaPlayer.seekTo((int) startTime);
                    Toast.makeText(getApplicationContext(),"You have Jumped backward 5 seconds",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Cannot jump backward 5 seconds",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }






    private Runnable UpdateSongTime = new Runnable() {
        public void run() {
            startTime = mediaPlayer.getCurrentPosition();
            tx1.setText(String.format("%d min, %d sec",

                            TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                            TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                            toMinutes((long) startTime)))
            );
            seekbar.setProgress((int)startTime);
            myHandler.postDelayed(this, 100);
        }
    };



}




