package com.gr1.shop.service;

import com.gr1.shop.domain.*; // for static metamodels
import com.gr1.shop.domain.Anh;
import com.gr1.shop.repository.AnhRepository;
import com.gr1.shop.service.criteria.AnhCriteria;
import com.gr1.shop.service.dto.AnhDTO;
import com.gr1.shop.service.mapper.AnhMapper;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.github.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link Anh} entities in the database.
 * The main input is a {@link AnhCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link AnhDTO} or a {@link Page} of {@link AnhDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class AnhQueryService extends QueryService<Anh> {

    private final Logger log = LoggerFactory.getLogger(AnhQueryService.class);

    private final AnhRepository anhRepository;

    private final AnhMapper anhMapper;


    public AnhQueryService(AnhRepository anhRepository, AnhMapper anhMapper) {
        this.anhRepository = anhRepository;
        this.anhMapper = anhMapper;
    }

    /**
     * Return a {@link List} of {@link AnhDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<AnhDTO> findByCriteria(AnhCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Anh> specification = createSpecification(criteria);
        return anhMapper.toDto(anhRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link AnhDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<AnhDTO> findByCriteria(AnhCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Anh> specification = createSpecification(criteria);
        return anhRepository.findAll(specification, page).map(anhMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(AnhCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Anh> specification = createSpecification(criteria);
        return anhRepository.count(specification);
    }

    /**
     * Function to convert {@link AnhCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Anh> createSpecification(AnhCriteria criteria) {
        Specification<Anh> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
//            if (criteria.getDistinct() != null) {
//                specification = specification.and(distinct(criteria.getDistinct()));
//            }
            if (criteria.getId() != null) {
                specification = specification.and(buildStringSpecification(criteria.getId(), Anh_.id));
            }
            if (criteria.getIdSanpham() != null) {
                specification = specification.and(buildStringSpecification(criteria.getIdSanpham(), Anh_.idSanpham));
            }
            if (criteria.getUrl() != null) {
                specification = specification.and(buildStringSpecification(criteria.getUrl(), Anh_.url));
            }
        }
        return specification;
    }
}
