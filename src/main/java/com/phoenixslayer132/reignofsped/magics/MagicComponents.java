package com.phoenixslayer132.reignofsped.magics;

public class MagicComponents{
    private MagicComponents(){}

    private eElement eElement;
    private float manaCost;
    private Usage usage;
    private long duration;
    private long cooldown;
    private boolean isAttack;
    private String vocalCue;

    public String getVocalCue() {
        return vocalCue;
    }

    public eElement getElement() {
        return eElement;
    }

    public float getManaCost() {
        return manaCost;
    }

    public Usage getUsage() {
        return usage;
    }

    public long getDuration() {
        return duration;
    }

    public long getCooldown() {
        return cooldown;
    }
    public boolean isAttack(){
        return isAttack;
    }

    public static class MagicComponentBuilder{
        private MagicComponents components;

        public static MagicComponentBuilder builder(){
            MagicComponentBuilder builder = new MagicComponentBuilder();
            builder.components = new MagicComponents();
            return builder;
        }
        public MagicComponentBuilder element(eElement eElement){
            this.components.eElement = eElement;
            return this;
        }
        public MagicComponentBuilder manaCost(float manaCost){
            this.components.manaCost = manaCost;
            return this;
        }
        public MagicComponentBuilder usage(Usage usage){
            this.components.usage = usage;
            return this;
        }
        public MagicComponentBuilder duration(long duration){
            this.components.duration = duration;
            return this;
        }
        public MagicComponentBuilder cooldown(long cooldown){
            this.components.cooldown = cooldown;
            return this;
        }
        public MagicComponentBuilder isAttack(boolean isAttack){
            this.components.isAttack = isAttack;
            return this;
        }
        public MagicComponentBuilder vocalCue(String vocalCue){
            this.components.vocalCue = vocalCue;
            return this;
        }
        public MagicComponents build(){
            return this.components;
        }
    }

    public enum eElement {
        FIRE("fire", ROS_DamageType.FIRE),
        WATER("water", ROS_DamageType.WATER),
        AIR("air", ROS_DamageType.AIR),
        EARTH("earth", ROS_DamageType.EARTH);

        public String getName() {
            return name;
        }


        public ROS_DamageType getDamageType() {
            return damageType;
        }

        private final String name;
        private final ROS_DamageType damageType;

        eElement(String name, ROS_DamageType damageType) {
            this.name = name;
            this.damageType = damageType;
        }
    }

}
