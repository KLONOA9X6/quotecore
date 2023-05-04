package net.quotecore.client.renderer.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

@Environment(EnvType.CLIENT)
public class SoulEnergyExoskeletonModel<T extends Entity> extends EntityModel<T> {
    public SoulEnergyExoskeletonModel(ModelPart root) {
        super();
    }

    public static TexturedModelData getTexturedModelData() {    // 淦，这写的什么玩意
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();

        ModelPartData armorBody = modelPartData.addChild("armorBody", ModelPartBuilder.create().uv(0,0).cuboid(-5.0F,-1.0F,-3.0F,10.0F,14.0F,6.0F, new Dilation(0.0F)),ModelTransform.pivot(0.0F,0.0F,0.0F));
        ModelPartData bone = armorBody.addChild("bone", ModelPartBuilder.create().uv(0,29).cuboid(-2.0F,9.0F,-4.0F,4.0F,3.0F,1.0F,new Dilation(0.0F))
                .uv(0,20).cuboid(-5.0F,0.0F,-2.0F,10.0F,5.0F,4.0F,new Dilation(0.0F)),ModelTransform.pivot(0.0F,0.0F,0.0F));
        ModelPartData c_r1 = bone.addChild("c_r1",ModelPartBuilder.create().uv(0,29).cuboid(-2.0F, 9.0F, -4.0F, 4.0F, 3.0F, 1.0F, new Dilation(0.0F)),ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));
        ModelPartData arm = armorBody.addChild("arm",ModelPartBuilder.create(), ModelTransform.pivot(0.0F,0.0F,0.0F));
        ModelPartData right = arm.addChild("right",ModelPartBuilder.create(),ModelTransform.pivot(0.0F,0.0F,0.0F));
        ModelPartData right_2_r1 = right.addChild("right_2_r1",ModelPartBuilder.create().uv(0,52).cuboid(4.0F, -3.0F, 3.0F, 5.0F, 2.0F, 1.0F,new Dilation(0.0F))
                .uv(0,55).cuboid(8.0F, -3.0F, 2.0F, 1.0F, 2.0F, 1.0F,new Dilation(0.0F))
                .uv(12,29).cuboid(8.0F, -4.0F, -2.0F, 1.0F, 4.0F, 4.0F,new Dilation(0.0F)),ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.1416F));
        ModelPartData left = arm.addChild("left",ModelPartBuilder.create().uv(12,29).cuboid(8.0F, 0.0F, -2.0F, 1.0F, 4.0F, 4.0F,new Dilation(0.0F))
                .uv(0,52).cuboid(4.0F, 1.0F, 3.0F, 5.0F, 2.0F, 1.0F,new Dilation(0.0F))
                .uv(0,55).cuboid(8.0F, 1.0F, 2.0F, 1.0F, 2.0F, 1.0F,new Dilation(0.0F)),ModelTransform.pivot(0.0F,0.0F,0.0F));

        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {

    }
}
