package me.gonkas.zombieplayers.entity.client.model;

import me.gonkas.zombieplayers.entity.ZombifiedPlayerEntity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.PlayerEntityModel;

public class ZombifiedPlayerEntityModel<T extends ZombifiedPlayerEntity> extends PlayerEntityModel<T> {
    public ZombifiedPlayerEntityModel(ModelPart root, boolean thinArms) {
        super(root, thinArms);
    }
}
