package com.phoenixslayer132.reignofsped.magics.vocalmagic;

import com.phoenixslayer132.reignofsped.magics.Boon;
import com.phoenixslayer132.reignofsped.magics.MagicComponents;
import com.phoenixslayer132.reignofsped.magics.Usage;
import com.phoenixslayer132.reignofsped.magics.UsageComponents;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.enchantment.Enchantments;

import java.util.ArrayList;

import static com.phoenixslayer132.reignofsped.magics.eUsage.SELF;
import static com.phoenixslayer132.reignofsped.magics.eUsage.SUMMON;

public class VocalMagic {
    public static VocalMagic[] ROS_PRESETS = {
            new VocalMagic(MagicComponents.MagicComponentBuilder.builder()
                    .vocalCue("fah lah shi")
                    .element(MagicComponents.eElement.FIRE)
                    .usage(new Usage(SELF, UsageComponents.UsageComponentsBuilder.builder()
                            .appliesBoon(true)
                            .boon(Boon.combine(Boon.enchantMainHand(Enchantments.FIRE_ASPECT, 1),
                                    Boon.notify("You now have Fire Aspect!")))
                            .build()))
                    .build()),

            new VocalMagic(MagicComponents.MagicComponentBuilder.builder()
                    .vocalCue("fah rah shi")
                    .element(MagicComponents.eElement.FIRE)
                    .usage(new Usage(SELF, UsageComponents.UsageComponentsBuilder.builder()
                            .appliesBoon(true)
                            .boon(Boon.combine(Boon.potionEffect(MobEffects.FIRE_RESISTANCE, 20 * 60 * 5, 0),
                                    Boon.notify("You are now immune to fire damage!")))
                            .build()))
                    .build()),

            new VocalMagic(MagicComponents.MagicComponentBuilder.builder()
                    .vocalCue("fah pah shi")
                    .element(MagicComponents.eElement.FIRE)
                    .usage(new Usage(SELF, UsageComponents.UsageComponentsBuilder.builder()
                            .appliesBoon(true)
                            .boon(Boon.combine(Boon.potionEffect(MobEffects.FIRE_RESISTANCE, 20 * 60 * 30, 0),
                                    Boon.enchantMainHand(Enchantments.FIRE_ASPECT, 10),
                                    Boon.notify("You now embody Fire!")))
                            .build()
                    ))
                    .build()),

            new VocalMagic(MagicComponents.MagicComponentBuilder.builder()
                    .vocalCue("fah pah suh")
                    .element(MagicComponents.eElement.FIRE)
                    .usage(new Usage(SUMMON, UsageComponents.UsageComponentsBuilder.builder()
                            .appliesBoon(true)
                            .boon(Boon.combine(Boon.summonEntity(EntityType.BLAZE, 3),
                                    Boon.notify("You made a fiery friend!")))
                            .build()
                    ))
                    .build()),

            new VocalMagic(MagicComponents.MagicComponentBuilder.builder()
                    .vocalCue("wah lah shi")
                    .element(MagicComponents.eElement.WATER)
                    .usage(new Usage(SELF, UsageComponents.UsageComponentsBuilder.builder()
                            .appliesBoon(true)
                            .boon(Boon.combine(Boon.enchantMainHand(Enchantments.AQUA_AFFINITY, 2),
                                    Boon.notify("You now have Aqua Affinity!")))
                            .build()))
                    .build()),

            new VocalMagic(MagicComponents.MagicComponentBuilder.builder()
                    .vocalCue("wah rah shi")
                    .element(MagicComponents.eElement.WATER)
                    .usage(new Usage(SELF, UsageComponents.UsageComponentsBuilder.builder()
                            .appliesBoon(true)
                            .boon(Boon.combine(Boon.potionEffect(MobEffects.DOLPHINS_GRACE, 20 * 60 * 5, 0),
                                    Boon.notify("You now swim faster!")))
                            .build()))
                    .build()),

            new VocalMagic(MagicComponents.MagicComponentBuilder.builder()
                    .vocalCue("wah pah shi")
                    .element(MagicComponents.eElement.WATER)
                    .usage(new Usage(SELF, UsageComponents.UsageComponentsBuilder.builder()
                            .appliesBoon(true)
                            .boon(Boon.combine(Boon.potionEffect(MobEffects.CONDUIT_POWER, 20 * 60 * 60, 1),
                                    Boon.notify("You now embody Water!")))
                            .build()
                    ))
                    .build()),

            new VocalMagic(MagicComponents.MagicComponentBuilder.builder()
                    .vocalCue("wah pah suh")
                    .element(MagicComponents.eElement.WATER)
                    .usage(new Usage(SUMMON, UsageComponents.UsageComponentsBuilder.builder()
                            .appliesBoon(true)
                            .boon(Boon.combine(Boon.summonEntity(EntityType.GUARDIAN, 3),
                                    Boon.notify("You made a wet buddy!")))
                            .build()))
                    .build()),

            new VocalMagic(MagicComponents.MagicComponentBuilder.builder()
                    .vocalCue("hah lah shi")
                    .element(MagicComponents.eElement.AIR)
                    .usage(new Usage(SELF, UsageComponents.UsageComponentsBuilder.builder()
                            .appliesBoon(true)
                            .boon(Boon.combine(Boon.enchantMainHand(Enchantments.KNOCKBACK, 5),
                                    Boon.notify("Lets see them fly!")))
                            .build()))
                    .build()),

            new VocalMagic(MagicComponents.MagicComponentBuilder.builder()
                    .vocalCue("hah rah shi")
                    .element(MagicComponents.eElement.AIR)
                    .usage(new Usage(SELF, UsageComponents.UsageComponentsBuilder.builder()
                            .appliesBoon(true)
                            .boon(Boon.combine(Boon.potionEffect(MobEffects.LEVITATION, 20 * 3, 0),
                                    Boon.notify("Hopefully you just saved yourself in time!")))
                            .build()))
                    .build()),

            new VocalMagic(MagicComponents.MagicComponentBuilder.builder()
                    .vocalCue("hah pah shi")
                    .element(MagicComponents.eElement.AIR)
                    .usage(new Usage(SELF, UsageComponents.UsageComponentsBuilder.builder()
                            .appliesBoon(true)
                            .boon(Boon.combine(Boon.potionEffect(MobEffects.MOVEMENT_SPEED, 20 * 60 * 60, 1),
                                    Boon.enchantMainHand(Enchantments.KNOCKBACK, 100),
                                    Boon.notify("You now embody Air!")))
                            .build()
                    ))
                    .build()),

            new VocalMagic(MagicComponents.MagicComponentBuilder.builder()
                    .vocalCue("hah pah suh")
                    .element(MagicComponents.eElement.AIR)
                    .usage(new Usage(SUMMON, UsageComponents.UsageComponentsBuilder.builder()
                            .appliesBoon(true)
                            .boon(Boon.combine(Boon.summonEntity(EntityType.BREEZE, 3),
                                    Boon.notify("You made a gusty fellow!")))
                            .build()))
                    .build()),

            new VocalMagic(MagicComponents.MagicComponentBuilder.builder()
                    .vocalCue("gah lah shi")
                    .element(MagicComponents.eElement.EARTH)
                    .usage(new Usage(SELF, UsageComponents.UsageComponentsBuilder.builder()
                            .appliesBoon(true)
                            .boon(Boon.combine(Boon.enchantMainHand(Enchantments.SILK_TOUCH, 1),
                                    Boon.notify("You now have Silk Touch!")))
                            .build()))
                    .build()),

            new VocalMagic(MagicComponents.MagicComponentBuilder.builder()
                    .vocalCue("gah rah shi")
                    .element(MagicComponents.eElement.EARTH)
                    .usage(new Usage(SELF, UsageComponents.UsageComponentsBuilder.builder()
                            .appliesBoon(true)
                            .boon(Boon.combine(Boon.potionEffect(MobEffects.HEALTH_BOOST, 20 * 60 * 5, 2),
                                    Boon.potionEffect(MobEffects.REGENERATION, 5, 7),
                                    Boon.notify("1UP!")))
                            .build()))
                    .build()),

            new VocalMagic(MagicComponents.MagicComponentBuilder.builder()
                    .vocalCue("gah pah shi")
                    .element(MagicComponents.eElement.EARTH)
                    .usage(new Usage(SELF, UsageComponents.UsageComponentsBuilder.builder()
                            .appliesBoon(true)
                            .boon(Boon.combine(Boon.potionEffect(MobEffects.DAMAGE_RESISTANCE, 20 * 60 * 60, 2),
                                    Boon.enchantMainHand(Enchantments.BLAST_PROTECTION, 10),
                                    Boon.notify("You now embody Earth!")))
                            .build()
                    ))
                    .build()),

            new VocalMagic(MagicComponents.MagicComponentBuilder.builder()
                    .vocalCue("gah pah suh")
                    .element(MagicComponents.eElement.EARTH)
                    .usage(new Usage(SUMMON, UsageComponents.UsageComponentsBuilder.builder()
                            .appliesBoon(true)
                            .boon(Boon.combine(Boon.summonEntity(EntityType.IRON_GOLEM, 3),
                                    Boon.notify("You made a tuff guy!")))
                            .build()
                    ))
                    .build()),
    };

    ArrayList<VocalMagic> CUSTOM_PRESETS = new ArrayList<>();

    private MagicComponents magicComponents;

    public VocalMagic(MagicComponents magicComponents){
        this.magicComponents = magicComponents;
    }

    public MagicComponents getMagicComponents(){
        return this.magicComponents;
    }
}
