package com.gr1.fashionshop.controller;


import com.gr1.fashionshop.domain.Giay;
import com.gr1.fashionshop.repository.GiayRepository;
import com.gr1.fashionshop.service.GiayQueryService;
import com.gr1.fashionshop.service.GiayService;
import com.gr1.fashionshop.service.criteria.GiayCriteria;
import com.gr1.fashionshop.service.dto.GiayDTO;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import java.util.Optional;


import com.gr1.fashionshop.service.mapper.GiayMapper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.gr1.fashionshop.domain.Giay}.
 */
@Component

@RestController
@RequestMapping("/api")
public class GiayResource {

    private final Logger log = LoggerFactory.getLogger(GiayResource.class);

    private static final String ENTITY_NAME = "giay";

    @Value("fashion_shop")
    private String applicationName;

    private final GiayService giayService;

    private final GiayRepository giayRepository;

    private final GiayQueryService giayQueryService;

    private  final GiayMapper giayMapper;

    public GiayResource(
            GiayService giayService,
            GiayRepository giayRepository,
            GiayQueryService giayQueryService,
            GiayMapper giayMapper
    )
    {
        this.giayService = giayService;
        this.giayRepository = giayRepository;
        this.giayQueryService = giayQueryService;
        this.giayMapper = giayMapper;
    }
    /**
     * {@code GET  /giays} : get all the giays.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of giays in body.
     */
    @GetMapping("/giays")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<GiayDTO>> getAllGiays(
            GiayCriteria criteria,
            @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get Giays by criteria: {}", criteria);
        Page<GiayDTO> page = giayQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code POST  /giays} : Create a new giay.
     *
     * @param giayDTO the giayDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new giayDTO, or with status {@code 400 (Bad Request)} if the giay has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/giays")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<GiayDTO> createGiay(@RequestBody GiayDTO giayDTO) throws URISyntaxException {
        log.debug("REST request to save Giay : {}", giayDTO);

        GiayDTO result = giayService.save(giayDTO);
        return ResponseEntity
            .created(new URI("/api/giays/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId()))
            .body(result);
    }

    /**
     * {@code PUT  /giays/:id} : Updates an existing giay.
     *
     * @param id the id of the giayDTO to save.
     * @param giayDTO the giayDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated giayDTO,
     * or with status {@code 400 (Bad Request)} if the giayDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the giayDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/giays/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Giay> updateGiay(
            @PathVariable(value = "id", required = false) final String id,
            @RequestBody GiayDTO giayDTO)
    {
        Giay giay = giayMapper.toEntity(giayDTO);
        giay.id(id);
        Giay result = giayService.update(giay);
        return ResponseEntity.ok().body(result);

    }

    /**
     * {@code PATCH  /giays/:id} : Partial updates given fields of an existing giay, field will ignore if it is null
     *
     * @param id the id of the giayDTO to save.
     * @param giayDTO the giayDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated giayDTO,
     * or with status {@code 400 (Bad Request)} if the giayDTO is not valid,
     * or with status {@code 404 (Not Found)} if the giayDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the giayDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
//    @PatchMapping(value = "/giays/{id}", consumes = { "application/json", "application/merge-patch+json" })
//    public ResponseEntity<GiayDTO> partialUpdateGiay(
//        @PathVariable(value = "id", required = false) final String id,
//        @RequestBody GiayDTO giayDTO
//    ) throws URISyntaxException {
//        log.debug("REST request to partial update Giay partially : {}, {}", id, giayDTO);
//
//
//        Optional<GiayDTO> result = giayService.partialUpdate(giayDTO);
//
//        return ResponseUtil.wrapOrNotFound(result, HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, giayDTO.getId()));
//    }


    /**
     * {@code GET  /giays/count} : count all the giays.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/giays/count")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Long> countGiays(GiayCriteria criteria) {
        log.debug("REST request to count Giays by criteria: {}", criteria);
        return ResponseEntity.ok().body(giayQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /giays/:id} : get the "id" giay.
     *
     * @param id the id of the giayDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the giayDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/giays/{id}")
    public ResponseEntity<GiayDTO> getGiay(@PathVariable String id) {
        log.debug("REST request to get Giay : {}", id);
        Optional<GiayDTO> giayDTO = giayService.findOne(id);
        return ResponseUtil.wrapOrNotFound(giayDTO);
    }

    /**
     * {@code DELETE  /giays/:id} : delete the "id" giay.
     *
     * @param id the id of the giayDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/giays/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Void> deleteGiay(@PathVariable String id) {
        log.debug("REST request to delete Giay : {}", id);
        giayService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id)).build();
    }

    /**
     * {@code SEARCH  /_search/giays?query=:query} : search for the giay corresponding
     * to the query.
     *
     * @param query the query of the giay search.
     * @param pageable the pagination information.
     * @return the result of the search.
     */
//    @GetMapping("/_search/giays")
//    public ResponseEntity<List<GiayDTO>> searchGiays(
//        @RequestParam String query,
//        @org.springdoc.api.annotations.ParameterObject Pageable pageable
//    ) {
//        log.debug("REST request to search for a page of Giays for query {}", query);
//        Page<GiayDTO> page = giayService.search(query, pageable);
//        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
//        return ResponseEntity.ok().headers(headers).body(page.getContent());
//    }
}
