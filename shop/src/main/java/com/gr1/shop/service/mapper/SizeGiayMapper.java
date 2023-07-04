package com.gr1.shop.service.mapper;


import com.gr1.shop.domain.SizeGiay;

import com.gr1.shop.service.dto.SizeGiayDTO;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

/**
 * Mapper for the entity {@link SizeGiay} and its DTO {@link SizeGiayDTO}.
 */
@Mapper(componentModel = "spring")
@Component
public interface SizeGiayMapper extends EntityMapper<SizeGiayDTO, SizeGiay> {

}
