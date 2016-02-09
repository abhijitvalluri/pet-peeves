package com.abhijitvalluri.android.petpeeves;

import java.util.Date;
import java.util.UUID;

/**
 * Crime model for the CriminalIntent app
 */
public class Crime {
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;
    private String mSuspectName;
    private Integer mSuspectID;

    public Crime() {
        this(UUID.randomUUID());
    }

    public Crime(UUID id) {
        mId = id;
        mDate = new Date();
    }

    public String getTitle() {
        return mTitle;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public UUID getId() {
        return mId;
    }

    public String getSuspectName() {
        return mSuspectName;
    }

    public void setSuspect(String suspect, Integer contactID) {
        mSuspectName = suspect;
        mSuspectID = contactID;
    }

    public Integer getSuspectID() {
        return mSuspectID;
    }

    public String getPhotoFilename() {
        return "IMG_" + getId().toString() + ".jpg";
    }
}
