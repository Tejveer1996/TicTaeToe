package TicTaeToe.Service.WinningStrategy;

import TicTaeToe.Model.Board;
import TicTaeToe.Model.Move;
import TicTaeToe.Model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class orderOneWinningStrategy implements WinningStrategy{
    private int dimension;
    private List<HashMap<Character,Integer>> rowHashMapList;
    private List<HashMap<Character,Integer>> colHashMapList;
    private HashMap<Character,Integer> leftDiagonalHashMap;
    private HashMap<Character,Integer> rightDiagonalHashMap;
    private HashMap<Character,Integer> cornerHashMap;

public orderOneWinningStrategy(int dimension) {
        this.dimension = dimension;
        this.rowHashMapList = new ArrayList<>();
        this.colHashMapList = new ArrayList<>();
        this.leftDiagonalHashMap = new HashMap<>();
        this.rightDiagonalHashMap = new HashMap<>();
        this.cornerHashMap = new HashMap<>();

        for (int i=0; i<dimension; i++){
            rowHashMapList.add(new HashMap<>());
            colHashMapList.add(new HashMap<>());
        }
    }

    @Override
    public Player checkWinner(Board board, Move lastMove) {
        Player player = lastMove.getPlayer();
        char symbol = player.getSymbol();
        int row = lastMove.getCell().getRow();
        int col = lastMove.getCell().getCol();

        boolean winner = (checkCorner(row,col) && checkAndUpdateCorner(symbol)
                          || checkAndUpdateRowList(row,symbol)
                          || checkAndUpdateColList(col,symbol)
                          || checkLeftDiagonal(row,col) && checkAndUpdateLeftDiagonal(symbol)
                          || checkRightDiagonal(row,col) && checkAndUpdateRightDiagonal(symbol));
        if (winner){
            return player;
        }
        return null;
    }

    private boolean checkAndUpdateRightDiagonal(char symbol) {
        if (rightDiagonalHashMap.containsKey(symbol)){
            rightDiagonalHashMap.put(symbol,rightDiagonalHashMap.get(symbol)+1);
            return rightDiagonalHashMap.get(symbol)==dimension;
        }else {
            rightDiagonalHashMap.put(symbol,1);
        }
        return false;
    }

    private boolean checkRightDiagonal(int row, int col) {
       return (row+col)==dimension-1;
    }

    private boolean checkAndUpdateLeftDiagonal(char symbol) {
         if (leftDiagonalHashMap.containsKey(symbol)){
             leftDiagonalHashMap.put(symbol,leftDiagonalHashMap.get(symbol)+1);
             return leftDiagonalHashMap.get(symbol)==dimension;
         }else {
             leftDiagonalHashMap.put(symbol,1);
         }
         return false;
    }

    private boolean checkLeftDiagonal(int row, int col) {
         return row==col;
    }

    private boolean checkAndUpdateColList(int col, char symbol) {
         HashMap<Character,Integer> colHashMap = colHashMapList.get(col);
         if (colHashMap.containsKey(symbol)){
             colHashMap.put(symbol,colHashMap.get(symbol)+1);
             return colHashMap.get(symbol) == dimension;
         }else {
             colHashMap.put(symbol,1);
         }
         return false;
    }

    private boolean checkAndUpdateRowList(int row, char symbol) {
        HashMap<Character,Integer> rowHashMap = rowHashMapList.get(row);
        if (rowHashMap.containsKey(symbol)){
            rowHashMap.put(symbol,rowHashMap.get(symbol)+1);
            return rowHashMap.get(symbol) == dimension;
        }else{
            rowHashMap.put(symbol,1);
        }
        return false;
    }

    private boolean checkAndUpdateCorner(char symbol) {
        if (cornerHashMap.containsKey(symbol)){
            cornerHashMap.put(symbol,cornerHashMap.get(symbol)+1);
            return cornerHashMap.get(symbol)==4;
        }else {
            cornerHashMap.put(symbol,1);
        }
         return false;
    }

    private boolean checkCorner(int row, int col) {
        return (  row==0 && col==0
                || row==0 && col==dimension-1
                || row==dimension-1 && col==0
                || row==dimension-1 && col==dimension-1);
    }
}