package me.nim.hello;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Toast.makeText(this, "hey", Toast.LENGTH_LONG);

    }

    public void onAClicked(View view) {
        Intent intent = new Intent(MainActivity.this, CoordinatorActivity.class);
        startActivity(intent);
    }

    public void onBClicked(View view) {
        Intent intent = new Intent(MainActivity.this, RecyclerActivity.class);
        startActivity(intent);
    }

    public void onCClicked(View view) {
        Intent intent = new Intent(MainActivity.this, CoordinatorActivity.class);
        startActivity(intent);
    }
}
