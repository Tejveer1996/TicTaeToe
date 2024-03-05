package TicTaeToe.Controller;

import TicTaeToe.Model.*;
import TicTaeToe.Service.WinningStrategy.WinningStrategyFactory;

import java.util.List;

public class GameController {
    public Game createGame(int dimension, List<Player> players){
        return new Game.Builder()
                .setDimension(dimension)
                .setPlayers(players)
                .setWinningStrategy(WinningStrategyFactory.getWinningStrategy(dimension))
                .build();
    }

    public void displayBoard(Game game){
        game.getCurrentBoard().displayBoard();
    }

    public GameStatus gameStatus(Game game){
        return game.getGameStatus();
    }

    public Move executeMove(Game game,Player player){
        return player.makeMove(game.getCurrentBoard());
    }

    public Player checkWinner(Game game, Move lastMovePlayed){
        return game.getWinningStrategy().checkWinner(game.getCurrentBoard(),lastMovePlayed);
    }

    // Undo and replay game
}
