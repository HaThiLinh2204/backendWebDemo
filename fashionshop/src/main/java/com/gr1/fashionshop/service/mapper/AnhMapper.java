package com.gr1.fashionshop.service.mapper;

import com.gr1.fashionshop.domain.Anh;
import com.gr1.fashionshop.service.dto.AnhDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


/**
 * Mapper for the entity {@link Anh} and its DTO {@link AnhDTO}.
 */
@Mapper(componentModel = "spring")
@Component
public interface AnhMapper extends EntityMapper<AnhDTO, Anh> {
}
