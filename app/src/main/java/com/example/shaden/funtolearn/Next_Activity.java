package com.example.shaden.funtolearn;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridLayout;
import android.widget.ImageView;

import java.io.Serializable;

/**
 * Created by Shaden on 1/5/2016.
 */
public class Next_Activity extends AppCompatActivity {

    int sound, image;
    private static final Integer[] images_id = {R.id.image_1,R.id.image_2,R.id.image_3,R.id.image_4,R.id.image_5,R.id.image_6,
            R.id.image_7,R.id.image_8,R.id.image_9,R.id.image_10,R.id.image_11,R.id.image_12,
            R.id.image_13,R.id.image_14,R.id.image_15,R.id.image_16,R.id.image_17,R.id.image_18,
            R.id.i_19,R.id.i_20,R.id.i_21,R.id.i_22,R.id.i_23,R.id.i_24,
            R.id.image_25,R.id.image_26};
    ImageView[] image_Views;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next_activity);

        image_Views = new ImageView[26];


        for (int i = 0; i < 26; i++) {

            image_Views[i] = (ImageView) findViewById(images_id[i]);
        }


        Letters l = new Letters();


        Intent intent = getIntent();
        l= (Letters)(intent.getSerializableExtra("letter"));
        // sound= l.sound

      // String image_id = intent.getStringExtra("image_number");
      // int id = Integer.valueOf(image_id);


    }

}
