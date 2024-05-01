package com.zhilizhan.bhtpvz.client.model.entity.plant.defence;

import com.hungteen.pvz.client.model.entity.plant.PVZPlantModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.zhilizhan.bhtpvz.common.entity.plant.defence.SelfImitaterEntity;
import net.minecraft.client.model.geom.ModelPart;

public class SelfImitaterModel extends PVZPlantModel<SelfImitaterEntity> {
    private final ModelPart total;
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart cube_r1;
    private final ModelPart cube_r2;
    private final ModelPart hands;
    private final ModelPart hand1;
    private final ModelPart hand2;
    private final ModelPart hand3;
    private final ModelPart hand4;
    private final ModelPart hand4_r1;
    private final ModelPart face;
    private final ModelPart cube_r3;
    private final ModelPart getPlantWholeBody;

    public SelfImitaterModel() {
        texWidth = 64;
        texHeight = 64;

        total = new ModelPart(this);
        total.setPos(0.0F, 24.0F, 0.0F);


        body = new ModelPart(this);
        body.setPos(0.0F, 0.0F, 0.0F);
        total.addChild(body);
        body.texOffs(0, 53).addBox(-4.5F, -17.0F, -3.0F, 9.0F, 5.0F, 6.0F, 0.0F, false);
        body.texOffs(30, 52).addBox(-4.5F, -6.25F, -3.0F, 9.0F, 6.0F, 6.0F, 0.4F, false);
        body.texOffs(0, 41).addBox(-4.5F, -12.25F, -3.0F, 9.0F, 6.0F, 6.0F, 0.2F, false);

        head = new ModelPart(this);
        head.setPos(0.0F, -17.0F, 0.0F);
        total.addChild(head);
        head.texOffs(0, 57).addBox(-1.0F, -2.25F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r1 = new ModelPart(this);
        cube_r1.setPos(-1.5F, -0.75F, -1.5F);
        head.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.0F, 0.0F, -0.1309F);
        cube_r1.texOffs(48, 35).addBox(-4.0F, 0.0F, -2.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);

        cube_r2 = new ModelPart(this);
        cube_r2.setPos(-0.75F, -0.5F, -1.5F);
        head.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.0F, 0.0F, -0.1309F);
        cube_r2.texOffs(32, 43).addBox(-4.0F, -1.0F, -2.0F, 9.0F, 2.0F, 7.0F, 0.1F, false);

        hands = new ModelPart(this);
        hands.setPos(0.0F, 0.0F, 0.0F);
        total.addChild(hands);


        hand1 = new ModelPart(this);
        hand1.setPos(-4.0F, -10.0F, 0.0F);
        hands.addChild(hand1);
        setRotationAngle(hand1, 0.0F, 0.0F, 0.3054F);
        hand1.texOffs(56, 56).addBox(-3.0F, -1.0F, 0.0F, 3.0F, 1.0F, 1.0F, -0.25F, false);

        hand2 = new ModelPart(this);
        hand2.setPos(-4.0F, -5.0F, 0.0F);
        hands.addChild(hand2);
        setRotationAngle(hand2, 0.0F, 0.48F, -0.1745F);
        hand2.texOffs(56, 54).addBox(-3.0F, -1.0F, 0.0F, 3.0F, 1.0F, 1.0F, -0.25F, false);

        hand3 = new ModelPart(this);
        hand3.setPos(4.0F, -3.0F, 0.0F);
        hands.addChild(hand3);
        setRotationAngle(hand3, 0.0F, -2.6616F, 0.6981F);
        hand3.texOffs(56, 52).addBox(-3.0F, -1.0F, 0.0F, 3.0F, 1.0F, 1.0F, -0.25F, false);

        hand4 = new ModelPart(this);
        hand4.setPos(3.0F, -14.0F, 2.0F);
        hands.addChild(hand4);
        setRotationAngle(hand4, 0.0F, 2.7053F, 0.6981F);


        hand4_r1 = new ModelPart(this);
        hand4_r1.setPos(-3.0F, 14.0F, -2.0F);
        hand4.addChild(hand4_r1);
        setRotationAngle(hand4_r1, 0.1745F, 0.0F, 0.0F);
        hand4_r1.texOffs(28, 56).addBox(0.0F, -14.0F, 5.0F, 3.0F, 1.0F, 1.0F, -0.25F, false);

        face = new ModelPart(this);
        face.setPos(0.0F, -18.0F, 0.5F);
        total.addChild(face);
        face.texOffs(31, 46).addBox(-3.5F, 2.0F, -4.0F, 3.0F, 3.0F, 1.0F, -0.45F, false);
        face.texOffs(32, 53).addBox(-2.5F, 3.0F, -3.85F, 1.0F, 1.0F, 1.0F, -0.25F, false);
        face.texOffs(32, 53).addBox(1.5F, 3.0F, -3.85F, 1.0F, 1.0F, 1.0F, -0.25F, false);
        face.texOffs(24, 43).addBox(0.5F, 2.0F, -4.0F, 3.0F, 3.0F, 1.0F, -0.45F, false);

        cube_r3 = new ModelPart(this);
        cube_r3.setPos(2.0F, 4.5F, -3.5F);
        face.addChild(cube_r3);
        setRotationAngle(cube_r3, -0.0436F, 0.0F, 0.0F);
        cube_r3.texOffs(0, 54).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 2.0F, 1.0F, -0.45F, false);
        cube_r3.texOffs(32, 53).addBox(-4.5F, -0.5F, -0.5F, 1.0F, 2.0F, 1.0F, -0.45F, false);

        getPlantWholeBody = new ModelPart(this);
        getPlantWholeBody.setPos(0.0F, 0.0F, 0.0F);

    }

    @Override
    public void setupAnim(SelfImitaterEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        if (entity.isAlive()&&entity.isImitating()&&entity.getImitaterChance()>0) {
            this.total.yRot = ageInTicks / 3.0F;
        }
    }
    @Override
    public void renderToBuffer(PoseStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        total.render(matrixStack, buffer, packedLight, packedOverlay);
    }
    public void setRotationAngle(ModelPart modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
    @Override
    public ModelPart getPlantWholeBody() {
        return this.total;
    }
}
    