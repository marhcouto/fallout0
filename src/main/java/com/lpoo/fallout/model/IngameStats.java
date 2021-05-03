package com.lpoo.fallout.model;

public class IngameStats {
    private Integer healthPoints;
    private Float dodgeChance;
    private Float missChance;
    private Integer baseDamage;
    private Float critRatio;

    public IngameStats(Integer healthPoints, Float dodgeChance, Float missChange, Integer baseDamage, Float critRatio) {
        this.healthPoints = healthPoints;
        this.dodgeChance = dodgeChance;
        this.missChance = missChange;
        this.baseDamage = baseDamage;
        this.critRatio = critRatio;
    }

    public IngameStats(Character character) {
        this.healthPoints = character.getAttributes().getStrength() * character.getLevel();
        this.dodgeChance = (float) (character.getAttributes().getIntelligence() / 100);
        this.missChance = (float) ((100 - character.getAttributes().getLuck()) / 100);
        this.baseDamage = character.getWeapon().getDamage();
        this.critRatio = (float) (character.getAttributes().getIntelligence() / 100 + character.getAttributes().getLuck() / 100);
    }

    public Integer getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(Integer healthPoints) {
        this.healthPoints = healthPoints;
    }

    public Float getdodgeChance() {
        return dodgeChance;
    }

    public void setdodgeChance(Float dodgeChance) {
        this.dodgeChance = dodgeChance;
    }

    public Float getMissChance() {
        return missChance;
    }

    public void setMissChance(Float missChance) {
        this.missChance = missChance;
    }

    public Integer getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(Integer baseDamage) {
        this.baseDamage = baseDamage;
    }

    public Float getCritRatio() { return critRatio; }

    public void setCritRatio(Float critRatio) {
        this.critRatio = critRatio;
    }

    /*public void caculateStats(Character character) {
        this.healthPoints = character.getAttributes().getStrength() * character.getLevel();
        this.dodgeChance = (float) (character.getAttributes().getIntelligence() / 100);
        this.missChance = (float) ((100 - character.getAttributes().getLuck()) / 100);
        this.baseDamage = character.getWeapon().getDamage();
        this.critRatio = (float) (character.getAttributes().getIntelligence() / 100 + character.getAttributes().getLuck() / 100);
        return this;
    }*/
}
