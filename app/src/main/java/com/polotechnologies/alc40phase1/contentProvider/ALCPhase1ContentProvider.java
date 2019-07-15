package com.polotechnologies.alc40phase1.contentProvider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.polotechnologies.alc40phase1.database.ALCPhase1OpenHelper;

import static com.polotechnologies.alc40phase1.contentProvider.ALCPhase1ContentProviderContract.AUTHORITY;
import static com.polotechnologies.alc40phase1.contentProvider.ALCPhase1ContentProviderContract.UserProfile;
import static com.polotechnologies.alc40phase1.database.ALCPhase1DatabaseContract.UserInformationEntry;

public class ALCPhase1ContentProvider extends ContentProvider {

    private ALCPhase1OpenHelper mDbOpenHelper;

    private static UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    public static final int USER_PROFILE = 0;

    static{
        sUriMatcher.addURI(AUTHORITY,
                UserProfile.PATH, USER_PROFILE);
    }

    @Override
    public boolean onCreate() {
        mDbOpenHelper = new ALCPhase1OpenHelper(getContext());
        return true;
    }

    
    @Nullable
    @Override
    public Cursor query( @NonNull Uri uri,  @Nullable String[] projection,  @Nullable String selection,  @Nullable String[] selectionArgs,  @Nullable String sortOrder) {
        Cursor cursor = null;
        SQLiteDatabase dB = mDbOpenHelper.getReadableDatabase();

        int uriMatch = sUriMatcher.match(uri);

        if (uriMatch == USER_PROFILE) {
            cursor = dB.query(UserInformationEntry.TABLE_NAME, projection, selection, selectionArgs,
                    null, null, sortOrder);
        }

        return cursor;
    }

    
    @Nullable
    @Override
    public String getType( @NonNull Uri uri) {
        return null;
    }

    
    @Nullable
    @Override
    public Uri insert( @NonNull Uri uri,  @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete( @NonNull Uri uri,  @Nullable String selection,  @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update( @NonNull Uri uri,  @Nullable ContentValues values,  @Nullable String selection,  @Nullable String[] selectionArgs) {
        return 0;
    }
}
