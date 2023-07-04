package com.gr1.shop.service.impl;


import com.gr1.shop.domain.Anh;
import com.gr1.shop.repository.AnhRepository;
import com.gr1.shop.service.AnhService;
import com.gr1.shop.service.dto.AnhDTO;
import com.gr1.shop.service.mapper.AnhMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Anh}.
 */
@Service
@Transactional
public class AnhServiceImpl implements AnhService {

    private final Logger log = LoggerFactory.getLogger(AnhServiceImpl.class);

    private final AnhRepository anhRepository;

    private final AnhMapper anhMapper;



    public AnhServiceImpl(AnhRepository anhRepository, AnhMapper anhMapper) {
        this.anhRepository = anhRepository;
        this.anhMapper = anhMapper;
    }

    @Override
    public AnhDTO save(AnhDTO anhDTO) {
        log.debug("Request to save Anh : {}", anhDTO);
        Anh anh = anhMapper.toEntity(anhDTO);
        anh = anhRepository.save(anh);
        AnhDTO result = anhMapper.toDto(anh);
        return result;
    }

    @Override
    public AnhDTO update(AnhDTO anhDTO) {
        log.debug("Request to update Anh : {}", anhDTO);
        Anh anh = anhMapper.toEntity(anhDTO);
        anh = anhRepository.save(anh);
        AnhDTO result = anhMapper.toDto(anh);
        return result;
    }

    @Override
    public Optional<AnhDTO> partialUpdate(AnhDTO anhDTO) {
        log.debug("Request to partially update Anh : {}", anhDTO);

        return anhRepository
            .findById(anhDTO.getId())
            .map(existingAnh -> {
                anhMapper.partialUpdate(existingAnh, anhDTO);

                return existingAnh;
            })
            .map(anhRepository::save)

            .map(anhMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<AnhDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Anhs");
        return anhRepository.findAll(pageable).map(anhMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AnhDTO> findOne(String id) {
        log.debug("Request to get Anh : {}", id);
        return anhRepository.findById(id).map(anhMapper::toDto);
    }

    @Override
    public void delete(String id) {
        log.debug("Request to delete Anh : {}", id);
        anhRepository.deleteById(id);
    }

    @Override
    public Page<AnhDTO> search(String query, Pageable pageable) {
        return null;
    }


}
