package xyz.ollieee.nms.v1_17;

import net.minecraft.server.level.WorldServer;
import net.minecraft.world.level.block.state.IBlockData;
import net.minecraft.world.level.chunk.ChunkStatus;
import net.minecraft.world.level.chunk.DataPaletteBlock;
import org.bukkit.ChunkSnapshot;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_17_R1.CraftChunk;
import org.bukkit.craftbukkit.v1_17_R1.CraftWorld;
import xyz.ollieee.api.pathing.world.chunk.ChunkSnapshotGrabber;

import java.lang.reflect.Field;

public class OneSeventeenSnapshotGrabber implements ChunkSnapshotGrabber {

    private static final Field blockIDField;

    static {
        try {
            blockIDField = CraftChunk.class.getDeclaredField("emptyBlockIDs");
            blockIDField.setAccessible(true);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public ChunkSnapshot getSnapshot(World world, int chunkX, int chunkZ) {
        try {

            WorldServer server = ((CraftWorld) world).getHandle();
            CraftChunk newCraftChunk = new CraftChunk(server, chunkX, chunkZ);

            server.getChunkProvider().getChunkAt(chunkX, chunkZ, ChunkStatus.m, true);
            DataPaletteBlock<IBlockData> dataDataPaletteBlock = (DataPaletteBlock<IBlockData>) blockIDField.get(newCraftChunk);

            dataDataPaletteBlock.b();
            dataDataPaletteBlock.a();
            ChunkSnapshot chunkSnapshot = newCraftChunk.getChunkSnapshot();
            dataDataPaletteBlock.b();

            return chunkSnapshot;

        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

}
