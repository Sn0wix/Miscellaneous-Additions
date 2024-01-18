package net.sn0wix_.misc_additions.common.block.entities;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.JukeboxBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SingleStackInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Clearable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.sn0wix_.misc_additions.common.MiscAdditions;
import net.sn0wix_.misc_additions.common.block.custom.EndRelayBlock;
import net.sn0wix_.misc_additions.common.util.tags.ModItemTags;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.VisibleForTesting;

public class EndRelayBlockEntity extends BlockEntity implements SingleStackInventory, Clearable {
    public int currentDelay = 0;
    public final int compassDelay = 80;
    public final int teleportDelay = 120;
    public ItemStack compass_stack = ItemStack.EMPTY;

    public EndRelayBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.END_RELAY_BLOCK_ENTITY, pos, state);
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        if (currentDelay > 0) {
            currentDelay--;
        }
    }


    //NBT data
    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        if (nbt.contains("CompassItem", NbtElement.COMPOUND_TYPE)) {
            this.compass_stack = ItemStack.fromNbt(nbt.getCompound("CompassItem"));
        }
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        if (!this.getStack().isEmpty()) {
            nbt.put("CompassItem", this.getStack().writeNbt(new NbtCompound()));
        }
    }



    //Item transfering between hopper and end relay
    @Override
    public boolean canTransferTo(Inventory hopperInventory, int slot, ItemStack stack) {
        return hopperInventory.containsAny(ItemStack::isEmpty);
    }


    //HELPER METHODS
    private void updateState(@Nullable Entity entity, boolean hasCompass) {
        if (this.world.getBlockState(this.getPos()) == this.getCachedState()) {
            this.world.setBlockState(this.getPos(), this.getCachedState().with(EndRelayBlock.HAS_COMPASS, hasCompass), Block.NOTIFY_LISTENERS);
            this.world.emitGameEvent(GameEvent.BLOCK_CHANGE, this.getPos(), GameEvent.Emitter.of(entity, this.getCachedState()));
        }
    }

    public void dropCompass() {
        if (this.world == null || this.world.isClient) {
            return;
        }
        BlockPos blockPos = this.getPos();
        ItemStack itemStack = this.getStack();
        if (itemStack.isEmpty()) {
            return;
        }
        this.emptyStack();
        Vec3d vec3d = Vec3d.add(blockPos, 0.5, 1.01, 0.5).addRandom(this.world.random, 0.7f);
        ItemStack itemStack2 = itemStack.copy();
        ItemEntity itemEntity = new ItemEntity(this.world, vec3d.getX(), vec3d.getY(), vec3d.getZ(), itemStack2);
        itemEntity.setToDefaultPickupDelay();
        this.world.spawnEntity(itemEntity);
    }

    @Override
    public BlockEntity asBlockEntity() {
        return this;
    }


    //Inventory
    @Override
    public ItemStack getStack() {
        return compass_stack;
    }

    @Override
    public ItemStack decreaseStack(int count) {
        ItemStack itemStack = this.compass_stack;
        this.compass_stack = ItemStack.EMPTY;
        if (!itemStack.isEmpty()) {
            this.updateState(null, false);
        }
        return itemStack;
    }

    @Override
    public void setStack(ItemStack stack) {
        if (stack.isOf(Items.COMPASS) && this.world != null) {
            this.compass_stack = stack;
            currentDelay = compassDelay;
            this.updateState(null, true);
        } else if (stack.isEmpty()) {
            this.decreaseStack(1);
        }
    }


    public void setCompass(ItemStack stack) {
        if (currentDelay == 0) {
            if (!compass_stack.isEmpty()) {
                dropCompass();
            }

            this.compass_stack = stack.copy();
            this.compass_stack.setCount(getMaxCountPerStack());
            updateState(null, !stack.isEmpty());
            this.world.updateNeighborsAlways(this.getPos(), this.getCachedState().getBlock());
            this.markDirty();
            currentDelay = compassDelay;
        }
    }
    @Override
    public boolean isValid(int slot, ItemStack stack) {
        if (stack.isOf(Items.COMPASS)) {
            return true;
        }

        return stack.isIn(ModItemTags.END_RELAY_CHARGEABLE);
    }

    @Override
    public int getMaxCountPerStack() {
        return 1;
    }

    public static void tick(World world, BlockPos pos, BlockState state, EndRelayBlockEntity endRelayBlockEntity) {
        endRelayBlockEntity.tick(world, pos, state);
    }
}
