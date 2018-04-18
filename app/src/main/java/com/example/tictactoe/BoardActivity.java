package com.example.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class BoardActivity extends AppCompatActivity {

    private String[][] board = new String[3][3];
    private static String EMPTY_STRING = "";
    private String lastPlayer = EMPTY_STRING;
    private static String X = "X";
    private static String O = "O";

    Button button00;
    Button button01;
    Button button02;
    Button button10;
    Button button11;
    Button button12;
    Button button20;
    Button button21;
    Button button22;
    Button resetBoardButton;
    TextView playerXScore;
    TextView playerOScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        button00 = findViewById(R.id.button00);
        button01 = findViewById(R.id.button01);
        button02 = findViewById(R.id.button02);
        button10 = findViewById(R.id.button10);
        button11 = findViewById(R.id.button11);
        button12 = findViewById(R.id.button12);
        button20 = findViewById(R.id.button20);
        button21 = findViewById(R.id.button21);
        button22 = findViewById(R.id.button22);
        resetBoardButton = findViewById(R.id.resetButton);
        playerXScore = findViewById(R.id.player1_score);
        playerOScore = findViewById(R.id.player2_score);

        initializeBoardArray();
        setClickListeners();
    }

    private void initializeBoardArray() {
        board[0][0] = EMPTY_STRING;
        board[0][1] = EMPTY_STRING;
        board[0][2] = EMPTY_STRING;
        board[1][0] = EMPTY_STRING;
        board[1][1] = EMPTY_STRING;
        board[1][2] = EMPTY_STRING;
        board[2][0] = EMPTY_STRING;
        board[2][1] = EMPTY_STRING;
        board[2][2] = EMPTY_STRING;
    }

    public void setClickListeners() {
        resetBoardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }
        });

        button00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setXOrO(button00);
            }
        });

        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setXOrO(button01);
            }
        });

        button02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setXOrO(button02);
            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setXOrO(button10);
            }
        });

        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setXOrO(button11);
            }
        });

        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setXOrO(button12);
            }
        });

        button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setXOrO(button20);
            }
        });

        button21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setXOrO(button21);
            }
        });

        button22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setXOrO(button22);
            }
        });
    }

    public void clearButton() {
        button00.setText(EMPTY_STRING);
        button01.setText(EMPTY_STRING);
        button02.setText(EMPTY_STRING);
        button10.setText(EMPTY_STRING);
        button11.setText(EMPTY_STRING);
        button12.setText(EMPTY_STRING);
        button20.setText(EMPTY_STRING);
        button21.setText(EMPTY_STRING);
        button22.setText(EMPTY_STRING);
    }

    private void setXOrO(Button button) {
        if (button.getText().toString().equals(EMPTY_STRING)) {

            if (lastPlayer.equals(EMPTY_STRING)) {
                String PLAYER = "player";
                button.setText(getIntent().getStringExtra(PLAYER));
                lastPlayer = getIntent().getStringExtra(PLAYER);
            } else if (lastPlayer.equals(X)) {
                button.setText(O);
                lastPlayer = O;
            } else if (lastPlayer.equals(O)) {
                button.setText(X);
                lastPlayer = X;
            }

            setBoardArrayValue(button);
            checkForWinnerAndUpdateScore();
        } else {
            Toast.makeText(this, "This has been filled. Select an empty one.", Toast.LENGTH_SHORT).show();
        }
    }

    private void setBoardArrayValue(Button button) {
        if (button.getId() == R.id.button00) {
            board[0][0] = button.getText().toString();
        } else if (button.getId() == R.id.button01) {
            board[0][1] = button.getText().toString();
        } else if (button.getId() == R.id.button02) {
            board[0][2] = button.getText().toString();
        } else if (button.getId() == R.id.button10) {
            board[1][0] = button.getText().toString();
        } else if (button.getId() == R.id.button11) {
            board[1][1] = button.getText().toString();
        } else if (button.getId() == R.id.button12) {
            board[1][2] = button.getText().toString();
        } else if (button.getId() == R.id.button20) {
            board[2][0] = button.getText().toString();
        } else if (button.getId() == R.id.button21) {
            board[2][1] = button.getText().toString();
        } else if (button.getId() == R.id.button22) {
            board[2][2] = button.getText().toString();
        }
    }

    private void checkForWinnerAndUpdateScore() {
        if (isPlayerWinner(X)) {
            int score = Integer.valueOf(playerXScore.getText().toString());
            playerXScore.setText(String.valueOf(++score));

            Toast.makeText(this, "Player " + X + " has won this round.", Toast.LENGTH_LONG).show();

            resetGame();
        } else if (isPlayerWinner(O)) {
            int score = Integer.valueOf(playerOScore.getText().toString());
            playerOScore.setText(String.valueOf(++score));

            Toast.makeText(this, "Player " + O + " has won this round.", Toast.LENGTH_LONG).show();

            resetGame();
        }
    }

    private void resetGame() {
        clearButton();
        initializeBoardArray();
        lastPlayer = EMPTY_STRING;
    }

    private boolean isPlayerWinner(String player) {
        return board[0][0].equals(player) && board[0][1].equals(player) && board[0][2].equals(player)
                || board[1][0].equals(player) && board[1][1].equals(player) && board[1][2].equals(player)
                || board[2][0].equals(player) && board[2][1].equals(player) && board[2][2].equals(player)
                || board[0][0].equals(player) && board[1][0].equals(player) && board[2][0].equals(player)
                || board[0][1].equals(player) && board[1][1].equals(player) && board[2][1].equals(player)
                || board[0][2].equals(player) && board[1][2].equals(player) && board[2][2].equals(player)
                || board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)
                || board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player);
    }
}