package com.gr1.shop.controller;



import com.gr1.shop.repository.SizeGiayRepository;
import com.gr1.shop.service.SizeGiayQueryService;
import com.gr1.shop.service.SizeGiayService;
import com.gr1.shop.service.criteria.SizeGiayCriteria;
import com.gr1.shop.service.dto.SizeGiayDTO;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.gr1.shop.domain.SizeGiay}.
 */
@RestController
@RequestMapping("/api")
public class SizeGiayResource {

    private final Logger log = LoggerFactory.getLogger(SizeGiayResource.class);

    private static final String ENTITY_NAME = "sizeGiay";

    @Value("fashion_shop")
    private String applicationName;

    private final SizeGiayService sizeGiayService;

    private final SizeGiayRepository sizeGiayRepository;

    private final SizeGiayQueryService sizeGiayQueryService;

    public SizeGiayResource(
        SizeGiayService sizeGiayService,
        SizeGiayRepository sizeGiayRepository,
        SizeGiayQueryService sizeGiayQueryService
    ) {
        this.sizeGiayService = sizeGiayService;
        this.sizeGiayRepository = sizeGiayRepository;
        this.sizeGiayQueryService = sizeGiayQueryService;
    }

    /**
     * {@code POST  /size-giays} : Create a new sizeGiay.
     *
     * @param sizeGiayDTO the sizeGiayDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new sizeGiayDTO, or with status {@code 400 (Bad Request)} if the sizeGiay has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/size-giays")
    public ResponseEntity<SizeGiayDTO> createSizeGiay(@RequestBody SizeGiayDTO sizeGiayDTO) throws URISyntaxException {
        log.debug("REST request to save SizeGiay : {}", sizeGiayDTO);

        SizeGiayDTO result = sizeGiayService.save(sizeGiayDTO);
        return ResponseEntity
            .created(new URI("/api/size-giays/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId()))
            .body(result);
    }

    /**
     * {@code PUT  /size-giays/:id} : Updates an existing sizeGiay.
     *
     * @param id the id of the sizeGiayDTO to save.
     * @param sizeGiayDTO the sizeGiayDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated sizeGiayDTO,
     * or with status {@code 400 (Bad Request)} if the sizeGiayDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the sizeGiayDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/size-giays/{id}")
    public ResponseEntity<SizeGiayDTO> updateSizeGiay(
        @PathVariable(value = "id", required = false) final String id,
        @RequestBody SizeGiayDTO sizeGiayDTO
    ) throws URISyntaxException {
        log.debug("REST request to update SizeGiay : {}, {}", id, sizeGiayDTO);


        SizeGiayDTO result = sizeGiayService.update(sizeGiayDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, sizeGiayDTO.getId()))
            .body(result);
    }

    /**
     * {@code PATCH  /size-giays/:id} : Partial updates given fields of an existing sizeGiay, field will ignore if it is null
     *
     * @param id the id of the sizeGiayDTO to save.
     * @param sizeGiayDTO the sizeGiayDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated sizeGiayDTO,
     * or with status {@code 400 (Bad Request)} if the sizeGiayDTO is not valid,
     * or with status {@code 404 (Not Found)} if the sizeGiayDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the sizeGiayDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/size-giays/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<SizeGiayDTO> partialUpdateSizeGiay(
        @PathVariable(value = "id", required = false) final String id,
        @RequestBody SizeGiayDTO sizeGiayDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update SizeGiay partially : {}, {}", id, sizeGiayDTO);


        Optional<SizeGiayDTO> result = sizeGiayService.partialUpdate(sizeGiayDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, sizeGiayDTO.getId())
        );
    }

    /**
     * {@code GET  /size-giays} : get all the sizeGiays.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of sizeGiays in body.
     */
    @GetMapping("/size-giays")
    public ResponseEntity<List<SizeGiayDTO>> getAllSizeGiays(
        SizeGiayCriteria criteria,
        @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get SizeGiays by criteria: {}", criteria);
        Page<SizeGiayDTO> page = sizeGiayQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /size-giays/count} : count all the sizeGiays.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/size-giays/count")
    public ResponseEntity<Long> countSizeGiays(SizeGiayCriteria criteria) {
        log.debug("REST request to count SizeGiays by criteria: {}", criteria);
        return ResponseEntity.ok().body(sizeGiayQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /size-giays/:id} : get the "id" sizeGiay.
     *
     * @param id the id of the sizeGiayDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the sizeGiayDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/size-giays/{id}")
    public ResponseEntity<SizeGiayDTO> getSizeGiay(@PathVariable String id) {
        log.debug("REST request to get SizeGiay : {}", id);
        Optional<SizeGiayDTO> sizeGiayDTO = sizeGiayService.findOne(id);
        return ResponseUtil.wrapOrNotFound(sizeGiayDTO);
    }

    /**
     * {@code DELETE  /size-giays/:id} : delete the "id" sizeGiay.
     *
     * @param id the id of the sizeGiayDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/size-giays/{id}")
    public ResponseEntity<Void> deleteSizeGiay(@PathVariable String id) {
        log.debug("REST request to delete SizeGiay : {}", id);
        sizeGiayService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id)).build();
    }

    /**
     * {@code SEARCH  /_search/size-giays?query=:query} : search for the sizeGiay corresponding
     * to the query.
     *
     * @param query the query of the sizeGiay search.
     * @param pageable the pagination information.
     * @return the result of the search.
     */
    @GetMapping("/_search/size-giays")
    public ResponseEntity<List<SizeGiayDTO>> searchSizeGiays(
        @RequestParam String query,
        @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to search for a page of SizeGiays for query {}", query);
        Page<SizeGiayDTO> page = sizeGiayService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }
}
