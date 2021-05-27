package com.lpoo.fallout.model.statsmenu;

import com.lpoo.fallout.controller.statsmenu.StatsMenuController;
import com.lpoo.fallout.model.battle.BattleMenuModel;
import com.lpoo.fallout.model.option.OptionMenuModel;
import com.lpoo.fallout.model.wander.element.VaultBoy;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class StatsMenuModel extends OptionMenuModel<StatsMenuModel.OPTION> {
    private VaultBoy vaultBoy;

    public enum OPTION {
        SPEND_POINTS(0, "SPEND POINTS"),
        SAVE(1, "SAVE");

        private static final Map<Integer, StatsMenuModel.OPTION> BY_INDEX = new HashMap<>();
        private static final Map<String, StatsMenuModel.OPTION> BY_LABEL = new HashMap<>();

        static {
            for (StatsMenuModel.OPTION o: values()) {
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

        public static StatsMenuModel.OPTION valueOfLabel(String label) {
            return BY_LABEL.get(label);
        }

        public static StatsMenuModel.OPTION valueOfIndex(Integer index) {
            return BY_INDEX.get(index);
        }
    }

    public StatsMenuModel(@NotNull VaultBoy vaultBoy) {
        super(OPTION.values().length);
        this.vaultBoy = vaultBoy;
    }

    @Override
    public OPTION getSelectedOption() {
        return StatsMenuModel.OPTION.valueOfIndex(getSelectedIdx());
    }

    public VaultBoy getVaultBoy() {
        return vaultBoy;
    }
}
