package com.lpoo.fallout.ui;

import com.googlecode.lanterna.TextColor;

import java.io.IOException;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.LinkedList;

public class UIRender {
    private final LanternaTerminal terminal;
    private AbstractList<LCharacter> characterStack;

    public UIRender() throws IOException {
        characterStack = new LinkedList<>();
        terminal = new LanternaTerminal();
    }

    public void pushChar(LCharacter... characters) {
        characterStack.addAll(Arrays.asList(characters));
    }

    public void commit() throws IOException {
        terminal.getScreen().clear();
        for (LCharacter character: characterStack) {
            terminal.getGraphics().setForegroundColor(TextColor.Factory.fromString(character.getForegroundColor()));
            terminal.getGraphics().setBackgroundColor(TextColor.Factory.fromString(character.getBackgroudColor()));
            terminal.getGraphics().putString(character.getPosition().getColumn(), character.getPosition().getRow(), character.getImgChar());
        }
        terminal.getScreen().refresh();
        characterStack.clear();
    }

    public Class<CharacterFactory> createCharacterFactory() {
        return CharacterFactory.class;
    }

    public LanternaTerminal getTerminal() {
        return terminal;
    }
}
