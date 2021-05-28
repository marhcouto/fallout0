package com.lpoo.fallout.controller.messagedisplay;

import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.controller.MainController;
import com.lpoo.fallout.gui.GUI;
import com.lpoo.fallout.model.messagedisplay.MessageDisplayModel;

public class MessageDisplayController extends MainController<MessageDisplayModel> {
    public MessageDisplayController(MessageDisplayModel model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        switch(action) {
            case QUIT: {
                game.clearStates();
                break;
            }
            case ENTER: {
                game.popState();
                break;
            }
            default: {
                break;
            }
        }
    }
}
