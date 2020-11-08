package com.example;

import android.widget.Toast;

public class TicTacToe {

    public ButtonChar board[][]=new ButtonChar[3][3];
    public int count=0;

    public enum ButtonChar{
        X,O;
    }

    public void set(ButtonChar c,int x, int y){
        if(board[x][y]==null) {
            board[x][y] = c;
            count++;
        }
    }

    public boolean didWin(){
        return checkRow() || checkColumn() || checkDiagonal();
    }

    public boolean checkRow(){
        boolean won=false;
        for(int i=0;i<board.length;i++){
            ButtonChar start=board[i][0];
            for(int j=1;j<board[i].length;j++){
                if(start==board[i][j]){
                    won=true;
                }
            }
            if(won){
                return true;
            }
        }
        return false;
    }

    public boolean checkColumn(){
        boolean won=false;
        for(int i=0;i<board.length;i++){
            ButtonChar start=board[0][i];
            for(int j=1;j<board[i].length;j++){
                if(start==board[j][i]){
                    won=true;
                }
            }
            if(won){
                return true;
            }
        }
        return false;
    }

    public boolean checkDiagonal(){
        boolean won=false;
        ButtonChar start=board[0][0];
        for(int i=1;i<board.length;i++){
            if(start==board[i][i]){
                won=true;
            }
        }
        if(won){
            return true;
        }
        won=false;
        start=board[0][board.length-1];
        for(int i=1;i<board.length;i++){
            if (start == board[i][board.length - 1 - i]) {
                won = true;
            }
        }
        return won;
    }

    public void Drawed(){
        board=new ButtonChar[3][3];
    }
    


}
