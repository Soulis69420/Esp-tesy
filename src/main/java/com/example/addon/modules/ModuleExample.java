package com.example.modules;

import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.meteorclient.systems.modules.categories.Category;
import meteordevelopment.meteorclient.events.render.Render3DEvent;
import meteordevelopment.meteorclient.utils.render.color.Color;
import meteordevelopment.meteorclient.utils.render.RenderUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.ItemFrameEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.boss.WitherEntity;
import meteordevelopment.orbit.EventHandler;

public class ExtraESP extends Module {
    public ExtraESP() {
        super(Category.Render, "extra-esp", "Highlights extra entities such as items, projectiles, and bosses.");
    }

    @EventHandler
    private void onRender(Render3DEvent event) {
        for (Entity entity : mc.world.getEntities()) {
            if (entity instanceof ItemEntity || entity instanceof ProjectileEntity || entity instanceof WitherEntity || entity instanceof ItemFrameEntity) {
                RenderUtils.drawBox(entity.getBoundingBox(), new Color(255, 0, 0, 100));
            }
        }
    }
}
