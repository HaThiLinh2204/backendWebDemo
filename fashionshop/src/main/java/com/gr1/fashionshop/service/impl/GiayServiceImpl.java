package com.gr1.fashionshop.service.impl;

import com.gr1.fashionshop.domain.Giay;
import com.gr1.fashionshop.exception.ResourceNotFoundException;
import com.gr1.fashionshop.repository.GiayRepository;
import com.gr1.fashionshop.service.GiayService;
import com.gr1.fashionshop.service.dto.GiayDTO;
import com.gr1.fashionshop.service.mapper.GiayMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


/**
 * Service Implementation for managing {@link Giay}.
 */
@Service
@Transactional
public class GiayServiceImpl implements GiayService {

    private final Logger log = LoggerFactory.getLogger(GiayServiceImpl.class);

    private final GiayRepository giayRepository;

    private final GiayMapper giayMapper;


    public GiayServiceImpl(GiayRepository giayRepository, GiayMapper giayMapper) {
        this.giayRepository = giayRepository;
        this.giayMapper = giayMapper;
    }

    @Override
    public GiayDTO save(GiayDTO giayDTO) {
        log.debug("Request to save Giay : {}", giayDTO);
        Giay giay = giayMapper.toEntity(giayDTO);
        giay = giayRepository.save(giay);
        GiayDTO result = giayMapper.toDto(giay);
        return result;
    }

    @Override
    public Giay update( Giay giay) {
        log.debug("Request to update Giay : {}", giay);
        Giay result = giayRepository
                .findById(giay.getId())
                .orElseThrow(() -> ResourceNotFoundException
                        .fromResource("giay", giay.getId()));
                result.gia(giay.getGia())
                        .moTa(giay.getMoTa())
                        .tenGiay(giay.getTenGiay());
                return null;

    }

    @Override
    public Optional<GiayDTO> partialUpdate(GiayDTO giayDTO) {
        log.debug("Request to partially update Giay : {}", giayDTO);

        return giayRepository
            .findById(giayDTO.getId())
            .map(existingGiay -> {
                giayMapper.partialUpdate(existingGiay, giayDTO);

                return existingGiay;
            })
            .map(giayRepository::save)
            .map(giayMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<GiayDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Giays");
        return giayRepository.findAll(pageable).map(giayMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<GiayDTO> findOne(String id) {
        log.debug("Request to get Giay : {}", id);
        return giayRepository.findById(id).map(giayMapper::toDto);
    }

    @Override
    public void delete(String id) {
        log.debug("Request to delete Giay : {}", id);
        giayRepository.deleteById(id);
    }

    @Override
    public Page<GiayDTO> search(String query, Pageable pageable) {
        return null;
    }


}
