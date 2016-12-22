package com.example.ashwinachar.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int activePlayer = 0;
    // 0 = x and 1 = o

    boolean gameActive = true;

    int gameState[] = {2,2,2,2,2,2,2,2,2};
    // 2 means unplayed

    int[][] winningPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public void dropIn(View view) {

        ImageView counter = (ImageView) view;

        int tappedTile = Integer.parseInt(counter.getTag().toString());

        if(gameState[tappedTile] == 2  && gameActive) {

            gameState[tappedTile] = activePlayer;

            counter.setTranslationY(-1000f);

            if (activePlayer == 0) {

                counter.setImageResource(R.drawable.x);

                activePlayer = 1;

            } else {

                counter.setImageResource(R.drawable.o);

                activePlayer = 0;

            }

            counter.animate().translationYBy(1000f).rotation(360).setDuration(300);

            for(int []winP : winningPositions) {
                if (gameState[winP[0]] == gameState[winP[1]] &&
                        gameState[winP[1]] == gameState[winP[2]] &&
                        gameState[winP[0]] != 2) {


//                    System.out.println("The gamestate is: " + gameState[winP[0]] + gameState[winP[1]] + gameState[winP[2]]);
//                    System.out.println("The winningPosition is: " + winP[0] + winP[1] + winP[2]);
                    gameActive = false;

                    String winner = "O";
                    if (gameState[winP[0]] == 0) {
                        winner = "X";
                    }

                    TextView winMsg = (TextView) findViewById(R.id.winnerMessage);
                    winMsg.setText(winner + " has won");
                    System.out.println(winMsg.getText().toString());

                    LinearLayout ll = (LinearLayout) findViewById(R.id.playAgainLayout);
                    ll.setVisibility(View.VISIBLE);
                    break;

                }
                else {
                    boolean gameOver = true;
                    for(int winState : gameState) {
                        if (winState == 2) {
                            gameOver = false;
                        }
                    }
                        if(gameOver){
                            TextView winMsg = (TextView) findViewById(R.id.winnerMessage);
                            winMsg.setText("It's a tie!!!");
                            LinearLayout ll = (LinearLayout) findViewById(R.id.playAgainLayout);
                            ll.setVisibility(View.VISIBLE);
                            System.out.println(winMsg.getText().toString());
                        }


                }

            }

        }
    }

    public void playAgain(View view){
//
//        gameActive = true;
//        LinearLayout ll = (LinearLayout) findViewById(R.id.playAgainLayout);
//        ll.setVisibility(View.INVISIBLE);
//
//        activePlayer = 0;
//        // 0 = x and 1 = o
//
//        for(int i = 0; i<gameState.length; i++)
//            gameState[i] = 2;
//        // 2 means unplayed
//
//        GridLayout gl =(GridLayout) findViewById(R.id.gridLayout);
//        for(int i = 0; i<gl.getChildCount(); i++){
//            ((ImageView) gl.getChildAt(i)).setImageResource(0);
//        }


        //Shortcut for above code
         super.recreate();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
