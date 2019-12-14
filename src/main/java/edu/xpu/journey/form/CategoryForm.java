package edu.xpu.journey.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author x
 */
@Data
public class CategoryForm {
    @NotNull
    private Integer id;

    @NotNull
    private String myname;

    @NotNull
    private String describes;
}