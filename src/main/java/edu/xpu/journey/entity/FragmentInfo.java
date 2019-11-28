package edu.xpu.journey.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@DynamicUpdate
public class FragmentInfo {
    @Id
    private String fragmentName;

    private String fragmentData;

    private String fragmentAnnotation;
}