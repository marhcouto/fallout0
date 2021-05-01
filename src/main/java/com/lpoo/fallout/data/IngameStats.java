package com.lpoo.fallout.data;

public class IngameStats {
    private Integer healthPoints;
    private Float dodgeChance;
    private Float missChange;
    private Integer baseDamage;
    private Float critRatio;

    public IngameStats(Integer healthPoints, Float dodgeChance, Float missChange, Integer baseDamage, Float critRatio) {
        this.healthPoints = healthPoints;
        this.dodgeChance = dodgeChance;
        this.missChange = missChange;
        this.baseDamage = baseDamage;
        this.critRatio = critRatio;
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

    public Float getMissChange() {
        return missChange;
    }

    public void setMissChange(Float missChange) {
        this.missChange = missChange;
    }

    public Integer getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(Integer baseDamage) {
        this.baseDamage = baseDamage;
    }

    public Float getCritRatio() {
        return critRatio;
    }

    public void setCritRatio(Float critRatio) {
        this.critRatio = critRatio;
    }
}
