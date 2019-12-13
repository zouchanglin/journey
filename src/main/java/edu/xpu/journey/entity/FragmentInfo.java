package edu.xpu.journey.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@DynamicUpdate
@Accessors(chain = true)
public class FragmentInfo {
    @Id
    private String fragmentName;

    private String fragmentData;

    private String fragmentAnnotation;
}