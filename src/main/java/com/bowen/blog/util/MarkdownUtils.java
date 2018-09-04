package com.bowen.blog.util;

import org.pegdown.PegDownProcessor;

/**
 * Created by libowen on 2018/8/19.
 * markDown解析
 */
public class MarkdownUtils {

    // 默认最大解析2k个字符
    private static final PegDownProcessor processor = new PegDownProcessor();

    public static String convertToHtml(String markDownString) {
        return processor.markdownToHtml(markDownString);
    }


}
