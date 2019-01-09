package ca.cpthriftshop.logintest;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import static com.facebook.FacebookSdk.*;

public class MainActivity extends AppCompatActivity {

        LoginButton loginButton;
        TextView textView;
        CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        loginButton = (LoginButton)findViewById(R.id.login_button);
        textView = (TextView)findViewById(R.id.textView);
        callbackManager = CallbackManager.Factory.create();

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                String appUserId = loginResult.getAccessToken().getUserId();
                String appToken = loginResult.getAccessToken().getToken();

                Intent intent = new Intent(MainActivity.this, StartActivity.class);
                intent.putExtra("a",appUserId);
                intent.putExtra("b",appToken);

                startActivity(intent);
            }

            @Override
            public void onCancel() {
                textView.setText("Login Cancelled");
            }

            @Override
            public void onError(FacebookException error) {
                textView.setText("Login Error");

            }


        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        callbackManager.onActivityResult(requestCode,resultCode,data);
    }
}
