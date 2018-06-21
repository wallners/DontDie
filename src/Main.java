import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

import java.nio.charset.Charset;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Terminal terminal = TerminalFacade.createTerminal(System.in,
                System.out, Charset.forName("UTF8"));

        char [][] board = new char [20][20];

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
                    break;
                case ArrowUp:
                    break;
                case ArrowLeft:
                    break;
                case ArrowRight:
                    break;
            }
            clearScreen(terminal);
            System.out.println(key.getCharacter() + " " + key.getKind());
        }
    }

    public static void clearScreen(Terminal terminal) {
        terminal.clearScreen();
    }
}