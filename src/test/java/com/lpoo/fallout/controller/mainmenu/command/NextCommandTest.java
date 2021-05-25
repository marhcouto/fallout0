package com.lpoo.fallout.controller.mainmenu.command;

import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.controller.mainmenu.MainMenuOptionsController;
import com.lpoo.fallout.model.filehandling.FileHandler;
import com.lpoo.fallout.model.mainmenu.MainMenuModel;
import com.lpoo.fallout.model.wander.Attributes;
import com.lpoo.fallout.states.WanderState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.io.IOException;

class NextCommandTest {
    MainMenuOptionsController controller;
    Game mockedGame;
    Attributes attributes;

    @BeforeEach
    void setUp() {
        attributes = new Attributes(1, 2, 3, 4);
        controller = Mockito.mock(MainMenuOptionsController.class);
        MainMenuModel model = Mockito.mock(MainMenuModel.class);
        Mockito.when(model.getAttributes()).thenReturn(attributes);
        Mockito.when(controller.getModel()).thenReturn(model);
        mockedGame = Mockito.mock(Game.class);
    }

    @Test
    void activate() throws IOException, ClassNotFoundException {
        FileHandler fileHandlerMock = Mockito.mock(FileHandler.class);

        NextCommand command = new NextCommand(controller, fileHandlerMock);

        ArgumentCaptor<Attributes> attributeArgumentCaptor = ArgumentCaptor.forClass(Attributes.class);

        command.activate(mockedGame);
        Mockito.verify(mockedGame, Mockito.times(1)).pushController(Mockito.any(WanderState.class));
        Mockito.verify(fileHandlerMock).createWanderModel(Mockito.any(String.class), attributeArgumentCaptor.capture());

        Assertions.assertEquals(attributes, attributeArgumentCaptor.getValue());
    }
}