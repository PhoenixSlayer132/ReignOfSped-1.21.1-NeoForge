package com.phoenixslayer132.reignofsped.magics;

import com.phoenixslayer132.reignofsped.magics.vocalmagic.FIMagicEffect;

public class UsageComponents {
    private UsageComponents() {}

    private boolean appliesBoon;

    public boolean isAppliesBoon() {
        return appliesBoon;
    }

    public boolean isDealsDamage() {
        return dealsDamage;
    }

    public FIMagicEffect getBoon() {
        return boon;
    }

    public Runnable getDamage() {
        return damage;
    }

    private boolean dealsDamage;

    private FIMagicEffect boon;
    private Runnable damage;


    public static class UsageComponentsBuilder {
        private UsageComponents components;

        public static UsageComponentsBuilder builder() {
            UsageComponentsBuilder builder = new UsageComponentsBuilder();
            builder.components = new UsageComponents();
            return builder;
        }

        public UsageComponentsBuilder appliesBoon(boolean appliesBoon){
            this.components.appliesBoon = appliesBoon;
            return this;
        }
        public UsageComponentsBuilder dealsDamage(boolean dealsDamage){
            this.components.dealsDamage = dealsDamage;
            return this;
        }

        public UsageComponentsBuilder boon(FIMagicEffect boon){
            this.components.boon = boon;
            return this;
        }
        public UsageComponentsBuilder damage(Runnable damage){
            this.components.damage = damage;
            return this;
        }

        public UsageComponents build(){
            return this.components;
        }

    }


}
