package com.zhilizhan.bhtpvz.client.model.entity.plant.appease;

import com.hungteen.pvz.client.model.entity.plant.PlantShooterModel;
import com.zhilizhan.bhtpvz.common.entity.plant.appease.PrimalPeaShooterEntity;
import net.minecraft.client.model.geom.ModelPart;

import java.util.Optional;

public class PrimalPeaShooterModel  extends PlantShooterModel<PrimalPeaShooterEntity> {
    private final ModelPart total;
    private final ModelPart body;
    private final ModelPart stick_r1;
    private final ModelPart head;
    private final ModelPart head_r1;
    private final ModelPart hair;
    private final ModelPart leafl_r1;
    private final ModelPart leafl_r1_r1;
    private final ModelPart leafl_r1_r2;
    private final ModelPart down;
    private final ModelPart n_r1;
    private final ModelPart w_r1;
    private final ModelPart e_r1;
    private final ModelPart s_r1;
    private final ModelPart getPlantWholeBody;

    public PrimalPeaShooterModel() {
        texWidth = 64;
        texHeight = 64;

        total = new ModelPart(this);
        total.setPos(0.0F, 24.0F, 0.0F);


        body = new ModelPart(this);
        body.setPos(0.0F, 0.0F, 0.0F);
        total.addChild(body);


        stick_r1 = new ModelPart(this);
        stick_r1.setPos(0.0F, 0.0F, 0.0F);
        body.addChild(stick_r1);
        setRotationAngle(stick_r1, -0.0873F, 0.0F, 0.0F);
        stick_r1.texOffs(0, 31).addBox(-1.0F, -10.0F, -1.0F, 2.0F, 10.0F, 2.0F, 0.0F, false);

        head = new ModelPart(this);
        head.setPos(-1.0F, -1.0F, 0.0F);
        body.addChild(head);
        head.texOffs(30, 0).addBox(-1.0F, -16.0F, -7.0F, 4.0F, 4.0F, 3.0F, 0.0F, false);
        head.texOffs(44, 0).addBox(-2.0F, -17.0F, -8.0F, 6.0F, 6.0F, 2.0F, 0.0F, false);
        head.texOffs(0, 0).addBox(-4.0F, -21.0F, -4.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);
        head.texOffs(40, 8).addBox(-1.0F, -11.0F, -1.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);

        head_r1 = new ModelPart(this);
        head_r1.setPos(1.0F, -15.0F, -14.0F);
        head.addChild(head_r1);
        setRotationAngle(head_r1, 0.7854F, 0.0F, 0.0F);
        head_r1.texOffs(18, 15).addBox(-5.0F, 2.2F, 10.0F, 10.0F, 2.8F, 2.0F, 0.0F, false);

        hair = new ModelPart(this);
        hair.setPos(0.0F, -16.5F, 12.0F);
        head.addChild(hair);


        leafl_r1 = new ModelPart(this);
        leafl_r1.setPos(0.0F, 0.0F, 0.0F);
        hair.addChild(leafl_r1);
        setRotationAngle(leafl_r1, 0.1745F, 0.0F, 0.0F);
        leafl_r1.texOffs(0, 0).addBox(0.0F, -0.5F, -6.0F, 2.0F, 1.0F, 3.0F, 0.0F, false);

        leafl_r1_r1 = new ModelPart(this);
        leafl_r1_r1.setPos(0.6292F, 2.9F, -3.5081F);
        leafl_r1.addChild(leafl_r1_r1);
        setRotationAngle(leafl_r1_r1, 0.0F, -0.0436F, 1.6144F);
        leafl_r1_r1.texOffs(42, 19).addBox(-5.0F, 0.0F, -0.5F, 4.0F, 6.0F, 1.0F, 0.0F, false);

        leafl_r1_r2 = new ModelPart(this);
        leafl_r1_r2.setPos(1.0F, 2.9F, -3.5F);
        leafl_r1.addChild(leafl_r1_r2);
        setRotationAngle(leafl_r1_r2, 0.0F, 0.0F, -1.6144F);
        leafl_r1_r2.texOffs(42, 19).addBox(1.0F, 1.0F, -0.5F, 4.0F, 6.0F, 1.0F, 0.0F, false);

        down = new ModelPart(this);
        down.setPos(0.0F, 0.0F, 0.0F);
        total.addChild(down);


        n_r1 = new ModelPart(this);
        n_r1.setPos(0.0F, 0.8F, 0.0F);
        down.addChild(n_r1);
        setRotationAngle(n_r1, -0.1745F, -0.7854F, 0.0F);
        n_r1.texOffs(4, 20).addBox(-2.0F, -1.0F, -7.0F, 4.0F, 1.0F, 6.0F, 0.0F, false);

        w_r1 = new ModelPart(this);
        w_r1.setPos(0.0F, 0.8F, 0.0F);
        down.addChild(w_r1);
        setRotationAngle(w_r1, 0.1745F, -0.7854F, -0.1745F);
        w_r1.texOffs(6, 27).addBox(1.0F, -1.0F, -2.0F, 6.0F, 1.0F, 4.0F, 0.0F, false);

        e_r1 = new ModelPart(this);
        e_r1.setPos(0.0F, 0.8F, 0.0F);
        down.addChild(e_r1);
        setRotationAngle(e_r1, -0.1745F, -0.7854F, 0.1745F);
        e_r1.texOffs(26, 27).addBox(-7.0F, -1.0F, -2.0F, 6.0F, 1.0F, 4.0F, 0.0F, false);

        s_r1 = new ModelPart(this);
        s_r1.setPos(0.0F, 0.8F, 0.0F);
        down.addChild(s_r1);
        setRotationAngle(s_r1, 0.1745F, -0.7854F, 0.0F);
        s_r1.texOffs(24, 20).addBox(-2.0F, -1.0F, 1.0F, 4.0F, 1.0F, 6.0F, 0.0F, false);

        getPlantWholeBody = new ModelPart(this);
        getPlantWholeBody.setPos(0.0F, 0.0F, 0.0F);

    }
    public Optional<ModelPart> getHeadModel() {
        return Optional.ofNullable(this.head);
    }

    public Optional<ModelPart> getBodyModel() {
        return Optional.ofNullable(this.body);
    }

    public ModelPart getPlantWholeBody() {
        return this.total;
    }
}
