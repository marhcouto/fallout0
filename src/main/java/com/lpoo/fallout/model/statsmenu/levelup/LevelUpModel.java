package com.lpoo.fallout.model.statsmenu.levelup;

import com.lpoo.fallout.model.option.OptionMenuModel;
import com.lpoo.fallout.model.wander.Attributes;
import com.lpoo.fallout.model.wander.element.VaultBoy;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class LevelUpModel extends OptionMenuModel<LevelUpModel.OPTION> {
    private final VaultBoy vaultBoy;
    private final Attributes newAttributes;
    private int usedLevel;

    public enum OPTION {
        STRENGTH(0, Attributes.OPTION.STRENGTH.label),
        AGILITY (1, Attributes.OPTION.AGILITY.label),
        INTELLIGENCE(2, Attributes.OPTION.INTELLIGENCE.label),
        LUCK (3, Attributes.OPTION.LUCK.label),
        NEXT (4, "COMMIT");

        private static final Map<Integer, LevelUpModel.OPTION> BY_INDEX = new HashMap<>();
        private static final Map<String, LevelUpModel.OPTION> BY_LABEL = new HashMap<>();

        static {
            for (LevelUpModel.OPTION o: values()) {
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

        public static LevelUpModel.OPTION valueOfLabel(String label) {
            return BY_LABEL.get(label);
        }

        public static LevelUpModel.OPTION valueOfIndex(Integer index) {
            return BY_INDEX.get(index);
        }
    }

    public LevelUpModel(@NotNull VaultBoy vaultBoy) {
        super(OPTION.values().length);
        this.vaultBoy = vaultBoy;
        newAttributes = new Attributes(0, 0, 0, 0);
        usedLevel = 0;
    }

    public boolean useLevel() {
        if (usedLevel < vaultBoy.getUnusedLevelPoints()) {
            usedLevel++;
            return true;
        }
        return false;
    }

    public void freeLevel() {
        if (usedLevel > 0) {
            usedLevel--;
        }
    }

    public int getUsedLevel() {
        return usedLevel;
    }

    @Override
    public OPTION getSelectedOption() {
        return OPTION.valueOfIndex(getSelectedIdx());
    }

    public VaultBoy getVaultBoy() {
        return vaultBoy;
    }

    public Attributes getNewAttributes() {
        return newAttributes;
    }
}
