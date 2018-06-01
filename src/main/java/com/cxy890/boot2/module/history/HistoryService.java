package com.cxy890.boot2.module.history;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author BD-PC27
 */
@Service
public class HistoryService {

    private static List<String> sh = Arrays.asList("盘古氏",
            "天皇氏","地皇氏","人皇氏","有巢氏","燧人氏","伏羲氏","女娲氏","神农氏");

    private static List<String> wd = Arrays.asList("黄帝姬轩辕","少昊己挚","玄帝姬颛顼","帝喾姬夋","帝挚姬挚","唐尧伊祁放勋","虞舜姚重华");

    public List<String> emperor() {
        return Arrays.asList("盘古氏",
                "天皇氏","地皇氏","人皇氏","有巢氏","燧人氏","伏羲氏","女娲氏","神农氏");
    }

}
