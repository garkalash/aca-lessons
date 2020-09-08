package com.aca.patterns.behavioral.iterator;

/**
 * @author: garik
 * @created" 9/8/2020, 9:06 PM
 */
public class Demo {
    public static void main(String[] args) {
        ChannelCollection channelCollection =  new ChannelCollectionImpl();
        channelCollection.addChannel(new Channel(1, Channel.ChannelLang.ARMENIAN));
        channelCollection.addChannel(new Channel(2, Channel.ChannelLang.ALL));
        channelCollection.addChannel(new Channel(3, Channel.ChannelLang.ARMENIAN));
        channelCollection.addChannel(new Channel(4, Channel.ChannelLang.FRENCH));
        channelCollection.addChannel(new Channel(5, Channel.ChannelLang.ENGLISH));
        channelCollection.addChannel(new Channel(6, Channel.ChannelLang.ARMENIAN));

        ChannelCollection.ChannelIterator iterator = channelCollection.iterator(Channel.ChannelLang.ARMENIAN);
        while (iterator.hasNext()){
            Channel channel = iterator.next();
            System.out.println(channel.getNumber());
        }

    }
}
