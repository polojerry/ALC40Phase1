package com.polotechnologies.alc40phase1.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.polotechnologies.alc40phase1.database.ALCPhase1DatabaseContract.UserInformationEntry;

public class ALCPhase1OpenHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "alc_phase_1.db";
    private static final int DATABASE_VERSION = 1;

    public ALCPhase1OpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UserInformationEntry.SQL_CREATE_TABLE);

        DatabaseWorker mDbWorker = new DatabaseWorker(db);
        mDbWorker.insertUserProfile();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
