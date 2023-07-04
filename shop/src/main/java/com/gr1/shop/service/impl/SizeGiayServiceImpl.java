package com.gr1.shop.service.impl;


import com.gr1.shop.domain.SizeGiay;
import com.gr1.shop.repository.SizeGiayRepository;

import com.gr1.shop.service.SizeGiayService;
import com.gr1.shop.service.dto.SizeGiayDTO;
import com.gr1.shop.service.mapper.SizeGiayMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link SizeGiay}.
 */
@Service
@Transactional
public class SizeGiayServiceImpl implements SizeGiayService {

    private final Logger log = LoggerFactory.getLogger(SizeGiayServiceImpl.class);

    private final SizeGiayRepository sizeGiayRepository;

    private final SizeGiayMapper sizeGiayMapper;


    public SizeGiayServiceImpl(
        SizeGiayRepository sizeGiayRepository,
        SizeGiayMapper sizeGiayMapper

    ) {
        this.sizeGiayRepository = sizeGiayRepository;
        this.sizeGiayMapper = sizeGiayMapper;

    }

    @Override
    public SizeGiayDTO save(SizeGiayDTO sizeGiayDTO) {
        log.debug("Request to save SizeGiay : {}", sizeGiayDTO);
        SizeGiay sizeGiay = sizeGiayMapper.toEntity(sizeGiayDTO);
        sizeGiay = sizeGiayRepository.save(sizeGiay);
        SizeGiayDTO result = sizeGiayMapper.toDto(sizeGiay);

        return result;
    }

    @Override
    public SizeGiayDTO update(SizeGiayDTO sizeGiayDTO) {
        log.debug("Request to update SizeGiay : {}", sizeGiayDTO);
        SizeGiay sizeGiay = sizeGiayMapper.toEntity(sizeGiayDTO);
        sizeGiay = sizeGiayRepository.save(sizeGiay);
        SizeGiayDTO result = sizeGiayMapper.toDto(sizeGiay);

        return result;
    }

    @Override
    public Optional<SizeGiayDTO> partialUpdate(SizeGiayDTO sizeGiayDTO) {
        log.debug("Request to partially update SizeGiay : {}", sizeGiayDTO);

        return sizeGiayRepository
            .findById(sizeGiayDTO.getId())
            .map(existingSizeGiay -> {
                sizeGiayMapper.partialUpdate(existingSizeGiay, sizeGiayDTO);

                return existingSizeGiay;
            })
            .map(sizeGiayRepository::save)

            .map(sizeGiayMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<SizeGiayDTO> findAll(Pageable pageable) {
        log.debug("Request to get all SizeGiays");
        return sizeGiayRepository.findAll(pageable).map(sizeGiayMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<SizeGiayDTO> findOne(String id) {
        log.debug("Request to get SizeGiay : {}", id);
        return sizeGiayRepository.findById(id).map(sizeGiayMapper::toDto);
    }

    @Override
    public void delete(String id) {
        log.debug("Request to delete SizeGiay : {}", id);
        sizeGiayRepository.deleteById(id);

    }

    @Override
    public Page<SizeGiayDTO> search(String query, Pageable pageable) {
        return null;
    }


}
