package TicTaeToe.Service.BotPlayingStrategy;

import TicTaeToe.Exception.GameOverException;import TicTaeToe.Model.*;

import java.util.List;

public class RandomBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Move makeMove(Board board, Player bot) {
        List<List<Cell>> matrix = board.getMatrix();
        for(int i=0; i<matrix.size(); i++){
            for(int j=0; j<matrix.size(); j++){
               if(matrix.get(i).get(j).getCellState().equals(CellState.Empty)){
                    matrix.get(i).get(j).setCellState(CellState.Filled);
                    matrix.get(i).get(j).setPlayer(bot);
                    return new Move(matrix.get(i).get(j),bot);
                }
            }
        }
        throw new GameOverException("Game over - No space is available to play");
    }
}
