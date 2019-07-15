package com.polotechnologies.alc40phase1.contentProvider;

import android.net.Uri;
import android.provider.BaseColumns;

public class ALCPhase1ContentProviderContract {

    public static String AUTHORITY = "com.polotechnologies.alc40phase1.provider";
    public static Uri AUTHORITY_URI = Uri.parse("content://" + AUTHORITY);

    private ALCPhase1ContentProviderContract(){

    }

    protected interface UserProfileColumns{
        String COLUMN_PROFILE_PICTURE="user_profile_picture";
        String COLUMN_NAME = "user_profile_name";
        String COLUMN_TRACK="user_track";
        String COLUMN_COUNTRY = "user_country";
        String COLUMN_EMAIL_ADDRESS="user_email_address";
        String COLUMN_PHONE_NUMBER = "user_phone_number";
        String COLUMN_SLACK_USERNAME = "user_slack_username";
    }

    public static class UserProfile implements BaseColumns,UserProfileColumns{

        static String PATH = "user_profile";
        public static Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI,PATH);
    }

}
