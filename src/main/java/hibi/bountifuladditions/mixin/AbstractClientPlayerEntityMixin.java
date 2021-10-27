package hibi.bountifuladditions.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.client.network.AbstractClientPlayerEntity;

@Mixin(AbstractClientPlayerEntity.class)
public class AbstractClientPlayerEntityMixin {
	@Inject(
		method = "getSpeed()F",
		at = @At("HEAD"),
		cancellable = true
	)
	private void lockFov(CallbackInfoReturnable<Float> cbir) {
		cbir.setReturnValue(1.0f);
	}
}
