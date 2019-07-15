package com.polotechnologies.alc40phase1;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.polotechnologies.alc40phase1.database.ALCPhase1DatabaseContract.UserInformationEntry;
import static com.polotechnologies.alc40phase1.contentProvider.ALCPhase1ContentProviderContract.UserProfile;

public class ProfileActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>{

    private int LOADER_USER_PROFILE = 1;

    private ImageView userPicture;
    private TextView userName;
    private TextView userTrack;
    private TextView userCountry;
    private TextView userEmail;
    private TextView userPhoneNumber;
    private TextView userSlackUsername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initViews();
        getLoaderManager().initLoader(LOADER_USER_PROFILE, null, this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getLoaderManager().restartLoader(LOADER_USER_PROFILE, null, this);
    }

    private void initViews() {
        userPicture = findViewById(R.id.userPicture);
        userName = findViewById(R.id.userName);
        userTrack = findViewById(R.id.textView_track);
        userCountry = findViewById(R.id.textView_country);
        userEmail = findViewById(R.id.textView_email);
        userPhoneNumber = findViewById(R.id.textView_phone_number);
        userSlackUsername = findViewById(R.id.textView_slack_username);
    }

    private void displayUserProfile(Cursor data) {
        int profilePictureIndexPos = data.getColumnIndex(UserInformationEntry.COLUMN_PROFILE_PICTURE);
        int profileNameIndexPos = data.getColumnIndex(UserInformationEntry.COLUMN_NAME);
        int profileTrackIndexPos = data.getColumnIndex(UserInformationEntry.COLUMN_TRACK);
        int profileCountryIndexPos = data.getColumnIndex(UserInformationEntry.COLUMN_COUNTRY);
        int profileEmailAddressIndexPos = data.getColumnIndex(UserInformationEntry.COLUMN_EMAIL_ADDRESS);
        int profilePhoneNumberIndexPos = data.getColumnIndex(UserInformationEntry.COLUMN_PHONE_NUMBER);
        int profileSlackUsernameIndexPos = data.getColumnIndex(UserInformationEntry.COLUMN_SLACK_USERNAME);

        data.moveToNext();
        int profileImage = data.getInt(profilePictureIndexPos);

        userPicture.setImageDrawable(getDrawable(profileImage));
        userName.setText(data.getString(profileNameIndexPos));
        userTrack.setText(data.getString(profileTrackIndexPos));
        userCountry.setText(data.getString(profileCountryIndexPos));
        userEmail.setText(data.getString(profileEmailAddressIndexPos));
        userPhoneNumber.setText(data.getString(profilePhoneNumberIndexPos));
        userSlackUsername.setText(data.getString(profileSlackUsernameIndexPos));
    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        CursorLoader loader = null;
        if (id == LOADER_USER_PROFILE) {
            loader = createProfileLoader();
        }
        return loader;
    }
    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        if (loader.getId() == LOADER_USER_PROFILE) {
            loadUserProfile(data);
        }

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    private CursorLoader createProfileLoader() {
        Uri uri =UserProfile.CONTENT_URI;

        final String[] profileColumns = {
                UserProfile.COLUMN_PROFILE_PICTURE,
                UserProfile.COLUMN_NAME,
                UserProfile.COLUMN_TRACK,
                UserProfile.COLUMN_COUNTRY,
                UserProfile.COLUMN_EMAIL_ADDRESS,
                UserProfile.COLUMN_PHONE_NUMBER,
                UserProfile.COLUMN_SLACK_USERNAME,

        };

        return new CursorLoader(this, uri, profileColumns, null, null,
                UserProfile.COLUMN_NAME);

    }

    private void loadUserProfile(Cursor data) {
        displayUserProfile(data);
    }


}
