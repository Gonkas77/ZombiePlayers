package me.gonkas.zombieplayers.entities;

import com.mojang.authlib.GameProfile;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.scoreboard.AbstractTeam;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ZombifiedPlayer extends PlayerEntity {

    public ZombifiedPlayer(World world, BlockPos pos, float yaw, GameProfile gameProfile) {
        super(world, pos, yaw, gameProfile);
    }

    @Override
    public boolean isSpectator() {
        try {return this.isCollidable() || !this.getScoreboardTeam().getCollisionRule().equals(AbstractTeam.CollisionRule.NEVER);}
        catch (NullPointerException ignored) {return false;}
    }

    @Override
    public boolean isCreative() {
        return this.isInCreativeMode();
    }
}
