package com.lpoo.fallout.model.wander;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Attributes implements Serializable {
    private Integer strength;
    private Integer agility;
    private Integer intelligence;
    private Integer luck;

    public enum OPTION {
        STRENGTH(0, "STRENGTH"),
        AGILITY (1, "AGILITY"),
        INTELLIGENCE(2, "INTELLIGENCE"),
        LUCK (3, "LUCK");

        private static final Map<Integer, Attributes.OPTION> BY_INDEX = new HashMap<>();
        private static final Map<String, Attributes.OPTION> BY_LABEL = new HashMap<>();

        static {
            for (Attributes.OPTION o: values()) {
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

        public static boolean contains(String label) {
            return BY_LABEL.get(label) != null;
        }

        public static Attributes.OPTION valueOfLabel(String label) {
            return BY_LABEL.get(label);
        }

        public static Attributes.OPTION valueOfIndex(Integer index) {
            return BY_INDEX.get(index);
        }
    }

    public Attributes() {
        this(1, 1, 1, 1);
    }

    public Attributes(Integer strength, Integer agility, Integer intelligence, Integer luck) {
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.luck = luck;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getAgility() {
        return agility;
    }

    public void setAgility(Integer agility) {
        this.agility = agility;
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
    }

    public Integer getLuck() {
        return luck;
    }

    public void setLuck(Integer luck) {
        this.luck = luck;
    }

    public boolean greaterThan(Attributes attributes) {
        return this.agility >= attributes.agility && this.strength >= attributes.strength
                && this.intelligence >= attributes.intelligence && this.luck >= attributes.luck;
    }

    public void changeAttributes(Attributes attributes)  {
        this.strength += attributes.getStrength();
        this.agility += attributes.getAgility();
        this.intelligence += attributes.getIntelligence();
        this.luck += attributes.getLuck();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o.getClass() != this.getClass()) return false;
        if (o == null) return false;

        Attributes a = (Attributes) o;
        return a.getAgility().equals(this.agility) && a.getIntelligence().equals(this.getIntelligence()) &&
                a.getStrength().equals(this.getStrength()) && a.getLuck().equals(this.getLuck());
    }

    public Integer getValue(OPTION option) {
        switch (option) {
            case STRENGTH:
                return getStrength();
            case AGILITY:
                return getAgility();
            case LUCK:
                return getLuck();
            case INTELLIGENCE:
                return getIntelligence();
            default:
                return -1;
        }
    }

}
