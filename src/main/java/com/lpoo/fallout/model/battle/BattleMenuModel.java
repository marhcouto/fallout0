package com.lpoo.fallout.model.battle;

import com.lpoo.fallout.model.option.OptionMenuModel;

import java.util.HashMap;
import java.util.Map;

public class BattleMenuModel extends OptionMenuModel<BattleMenuModel.OPTION> {
    public enum OPTION {
        ATTACK (0, "ATTACK"),
        USE_STIMPACK (1, "USE_STIMPACK"),
        GIVE_TURN (2, "GIVE_TURN");

        private static final Map<Integer, BattleMenuModel.OPTION> BY_INDEX = new HashMap<>();
        private static final Map<String, BattleMenuModel.OPTION> BY_LABEL = new HashMap<>();

        static {
            for (BattleMenuModel.OPTION o: values()) {
                BY_INDEX.put(o.index, o);
                BY_LABEL.put(o.label, o);
            }
        }

        public final String label;
        public final Integer index;

        OPTION(Integer index, String label) {
            this.index = index;
            this.label = label;
        }

        public static BattleMenuModel.OPTION valueOfLabel(String label) {
            return BY_LABEL.get(label);
        }

        public static BattleMenuModel.OPTION valueOfIndex(Integer index) {
            return BY_INDEX.get(index);
        }
    }

    public BattleMenuModel() {
        super(OPTION.values().length);
    }

    @Override
    public OPTION getSelectedOption() {
        return OPTION.valueOfIndex(getSelectedIdx());
    }

    @Override
    public void increaseSelectedIdx() {
        if ((getSelectedIdx() % 2) == 0) {
            super.increaseSelectedIdx();
        }
    }

    @Override
    public void decreaseSelectedIdx() {
        if ((getSelectedIdx() % 2) == 1) {
            super.decreaseSelectedIdx();
        }
    }

    public void leftSelectedIdx() {
        super.setSelectedIdx(getSelectedIdx() - 2);
    }

    public void rightSelectedIdx() {
        super.setSelectedIdx(getSelectedIdx() + 2);
    }
}
