package com.zhilizhan.bhtpvz.client.model.entity.zombie.bhtpvz;

import com.hungteen.pvz.client.model.entity.zombie.PVZZombieModel;
import com.zhilizhan.bhtpvz.common.entity.zombie.bhtpvz.SteelPumpkinZombieEntity;
import net.minecraft.client.model.geom.ModelPart;

import java.util.Optional;

public class SteelPumpkinZombieModel extends PVZZombieModel<SteelPumpkinZombieEntity> {
    private final ModelPart total;
    private final ModelPart right_leg;
    private final ModelPart left_leg;
    private final ModelPart up;
    private final ModelPart body;
    private final ModelPart hammer;
    private final ModelPart left_hand;
    private final ModelPart right_hand;
    private final ModelPart head;
    private final ModelPart teeth_r1;
    private final ModelPart ladder;
    private final ModelPart floor;
    private final ModelPart getZombieLeftHand;
    private final ModelPart getZombieRightHand;
    private final ModelPart getZombieLeftLeg;
    private final ModelPart getZombieRightLeg;
    private final ModelPart getZombieHead;
    private final ModelPart getZombieUpBody;
    private final ModelPart getZombieWholeBody;

    public SteelPumpkinZombieModel() {
        texWidth = 256;
        texHeight = 256;

        total = new ModelPart(this);
        total.setPos(0.0F, 24.0F, 0.0F);


        right_leg = new ModelPart(this);
        right_leg.setPos(-4.0F, -23.0F, 0.0F);
        total.addChild(right_leg);
        right_leg.texOffs(44, 0).addBox(-4.0F, -1.0F, -4.0F, 8.0F, 24.0F, 8.0F, 0.0F, false);

        left_leg = new ModelPart(this);
        left_leg.setPos(4.0F, -23.0F, 0.0F);
        total.addChild(left_leg);
        left_leg.texOffs(0, 0).addBox(-4.0F, -1.0F, -4.0F, 8.0F, 24.0F, 8.0F, 0.0F, false);

        up = new ModelPart(this);
        up.setPos(0.0F, 0.0F, 0.0F);
        total.addChild(up);


        body = new ModelPart(this);
        body.setPos(0.0F, -23.0F, 0.0F);
        up.addChild(body);
        body.texOffs(0, 41).addBox(-8.0F, -25.0F, -4.0F, 16.0F, 24.0F, 8.0F, 0.0F, false);

        hammer = new ModelPart(this);
        hammer.setPos(9.0F, -1.0F, 0.5F);
        body.addChild(hammer);
        setRotationAngle(hammer, 0.4363F, 0.0F, 0.0F);
        hammer.texOffs(0, 163).addBox(-1.0F, -6.0F, -0.5F, 1.0F, 9.0F, 1.0F, 0.0F, false);
        hammer.texOffs(0, 175).addBox(-1.0F, 3.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.2F, false);
        hammer.texOffs(0, 179).addBox(-1.0F, -5.75F, -3.5F, 1.0F, 1.0F, 1.0F, 0.4F, false);
        hammer.texOffs(6, 163).addBox(-1.0F, -5.75F, -3.5F, 1.0F, 1.0F, 5.0F, 0.1F, false);

        left_hand = new ModelPart(this);
        left_hand.setPos(8.0F, -48.0F, 0.0F);
        up.addChild(left_hand);
        setRotationAngle(left_hand, -0.8727F, 0.0F, 0.0F);
        left_hand.texOffs(96, 60).addBox(0.0F, 0.0F, -4.0F, 8.0F, 24.0F, 8.0F, 0.0F, false);

        right_hand = new ModelPart(this);
        right_hand.setPos(-8.0F, -48.0F, 0.0F);
        up.addChild(right_hand);
        setRotationAngle(right_hand, -0.8727F, 0.0F, 0.0F);
        right_hand.texOffs(96, 0).addBox(-8.0F, 0.0F, -4.0F, 8.0F, 24.0F, 8.0F, 0.0F, false);

        head = new ModelPart(this);
        head.setPos(0.0F, -48.0F, 0.0F);
        up.addChild(head);


        teeth_r1 = new ModelPart(this);
        teeth_r1.setPos(0.0F, 48.0F, 0.0F);
        head.addChild(teeth_r1);
        setRotationAngle(teeth_r1, 0.0F, 1.5708F, 0.0F);
        teeth_r1.texOffs(129, 26).addBox(9.0F, -54.5F, -8.5F, 1.0F, 6.0F, 17.0F, 1.0F, false);
        teeth_r1.texOffs(128, 0).addBox(-7.5F, -58.5F, -8.5F, 17.0F, 10.0F, 17.0F, 1.0F, false);
        teeth_r1.texOffs(128, 50).addBox(-7.0F, -58.5F, -8.0F, 16.0F, 9.0F, 16.0F, 1.0F, false);

        ladder = new ModelPart(this);
        ladder.setPos(0.0F, -38.0F, -20.0F);
        up.addChild(ladder);
        setRotationAngle(ladder, 0.2182F, 0.0F, 0.0F);
        ladder.texOffs(15, 202).addBox(-12.0F, -22.0F, -2.0F, 3.0F, 50.0F, 4.0F, 0.1F, false);
        ladder.texOffs(0, 202).addBox(9.0F, -22.0F, -2.0F, 3.0F, 50.0F, 4.0F, 0.1F, false);
        ladder.texOffs(0, 194).addBox(8.0F, 28.0F, -3.0F, 5.0F, 1.0F, 6.0F, 0.0F, false);
        ladder.texOffs(0, 185).addBox(-13.0F, 28.0F, -3.0F, 5.0F, 1.0F, 6.0F, 0.0F, false);

        floor = new ModelPart(this);
        floor.setPos(0.0F, 0.0F, 0.0F);
        ladder.addChild(floor);
        floor.texOffs(31, 250).addBox(-9.0F, 20.0F, -2.0F, 18.0F, 2.0F, 4.0F, 0.0F, false);
        floor.texOffs(31, 242).addBox(-9.0F, 12.0F, -2.0F, 18.0F, 2.0F, 4.0F, 0.0F, false);
        floor.texOffs(30, 234).addBox(-9.0F, 4.0F, -2.0F, 18.0F, 2.0F, 4.0F, 0.0F, false);
        floor.texOffs(32, 225).addBox(-9.0F, -4.0F, -2.0F, 18.0F, 2.0F, 4.0F, 0.0F, false);
        floor.texOffs(30, 217).addBox(-9.0F, -12.0F, -2.0F, 18.0F, 2.0F, 4.0F, 0.0F, false);

        getZombieLeftHand = new ModelPart(this);
        getZombieLeftHand.setPos(0.0F, 0.0F, 0.0F);


        getZombieRightHand = new ModelPart(this);
        getZombieRightHand.setPos(0.0F, 0.0F, 0.0F);


        getZombieLeftLeg = new ModelPart(this);
        getZombieLeftLeg.setPos(0.0F, 0.0F, 0.0F);


        getZombieRightLeg = new ModelPart(this);
        getZombieRightLeg.setPos(0.0F, 0.0F, 0.0F);


        getZombieHead = new ModelPart(this);
        getZombieHead.setPos(0.0F, 0.0F, 0.0F);


        getZombieUpBody = new ModelPart(this);
        getZombieUpBody.setPos(0.0F, 0.0F, 0.0F);


        getZombieWholeBody = new ModelPart(this);
        getZombieWholeBody.setPos(0.0F, 0.0F, 0.0F);

    }
    @Override
    public void updateFreeParts(SteelPumpkinZombieEntity entity) {
        super.updateFreeParts(entity);
        final boolean hasLadder = entity.hasMetal();
        this.ladder.visible = hasLadder;
        this.isLeftHandFree = ! hasLadder;
        this.isRightHandFree = ! hasLadder;
    }

    @Override
    public void refreshAnim() {
        super.refreshAnim();
        this.right_hand.xRot = -0.8727f;
        this.left_hand.xRot = -0.8727f;
    }

    @Override
    public Optional<ModelPart> getHandDefence() {
        return Optional.ofNullable(this.ladder);
    }

    @Override
    public ModelPart getZombieLeftHand() {
        return this.left_hand;
    }

    @Override
    public ModelPart getZombieRightHand() {
        return this.right_hand;
    }

    @Override
    public ModelPart getZombieLeftLeg() {
        return this.left_leg;
    }

    @Override
    public ModelPart getZombieRightLeg() {
        return this.right_leg;
    }

    @Override
    public ModelPart getZombieHead() {
        return this.head;
    }

    @Override
    public ModelPart getZombieUpBody() {
        return this.up;
    }

    @Override
    public ModelPart getZombieWholeBody() {
        return this.total;
    }
}
