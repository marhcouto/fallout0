package com.lpoo.fallout.data;

public class Attributes {
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

    public void boostAttributes(Attributes attributes) {
        this.strength += attributes.getStrength();
        this.agility += attributes.getAgility();
        this.intelligence += attributes.getIntelligence();
        this.luck += attributes.getLuck();
    }

    private boolean canRemoveStrenght(Attributes attributes) {
        return (this.strength >= attributes.getStrength());
    }

    private boolean canRemoveAgility(Attributes attributes) {
        return (this.agility >= attributes.getAgility());
    }

    private boolean canRemoveIntelligence(Attributes attributes) {
        return (this.intelligence >= attributes.getIntelligence());
    }

    private boolean canRemoveLuck(Attributes attributes) {
        return (this.luck >= attributes.getLuck());
    }

    public boolean validRemoval(Attributes attributes) {
        return (canRemoveStrenght(attributes) && canRemoveAgility(attributes) && canRemoveIntelligence(attributes) && canRemoveLuck(attributes));
    }

    public boolean removeAttributes(Attributes attributes) {
        if (validRemoval(attributes)) {
            this.strength -= attributes.getStrength();
            this.agility -= attributes.getAgility();
            this.intelligence -= attributes.getIntelligence();
            this.luck -= attributes.getLuck();
            return true;
        }
        return false;
    }
}
