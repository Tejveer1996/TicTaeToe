package TicTaeToe.Main;

import TicTaeToe.Controller.GameController;
import TicTaeToe.Model.*;

import java.time.temporal.JulianFields;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        List<Player> players = new ArrayList<>();
        int id = 1;
        System.out.println("Welcome to TIC TAE TOE");
        System.out.println("Enter the Board size");
        Scanner sc = new Scanner(System.in);
        int dimension = sc.nextInt();
        System.out.println("Do you want to play with bot in the game ? Y or N");
        String botAns = sc.next();
        if (botAns.equalsIgnoreCase("Y")){
            Player bot = new Bot(id++, BotDifficultyLevel.Hard);
            players.add(bot);
        }

        while (id<dimension){
            System.out.println("Enter the player Name");
            String playerName = sc.next();
            System.out.println("Enter the player's Symbol");
            char symbol = sc.next().charAt(0);
            Player newPlayer = new Player(id++,playerName,symbol,PlayerType.Human);
            players.add(newPlayer);
        }
        Collections.shuffle(players);
        Game game = gameController.createGame(dimension,players);
        int playerIndex = -1;
        while (game.getGameStatus().equals(GameStatus.In_Progress)){
            gameController.displayBoard(game);
            playerIndex++;
            playerIndex = playerIndex%players.size();
            if(game.getMoves().size() == dimension*dimension){
                System.out.println("The game is Draw");
                break;
            }
            Move movePlayed = gameController.executeMove(game,players.get(playerIndex));
            game.getMoves().add(movePlayed);

            Player winner =  gameController.checkWinner(game,movePlayed);
            if(winner!=null){
                System.out.println("The winner is "+winner.getName());
                break;
            }


        }
        System.out.println("The final status of the game");
        gameController.displayBoard(game);
    }
}
