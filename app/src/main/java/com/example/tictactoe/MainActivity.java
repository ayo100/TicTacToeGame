package com.example.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToBoardActivity(View view) {
        String player = "";

        if (view.getId() == R.id.player_x) {
            player = "X";
        } else if (view.getId() == R.id.player_o) {
            player = "O";
        }

        Intent intent = new Intent(this, BoardActivity.class);
        intent.putExtra("player", player);
        startActivity(intent);
    }
}