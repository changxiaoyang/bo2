package com.cxy890.boot2.util;

import com.cxy890.boot2.object.Objects;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author BD-PC27
 */
@Data
public class ObjectBox {

    private static Map<String, ObjectBox> boxConcurrentHashMap = new ConcurrentHashMap<>();

    private String id;

//    private int size;

    private List<Objects> objects = new ArrayList<>();

    public static ObjectBox put(List<Objects> objs) {
        ObjectBox box = new ObjectBox();
//        box.size = objs.size();
        box.id = (int)(Math.random() * 9999 + 1) + "";
        box.objects.addAll(objs);
        boxConcurrentHashMap.put(box.id, box);
        return box;
    }

    public static ObjectBox get(String id) {
        return boxConcurrentHashMap.get(id);
    }

}
