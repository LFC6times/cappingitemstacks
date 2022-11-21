package ml.ikwid.capitemstacks.mixin;

import ml.ikwid.capitemstacks.imixin.IItemMixin;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Item.class)
public class MixinItem implements IItemMixin {
    @Mutable
    @Shadow @Final private int maxCount;

    @Override
    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }
}
