package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import com.clevertap.android.sdk.CleverTapAPI;
import android.view.View;
import android.widget.Button;

import android.os.Bundle;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Initialize CleverTap
                CleverTapAPI cleverTap = CleverTapAPI.getDefaultInstance(getApplicationContext());
                CleverTapAPI.setDebugLevel(CleverTapAPI.LogLevel.DEBUG);

                // Check if cleverTap is not null before pushing event
                if (cleverTap != null) {
                    // Raise "Product Viewed" event
                    HashMap<String, Object> prodViewedAction = new HashMap<>();
                    prodViewedAction.put("Product Name", "Your Product Name");
                    cleverTap.pushEvent("Product Viewed", prodViewedAction);
                }
            }
        });
    }
}