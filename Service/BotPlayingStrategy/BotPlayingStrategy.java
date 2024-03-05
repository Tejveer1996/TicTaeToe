package TicTaeToe.Service.BotPlayingStrategy;

import TicTaeToe.Model.Board;
import TicTaeToe.Model.Move;
import TicTaeToe.Model.Player;

import javax.swing.text.ComponentView;

public interface BotPlayingStrategy {
    Move makeMove(Board board, Player player);
}
