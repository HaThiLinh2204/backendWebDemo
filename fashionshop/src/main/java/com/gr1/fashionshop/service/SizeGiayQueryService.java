package com.gr1.fashionshop.service;

import com.gr1.fashionshop.domain.*; // for static metamodels
import com.gr1.fashionshop.domain.SizeGiay;
import com.gr1.fashionshop.repository.SizeGiayRepository;
import com.gr1.fashionshop.service.criteria.SizeGiayCriteria;
import com.gr1.fashionshop.service.dto.SizeGiayDTO;
import com.gr1.fashionshop.service.mapper.SizeGiayMapper;
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
 * Service for executing complex queries for {@link SizeGiay} entities in the database.
 * The main input is a {@link SizeGiayCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link SizeGiayDTO} or a {@link Page} of {@link SizeGiayDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class SizeGiayQueryService extends QueryService<SizeGiay> {

    private final Logger log = LoggerFactory.getLogger(SizeGiayQueryService.class);

    private final SizeGiayRepository sizeGiayRepository;

    private final SizeGiayMapper sizeGiayMapper;



    public SizeGiayQueryService(
        SizeGiayRepository sizeGiayRepository,
        SizeGiayMapper sizeGiayMapper

    ) {
        this.sizeGiayRepository = sizeGiayRepository;
        this.sizeGiayMapper = sizeGiayMapper;

    }

    /**
     * Return a {@link List} of {@link SizeGiayDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<SizeGiayDTO> findByCriteria(SizeGiayCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<SizeGiay> specification = createSpecification(criteria);
        return sizeGiayMapper.toDto(sizeGiayRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link SizeGiayDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<SizeGiayDTO> findByCriteria(SizeGiayCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<SizeGiay> specification = createSpecification(criteria);
        return sizeGiayRepository.findAll(specification, page).map(sizeGiayMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(SizeGiayCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<SizeGiay> specification = createSpecification(criteria);
        return sizeGiayRepository.count(specification);
    }

    /**
     * Function to convert {@link SizeGiayCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<SizeGiay> createSpecification(SizeGiayCriteria criteria) {
        Specification<SizeGiay> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
//            if (criteria.getDistinct() != null) {
//                specification = specification.and(distinct(criteria.getDistinct()));
//            }
            if (criteria.getId() != null) {
                specification = specification.and(buildStringSpecification(criteria.getId(), SizeGiay_.id));
            }
            if (criteria.getIdSanpham() != null) {
                specification = specification.and(buildStringSpecification(criteria.getIdSanpham(), SizeGiay_.idSanpham));
            }
            if (criteria.getSoLuong() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getSoLuong(), SizeGiay_.soLuong));
            }
            if (criteria.getMauSac() != null) {
                specification = specification.and(buildStringSpecification(criteria.getMauSac(), SizeGiay_.mauSac));
            }
            if (criteria.getSizeName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getSizeName(), SizeGiay_.sizeName));
            }
//            if (criteria.getIsDeleted() != null) {
//                specification = specification.and(buildStringSpecification(criteria.getIsDeleted(), SizeGiay_.isDeleted));
//            }

        }
        return specification;
    }
}
