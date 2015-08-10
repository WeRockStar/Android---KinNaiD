package cs.xml.kinnaid;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import db.User;
import db.UserSource;

public class SignUp extends Activity {

	EditText edtUser, edtPassword, edtConPassword;
	Toast t;
	Button btnSignUp, btnClose;
	UserSource source;
	AlertDialog.Builder alert;
	Typeface tfBoon, tfTPK;
	TextView txtSigup;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup);

		edtUser = (EditText) findViewById(R.id.edtUser);
		edtPassword = (EditText) findViewById(R.id.edtPassword);
		edtConPassword = (EditText) findViewById(R.id.edtConPassword);
		btnSignUp = (Button) findViewById(R.id.btnSignUp);
		btnClose = (Button) findViewById(R.id.btnClose);
		txtSigup = (TextView) findViewById(R.id.txtSig);

		tfTPK = Typeface.createFromAsset(getAssets(), "TPKubua.ttf");
		tfBoon = Typeface.createFromAsset(getAssets(), "boontook.otf");
		btnSignUp.setTypeface(tfBoon);
		txtSigup.setTypeface(tfTPK);

		source = new UserSource(getApplicationContext());
		source.open();
		t = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG);

		btnClose.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(SignUp.this, Login.class);
				startActivity(i);
				overridePendingTransition(android.R.anim.fade_in,
						android.R.anim.fade_out);
				finish();
			}
		});
		btnSignUp.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// User Class
				User user = new User();

				if (edtUser.getText().toString().trim().equals("")
						|| edtPassword.getText().toString().trim().equals("")
						|| edtConPassword.getText().toString().trim()
								.equals("")) {
					t.setText("กรุณาใส่ค่าให้ครบ ห้ามมีช่องว่าง หรือ อักขระพิเศษ และต้องเป็นอักขระภาษาอังกฤษเท่านั้น");
					t.setGravity(Gravity.TOP, 0, 50);
					t.show();

					edtUser.setText("");
					edtPassword.setText("");
					edtConPassword.setText("");

					// return focus
					edtUser.requestFocus();
				} else {
					if ((edtUser.getText().toString().trim().length() >= 4 && edtPassword
							.getText().toString().trim().length() >= 4)
							|| edtPassword
									.getText()
									.toString()
									.trim()
									.equals(edtConPassword.getText().toString()
											.trim())) {
						if (edtPassword
								.getText()
								.toString()
								.trim()
								.equals(edtConPassword.getText().toString()
										.trim())) {// Password Valid
							user.setUser(edtUser.getText().toString());
							user.setPass(edtConPassword.getText().toString());

							// insert to DB
							source.insertUser(user);
							// clear
							edtUser.setText("");
							edtPassword.setText("");
							edtConPassword.setText("");

							alert = new AlertDialog.Builder(SignUp.this);
							alert.setTitle("ลงทะเบียนสำเร็จ");
							alert.setCancelable(false);
							alert.setMessage("กลับไปที่หน้าเข้าสู่ระบบ");
							alert.setPositiveButton("ตกลง",
									new DialogInterface.OnClickListener() {
										@Override
										public void onClick(
												DialogInterface dialog,
												int which) {
											Intent i = new Intent(SignUp.this,
													Login.class);
											startActivity(i);
											overridePendingTransition(
													android.R.anim.fade_in,
													android.R.anim.fade_out);
											finish();
										}
									});

							alert.show();
						}
					} else {
						// Password Invalid
						t.setText("รหัสผ่านเข้ากันไม่ได้");
						t.setGravity(Gravity.TOP, 0, 50);
						t.show();

						edtPassword.setText("");
						edtConPassword.setText("");

						// return focus
						edtPassword.requestFocus();
					}
				}
			}
		});
	}

	@Override
	protected void onStart() {
		super.onStart();
		source.open();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		source.close();

	}

	@Override
	// close keyboard
	public boolean onTouchEvent(MotionEvent event) {
		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
		return true;
	}
}
