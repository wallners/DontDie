import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

import java.nio.charset.Charset;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Terminal terminal = TerminalFacade.createTerminal(System.in,
                System.out, Charset.forName("UTF8"));

        char [][] board = new char [20][20];
        Player player = new Player(10,10);
        Monster monster1 = new Monster(0,0);
        moveCursor(player, terminal);
        moveCursor(monster1,terminal);
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
                    player.setY(-1);
                    break;
                case ArrowUp:
                    player.setY(+1);
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
            System.out.println(key.getCharacter() + " " + key.getKind());
        }
    }

    public static void clearScreen(Terminal terminal) {
        terminal.clearScreen();
    }
    public static void moveCursor(Player player, Terminal terminal) {
        int x = player.getX();
        int y = player.getY();
        terminal.moveCursor(x,y);
        terminal.putCharacter('O');
        terminal.moveCursor(0,0);

    }
    public static void moveCursor(Monster monster, Terminal terminal) {
        int x = monster.getX();
        int y = monster.getY();
        terminal.moveCursor(x,y);
        terminal.putCharacter('X');
        terminal.moveCursor(0,0);

    }
}