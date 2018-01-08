package com.example.osamak.miwokapp;

/**
 * Created by osamak on 8/25/17.
 */

public class Word {

    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResources;
    private int mAudioResources;


    public Word(String mDefaultTranslation, String mMiwokTranslation, int mImageResources, int mAudioResources) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.mImageResources = mImageResources;
        this.mAudioResources = mAudioResources;
    }

    public Word(String mDefaultTranslation, String mMiwokTranslation,int mAudioResources) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.mAudioResources = mAudioResources;
    }

    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getmMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getmImageResources() {
        return mImageResources;
    }

    public int getmAudioResources() {
        return mAudioResources;
    }

}
