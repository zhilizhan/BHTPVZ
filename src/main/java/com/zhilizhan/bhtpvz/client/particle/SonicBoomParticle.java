package com.zhilizhan.bhtpvz.client.particle;

import com.hungteen.pvz.client.particle.PVZNormalParticle;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;

public class SonicBoomParticle  extends PVZNormalParticle {

    public SonicBoomParticle(ClientLevel world, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, SpriteSet spriteSet) {
        super(world, x, y, z, xSpeed, ySpeed, zSpeed);
        this.quadSize = 0.2F;
        this.lifetime = this.random.nextInt(5) + 15;
        this.hasPhysics = false;
        this.gravity = 0.0F;
        this.xd /= 10.0;
        this.yd /= 10.0;
        this.zd /= 10.0;
        this.setSpriteFromAge(spriteSet);
    }
    public float getQuadSize(float scaleFactor) {
        return this.quadSize + Mth.clamp(((float)this.age + scaleFactor) / (float)this.lifetime*64, 0.0F, 1.0F);
    }
    public static class Factory implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprite;

        public Factory(SpriteSet sprite) {
            this.sprite = sprite;
        }

        public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            return new SonicBoomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.sprite);
        }

        private Factory() {
            throw new UnsupportedOperationException("Use the Factory(IAnimatedSprite sprite) constructor");
        }
    }
}
