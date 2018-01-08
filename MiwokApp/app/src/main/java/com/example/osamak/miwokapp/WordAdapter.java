package com.example.osamak.miwokapp;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by osamak on 8/25/17.
 */

public class WordAdapter extends ArrayAdapter {

    private MediaPlayer mediaPlayer;
    private ArrayList<Word> words;
    private int backgroundColor;

    public WordAdapter(@NonNull Context context, ArrayList<Word> words, int backgroundColor) {
        super(context, 0, words);
        this.words = words;
        this.backgroundColor = backgroundColor;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view;

        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.list_items, parent, false);
        } else {
            view = convertView;
        }

        final Word word = words.get(position);

        ImageView ivMainImage = view.findViewById(R.id.main_image);
        TextView tvDefaultTranslation = view.findViewById(R.id.default_text_view);
        TextView tvMiwokTranslation = view.findViewById(R.id.miwok_text_view);
        final ImageView ivAudioIcon = view.findViewById(R.id.audio_icon);

        if (word.getmImageResources() != 0) {
            ivMainImage.setImageResource(word.getmImageResources());
        } else {
            ivMainImage.setVisibility(View.GONE);
        }

        tvDefaultTranslation.setText(String.valueOf(word.getmDefaultTranslation()));
        tvMiwokTranslation.setText(String.valueOf(word.getmMiwokTranslation()));


        View container = view.findViewById(R.id.container);
        int color = ContextCompat.getColor(getContext(), backgroundColor);
        container.setBackgroundColor(color);

        ivAudioIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(getContext(), word.getmAudioResources());
                mediaPlayer.start();
                ivAudioIcon.setImageResource(android.R.drawable.ic_media_pause);
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        ivAudioIcon.setImageResource(android.R.drawable.ic_media_play);
                        mediaPlayer.release();
                    }
                });
            }
        });
        return view;
    }
}
