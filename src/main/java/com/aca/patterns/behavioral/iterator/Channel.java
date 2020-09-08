package com.aca.patterns.behavioral.iterator;

import java.util.Objects;

/**
 * @author: garik
 * @created" 9/8/2020, 8:43 PM
 */
public class Channel {
    private final int number;
    private final ChannelLang lang;

    public Channel(int number, ChannelLang lang) {
        this.number = number;
        this.lang = lang;
    }

    public int getNumber() {
        return number;
    }

    public ChannelLang getLang() {
        return lang;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Channel channel = (Channel) o;
        return number == channel.number &&
                lang == channel.lang;
    }

    enum ChannelLang {
        ARMENIAN, FRENCH, ENGLISH, ALL;
    }
}
