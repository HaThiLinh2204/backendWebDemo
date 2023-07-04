package com.gr1.shop.service;

import com.gr1.shop.service.dto.SizeGiayDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.gr1.shop.domain.SizeGiay}.
 */
public interface SizeGiayService {
    /**
     * Save a sizeGiay.
     *
     * @param sizeGiayDTO the entity to save.
     * @return the persisted entity.
     */
    SizeGiayDTO save(SizeGiayDTO sizeGiayDTO);

    /**
     * Updates a sizeGiay.
     *
     * @param sizeGiayDTO the entity to update.
     * @return the persisted entity.
     */
    SizeGiayDTO update(SizeGiayDTO sizeGiayDTO);

    /**
     * Partially updates a sizeGiay.
     *
     * @param sizeGiayDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<SizeGiayDTO> partialUpdate(SizeGiayDTO sizeGiayDTO);

    /**
     * Get all the sizeGiays.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<SizeGiayDTO> findAll(Pageable pageable);

    /**
     * Get the "id" sizeGiay.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<SizeGiayDTO> findOne(String id);

    /**
     * Delete the "id" sizeGiay.
     *
     * @param id the id of the entity.
     */
    void delete(String id);

    /**
     * Search for the sizeGiay corresponding to the query.
     *
     * @param query the query of the search.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<SizeGiayDTO> search(String query, Pageable pageable);
}
