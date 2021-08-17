package com.imutable.coding.foundation.service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Table("place_categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @JsonIgnore
    private long categoryId;
    @Column
    private String categoryName;
    @Column
    private String categoryImageUrl;
    @Column
    private String categorySecondaryImageUrl;

}
