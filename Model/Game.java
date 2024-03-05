package TicTaeToe.Model;

import TicTaeToe.Exception.BotCountException;
import TicTaeToe.Exception.InvalidSymbolException;
import TicTaeToe.Exception.PlayerCountException;
import TicTaeToe.Service.WinningStrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {
    private Board currentBoard;
    private List<Player> players;
    private Player currentPlayer;
    private GameStatus gameStatus;
    private List<Move> moves;
    private List<Board> boardState;
    private WinningStrategy winningStrategy;
    private int noOfSymbols;

    public Game(Board currentBoard, List<Player> players, WinningStrategy winningStrategy) {
        this.currentBoard = currentBoard;
        this.players = players;
        this.currentPlayer = null;
        this.gameStatus = GameStatus.In_Progress;
        this.moves = new ArrayList<>();
        this.boardState = new ArrayList<>();
        this.winningStrategy = winningStrategy;
        this.noOfSymbols = players.size();
    }

    public Board getCurrentBoard() {
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println(e);
        }

        return currentBoard;
    }

    public void setCurrentBoard(Board currentBoard) {
        this.currentBoard = currentBoard;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public List<Board> getBoardState() {
        return boardState;
    }

    public void setBoardState(List<Board> boardState) {
        this.boardState = boardState;
    }

    public WinningStrategy getWinningStrategy() {
        return winningStrategy;
    }

    public void setWinningStrategy(WinningStrategy winningStrategy) {
        this.winningStrategy = winningStrategy;
    }

    public int getNoOfSymbols() {
        return noOfSymbols;
    }

    public void setNoOfSymbols(int noOfSymbols) {
        this.noOfSymbols = noOfSymbols;
    }
    public static Builder builder(){
        return new Builder();
    }
    public static class Builder{
        private int dimension;
        private Board currentBoard;
        private List<Player> players;
        private WinningStrategy winningStrategy;

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setCurrentBoard(Board currentBoard) {
            this.currentBoard = currentBoard;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStrategy(WinningStrategy winningStrategy) {
            this.winningStrategy = winningStrategy;
            return this;
        }

        public void validateBotCount(){
            int botCount = 0;
            for(Player player : players){
                if (player.getPlayerType().equals(PlayerType.Bot)){
                    botCount++;
                }
            }
            if(botCount >1 || botCount <0){
                throw new BotCountException("No of bots can't be less than 0 or greater than 1");
            }
        }

        public void validateNumberOfPlayers(){
           // no of players cannot be greater than dimension -2.
            if(players.size() > dimension-2 || players.size()<2){
                throw new PlayerCountException("Invalid number of players entered");
            }
        }

        public void validatePlayersSymbol(){
            HashSet<Character> symbols = new HashSet<>();
            for(Player player: players){
                symbols.add(player.getSymbol());
            }
            if(symbols.size() != players.size()){
                throw new InvalidSymbolException("Entered symbol is already exist");
            }
        }
        public void validate(){
            validateBotCount();
            validateNumberOfPlayers();
            validatePlayersSymbol();
        }

        public Game build(){
            return new Game(new Board(dimension), players,winningStrategy);
        }
    }
}
