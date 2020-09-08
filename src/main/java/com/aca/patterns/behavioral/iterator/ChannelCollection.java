package com.aca.patterns.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

public interface ChannelCollection {
    void addChannel(Channel channel);
    void removeChannel(Channel channel);

    ChannelIterator iterator(Channel.ChannelLang lang);

    interface ChannelIterator {
        boolean hasNext();
        Channel next();
    }
}

class ChannelCollectionImpl implements ChannelCollection{
    private List<Channel> channels = new ArrayList<>();


    @Override
    public void addChannel(Channel channel) {
        channels.add(channel);
    }

    @Override
    public void removeChannel(Channel channel) {
        channels.remove(channel);
    }

    @Override
    public ChannelIterator iterator(Channel.ChannelLang lang) {
        return new IteratorImpl(lang, channels);
    }

    public class IteratorImpl implements ChannelIterator{
        private final Channel.ChannelLang lang;
        private final List<Channel> channels;
        private int position;

        public IteratorImpl(Channel.ChannelLang lang, List<Channel> channels){
            this.lang = lang;
            this.channels = channels;
        }


        @Override
        public boolean hasNext() {
            for(int i = position; i < channels.size(); ++i){
                if(lang == Channel.ChannelLang.ALL || channels.get(i).getLang() == lang){
                    position = i;
                    return true;
                }
            }
            position = -1;
            return false;
        }

        @Override
        public Channel next() {
            if(position == -1) return null;
            Channel channel = channels.get(position);
            ++position;
            return channel;
        }
    }
}
