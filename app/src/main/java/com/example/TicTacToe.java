package com.example;

public class TicTacToe {

    public ButtonChar board[][]=new ButtonChar[3][3];

    public enum ButtonChar{
        X,O;
    }

    public void set(ButtonChar c,int x, int y){
        if(board[x][y]==null) {
            board[x][y] = c;
        }
    }

    public boolean didWin(){
        return checkRow() || checkColumn() || checkDiagonal();
    }

    public boolean checkRow(){
        return true;
    }

    public boolean checkColumn(){
        return true;
    }

    public boolean checkDiagonal(){
        return true;
    }



}
