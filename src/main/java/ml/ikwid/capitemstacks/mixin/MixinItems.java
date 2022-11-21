package ml.ikwid.capitemstacks.mixin;

import ml.ikwid.capitemstacks.imixin.IItemMixin;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Items.class)
public class MixinItems {
    @Unique
    private static void setItemMaxCount(Item item, int count) {
        ((IItemMixin) item).setMaxCount(count);
    }

    @Inject(method = "register(Ljava/lang/String;Lnet/minecraft/item/Item;)Lnet/minecraft/item/Item;", at = @At("HEAD"))
    private static void changeCap(String id, Item item, CallbackInfoReturnable<Item> cir) {
        setItemMaxCount(item, switch(id) {
            case "ender_pearl" -> 8;
            case "end_crystal", "respawn_anchor" -> 1;
            case "golden_apple" -> 16;
            default -> item.getMaxCount();
        });
    }
}
