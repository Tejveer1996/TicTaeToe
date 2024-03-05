package TicTaeToe.Model;

import TicTaeToe.Service.BotPlayingStrategy.BotStrategyFactory;

public class Bot extends Player {
     private BotDifficultyLevel botDifficultyLevel;
    public Bot(int id,BotDifficultyLevel botDifficultyLevel) {
        super(id, "Chitti", '$', PlayerType.Bot);
        this.botDifficultyLevel = botDifficultyLevel;
    }

    public Move makeMove(Board board){
        return BotStrategyFactory.botPlayingStrategy().makeMove(board,this);
    }

}