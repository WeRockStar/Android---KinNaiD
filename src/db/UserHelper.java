package db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class UserHelper extends SQLiteOpenHelper {

    //db name
    public static final String DATABASE_NAME = "KinNaiD.db";
    public static final int DATABASE_VERSION = 1;

    //User
    public static final String TABLE_USER = "User";
    public static final String USERID = "user_id";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";


    //create table
    private static final String CREATE_USER = "CREATE TABLE IF NOT EXISTS " + TABLE_USER
            + "( " + USERID + " integer primary key autoincrement , "
            + USERNAME + " text(30) not null , "
            + PASSWORD + " text(20) not null );";


    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_USER);
            Log.e("Create DB Complete" , "Create DB Complete");
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.e("Create DB Fail" , "Create DB Fail");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_USER); //upgrade
        onCreate(db);
    }
}
