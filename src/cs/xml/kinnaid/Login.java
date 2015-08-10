package cs.xml.kinnaid;

import java.sql.SQLException;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import db.UserSource;

public class Login extends Activity {

	UserSource user;
	Typeface tfTPK, tfBoon;
	TextView txtAppName;
	Button btnLogin, btnSignUp;
	EditText edtUser, edtPassword;
	Toast t;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		txtAppName = (TextView) findViewById(R.id.txtAppName);
		btnLogin = (Button) findViewById(R.id.btnLogIn);
		btnSignUp = (Button) findViewById(R.id.btnSignUp);
		edtUser = (EditText) findViewById(R.id.edtUser);
		edtPassword = (EditText) findViewById(R.id.edtPassword);
		// font
		tfTPK = Typeface.createFromAsset(getAssets(), "TPKubua.ttf");
		tfBoon = Typeface.createFromAsset(getAssets(), "boontook.otf");
		txtAppName.setTypeface(tfTPK);
		btnLogin.setTypeface(tfBoon);

		t = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG);

		user = new UserSource(getApplicationContext());
		// open User DB
		user.open();

		btnLogin.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Login();
			}
		});
		btnSignUp.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				SignUp(); // call method
			}
		});
	}

	public void SignUp() {
		Intent in = new Intent(Login.this, SignUp.class);
		startActivity(in);
		overridePendingTransition(android.R.anim.fade_in,
				android.R.anim.fade_out);
		finish();
	}

	public void Login() {
		String storePass = user.getPassword(edtUser.getText().toString());
		String arr[] = storePass.split(",");

		if (edtPassword.getText().toString().trim().equals(arr[0])) {
			Intent i = new Intent(Login.this, FoodList.class);
			startActivity(i);
			overridePendingTransition(android.R.anim.fade_in,
					android.R.anim.fade_out);
			edtUser.setText("");
			edtPassword.setText("");
			finish();

		} else {
			t.setText("รหัสผ่านไม่ถูกต้อง");
			t.setGravity(Gravity.TOP, 0, 50);
			t.show();
			edtUser.setText("");
			edtPassword.setText("");
		}
	}

	@Override
	protected void onStart() {
		super.onStart();
		user.open();
	}

	@Override
	protected void onResume() {
		super.onResume();
		user.open();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		user.close();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
		return true;
	}

}
