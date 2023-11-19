package poly.DuAn1.nhom2.MD18309.PRO1121;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

@SuppressLint("CustomSplashScreen")
public class splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        Runnable goToLogin = () -> {
            Intent gotoLogin = new Intent(splashscreen.this, login_screen.class);
            startActivity(gotoLogin);
            finish();
        };
        new Handler().postDelayed(goToLogin, 2500);
    }
}