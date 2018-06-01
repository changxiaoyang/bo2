package com.cxy890.boot2.object;

/**
 * @author BD-PC27
 */
public interface Currency {

    enum Kind {
        gold,  silver
    }

    long value();
    Kind kind();
}
