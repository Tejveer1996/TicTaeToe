package TicTaeToe.Service.BotPlayingStrategy;

public class BotStrategyFactory {
    public static BotPlayingStrategy botPlayingStrategy(){
        return new RandomBotPlayingStrategy();
    }
}
