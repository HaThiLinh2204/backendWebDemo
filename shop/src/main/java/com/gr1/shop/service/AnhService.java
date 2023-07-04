package com.gr1.shop.service;

import com.gr1.shop.service.dto.AnhDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.gr1.shop.domain.Anh}.
 */
public interface AnhService {
    /**
     * Save a anh.
     *
     * @param anhDTO the entity to save.
     * @return the persisted entity.
     */
    AnhDTO save(AnhDTO anhDTO);

    /**
     * Updates a anh.
     *
     * @param anhDTO the entity to update.
     * @return the persisted entity.
     */
    AnhDTO update(AnhDTO anhDTO);

    /**
     * Partially updates a anh.
     *
     * @param anhDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<AnhDTO> partialUpdate(AnhDTO anhDTO);

    /**
     * Get all the anhs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<AnhDTO> findAll(Pageable pageable);

    /**
     * Get the "id" anh.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<AnhDTO> findOne(String id);

    /**
     * Delete the "id" anh.
     *
     * @param id the id of the entity.
     */
    void delete(String id);

    /**
     * Search for the anh corresponding to the query.
     *
     * @param query the query of the search.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<AnhDTO> search(String query, Pageable pageable);
}
