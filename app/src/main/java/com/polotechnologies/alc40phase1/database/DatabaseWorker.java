package com.polotechnologies.alc40phase1.database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.polotechnologies.alc40phase1.R;

import static com.polotechnologies.alc40phase1.database.ALCPhase1DatabaseContract.UserInformationEntry;

public class DatabaseWorker {

    private SQLiteDatabase mDb;

    public DatabaseWorker(SQLiteDatabase db) {
        mDb = db;
    }

    public void insertUserProfile(){
        ContentValues contentValues = new ContentValues();

        contentValues.put(UserInformationEntry.COLUMN_PROFILE_PICTURE, R.drawable.jeremiah_polo_profile_picture);
        contentValues.put(UserInformationEntry.COLUMN_NAME,"Jeremiah Polo");
        contentValues.put(UserInformationEntry.COLUMN_TRACK, "Android");
        contentValues.put(UserInformationEntry.COLUMN_COUNTRY,"Kenya");
        contentValues.put(UserInformationEntry.COLUMN_EMAIL_ADDRESS, "polojerry4@gmail.com");
        contentValues.put(UserInformationEntry.COLUMN_PHONE_NUMBER,"254790689212");
        contentValues.put(UserInformationEntry.COLUMN_SLACK_USERNAME,"@jeremiahpolo");

        mDb.insert(UserInformationEntry.TABLE_NAME,null,contentValues);

    }
}
