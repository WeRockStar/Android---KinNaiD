package db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.sql.SQLException;

/**
 * Created by Kotchaphan Muangsan on 07-Nov-14.
 */
public class userSource {
    SQLiteDatabase db;
    Context context;
    private  String[] allUser = {userHelper.USERID , userHelper.USERNAME , userHelper.PASSWORD};
    userHelper dbHelper; //class

    public  userSource(Context _context){
        context = _context;
        dbHelper = new userHelper(_context); //call constructure userHelper
        //Log.i("Test Souce", "Test Souce");
    }

    public  void open(){  //open DB
        db = dbHelper.getWritableDatabase();
        Log.i("Test Souce", "Test Souce");
    }

    public  void close(){
        db.close();
    }
}
