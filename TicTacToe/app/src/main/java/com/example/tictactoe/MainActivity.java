package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean firstPlayer;
    TextView currPlayer;
    ImageView[] cellArray;
    String[] players;


    static final int NO_PLAYER_ID = 0;
    static final int PLAYER1_ID = 1;
    static final int PLAYER2_ID = 2;
    static final int maxTurns = 9;
    int currTurn;
    static final int gameEndWinnerPosition = 0;
    static final int gameEndCell1 = 0;
    static final int gameEndCell2 = 1;
    static final int gameEndCell3 = 2;

    int[] gameBoardArray = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    int[][] winningPositions = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstPlayer = true;
        currPlayer = findViewById(R.id.currPlayerTextView);
        players = getResources().getStringArray(R.array.players);
        cellArray = new ImageView[9];
        currTurn = 0;

        for (int cellIndex = 0; cellIndex < 9; cellIndex++) {
            String cellID = "cell_" + cellIndex;
            int resource = getResources().getIdentifier(cellID, "id", getPackageName());
            cellArray[cellIndex] = findViewById(resource);
            int finalCellIndex = cellIndex;
            cellArray[cellIndex].setOnClickListener(view -> {
                currTurn++;
                Log.i("TAG", "clicked " + cellID);
                if (gameBoardArray[finalCellIndex] != NO_PLAYER_ID)
                    return;
                //String buttonNum = view.getResources().getResourceEntryName(view.getId());
                //int position = Integer.parseInt(cellID.substring(cellID.length() - 1, cellID.length()));

                if (firstPlayer) {
                    gameBoardArray[finalCellIndex] = PLAYER1_ID;
                    view.setBackgroundResource(R.drawable.cross);
                    currPlayer.setText(players[PLAYER2_ID -1]);
                } else {
                    gameBoardArray[finalCellIndex] = PLAYER2_ID;
                    view.setBackgroundResource(R.drawable.circle);
                    currPlayer.setText(players[PLAYER1_ID -1]);
                }

                int[] gameEnd = checkGameEnd();
                if (gameEnd.length != 0) {
                    if (gameEnd[gameEndWinnerPosition] == NO_PLAYER_ID
                            && currTurn == maxTurns) {
                        //TIE
                        currPlayer.setText("TIE!!!");
                        //stopGame();
                    } else {
                        //winner is declared
                        //stopGame();
                        currPlayer.setText("The winner is Player " + gameEnd[gameEndWinnerPosition] + "!");
                        // TODO: COLOR THE WINNING CELLS
                    }
                }

                firstPlayer = (!firstPlayer);
            });
        }
    }

    public int[] checkGameEnd() {
        int winner = NO_PLAYER_ID;
        int[] winningData = new int[4];
        for (int[] winningPosition : winningPositions) {
            if (gameBoardArray[winningPosition[gameEndCell1]] != NO_PLAYER_ID)
                if (gameBoardArray[winningPosition[gameEndCell1]] == gameBoardArray[winningPosition[gameEndCell2]]
                        &&gameBoardArray[winningPosition[gameEndCell1]] == gameBoardArray[winningPosition[gameEndCell3]]) {
                    winner = gameBoardArray[winningPosition[gameEndCell1]];
                    winningData[gameEndWinnerPosition] = winner;
                    winningData[gameEndCell1 + 1] = winningPosition[gameEndCell1];
                    winningData[gameEndCell2 + 1] = winningPosition[gameEndCell2];
                    winningData[gameEndCell3 + 1] = winningPosition[gameEndCell3];
                    return winningData;
                }
        }

        // maxturns achived == tie
        if (currTurn == maxTurns) {
            return winningData;
        }

        return new int[0];
    }


/*    public void drawLine(int[] winner, int winPo) {
        if (winPo <= 2) {
            line2.setBackgroundColor(Color.RED);
            if (winPo == 0)
                line2.setY(imageButtonsArray[0].getY() + 100);
            if (winPo == 1)
                line2.setY(imageButtonsArray[3].getY() + 100);
            if (winPo == 2)
                line2.setY(imageButtonsArray[6].getY() + 100);
        } else if (winPo > 2 && winPo <= 5) {
            line.setBackgroundColor(Color.RED);
            if (winPo == 3)
                line.setX(imageButtonsArray[3].getX() + 100);
            if (winPo == 4)
                line.setX(imageButtonsArray[4].getX() + 100);
            if (winPo == 5)
                line.setX(imageButtonsArray[5].getX() + 100);
        } else {
            line3.setBackgroundColor(Color.RED);
            if (winPo == 6)
                line3.setRotation(-45);
            if (winPo == 7)
                line3.setRotation(45);
        }
    }*/
}