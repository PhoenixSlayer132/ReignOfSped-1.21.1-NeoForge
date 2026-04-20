package com.phoenixslayer132.reignofsped.magics;

public enum ROS_DamageType {
    FIRE("fire", " was incinerated."),
    WATER("water", " couldn't hold their breath."),
    AIR("air", " was blown away."),
    EARTH("earth", " was suffocated.");

    public String getName() {
        return name;
    }

    public String getDeathMessage() {
        return deathMessage;
    }

    private final String name;
    private final String deathMessage;

    ROS_DamageType(String name, String deathMessage) {
        this.name = name;
        this.deathMessage = deathMessage;
    }
}
