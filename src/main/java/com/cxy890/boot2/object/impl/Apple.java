package com.cxy890.boot2.object.impl;

import com.cxy890.boot2.object.Currency;
import com.cxy890.boot2.object.Objects;
import com.cxy890.boot2.object.enums.Species;
import lombok.Data;

/**
 * @author BD-PC27
 */
@Data
public class Apple implements Objects {

    private long price;

    @Override
    public Species species() {
        return Species.FRUIT;
    }

    @Override
    public String name() {
        return "苹果";
    }

    @Override
    public Currency price() {
        return new Currency() {
            @Override
            public long value() {
                return price;
            }

            @Override
            public Kind kind() {
                return Kind.silver;
            }
        };
    }

    private Apple(){}

    public static Apple of(long price) {
        Apple apple = new Apple();
        apple.price = price;
        return apple;
    }
}
