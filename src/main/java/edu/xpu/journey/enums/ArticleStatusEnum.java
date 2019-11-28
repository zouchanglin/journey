package edu.xpu.journey.enums;

import lombok.Getter;

/**
 * 文章的状态
 * @author 长林
 */

@Getter
public enum ArticleStatusEnum implements EnumCode{
    /**
     * 0 草稿、 1 已经发布、 2 已删除
     */
    DEBUG(0, "草稿"),
    RELEASE(1, "已发布"),
    DELETE(2, "已删除"),
    ;

    private Integer code;
    private String message;

    ArticleStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}