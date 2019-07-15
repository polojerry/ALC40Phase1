package com.polotechnologies.alc40phase1.database;

import android.provider.BaseColumns;

public class ALCPhase1DatabaseContract {
    private ALCPhase1DatabaseContract() {
    }

    public static final class UserInformationEntry implements BaseColumns {

        public static final String TABLE_NAME = "user_profile";

        public static final String COLUMN_PROFILE_PICTURE="user_profile_picture";
        public static final String COLUMN_NAME = "user_profile_name";
        public static final String COLUMN_TRACK="user_track";
        public static final String COLUMN_COUNTRY = "user_country";
        public static final String COLUMN_EMAIL_ADDRESS="user_email_address";
        public static final String COLUMN_PHONE_NUMBER = "user_phone_number";
        public static final String COLUMN_SLACK_USERNAME = "user_slack_username";


        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_PROFILE_PICTURE + " INTEGER NOT NULL, " +
                        COLUMN_NAME + " TEXT NOT NULL, " +
                        COLUMN_TRACK + " TEXT NOT NULL, " +
                        COLUMN_COUNTRY + " TEXT NOT NULL, " +
                        COLUMN_EMAIL_ADDRESS + " TEXT UNIQUE NOT NULL, " +
                        COLUMN_PHONE_NUMBER + " TEXT UNIQUE NOT NULL, " +
                        COLUMN_SLACK_USERNAME +" TEXT UNIQUE NOT NULL)";

    }
}
