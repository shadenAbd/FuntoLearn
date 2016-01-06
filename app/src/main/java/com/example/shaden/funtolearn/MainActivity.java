package com.example.shaden.funtolearn;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.io.Serializable;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    ImageView [] imageViews;
    GridLayout gridLayout;
    int constant;
    //int resource=0;

    private static final Integer[] Imgid = {R.id.i_1,R.id.i_2,R.id.i_3,R.id.i_4,R.id.i_5,R.id.i_6,
            R.id.i_7,R.id.i_8,R.id.i_9,R.id.i_10,R.id.i_11,R.id.i_12,
            R.id.i_13,R.id.i_14,R.id.i_15,R.id.i_16,R.id.i_17,R.id.i_18,
            R.id.i_19,R.id.i_20,R.id.i_21,R.id.i_22,R.id.i_23,R.id.i_24,
            R.id.i_25,R.id.i_26};
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=(Button)findViewById(R.id.music);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread timerThread = new Thread() {
                    public void run() {
                        try {
                            sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            Intent intent = new Intent(MainActivity.this, Play_List.class);
                            startActivity(intent);
                        }
                    }
                };
                timerThread.start();


            }
        });

        imageViews = new ImageView[26];
        gridLayout = (GridLayout) findViewById(R.id.gridLayout);

        for (int i = 0; i < 26; i++) {
             constant = Imgid[i];
            imageViews[i] = (ImageView) findViewById(Imgid[i]);
        }

        imageViews[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Letters l = new Letters('a', 0, 0);
                Intent in = new Intent(MainActivity.this, Next_Activity.class);
                in.putExtra("letter", (Serializable)l);
                startActivity(in);
                /*Thread timerThread = new Thread(){
                    public void run(){
                        try{
                            sleep(100);
                        }catch(InterruptedException e){
                            e.printStackTrace();
                        }finally{
                            Intent in = new Intent(MainActivity.this, Next_Activity.class);
                            in.putExtra("letter", (Serializable)l);
                            startActivity(in);
                        }
                    }
                };
                timerThread.start();*/

            }
        });

        imageViews[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Letters l1 = new Letters('b', 1, 1);
                Intent intent1 = new Intent(MainActivity.this, Next_Activity.class);
                intent1.putExtra("letter", (Serializable)l1);
                startActivity(intent1);

            }
        });

        imageViews[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Letters l = new Letters('c', 2, 2);
            }
        });

        imageViews[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Letters l = new Letters('d', 3, 3);
            }
        });

        imageViews[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Letters l = new Letters('e', 4, 4);
            }
        });

        imageViews[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Letters l = new Letters('f', 5, 5);
            }
        });

        imageViews[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Letters l = new Letters('g', 6, 6);
            }
        });

        imageViews[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Letters l = new Letters('h', 7, 7);
            }
        });

        imageViews[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Letters l = new Letters('i', 8, 8);
            }
        });

        imageViews[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Letters l = new Letters('j', 9, 9);
            }
        });

        imageViews[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Letters l = new Letters('k', 10, 10);
            }
        });

        imageViews[11].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Letters l = new Letters('l', 11, 11);
            }
        });

        imageViews[12].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Letters l = new Letters('m', 12, 12);
            }
        });

        imageViews[13].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Letters l = new Letters('n', 13, 13);
            }
        });

        imageViews[14].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Letters l = new Letters('o', 14, 14);
            }
        });

        imageViews[15].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Letters l = new Letters('p', 15, 15);
            }
        });

        imageViews[16].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Letters l = new Letters('q', 16, 16);
            }
        });
        imageViews[17].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Letters l = new Letters('r', 17, 17);
            }
        });

        imageViews[18].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Letters l = new Letters('s', 18, 18);
            }
        });

        imageViews[19].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Letters l = new Letters('t', 19, 19);
            }
        });

        imageViews[20].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Letters l = new Letters('u', 20, 20);
            }
        });

        imageViews[21].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Letters l = new Letters('v', 21, 21);
            }
        });

        imageViews[22].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Letters l = new Letters('w', 22, 22);
            }
        });

        imageViews[23].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Letters l = new Letters('x', 23, 23);
            }
        });

        imageViews[24].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Letters l = new Letters('y', 24, 24);
            }
        });

        imageViews[25].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Letters l = new Letters('z', 25, 25);
            }
        });

       /* for (int i = 0; i < 26; i++) {
            imageViews[i].setOnClickListener(new View.OnClickListener() {
             @Override
              public void onClick(View v) {

                 //Toast.makeText(getApplicationContext(), "clicked "+constant, Toast.LENGTH_SHORT).show();

                 Thread timerThread = new Thread() {
                     public void run() {
                         try {
                             sleep(100);
                         } catch (InterruptedException e) {
                             e.printStackTrace();
                         } finally {
                         Intent intent = new Intent(MainActivity.this, Next_Activity.class);
                         intent.putExtra("image_number", constant);

                             startActivity(intent);
                         }
                     }
                 };
                 timerThread.start();

                 }
              }
            );
        }*/

    }


    }




