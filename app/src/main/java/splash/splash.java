package splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.kotchaphanmuangsan.kinnaid.login;
import com.example.kotchaphanmuangsan.kinnaid.R;
import android.os.Handler;
import android.util.Log;

/**
 * Created by Kotchaphan Muangsan on 07-Nov-14.
 */
public class splash extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        final Intent i = new Intent(splash.this , login.class);

       // Log.i("Test" , "Test");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                overridePendingTransition(android.R.anim.fade_in , android.R.anim.fade_out);
                startActivity(i);
                finish(); //kill activity
            }
        }, 2000);  // 2 second
    }
}
