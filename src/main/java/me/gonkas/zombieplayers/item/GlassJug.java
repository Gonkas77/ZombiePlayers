package me.gonkas.zombieplayers.item;

import me.gonkas.zombieplayers.registry.ZombiePlayersItems;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.mob.WardenEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import java.util.List;

public class GlassJug extends Item {
    public GlassJug(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        List<AreaEffectCloudEntity> list = world.getEntitiesByClass(
                AreaEffectCloudEntity.class,
                user.getBoundingBox().expand(2.0),
                entity -> entity != null && entity.isAlive() && entity.getOwner() instanceof WardenEntity
        );
        ItemStack itemStack = user.getStackInHand(hand);
        if (!list.isEmpty()) {
            AreaEffectCloudEntity areaEffectCloudEntity = list.getFirst();
            areaEffectCloudEntity.setRadius(areaEffectCloudEntity.getRadius() - 0.5F);
            world.playSound(null, user.getX(), user.getY(), user.getZ(),
                    SoundEvents.ITEM_BOTTLE_FILL_DRAGONBREATH, SoundCategory.NEUTRAL, 1.0F, 0.7F);
            world.emitGameEvent(user, GameEvent.FLUID_PICKUP, user.getPos());
            if (user instanceof ServerPlayerEntity serverPlayerEntity) {
                Criteria.PLAYER_INTERACTED_WITH_ENTITY.trigger(serverPlayerEntity, itemStack, areaEffectCloudEntity);
            }

            return TypedActionResult.success(this.fill(itemStack, user, new ItemStack(ZombiePlayersItems.SCULK_ENERGY)), world.isClient());
        } else {return TypedActionResult.pass(itemStack);}
    }

    protected ItemStack fill(ItemStack stack, PlayerEntity player, ItemStack outputStack) {
        player.incrementStat(Stats.USED.getOrCreateStat(this));
        return ItemUsage.exchangeStack(stack, player, outputStack);
    }
}
