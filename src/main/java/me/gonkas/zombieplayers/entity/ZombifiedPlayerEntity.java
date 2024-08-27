package me.gonkas.zombieplayers.entity;

import com.mojang.authlib.GameProfile;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.scoreboard.AbstractTeam;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ZombifiedPlayerEntity extends PlayerEntity {

    public ZombifiedPlayerEntity(World world, BlockPos pos, float yaw, GameProfile gameProfile) {
        super(world, pos, yaw, gameProfile);
    }

    public ZombifiedPlayerEntity(PlayerEntity player) {
        super(player.getWorld(), player.getBlockPos(), player.headYaw, player.getGameProfile());
    }

    @Override
    public boolean isSpectator() {

        // check if player isnt collidable and there is no rule saying they shouldnt be (basically only state possible is spectator mode)
        try {if (!this.isCollidable() && !this.getScoreboardTeam().getCollisionRule().equals(AbstractTeam.CollisionRule.NEVER)) {return true;}
        } catch (NullPointerException ignored) {return true;} // if no team exists, then no rules exists

        if (this.isAdventure()) {return false;}
        if (this.isCreative()) {return false;}
        return this.getAbilities().flying && this.getAbilities().invulnerable; // if player is flying and not in creative, must be in spectator
    }

    @Override
    public boolean isCreative() {
        return this.isInCreativeMode();
    }

    public boolean isAdventure() {
        return !this.getAbilities().allowModifyWorld;
    }
}
