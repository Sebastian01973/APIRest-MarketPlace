package com.tunja.market.persistence.mapper;

import com.tunja.market.domain.Category;
import com.tunja.market.persistence.entity.CategoryEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings({
            @Mapping(source = "idCategory",target = "categoryId"),
            @Mapping(source = "description",target = "category"),
            @Mapping(source = "state",target = "active"),
    })
    Category toCategory(CategoryEntity categoryEntity);

    @InheritInverseConfiguration
    @Mapping(target = "products",ignore = true)
    CategoryEntity toCategoryEntity(Category category);

}
