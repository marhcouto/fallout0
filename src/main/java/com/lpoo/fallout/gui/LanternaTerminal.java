package com.lpoo.fallout.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

public class LanternaTerminal {
    private Screen screen;
    private TextGraphics graphics;

    public LanternaTerminal() throws IOException {
        this(40, 20, 15);
    }

    public LanternaTerminal(Integer nColumns, Integer nRows, Integer fontSize) throws IOException {
        try {
            // Load Font
            File fontFile = new File("resources/square.ttf");
            Font font =  Font.createFont(Font.TRUETYPE_FONT, fontFile);
            // Register Font
            GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
            graphicsEnvironment.registerFont(font);

            Font loadedFont = font.deriveFont(Font.PLAIN, fontSize);
            AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);

            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                    .setInitialTerminalSize(new TerminalSize(nColumns, nRows)) // Sets terminal size
                    .setForceAWTOverSwing(true)
                    .setTerminalEmulatorFontConfiguration(fontConfig);

            Terminal terminal = terminalFactory.createTerminal();

            ((AWTTerminalFrame)terminal).addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    e.getWindow().dispose();
                }
            });

            screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();

            graphics = screen.newTextGraphics();
        } catch (FontFormatException fontFormat) {
            fontFormat.printStackTrace();
        }
    }

    public Screen getScreen() {
        return screen;
    }

    public TextGraphics getGraphics() {
        return graphics;
    }
}
