package com.lpoo.fallout.ui;

import com.googlecode.lanterna.TextColor;
import com.lpoo.fallout.data.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Text;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class UIRenderTest {
    private LCharacter character1;
    private LCharacter character2;
    private LCharacter character3;
    private LCharacter character4;
    private UIRender render;

    @BeforeEach
    void pushNewChars() {
        character1 = new LCharacter(new Position(10, 10), "#FFFFFF", "#FF0000", "1");
        character2 = new LCharacter(new Position(20, 10), "#FF0000", "#00FF00", "2");
        character3 = new LCharacter(new Position(5, 5), "#00FFFF", "#FF00FF", "3");
        character4 = new LCharacter(new Position(0, 0), "#0000FF", "#FFFF00", "4");
        try {
            render = new UIRender();
            render.pushChar(character1, character2, character3, character4);
            render.commit();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @Test
    void testFirstCharacter() {
        int row = character1.getPosition().getRow();
        int column = character1.getPosition().getColumn();
        Assertions.assertEquals("1", render.getTerminal().getGraphics().getCharacter(column, row).getCharacterString());
        Assertions.assertEquals(TextColor.Factory.fromString("#FFFFFF"), render.getTerminal().getGraphics().getCharacter(column, row).getForegroundColor());
        Assertions.assertEquals(TextColor.Factory.fromString("#FF0000"), render.getTerminal().getGraphics().getCharacter(column, row).getBackgroundColor());
    }

    @Test
    void testSecondCharacter() {
        int row = character2.getPosition().getRow();
        int column = character2.getPosition().getColumn();
        Assertions.assertEquals("2", render.getTerminal().getGraphics().getCharacter(column, row).getCharacterString());
        Assertions.assertEquals(TextColor.Factory.fromString("#FF0000"), render.getTerminal().getGraphics().getCharacter(column, row).getForegroundColor());
        Assertions.assertEquals(TextColor.Factory.fromString("#00FF00"), render.getTerminal().getGraphics().getCharacter(column, row).getBackgroundColor());
    }

    @Test
    void testThirdCharacter() {
        int row = character3.getPosition().getRow();
        int column = character3.getPosition().getColumn();
        Assertions.assertEquals("3", render.getTerminal().getGraphics().getCharacter(column, row).getCharacterString());
        Assertions.assertEquals(TextColor.Factory.fromString("#00FFFF"), render.getTerminal().getGraphics().getCharacter(column, row).getForegroundColor());
        Assertions.assertEquals(TextColor.Factory.fromString("#FF00FF"), render.getTerminal().getGraphics().getCharacter(column, row).getBackgroundColor());
    }

    @Test
    void testFourthCharacter() {
        int row = character4.getPosition().getRow();
        int column = character4.getPosition().getColumn();
        Assertions.assertEquals("4", render.getTerminal().getGraphics().getCharacter(column, row).getCharacterString());
        Assertions.assertEquals(TextColor.Factory.fromString("#0000FF"), render.getTerminal().getGraphics().getCharacter(column, row).getForegroundColor());
        Assertions.assertEquals(TextColor.Factory.fromString("#FFFF00"), render.getTerminal().getGraphics().getCharacter(column, row).getBackgroundColor());
    }
}