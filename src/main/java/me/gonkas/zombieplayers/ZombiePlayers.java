package me.gonkas.zombieplayers;

import me.gonkas.zombieplayers.registry.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.WardenEntity;
import net.minecraft.particle.ParticleTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZombiePlayers implements ModInitializer {

	public static final String MODID = "zombieplayers";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	@Override
	public void onInitialize() {

		ZombiePlayerBlockEntities.registerBlockEntities();
		ZombiePlayersEnchantments.registerEnchantments();
		ZombiePlayersEntities.registerEntities();
		ZombiePlayersBlocks.registerBlocks();
		ZombiePlayersItems.registerItems();
		ZombiePlayersTags.registerTags();

		ServerLivingEntityEvents.AFTER_DEATH.register((entity, damageSource) -> {
			if (entity instanceof WardenEntity) {
				createSculkCloudOnWardenDeath(entity);
            }
		});
	}

	public static void logRegistration(String type) {
        LOGGER.info("Registering {} for mod " + MODID, type);
	}

	private static void createSculkCloudOnWardenDeath(LivingEntity entity) {

		AreaEffectCloudEntity areaEffectCloudEntity = new AreaEffectCloudEntity(entity.getWorld(), entity.getX(), entity.getY(), entity.getZ());
		areaEffectCloudEntity.setOwner(entity);
		areaEffectCloudEntity.setParticleType(ParticleTypes.SCULK_SOUL);
		areaEffectCloudEntity.setRadius(1.5f);
		areaEffectCloudEntity.setDuration(300);
		areaEffectCloudEntity.setRadiusGrowth(-1.0f / (float) areaEffectCloudEntity.getDuration());
		areaEffectCloudEntity.addEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 100, 0));

		entity.getWorld().spawnEntity(areaEffectCloudEntity);
	}
}