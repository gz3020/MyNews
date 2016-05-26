package fence.mynews.model.mock;

import java.util.ArrayList;
import java.util.List;

import fence.mynews.model.entity.Channel;

/**
 * @author fence
 * @version 1.0.0
 * @description
 * @date 5/12/16
 */
public class ChannelLab {

    public static List<Channel> getChannels() {
        List<Channel> channels = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Channel channel = new Channel();
            channel.setId(i);
            channel.setName("Channel" + i);
            channels.add(channel);
        }

        return channels;
    }
}
