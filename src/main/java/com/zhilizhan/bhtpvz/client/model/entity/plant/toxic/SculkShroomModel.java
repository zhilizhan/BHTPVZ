package com.zhilizhan.bhtpvz.client.model.entity.plant.toxic;

import com.hungteen.pvz.client.model.entity.plant.PVZPlantModel;
import com.zhilizhan.bhtpvz.common.entity.plant.toxic.SculkShroomEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;

public class SculkShroomModel extends PVZPlantModel<SculkShroomEntity> {
    private final ModelPart total;
    private final ModelPart head;
    private final ModelPart face;
    private final ModelPart shoot;
    private final ModelPart shoot1;
    private final ModelPart shoot2;
    private final ModelPart cube_r1;
    private final ModelPart shoot3;
    private final ModelPart cube_r2;
    private final ModelPart shoot4;
    private final ModelPart shoot5;
    private final ModelPart shoot6;
    private final ModelPart cube_r3;
    private final ModelPart shoot7;
    private final ModelPart cube_r4;
    private final ModelPart shoot8;
    private final ModelPart getPlantWholeBody;

    public SculkShroomModel() {
        texWidth = 128;
        texHeight = 128;

        total = new ModelPart(this);
        total.setPos(0.0F, 24.0F, 0.0F);
        total.texOffs(46, 28).addBox(-6.0F, -5.0F, -6.0F, 12.0F, 5.0F, 12.0F, 0.0F, false);
        total.texOffs(42, 48).addBox(-6.0F, -3.0F, -6.0F, 12.0F, 3.0F, 12.0F, 0.1F, false);

        head = new ModelPart(this);
        head.setPos(0.0F, 0.0F, 0.0F);
        total.addChild(head);
        head.texOffs(0, 40).addBox(-6.5F, -12.0F, -6.5F, 13.0F, 7.0F, 13.0F, -0.3F, false);
        head.texOffs(45, 8).addBox(-6.5F, -11.0F, -6.5F, 13.0F, 6.0F, 13.0F, 0.0F, false);
        head.texOffs(0, 0).addBox(-5.5F, -11.0F, -7.5F, 11.0F, 6.0F, 15.0F, -0.2F, false);
        head.texOffs(0, 21).addBox(-7.5F, -11.0F, -5.5F, 15.0F, 6.0F, 11.0F, -0.2F, false);

        face = new ModelPart(this);
        face.setPos(0.0F, 0.0F, 0.0F);
        head.addChild(face);
        face.texOffs(0, 4).addBox(-5.0F, -12.0F, 0.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
        face.texOffs(0, 0).addBox(2.0F, -12.0F, 0.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);

        shoot = new ModelPart(this);
        shoot.setPos(0.0F, 0.0F, 0.0F);
        head.addChild(shoot);


        shoot1 = new ModelPart(this);
        shoot1.setPos(0.0F, -8.5F, -7.25F);
        shoot.addChild(shoot1);
        setRotationAngle(shoot1, -0.4363F, 0.0F, 0.0F);
        shoot1.texOffs(50, 28).addBox(-0.5F, -0.5F, -1.75F, 1.0F, 1.0F, 3.0F, 0.2F, false);
        shoot1.texOffs(41, 45).addBox(-1.5F, -1.5F, -3.25F, 3.0F, 3.0F, 2.0F, 0.0F, false);

        shoot2 = new ModelPart(this);
        shoot2.setPos(-6.25F, -8.5F, -6.25F);
        shoot.addChild(shoot2);
        setRotationAngle(shoot2, 0.0F, -0.7854F, 0.0F);
        shoot2.texOffs(0, 8).addBox(-3.25F, -1.5F, -1.5F, 2.0F, 3.0F, 3.0F, 0.0F, false);

        cube_r1 = new ModelPart(this);
        cube_r1.setPos(0.25F, 0.5F, -0.5F);
        shoot2.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.0F, 1.5708F, 0.0F);
        cube_r1.texOffs(5, 47).addBox(-1.0F, -1.0F, -2.0F, 1.0F, 1.0F, 3.0F, 0.2F, false);

        shoot3 = new ModelPart(this);
        shoot3.setPos(-7.25F, -8.5F, 0.0F);
        shoot.addChild(shoot3);
        setRotationAngle(shoot3, 0.0F, 0.0F, 0.4363F);
        shoot3.texOffs(0, 40).addBox(-3.25F, -1.5F, -1.5F, 2.0F, 3.0F, 3.0F, 0.0F, false);

        cube_r2 = new ModelPart(this);
        cube_r2.setPos(0.25F, 0.5F, -0.5F);
        shoot3.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.0F, 1.5708F, 0.0F);
        cube_r2.texOffs(0, 46).addBox(-1.0F, -1.0F, -2.0F, 1.0F, 1.0F, 3.0F, 0.2F, false);

        shoot4 = new ModelPart(this);
        shoot4.setPos(-6.25F, -8.5F, 6.25F);
        shoot.addChild(shoot4);
        setRotationAngle(shoot4, 0.0F, -0.7854F, 0.0F);
        shoot4.texOffs(56, 4).addBox(-0.5F, -0.5F, -1.25F, 1.0F, 1.0F, 3.0F, 0.2F, false);
        shoot4.texOffs(43, 0).addBox(-1.5F, -1.5F, 1.25F, 3.0F, 3.0F, 2.0F, 0.0F, false);

        shoot5 = new ModelPart(this);
        shoot5.setPos(0.0F, -8.5F, 7.25F);
        shoot.addChild(shoot5);
        setRotationAngle(shoot5, 0.4363F, 0.0F, 0.0F);
        shoot5.texOffs(56, 0).addBox(-0.5F, -0.5F, -1.25F, 1.0F, 1.0F, 3.0F, 0.2F, false);
        shoot5.texOffs(43, 5).addBox(-1.5F, -1.5F, 1.25F, 3.0F, 3.0F, 2.0F, 0.0F, false);

        shoot6 = new ModelPart(this);
        shoot6.setPos(6.25F, -8.5F, 6.25F);
        shoot.addChild(shoot6);
        setRotationAngle(shoot6, 0.0F, -0.7854F, 0.0F);
        shoot6.texOffs(0, 27).addBox(1.25F, -1.5F, -1.5F, 2.0F, 3.0F, 3.0F, 0.0F, false);

        cube_r3 = new ModelPart(this);
        cube_r3.setPos(0.75F, 0.5F, -0.5F);
        shoot6.addChild(cube_r3);
        setRotationAngle(cube_r3, 0.0F, 1.5708F, 0.0F);
        cube_r3.texOffs(45, 27).addBox(-1.0F, -1.0F, -2.0F, 1.0F, 1.0F, 3.0F, 0.2F, false);

        shoot7 = new ModelPart(this);
        shoot7.setPos(7.25F, -8.5F, 0.0F);
        shoot.addChild(shoot7);
        setRotationAngle(shoot7, 0.0F, 0.0F, -0.4363F);
        shoot7.texOffs(0, 21).addBox(1.25F, -1.5F, -1.5F, 2.0F, 3.0F, 3.0F, 0.0F, false);

        cube_r4 = new ModelPart(this);
        cube_r4.setPos(0.75F, 0.5F, -0.5F);
        shoot7.addChild(cube_r4);
        setRotationAngle(cube_r4, 0.0F, 1.5708F, 0.0F);
        cube_r4.texOffs(7, 11).addBox(-1.0F, -1.0F, -2.0F, 1.0F, 1.0F, 3.0F, 0.2F, false);

        shoot8 = new ModelPart(this);
        shoot8.setPos(6.25F, -8.5F, -6.25F);
        shoot.addChild(shoot8);
        setRotationAngle(shoot8, 0.0F, -0.7854F, 0.0F);
        shoot8.texOffs(51, 2).addBox(-0.5F, -0.5F, -1.75F, 1.0F, 1.0F, 3.0F, 0.2F, false);
        shoot8.texOffs(43, 10).addBox(-1.5F, -1.5F, -3.25F, 3.0F, 3.0F, 2.0F, 0.0F, false);

        getPlantWholeBody = new ModelPart(this);
        getPlantWholeBody.setPos(0.0F, 0.0F, 0.0F);

    }
    public void setupAnim(SculkShroomEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    public ModelPart getPlantWholeBody() {
        return this.total;
    }

    public EntityModel<SculkShroomEntity> getPlantModel() {
        return this;
    }
}