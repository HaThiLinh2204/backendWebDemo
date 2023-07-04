package com.gr1.shop.service.mapper;

import com.gr1.shop.domain.Giay;
import com.gr1.shop.service.dto.GiayDTO;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

/**
 * Mapper for the entity {@link Giay} and its DTO {@link GiayDTO}.
 */

@Mapper(componentModel = "spring")
@Component
public interface GiayMapper extends EntityMapper<GiayDTO, Giay> {}
