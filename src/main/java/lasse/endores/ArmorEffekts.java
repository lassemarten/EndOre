package lasse.endores;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;

public class ArmorEffekts {

    public static void initialize() {
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            for (ServerPlayer player : server.getPlayerList().getPlayers()) {
                END_LEGGINGS_EFFEKT(player);
                END_BOOTS_EFFEKT(player);
                END_HELMET_EFFEKT(player);
            }
        });
    }
    public static void END_LEGGINGS_EFFEKT(ServerPlayer player){
        if (player.getItemBySlot(EquipmentSlot.LEGS).is(ModItems.END_LEGGINGS)) {
            MobEffectInstance current = player.getEffect(MobEffects.SPEED);
            // nur auffrischen, wenn der Effekt fehlt oder bald ausläuft
            if (current == null || current.getDuration() < 20) {
                player.addEffect(new MobEffectInstance(
                        MobEffects.SPEED,
                        60,     // Dauer in Ticks (3 Sekunden)
                        1,      // Stufe: 0 = Schnelligkeit I, 1 = II
                        false,   // ambient (dezente Partikel)
                        false,  //  Partikel anzeigen
                        false    // Symbol oben rechts anzeigen
                ));
            }
        }
    }
    public static void END_BOOTS_EFFEKT(ServerPlayer player){
        if (player.getItemBySlot(EquipmentSlot.FEET).is(ModItems.END_BOOTS)) {
            MobEffectInstance current = player.getEffect(MobEffects.JUMP_BOOST);
            // nur auffrischen, wenn der Effekt fehlt oder bald ausläuft
            if (current == null || current.getDuration() < 20) {
                player.addEffect(new MobEffectInstance(
                        MobEffects.JUMP_BOOST,
                        60,     // Dauer in Ticks (3 Sekunden)
                        1,      // Stufe: 0 = Jumpboost I, 1 = II
                        false,   // ambient (dezente Partikel)
                        false,  //  Partikel anzeigen
                        false    // Symbol oben rechts anzeigen
                ));
            }
        }
    }
    public static void END_HELMET_EFFEKT(ServerPlayer player){
        if (player.getItemBySlot(EquipmentSlot.HEAD).is(ModItems.END_HELMET)) {
            MobEffectInstance current = player.getEffect(MobEffects.NIGHT_VISION);
            // nur auffrischen, wenn der Effekt fehlt oder bald ausläuft
            if (current == null || current.getDuration() < 215) {
                player.addEffect(new MobEffectInstance(
                        MobEffects.NIGHT_VISION,
                        240,     // Dauer in Ticks (12 Sekunden) (wegen blinken)
                        0,      // Stufe: 0 = Schnelligkeit I, 1 = II
                        false,   // ambient (dezente Partikel)
                        false,  //  Partikel anzeigen
                        false    // Symbol oben rechts anzeigen
                ));
            }
        }
    }
}