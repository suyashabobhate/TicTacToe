package com.example;

public class TicTacToe {

    public char board[][]=new char[3][3];

    public void set(char c,int x, int y){
        if(board[x][y]==0) {
            board[x][y] = c;
        }
    }

    public boolean didWin(){
        return checkRow() || checkColumn() || checkDiagonal();
    }

    public boolean checkRow(){
        for(int i=0;i<board.length;i++){
            int winCount=1;
            if(board[i][0]!=0) {
                char start = board[i][0];
                for (int j = 1; j < board[i].length; j++) {
                    if (start == board[i][j]) {
                        winCount++;
                    }
                }
            }
            if(winCount==board[i].length){
                return true;
            }
        }
        return false;
    }

    public boolean checkColumn(){
        for(int i=0;i<board.length;i++){
            int winCount=1;
            if(board[0][i]!=0) {
                char start = board[0][i];
                for (int j = 1; j < board[i].length; j++) {
                    if (start == board[j][i]) {
                       winCount++;
                    }
                }
            }
            if(winCount==board[i].length){
                return true;
            }
        }
        return false;
    }

    public boolean checkDiagonal(){
        char start;
        int winCount=1;
        if(board[0][0]!=0) {
            start = board[0][0];
            for (int i = 1; i < board.length; i++) {
                if (start == board[i][i]) {
                    winCount++;
                }
            }
        }
        if(winCount==board.length){
            return true;
        }
        winCount=1;
        if(board[0][board.length-1]!=0) {
            start = board[0][board.length - 1];
            for (int i = 1; i < board.length; i++) {
                if (start == board[i][board.length - 1 - i]) {
                   winCount++;
                }
            }
        }
        if(winCount==board.length){
            return true;
        }
        return false;
    }

    public void resetBoardArr(){
        board=new char[3][3];
    }
}
