package hack.sport.sporthealthandroidapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.google.gson.Gson;

import java.util.ArrayList;

import hack.sport.sporthealthandroidapp.models.MetricsModel;
import hack.sport.sporthealthandroidapp.models.UserDetailsModel;
import hack.sport.sporthealthandroidapp.utils.Utils;

/**
 * Created by Abhishek Kumar on 1/2/2016.
 */
public class DbHelper extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "healthApp.db";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TableUser.SQL_CREATE_USER_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(TableUser.SQL_DELETE_USER_ENTRIES);
        onCreate(db);
    }

    public void insertCustomerDetails(UserDetailsModel userDetailsModel){
        SQLiteDatabase db = this.getWritableDatabase();
        Gson gson = new Gson();
        ContentValues contentValues = new ContentValues();
        contentValues.put("userToken", userDetailsModel.getUserToken());
        contentValues.put("googleUserId", userDetailsModel.getGoogleUserId());
        contentValues.put("serverAuthCode", userDetailsModel.getServerAuthCode());
        contentValues.put("emailID", userDetailsModel.getEmailID());
        contentValues.put("userName", userDetailsModel.getUserName());
        contentValues.put("DOB", userDetailsModel.getDOB());
        contentValues.put("diseases", gson.toJson(userDetailsModel.getDiseases()));
        contentValues.put("location", gson.toJson(userDetailsModel.getLocation()));
        contentValues.put("goals", userDetailsModel.getGoals());
        contentValues.put("term_accpeptance", true);
        contentValues.put("height", gson.toJson(userDetailsModel.getHeight()));
        contentValues.put("weight", gson.toJson(userDetailsModel.getWeight()));
        contentValues.put("imageUrl", userDetailsModel.getImageUrl());

        db.insert(TableUser.TABLE_NAME, null, contentValues);
        db.close();
    }

    /**
     *
     * @return  ArrayList<FavouriteCategory> containing arrayList of all favourite category in ASC order
     */
    public UserDetailsModel getUserDetails(){
        SQLiteDatabase db = this.getReadableDatabase();
        UserDetailsModel userDetailsModel = new UserDetailsModel();

        Cursor cursor = db.query(
                TableUser.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );

        if(cursor.getCount() > 0) {
            cursor.moveToFirst();
            Gson gson = new Gson();
            userDetailsModel.setUserToken(cursor.getString(cursor.getColumnIndex("userToken")));
            userDetailsModel.setUserName(cursor.getString(cursor.getColumnIndex("userName")));
            userDetailsModel.setServerAuthCode(cursor.getString(cursor.getColumnIndex("serverAuthCode")));
            userDetailsModel.setGoogleUserId(cursor.getString(cursor.getColumnIndex("googleUserId")));
            userDetailsModel.setDiseases(gson.fromJson(cursor.getString(cursor.getColumnIndex("diseases")), ArrayList.class));
            userDetailsModel.setDOB(cursor.getString(cursor.getColumnIndex("DOB")));
            userDetailsModel.setEmailID(cursor.getString(cursor.getColumnIndex("emailID")));
            userDetailsModel.setHeight(gson.fromJson(cursor.getString(cursor.getColumnIndex("height")), MetricsModel.class));
            userDetailsModel.setWeight(gson.fromJson(cursor.getString(cursor.getColumnIndex("weight")), MetricsModel.class));
            userDetailsModel.setImageUrl(cursor.getString(cursor.getColumnIndex("imageUrl")));
        }
        cursor.close();
        db.close();
        return userDetailsModel;
    }
    /**
     *
     * @param tableName tableName to find nRows
     * @return no of rows in the given table
     */
    public int getTableRowsCount(String tableName){
        SQLiteDatabase db = this.getWritableDatabase();
        Long nRows = DatabaseUtils.queryNumEntries(db, tableName);
        return nRows.intValue();
    }
}

