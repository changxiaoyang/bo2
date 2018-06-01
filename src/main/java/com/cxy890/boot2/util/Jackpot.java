package com.cxy890.boot2.util;

import com.cxy890.boot2.object.Objects;

/**
 * @author BD-PC27
 */
public interface Jackpot {

    ObjectBox produce() throws Exception;

    Objects draw() throws Exception;

}
