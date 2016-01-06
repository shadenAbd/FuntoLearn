package com.example.shaden.funtolearn;

import android.media.Image;
import android.widget.ImageView;

import java.io.Serializable;

/**
 * Created by Shaden on 1/6/2016.
 */
public class Letters implements Serializable {
    char letter;
    int image;
    int sound;

    public Letters(char l, int i, int s)
    {
        letter= l;
        image= i;
        sound=s;
    }
    public Letters() {
        letter = 'a';
        image = 0;
        sound = 0;
    }
}
