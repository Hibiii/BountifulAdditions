package hibi.bountifuladditions.mixin;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;

@Mixin(InGameHud.class)
public class InGameHudMixin {
	@Shadow @Final
	private MinecraftClient client;
	@Inject(
		method = "method_9429()Z",
		at = @At("HEAD"),
		cancellable = true
	)
	private void hideXhair(CallbackInfoReturnable<Boolean> cbir) {
		if(this.client.options.perspective != 0)
			cbir.setReturnValue(false);
	}
}
