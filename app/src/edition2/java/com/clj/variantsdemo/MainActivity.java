package com.clj.variantsdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_1).setOnClickListener(this);
        findViewById(R.id.btn_2).setOnClickListener(this);

        differentAction();
    }

    private void differentAction() {
        Toast.makeText(this, "this is APP2", 5000).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1:
                startActivity(new Intent(MainActivity.this, PublicActivity1.class));
                break;

            case R.id.btn_2:
                startActivity(new Intent(MainActivity.this, PublicActivity1.class));
                break;
        }
    }
}
