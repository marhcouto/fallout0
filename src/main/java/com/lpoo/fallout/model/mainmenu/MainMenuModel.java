package com.lpoo.fallout.model.mainmenu;

import com.lpoo.fallout.model.option.OptionMenuModel;
import com.lpoo.fallout.model.wander.Attributes;

import java.util.HashMap;
import java.util.Map;

public class MainMenuModel extends OptionMenuModel<MainMenuModel.OPTION> {
    private final Attributes attributes;

    public enum OPTION {
        STRENGTH(0, "STRENGTH"),
        AGILITY (1, "AGILITY"),
        INTELLIGENCE(2, "INTELLIGENCE"),
        LUCK (3, "LUCK"),
        NEXT (4, "NEXT");

        private static final Map<Integer, OPTION> BY_INDEX = new HashMap<>();
        private static final Map<String, OPTION> BY_LABEL = new HashMap<>();

        static {
            for (OPTION o: values()) {
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

        public static OPTION valueOfLabel(String label) {
            return BY_LABEL.get(label);
        }

        public static OPTION valueOfIndex(Integer index) {
            return BY_INDEX.get(index);
        }
    }

    public MainMenuModel() {
        super(OPTION.values().length);
        attributes = new Attributes();
    }

    public Attributes getAttributes() {
        return attributes;
    }

    @Override
    public OPTION getSelectedOption() {
        return OPTION.valueOfIndex(getSelectedIdx());
    }

    public Integer getValue(OPTION option) {
        switch (option) {
            case STRENGTH:
                return attributes.getStrength();
            case AGILITY:
                return attributes.getAgility();
            case LUCK:
                return attributes.getLuck();
            case INTELLIGENCE:
                return attributes.getIntelligence();
            default:
                return -1;
        }
    }
}
