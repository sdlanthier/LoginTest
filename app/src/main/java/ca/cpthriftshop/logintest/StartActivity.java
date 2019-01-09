package ca.cpthriftshop.logintest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class StartActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String sessionId= getIntent().getStringExtra("a");
        setContentView(R.layout.activity_start);

        textView = (TextView)findViewById(R.id.textView2);
        textView.setText(sessionId);

    }

}
