package website.eccentric.tome;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class Channel {

    public static final ResourceLocation name = new ResourceLocation(EccentricTome.MODID, "general");
    public static final String version = new ResourceLocation(EccentricTome.MODID, "1").toString();

    public static SimpleChannel register() {
        final var channel = NetworkRegistry.ChannelBuilder.named(name)
            .clientAcceptedVersions(version -> true)
            .serverAcceptedVersions(version -> true)
            .networkProtocolVersion(() -> version)
            .simpleChannel();
        
        channel.registerMessage(1, TransformMessage.class, TransformMessage::encode, TransformMessage::decode, TransformMessage::handle);
        channel.registerMessage(2, UntransformMessage.class, UntransformMessage::encode, UntransformMessage::decode, UntransformMessage::handle);

        return channel;
    }
    
}
