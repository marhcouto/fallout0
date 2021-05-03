package com.lpoo.fallout.gui;

import com.googlecode.lanterna.TextColor;
import com.lpoo.fallout.data.Element;
import com.lpoo.fallout.data.LanternaDrawable;
import com.lpoo.fallout.data.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class LanternaGUITest {
    LanternaGUI gui;
    LanternaDrawable asset1;
    LanternaDrawable asset2;
    LanternaDrawable asset3;
    LanternaDrawable asset4;
    @BeforeEach
    void createAssets() throws IOException {
        gui = new LanternaGUI(new LanternaTerminal(40, 40));
        asset1 = new LanternaDrawable(new Position(10, 10), "#FFFFFF", "#FF0000", "1");
        asset2 = new LanternaDrawable(new Position(20, 10), "#FF0000", "#00FF00", "2");
        asset3 = new LanternaDrawable(new Position(5, 5), "#00FFFF", "#FF00FF", "3");
        asset4 = new LanternaDrawable(new Position(0, 0), "#0000FF", "#FFFF00", "4");

        gui.placeDrawable(asset1);
        gui.placeDrawable(asset2);
        gui.placeDrawable(asset3);
        gui.placeDrawable(asset4);
        gui.draw();
    }

    @Test
    void testFirstAsset() {
        LanternaGUI render = (LanternaGUI) gui;
        int row = asset1.getPosition().getRow();
        int column = asset1.getPosition().getColumn();
        Assertions.assertEquals("1", render.getTerminal().getGraphics().getCharacter(column, row).getCharacterString());
        Assertions.assertEquals(TextColor.Factory.fromString(asset1.getForegroundColor()), render.getTerminal().getGraphics().getCharacter(column, row).getForegroundColor());
        Assertions.assertEquals(TextColor.Factory.fromString(asset1.getBackgroundColor()), render.getTerminal().getGraphics().getCharacter(column, row).getBackgroundColor());
    }

    @Test
    void testSecondAsset() {
        LanternaGUI render = (LanternaGUI) gui;
        int row = asset2.getPosition().getRow();
        int column = asset2.getPosition().getColumn();
        Assertions.assertEquals("2", render.getTerminal().getGraphics().getCharacter(column, row).getCharacterString());
        Assertions.assertEquals(TextColor.Factory.fromString(asset2.getForegroundColor()), render.getTerminal().getGraphics().getCharacter(column, row).getForegroundColor());
        Assertions.assertEquals(TextColor.Factory.fromString(asset2.getBackgroundColor()), render.getTerminal().getGraphics().getCharacter(column, row).getBackgroundColor());
    }

    @Test
    void testThirdAsset() {
        LanternaGUI render = (LanternaGUI) gui;
        int row = asset3.getPosition().getRow();
        int column = asset3.getPosition().getColumn();
        Assertions.assertEquals("3", render.getTerminal().getGraphics().getCharacter(column, row).getCharacterString());
        Assertions.assertEquals(TextColor.Factory.fromString(asset3.getForegroundColor()), render.getTerminal().getGraphics().getCharacter(column, row).getForegroundColor());
        Assertions.assertEquals(TextColor.Factory.fromString(asset3.getBackgroundColor()), render.getTerminal().getGraphics().getCharacter(column, row).getBackgroundColor());
    }

    @Test
    void testFourthAsset() {
        LanternaGUI render = (LanternaGUI) gui;
        int row = asset4.getPosition().getRow();
        int column = asset4.getPosition().getColumn();
        Assertions.assertEquals("4", render.getTerminal().getGraphics().getCharacter(column, row).getCharacterString());
        Assertions.assertEquals(TextColor.Factory.fromString(asset4.getForegroundColor()), render.getTerminal().getGraphics().getCharacter(column, row).getForegroundColor());
        Assertions.assertEquals(TextColor.Factory.fromString(asset4.getBackgroundColor()), render.getTerminal().getGraphics().getCharacter(column, row).getBackgroundColor());
    }
}