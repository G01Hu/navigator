package com.ferrotec.oa.utils;


import org.junit.Test;

import java.util.UUID;

/**
 * Process Id生成
 *
 * @author H
 * @version 1.0
 * @date 2020/1/4
 **/
public class PageInitUtilsTest {

    /**
     * Process Id生成
     */
    @Test
    public void getProcessId() {

        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        System.out.println(uuid);
    }
}
