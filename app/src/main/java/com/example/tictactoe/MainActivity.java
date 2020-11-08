package com.example.tictactoe;

import android.util.Log;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.TicTacToe;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button[][] buttons = new Button[3][3];
    private boolean player1Turn = true;
    private int count=0;
    private int player1Points;
    private int player2Points;
    private TextView textViewPlayer1;
    private TextView textViewPlayer2;
    TicTacToe obj=new TicTacToe();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewPlayer1 = findViewById(R.id.p1);
        textViewPlayer2 = findViewById(R.id.p2);
        count=0;


        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons.length; j++) {
                String buttonID = "b" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(this);
            }
        }

        final Button reset = findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(((Button)v ).getText().toString().equalsIgnoreCase("RESET")) {
                resetBoardOnUsersRequest();
            }
            }
        });

    }

    @Override
    public void onClick(View v) {

        if (!((Button) v).getText().toString().equals("")) {
            return;
        }

        String tag= (String) v.getTag();
        int x=Integer.parseInt(String.valueOf(tag.charAt(0)));
        int y=Integer.parseInt(String.valueOf(tag.charAt(1)));
        if(player1Turn){
            ((Button) v).setText("X");
            obj.set('X',x,y);
        }
        else{
            ((Button) v).setText("O");
            obj.set('O',x,y);
        }

        count++;

        if (obj.didWin()){
            if (player1Turn){
                player1Wins();
            }
            else{
                player2Wins();
            }
        }
        else if (count == 9) {
            draw();
        }
        else {
            player1Turn = !player1Turn;
        }

    }

    private void player1Wins() {
        player1Points++;
        Toast.makeText(this, "Player 1 wins!", Toast.LENGTH_SHORT).show();
        updatePointsText();
        obj.resetBoardArr();
        resetBoard();
    }

    private void player2Wins() {
        player2Points++;
        Toast.makeText(this, "Player 2 wins!", Toast.LENGTH_SHORT).show();
        updatePointsText();
        obj.resetBoardArr();
        resetBoard();
    }

    private void draw() {
        obj.resetBoardArr();
        Toast.makeText(this, "Draw!", Toast.LENGTH_SHORT).show();
        resetBoard();
    }

    private void updatePointsText() {
        textViewPlayer1.setText("Player 1: " + player1Points);
        textViewPlayer2.setText("Player 2: " + player2Points);
    }

    private void resetBoard() {
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons.length; j++) {
                buttons[i][j].setText("");
            }
        }
        count=0;
        player1Turn = true;
    }

    private void resetBoardOnUsersRequest() {
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons.length; j++) {
                buttons[i][j].setText("");
                count=0;
                player1Points=0;
                player2Points=0;
                textViewPlayer1.setText("Player 1:"+player1Points);
                textViewPlayer2.setText("Player 2:"+player2Points);

            }
        }
    }

}