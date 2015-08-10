package splash;

import cs.xml.kinnaid.Login;
import cs.xml.kinnaid.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
		final Intent intent = new Intent(Splash.this , Login.class);
		
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				startActivity(intent);
				overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
				finish();
			}
		}, 2000);
	}
}
