package com.lpoo.fallout.gui;

import com.googlecode.lanterna.TextColor;
import com.lpoo.fallout.data.Element;
import com.lpoo.fallout.data.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class SingleCharGUITest {
    SingleCharGUI gui;
    SingleCharDrawable asset1;
    SingleCharDrawable asset2;
    SingleCharDrawable asset3;
    SingleCharDrawable asset4;
    @BeforeEach
    void createAssets() throws IOException {
        gui = new SingleCharGUI(new LanternaTerminal(40, 40));
        asset1 = new SingleCharDrawable(new Position(10, 10), "#FFFFFF", "#FF0000", "1");
        asset2 = new SingleCharDrawable(new Position(20, 10), "#FF0000", "#00FF00", "2");
        asset3 = new SingleCharDrawable(new Position(5, 5), "#00FFFF", "#FF00FF", "3");
        asset4 = new SingleCharDrawable(new Position(0, 0), "#0000FF", "#FFFF00", "4");

        asset1.pushDraw(gui);
        asset2.pushDraw(gui);
        asset3.pushDraw(gui);
        asset4.pushDraw(gui);
        gui.draw();
    }

    @Test
    void testFirstAsset() {
        SingleCharGUI render = (SingleCharGUI) gui;
        int row = asset1.getPosition().getRow();
        int column = asset1.getPosition().getColumn();
        Assertions.assertEquals("1", render.getTerminal().getGraphics().getCharacter(column, row).getCharacterString());
        Assertions.assertEquals(TextColor.Factory.fromString(asset1.getForegroundColor()), render.getTerminal().getGraphics().getCharacter(column, row).getForegroundColor());
        Assertions.assertEquals(TextColor.Factory.fromString(asset1.getBackgroundColor()), render.getTerminal().getGraphics().getCharacter(column, row).getBackgroundColor());
    }

    @Test
    void testSecondAsset() {
        SingleCharGUI render = (SingleCharGUI) gui;
        int row = asset2.getPosition().getRow();
        int column = asset2.getPosition().getColumn();
        Assertions.assertEquals("2", render.getTerminal().getGraphics().getCharacter(column, row).getCharacterString());
        Assertions.assertEquals(TextColor.Factory.fromString(asset2.getForegroundColor()), render.getTerminal().getGraphics().getCharacter(column, row).getForegroundColor());
        Assertions.assertEquals(TextColor.Factory.fromString(asset2.getBackgroundColor()), render.getTerminal().getGraphics().getCharacter(column, row).getBackgroundColor());
    }

    @Test
    void testThirdAsset() {
        SingleCharGUI render = (SingleCharGUI) gui;
        int row = asset3.getPosition().getRow();
        int column = asset3.getPosition().getColumn();
        Assertions.assertEquals("3", render.getTerminal().getGraphics().getCharacter(column, row).getCharacterString());
        Assertions.assertEquals(TextColor.Factory.fromString(asset3.getForegroundColor()), render.getTerminal().getGraphics().getCharacter(column, row).getForegroundColor());
        Assertions.assertEquals(TextColor.Factory.fromString(asset3.getBackgroundColor()), render.getTerminal().getGraphics().getCharacter(column, row).getBackgroundColor());
    }

    @Test
    void testFourthAsset() {
        SingleCharGUI render = (SingleCharGUI) gui;
        int row = asset4.getPosition().getRow();
        int column = asset4.getPosition().getColumn();
        Assertions.assertEquals("4", render.getTerminal().getGraphics().getCharacter(column, row).getCharacterString());
        Assertions.assertEquals(TextColor.Factory.fromString(asset4.getForegroundColor()), render.getTerminal().getGraphics().getCharacter(column, row).getForegroundColor());
        Assertions.assertEquals(TextColor.Factory.fromString(asset4.getBackgroundColor()), render.getTerminal().getGraphics().getCharacter(column, row).getBackgroundColor());
    }

    @Test
    void polymorphicGUI() throws IOException{
        SingleCharGUI gui = new SingleCharGUI(new LanternaTerminal(40, 40));
        class MockDrawableFactory implements DrawableFactory<SingleCharDrawable> {
            @Override
            public SingleCharDrawable getDrawable(Element element) {
                return asset1;
            }
        }
        DrawableFactory<SingleCharDrawable> mockFactory = new MockDrawableFactory();
        mockFactory.getDrawable(null).pushDraw(gui);
    }
}