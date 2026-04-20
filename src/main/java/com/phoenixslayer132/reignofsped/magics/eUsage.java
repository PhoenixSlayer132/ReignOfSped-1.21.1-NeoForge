package com.phoenixslayer132.reignofsped.magics;

public enum eUsage {
    PROJECTILE("projectile"),
    SELF("self"),
    AOE("area_of_effect"),
    GROUND("ground"),
    SUMMON("summon");

    eUsage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private final String name;
}