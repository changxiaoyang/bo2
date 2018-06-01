package com.cxy890.boot2.object;

import com.cxy890.boot2.object.enums.Species;

/**
 * @author BD-PC27
 */
public interface Objects {

    /**
     * 种类
     *
     * @return Species
     */
    Species species();

    String name();

    Currency price();

}
