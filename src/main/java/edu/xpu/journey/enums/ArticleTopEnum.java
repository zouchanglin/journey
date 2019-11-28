package edu.xpu.journey.enums;

import lombok.Getter;

/**
 * @author 长林
 */

@Getter
public enum ArticleTopEnum implements EnumCode {
    /**
     * 0 置顶、1 不置顶
     */
    TOP(0, "置顶"),
    NO_TOP(1, "不置顶");

    private Integer code;
    private String message;

    ArticleTopEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
