package com.phoenixslayer132.reignofsped.magics;

public class Usage {
    private UsageComponents usageComponents;
    eUsage eUsage;

    public Usage(eUsage eUsage, UsageComponents usageComponents) {
        this.eUsage = eUsage;
        this.usageComponents = usageComponents;
    }

    public UsageComponents getUsageComponents() {
        return usageComponents;
    }
}
