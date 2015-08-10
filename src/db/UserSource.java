package db;

import android.R.bool;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.sql.SQLException;

public class UserSource {
	SQLiteDatabase db;
	Context context;
	private String[] allUser = { UserHelper.USERID, UserHelper.USERNAME,
			UserHelper.PASSWORD };
	UserHelper dbHelper; // class

	public UserSource(Context _context) {
		context = _context;
		// call constructure UserHelper
		dbHelper = new UserHelper(_context);

	}

	public void open() { // open DB
		db = dbHelper.getWritableDatabase();
		Log.i("Test Souce", "Test Souce");
	}

	public void close() {
		db.close();
	}

	public User insertUser(User user) {
		ContentValues content = new ContentValues();
		content.put(UserHelper.USERNAME, user.getUser());
		content.put(UserHelper.PASSWORD, user.getPass());

		long userID = db.insert(UserHelper.TABLE_USER, null, content);

		Cursor cursor = db.query(UserHelper.TABLE_USER, allUser,
				UserHelper.USERID + " = " + userID, null, null, null, null);

		cursor.moveToFirst();
		return cursorToUser(cursor);

	}

	public boolean getUserName(String user) {
		Cursor cursor = db.query(UserHelper.TABLE_USER, null,
				UserHelper.USERNAME + " = ?", new String[] { user }, null,
				null, null);

		boolean chk = false;

		try {
			if (cursor.getCount() < 1) {
				chk = true;
				cursor.close();
			} else {
				chk = false;
			}
			cursor.moveToFirst();
			cursor.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return chk;
		}

	}

	public String getPassword(String userName) {
		Cursor cursor = db.query(UserHelper.TABLE_USER, null,
				UserHelper.USERNAME + " = ?", new String[] { userName }, null,
				null, null);

		if (cursor.getCount() < 1) {
			cursor.close();
			return "NOT EXIST";
		}
		cursor.moveToFirst();
		// à»ÃÕÂº password
		String pass = cursor.getString(cursor
				.getColumnIndex(UserHelper.PASSWORD));
		String id = cursor.getString(cursor.getColumnIndex(UserHelper.USERID));
		cursor.close();
		return pass + "," + id;
	}

	// Cursor point to User
	@SuppressWarnings("finally")
	private User cursorToUser(Cursor cursor) {
		User user = new User();
		try {
			user.setId(cursor.getLong(cursor.getColumnIndex(UserHelper.USERID)));
			user.setUser(cursor.getString(cursor
					.getColumnIndex(UserHelper.USERNAME)));
			user.setPass(cursor.getString(cursor
					.getColumnIndex(UserHelper.PASSWORD)));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return user;
		}
	}
}
