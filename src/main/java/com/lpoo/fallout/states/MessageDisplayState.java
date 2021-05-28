package com.lpoo.fallout.states;

import com.lpoo.fallout.controller.MainController;
import com.lpoo.fallout.controller.messagedisplay.MessageDisplayController;
import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.messagedisplay.MessageDisplayModel;
import com.lpoo.fallout.view.Viewer;
import com.lpoo.fallout.view.messagedisplay.MessageDisplayViewer;
import org.jetbrains.annotations.NotNull;

public class MessageDisplayState extends State<MessageDisplayModel> {
    public MessageDisplayState(MessageDisplayModel model) {
        super(model);
    }

    @Override
    protected @NotNull MainController<MessageDisplayModel> getController() {
        return new MessageDisplayController(getModel());
    }

    @Override
    public @NotNull MessageDisplayModel getModel() {
        return super.getModel();
    }

    @Override
    protected @NotNull Viewer<MessageDisplayModel, LanternaGUI> getViewer() {
        return new MessageDisplayViewer(getModel());
    }
}
