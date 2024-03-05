package TicTaeToe.Service.WinningStrategy;

import TicTaeToe.Model.Board;
import TicTaeToe.Model.Move;
import TicTaeToe.Model.Player;

public interface WinningStrategy {
    Player checkWinner(Board board, Move lastMove);
}
