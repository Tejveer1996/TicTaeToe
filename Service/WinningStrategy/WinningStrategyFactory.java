package TicTaeToe.Service.WinningStrategy;

public class WinningStrategyFactory {
    public static WinningStrategy getWinningStrategy(int dimension){

        return new orderOneWinningStrategy(dimension);
    }
}
