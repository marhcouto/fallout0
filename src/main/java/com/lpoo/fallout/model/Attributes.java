package com.lpoo.fallout.model;

import java.io.Serializable;

public class Attributes implements Serializable {
    private Integer strength;
    private Integer agility;
    private Integer intelligence;
    private Integer luck;

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

    public boolean validChange(Attributes attributes) {
        return this.agility + attributes.agility > 0 && this.strength + attributes.strength > 0
                 && this.intelligence + attributes.intelligence > 0 && this.luck + attributes.luck > 0;
    }

    public boolean greaterThan(Attributes attributes) {
        return this.agility >= attributes.agility && this.strength >= attributes.strength
                && this.intelligence >= attributes.intelligence && this.luck >= attributes.luck;
    }

    public void changeAttributes(Attributes attributes) throws InvalidAttributesForChangeException {
        if (!validChange(attributes)) throw new InvalidAttributesForChangeException();
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

    public static class InvalidAttributesForChangeException extends Throwable {
        private final String message;

        public InvalidAttributesForChangeException() {
            this.message = "Invalid change of attributes";
        }

        public String getMessage() {
            return message;
        }
    }
}
