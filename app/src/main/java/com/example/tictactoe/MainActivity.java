package com.example.tictactoe;

import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button[][] buttons = new Button[3][3];

    private boolean player1Turn = true;

    private int count;

    private int player1Points;
    private int player2Points;

    private TextView textViewPlayer1;
    private TextView textViewPlayer2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textViewPlayer1 = findViewById(R.id.p1);
        textViewPlayer2 = findViewById(R.id.p2);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
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
if(((Button)v ).getText().toString().equalsIgnoreCase("RESET"))
{
    resetBoard1();
}
            }
        });

    }

    @Override
    public void onClick(View v) {
        if (!((Button) v).getText().toString().equals("")) {
            return;
        }


        if (player1Turn) {
            ((Button) v).setText("X");
        } else {
            ((Button) v).setText("O");
        }

        count++;

        if (checkForWin()) {
            if (player1Turn) {
                player1Wins();
            } else {
                player2Wins();
            }
        } else if (count == 9) {
            draw();
        } else {
            player1Turn = !player1Turn;
        }

    }

    private boolean checkForWin() {
        String[][] field = new String[3][3];
        String m=null;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = buttons[i][j].getText().toString();
            }
        }
tl:
{
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (field[i][j].equals(field[0][0]) && !field[0][0].equals("")) {


                if (field[0][1].equals(field[i][j]) && !field[0][1].equals("")) {

                    if (field[0][2].equals(field[i][j]) && !field[0][2].equals("")) {
                        //wins!
                        m = field[i][j];
                        break tl;
                    }
                }


                if (field[1][0].equals(field[i][j]) && !field[1][0].equals("")) {

                    if (field[2][0].equals(field[i][j]) && !field[2][0].equals("")) {
                        //wins!
                        m = field[i][j];
                        break tl;
                    }
                }


                if (field[1][1].equals(field[i][j]) && !field[1][1].equals("")) {

                    if (field[2][2].equals(field[i][j]) && !field[2][2].equals("")) {
                        //wins
                        m = field[i][j];
                        break tl;
                    }
                }

        }

            if (field[i][j].equals(field[2][2]) && !field[2][2].equals("")) {


                    if (field[1][2].equals(field[i][j]) && !field[1][2].equals("")) {
                        if (field[0][2].equals(field[i][j]) && !field[0][2].equals("")) {
                            //wins
                            m = field[i][j];
                            break tl;
                        }
                    }



                    if (field[2][1].equals(field[i][j]) && !field[2][1].equals("")) {
                        if (field[2][0].equals(field[i][j]) && !field[2][0].equals("")) {
                            //wins
                            m = field[i][j];
                            break tl;
                        }
                    }




                    if (field[1][1].equals(field[i][j]) && !field[1][1].equals("")) {
                        if (field[0][0].equals(field[i][j]) && !field[0][0].equals("")) {
                            //wins
                            m = field[i][j];
                            break tl;
                        }
                    }

            }

            if (field[i][j].equals(field[2][0]) && !field[2][0].equals("")) {


                    if (field[1][0].equals(field[i][j]) && !field[1][0].equals("")) {
                        if (field[0][0].equals(field[i][j]) && !field[0][0].equals("")) {
                            //wins
                            m = field[i][j];
                            break tl;
                        }
                    }




                    if (field[2][1].equals(field[i][j]) && !field[2][1].equals("")) {
                        if (field[2][2].equals(field[i][j]) && !field[2][2].equals("")) {
                            //wins
                            m = field[i][j];
                            break tl;
                        }
                    }




                    if (field[1][1].equals(field[i][j]) && !field[1][1].equals("")) {
                        if (field[0][2].equals(field[i][j]) && !field[0][2].equals("")) {
                            //wins
                            m = field[i][j];
                            break tl;
                        }
                    }

            }

            if (field[i][j].equals(field[0][2]) && !field[0][2].equals("")) {


                    if (field[1][2].equals(field[i][j]) && !field[1][2].equals(""))

                    {
                        if (field[2][2].equals(field[i][j]) && !field[2][2].equals("")) {
                            //wins
                            m = field[i][j];
                            break tl;
                        }
                    }



                    if (field[0][1].equals(field[i][j]) && !field[0][1].equals("")) {
                        if (field[0][0].equals(field[i][j]) && !field[0][0].equals("")) {
                            //wins
                            m = field[i][j];
                            break tl;
                        }
                    }



                    if (field[1][1].equals(field[i][j]) && !field[1][1].equals("")) {
                        if (field[2][0].equals(field[i][j]) && !field[2][0].equals("")) {
                            //wins
                            m = field[i][j];
                            break tl;
                        }
                    }

            }

            if (field[i][j].equals(field[1][1]) && !field[1][1].equals("")) {


                    if (field[0][0].equals(field[i][j]) && !field[0][0].equals("")) {
                        if (field[2][2].equals(field[i][j]) && !field[2][2].equals("")) {
                            //wins
                            m = field[i][j];
                            break tl;
                        }
                    }




                    if (field[1][0].equals(field[i][j]) && !field[1][0].equals("")) {
                        if (field[1][2].equals(field[i][j]) && !field[1][2].equals("")) {
                            //wins
                            m = field[i][j];
                            break tl;
                        }
                    }




                    if (field[2][0].equals(field[i][j]) && !field[2][0].equals("")) {
                        if (field[0][2].equals(field[i][j]) && !field[0][2].equals("")) {
                            //wins
                            m = field[i][j];
                            break tl;
                        }
                    }




                    if (field[2][1].equals(field[i][j]) && !field[2][1].equals("")) {
                        if (field[0][1].equals(field[i][j]) && !field[0][1].equals("")) {
                            //wins
                            m = field[i][j];
                            break tl;
                        }
                    }

            }

            if (field[i][j].equals(field[1][0]) && !field[1][0].equals("")) {


                    if (field[0][0].equals(field[i][j]) && !field[0][0].equals("")) {
                        if (field[2][0].equals(field[i][j]) && !field[2][0].equals("")) {
                            //wins
                            m = field[i][j];
                            break tl;
                        }
                    }




                    if (field[1][1].equals(field[i][j]) && !field[1][1].equals("")) {
                        if (field[1][2].equals(field[i][j]) && !field[1][2].equals("")) {
                            //wins
                            m = field[i][j];
                            break tl;
                        }
                    }

            }

            if (field[i][j].equals(field[0][1]) && !field[0][1].equals("")) {


                    if (field[0][0].equals(field[i][j]) && !field[0][0].equals("")) {
                        if (field[0][2].equals(field[i][j]) && !field[0][2].equals("")) {
                            //wins
                            m = field[i][j];
                            break tl;
                        }
                    }



                    if (field[1][1].equals(field[i][j]) && !field[1][1].equals("")) {
                        if (field[2][1].equals(field[i][j]) && !field[2][1].equals("")) {
                            //wins
                            m = field[i][j];
                            break tl;
                        }
                    }


            }

            if (field[i][j].equals(field[1][2]) && !field[1][2].equals("")) {


                    if (field[2][2].equals(field[i][j]) && !field[2][2].equals("")) {
                        if (field[0][2].equals(field[i][j]) && !field[0][2].equals("")) {
                            //wins
                            m = field[i][j];
                            break tl;
                        }
                    }




                    if (field[1][1].equals(field[i][j]) && !field[1][1].equals("")) {
                        if (field[1][0].equals(field[i][j]) && !field[1][0].equals("")) {
                            //wins
                            m = field[i][j];
                            break tl;
                        }
                    }

            }

            if (field[i][j].equals(field[2][1]) && !field[2][1].equals("")) {


                    if (field[2][2].equals(field[i][j]) && !field[2][2].equals("")) {
                        if (field[2][0].equals(field[i][j]) && !field[2][0].equals("")) {
                            //wins
                            m = field[i][j];
                            break tl;
                        }
                    }




                    if (field[1][1].equals(field[i][j]) && !field[1][1].equals("")) {
                        if (field[0][1].equals(field[i][j]) && !field[0][1].equals("")) {
                            //wins
                            m = field[i][j];
                            break tl;
                        }
                    }


            }

        }
    }
}

if(m=="X" || m=="O" && m!=null)
    return true;

else
    return false;



    }

    private void player1Wins() {
        player1Points++;
        Toast.makeText(this, "Player 1 wins!", Toast.LENGTH_SHORT).show();
        updatePointsText();
        resetBoard();
    }

    private void player2Wins() {
        player2Points++;
        Toast.makeText(this, "Player 2 wins!", Toast.LENGTH_SHORT).show();
        updatePointsText();
        resetBoard();
    }

    private void draw() {
        Toast.makeText(this, "Draw!", Toast.LENGTH_SHORT).show();
        resetBoard();
    }

    private void updatePointsText() {
        textViewPlayer1.setText("Player 1: " + player1Points);
        textViewPlayer2.setText("Player 2: " + player2Points);
    }

    private void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
        count=0;
        player1Turn = true;


    }
    private void resetBoard1() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
                player1Points=0;
                player2Points=0;
                textViewPlayer1.setText("Player 1:"+player1Points);
                textViewPlayer2.setText("Player 2:"+player2Points);

            }
        }



    }

}


















