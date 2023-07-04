package com.gr1.shop.service;

import com.gr1.shop.service.dto.GiayDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.gr1.shop.domain.Giay}.
 */
public interface GiayService {
    /**
     * Save a giay.
     *
     * @param giayDTO the entity to save.
     * @return the persisted entity.
     */
    GiayDTO save(GiayDTO giayDTO);

    /**
     * Updates a giay.
     *
     * @param giayDTO the entity to update.
     * @return the persisted entity.
     */
    GiayDTO update(GiayDTO giayDTO);

    /**
     * Partially updates a giay.
     *
     * @param giayDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<GiayDTO> partialUpdate(GiayDTO giayDTO);

    /**
     * Get all the giays.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<GiayDTO> findAll(Pageable pageable);

    /**
     * Get the "id" giay.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<GiayDTO> findOne(String id);

    /**
     * Delete the "id" giay.
     *
     * @param id the id of the entity.
     */
    void delete(String id);

    /**
     * Search for the giay corresponding to the query.
     *
     * @param query the query of the search.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<GiayDTO> search(String query, Pageable pageable);
}
