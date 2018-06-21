import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

import java.nio.charset.Charset;

public class Board {

    public Monster monster1;
    public Monster monster2;
    public Monster monster3;
    public Monster monster4;
    public Player player;

    public Board(Terminal terminal) throws java.lang.InterruptedException {
        monster1 = new Monster(0, 0);
        monster2 = new Monster(0, 20);
        monster3 = new Monster(20, 0);
        monster4 = new Monster(20, 20);
        player = new Player(10, 10);

        monster1.moveMonster(player.getX(), player.getY());
        monster2.moveMonster(player.getX(), player.getY());
        monster3.moveMonster(player.getX(), player.getY());
        monster4.moveMonster(player.getX(), player.getY());


        moveCursor(monster1, terminal);
        moveCursor(monster2, terminal);
        moveCursor(monster3, terminal);
        moveCursor(monster4, terminal);


        char[][] board = new char[20][20];
        moveCursor(player, terminal);


        terminal.enterPrivateMode();

        while (true) {
//Wait for a key to be pressed
            Key key;
            do {
                Thread.sleep(5);
                key = terminal.readInput();
            }
            while (key == null);
            switch (key.getKind()) {
                case ArrowDown:
                    player.setY(+1);
                    break;
                case ArrowUp:
                    player.setY(-1);
                    break;
                case ArrowLeft:
                    player.setX(-1);
                    break;
                case ArrowRight:
                    player.setX(+1);
                    break;
            }

            clearScreen(terminal);
            moveCursor(player, terminal);
            monster1.moveMonster(player.getX(), player.getY());
            moveCursor(monster1, terminal);
            monster2.moveMonster(player.getX(), player.getY());
            moveCursor(monster2, terminal);
            monster3.moveMonster(player.getX(), player.getY());
            moveCursor(monster3, terminal);
            monster4.moveMonster(player.getX(), player.getY());
            moveCursor(monster4, terminal);

            if (monster1.getX() == player.getX() && monster1.getY() == player.getY()) {
                printText(10, 10, "Game Over... You lose", terminal);
                break;


            }


        }
    }


    public static void clearScreen(Terminal terminal) {
        terminal.clearScreen();
    }

    public static void moveCursor(Player player, Terminal terminal) {
        int x = player.getX();
        int y = player.getY();
        terminal.moveCursor(x, y);
        terminal.putCharacter('\u263A');
        terminal.moveCursor(0, 0);

    }

    public static void moveCursor(Monster monster, Terminal terminal) {
        int x = monster.getX();
        int y = monster.getY();
        terminal.moveCursor(x, y);
        terminal.putCharacter('\u2620');
        terminal.moveCursor(0, 0);

    }

    private static void printText(int x, int y, String message, Terminal
            terminal) {
        for (int i = 0; i < message.length(); i++) {
            terminal.moveCursor(x, y);
            terminal.putCharacter(message.charAt(i));
            x = x + 1;
        }
    }
}
