package com.gr1.shop.controller;



import com.gr1.shop.repository.AnhRepository;
import com.gr1.shop.service.AnhQueryService;
import com.gr1.shop.service.AnhService;
import com.gr1.shop.service.criteria.AnhCriteria;
import com.gr1.shop.service.dto.AnhDTO;

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
 * REST controller for managing {@link com.gr1.shop.domain.Anh}.
 */
@RestController
@RequestMapping("/api")
public class AnhResource {

    private final Logger log = LoggerFactory.getLogger(AnhResource.class);

    private static final String ENTITY_NAME = "anh";

    @Value("fashion shop")
    private String applicationName;

    private final AnhService anhService;

    private final AnhRepository anhRepository;

    private final AnhQueryService anhQueryService;

    public AnhResource(AnhService anhService, AnhRepository anhRepository, AnhQueryService anhQueryService) {
        this.anhService = anhService;
        this.anhRepository = anhRepository;
        this.anhQueryService = anhQueryService;
    }

    /**
     * {@code POST  /anhs} : Create a new anh.
     *
     * @param anhDTO the anhDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new anhDTO, or with status {@code 400 (Bad Request)} if the anh has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/anhs")
    public ResponseEntity<AnhDTO> createAnh(@RequestBody AnhDTO anhDTO) throws URISyntaxException {
        log.debug("REST request to save Anh : {}", anhDTO);
//        if (anhDTO.getId() != null) {
//            throw new BadRequestAlertException("A new anh cannot already have an ID", ENTITY_NAME, "idexists");
//        }
        AnhDTO result = anhService.save(anhDTO);
        return ResponseEntity
            .created(new URI("/api/anhs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /anhs/:id} : Updates an existing anh.
     *
     * @param id the id of the anhDTO to save.
     * @param anhDTO the anhDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated anhDTO,
     * or with status {@code 400 (Bad Request)} if the anhDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the anhDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/anhs/{id}")
    public ResponseEntity<AnhDTO> updateAnh(@PathVariable(value = "id", required = false) final Long id, @RequestBody AnhDTO anhDTO)
        throws URISyntaxException {
        log.debug("REST request to update Anh : {}, {}", id, anhDTO);
//        if (anhDTO.getId() == null) {
//            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
//        }
//        if (!Objects.equals(id, anhDTO.getId())) {
//            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
//        }
//
//        if (!anhRepository.existsById(id)) {
//            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
//        }

        AnhDTO result = anhService.update(anhDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, anhDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /anhs/:id} : Partial updates given fields of an existing anh, field will ignore if it is null
     *
     * @param id the id of the anhDTO to save.
     * @param anhDTO the anhDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated anhDTO,
     * or with status {@code 400 (Bad Request)} if the anhDTO is not valid,
     * or with status {@code 404 (Not Found)} if the anhDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the anhDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/anhs/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<AnhDTO> partialUpdateAnh(@PathVariable(value = "id", required = false) final Long id, @RequestBody AnhDTO anhDTO)
        throws URISyntaxException {
        log.debug("REST request to partial update Anh partially : {}, {}", id, anhDTO);
//        if (anhDTO.getId() == null) {
//            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
//        }
//        if (!Objects.equals(id, anhDTO.getId())) {
//            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
//        }
//
//        if (!anhRepository.existsById(id)) {
//            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
//        }

        Optional<AnhDTO> result = anhService.partialUpdate(anhDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, anhDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /anhs} : get all the anhs.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of anhs in body.
     */
    @GetMapping("/anhs")
    public ResponseEntity<List<AnhDTO>> getAllAnhs(AnhCriteria criteria, @org.springdoc.api.annotations.ParameterObject Pageable pageable) {
        log.debug("REST request to get Anhs by criteria: {}", criteria);
        Page<AnhDTO> page = anhQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /anhs/count} : count all the anhs.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/anhs/count")
    public ResponseEntity<Long> countAnhs(AnhCriteria criteria) {
        log.debug("REST request to count Anhs by criteria: {}", criteria);
        return ResponseEntity.ok().body(anhQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /anhs/:id} : get the "id" anh.
     *
     * @param id the id of the anhDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the anhDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/anhs/{id}")
    public ResponseEntity<AnhDTO> getAnh(@PathVariable String id) {
        log.debug("REST request to get Anh : {}", id);
        Optional<AnhDTO> anhDTO = anhService.findOne(id);
        return ResponseUtil.wrapOrNotFound(anhDTO);
    }

    /**
     * {@code DELETE  /anhs/:id} : delete the "id" anh.
     *
     * @param id the id of the anhDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/anhs/{id}")
    public ResponseEntity<Void> deleteAnh(@PathVariable String id) {
        log.debug("REST request to delete Anh : {}", id);
        anhService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }

    /**
     * {@code SEARCH  /_search/anhs?query=:query} : search for the anh corresponding
     * to the query.
     *
     * @param query the query of the anh search.
     * @param pageable the pagination information.
     * @return the result of the search.
     */
    @GetMapping("/_search/anhs")
    public ResponseEntity<List<AnhDTO>> searchAnhs(
        @RequestParam String query,
        @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to search for a page of Anhs for query {}", query);
        Page<AnhDTO> page = anhService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }
}
