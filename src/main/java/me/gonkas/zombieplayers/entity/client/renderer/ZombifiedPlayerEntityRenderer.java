package me.gonkas.zombieplayers.entity.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.PlayerEntityRenderer;

public class ZombifiedPlayerEntityRenderer extends PlayerEntityRenderer {
    public ZombifiedPlayerEntityRenderer(EntityRendererFactory.Context ctx, boolean slim) {
        super(ctx, slim);
    }
}
