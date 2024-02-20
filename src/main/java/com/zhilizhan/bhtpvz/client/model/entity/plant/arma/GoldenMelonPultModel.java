package com.zhilizhan.bhtpvz.client.model.entity.plant.arma;

import com.hungteen.pvz.client.model.entity.plant.PVZPlantModel;
import com.zhilizhan.bhtpvz.common.entity.plant.arma.GoldenMelonPultEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;

public class GoldenMelonPultModel extends PVZPlantModel<GoldenMelonPultEntity> {
    private final ModelPart total;
    private final ModelPart nw_r1;
    private final ModelPart sw_r1;
    private final ModelPart se_r1;
    private final ModelPart ne_r1;
    private final ModelPart pult;
    private final ModelPart bone;
    private final ModelPart melon;
    private final ModelPart getPlantWholeBody;

    public GoldenMelonPultModel() {
        texWidth = 64;
        texHeight = 64;

        total = new ModelPart(this);
        total.setPos(0.0F, 24.0F, 0.0F);
        total.texOffs(0, 0).addBox(-7.0F, -10.5F, -5.0F, 14.0F, 10.0F, 10.0F, 0.0F, false);
        total.texOffs(32, 44).addBox(-7.0F, -8.0F, -5.2F, 14.0F, 2.0F, 0.0F, 0.0F, false);

        nw_r1 = new ModelPart(this);
        nw_r1.setPos(0.0F, 0.0F, 0.0F);
        total.addChild(nw_r1);
        setRotationAngle(nw_r1, -0.0873F, 0.0F, -0.0873F);
        nw_r1.texOffs(29, 0).addBox(-1.0F, 0.0F, -8.0F, 11.0F, 0.0F, 9.0F, 0.0F, false);

        sw_r1 = new ModelPart(this);
        sw_r1.setPos(0.0F, 0.0F, 0.0F);
        total.addChild(sw_r1);
        setRotationAngle(sw_r1, 0.0873F, 0.0F, -0.0873F);
        sw_r1.texOffs(13, 47).addBox(-1.0F, 0.0F, -1.0F, 11.0F, 0.0F, 9.0F, 0.0F, false);

        se_r1 = new ModelPart(this);
        se_r1.setPos(0.0F, 0.0F, 0.0F);
        total.addChild(se_r1);
        setRotationAngle(se_r1, 0.0873F, 0.0F, 0.0873F);
        se_r1.texOffs(-9, 47).addBox(-10.0F, 0.0F, -1.0F, 11.0F, 0.0F, 9.0F, 0.0F, false);

        ne_r1 = new ModelPart(this);
        ne_r1.setPos(0.0F, 0.0F, 0.0F);
        total.addChild(ne_r1);
        setRotationAngle(ne_r1, -0.0873F, 0.0F, 0.0873F);
        ne_r1.texOffs(39, 18).addBox(-10.0F, 0.0F, -8.0F, 11.0F, 0.0F, 9.0F, 0.0F, false);

        pult = new ModelPart(this);
        pult.setPos(0.0F, -7.0F, 0.0F);
        total.addChild(pult);
        setRotationAngle(pult, 0.3927F, 0.0F, 0.0F);
        pult.texOffs(38, 51).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 11.0F, 0.0F, false);

        bone = new ModelPart(this);
        bone.setPos(0.0F, 0.0F, 9.0F);
        pult.addChild(bone);
        setRotationAngle(bone, -0.2182F, 0.0F, 0.0F);
        bone.texOffs(48, 9).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 5.0F, 0.0F, false);
        bone.texOffs(0, 20).addBox(-5.0F, -2.0F, 3.0F, 10.0F, 5.0F, 10.0F, 0.0F, false);
        bone.texOffs(0, 44).addBox(-4.0F, -2.0F, 4.0F, 8.0F, 4.0F, 8.0F, 0.0F, false);

        melon = new ModelPart(this);
        melon.setPos(0.0F, -5.5F, 8.0F);
        bone.addChild(melon);
        setRotationAngle(melon, -0.6545F, 0.0F, 0.0F);
        melon.texOffs(32, 27).addBox(-4.0F, -3.5F, -3.0F, 8.0F, 9.0F, 8.0F, 0.0F, false);

        getPlantWholeBody = new ModelPart(this);
        getPlantWholeBody.setPos(0.0F, 0.0F, 0.0F);

    }
    public void setupAnim(GoldenMelonPultEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        if (entity.getAttackTime() > 0) {
            float percent = 1.0F - (float)entity.getAttackTime() * 1.0F / (float)entity.getPultAnimTime();
            this.pult.xRot = (1.0F - Mth.abs(Mth.cos(percent * 3.14159F))) * 1.5F;
            this.melon.visible = (double)percent < 0.5;
        } else {
            this.pult.xRot = Mth.sin(ageInTicks / 10.0F) / 8.0F;
            this.melon.visible = true;
        }

    }

    public ModelPart getPlantWholeBody() {
        return this.total;
    }

    public EntityModel<GoldenMelonPultEntity> getPlantModel() {
        return this;
    }
}