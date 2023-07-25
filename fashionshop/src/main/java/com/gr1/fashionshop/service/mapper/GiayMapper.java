package com.gr1.fashionshop.service.mapper;

import com.gr1.fashionshop.domain.Giay;
import com.gr1.fashionshop.service.dto.GiayDTO;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

/**
 * Mapper for the entity {@link Giay} and its DTO {@link GiayDTO}.
 */

@Mapper(componentModel = "spring")
@Component
public interface GiayMapper extends EntityMapper<GiayDTO, Giay> {}
