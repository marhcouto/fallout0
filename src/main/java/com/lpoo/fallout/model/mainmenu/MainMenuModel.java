package com.lpoo.fallout.model.mainmenu;

import com.lpoo.fallout.model.option.OptionMenuModel;
import com.lpoo.fallout.model.wander.Attributes;

import java.util.HashMap;
import java.util.Map;

public class MainMenuModel extends OptionMenuModel<MainMenuModel.OPTION> {
    private final Attributes attributes;

    public enum OPTION {
        STRENGTH(0, Attributes.OPTION.STRENGTH.label),
        AGILITY (1, Attributes.OPTION.AGILITY.label),
        INTELLIGENCE(2, Attributes.OPTION.INTELLIGENCE.label),
        LUCK (3, Attributes.OPTION.LUCK.label),
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
        attributes = new Attributes(2, 2, 2, 2);
    }

    public Attributes getAttributes() {
        return attributes;
    }

    @Override
    public OPTION getSelectedOption() {
        return OPTION.valueOfIndex(getSelectedIdx());
    }
}
