package com.lpoo.fallout.model.option.mainmenu;

import com.lpoo.fallout.model.option.OptionMenuModel;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MainMenuOptionModel extends OptionMenuModel<MainMenuOption> {
    public MainMenuOptionModel(@NotNull List<MainMenuOption> options) {
        super(options);
    }

    @Override
    public void move(DIRECTION direction) {
        switch (direction) {
            case UP: {
                decreseSelectedIdx();
                break;
            }
            case DOWN: {
                increaseSelectedIdx();
                break;
            }
            default: {
                break;
            }
        }
    }
}
