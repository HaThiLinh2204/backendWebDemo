package com.gr1.shop.service;

import com.gr1.shop.domain.Giay;

import com.gr1.shop.domain.Giay_;
import com.gr1.shop.repository.GiayRepository;

import com.gr1.shop.service.criteria.GiayCriteria;
import com.gr1.shop.service.dto.GiayDTO;
import com.gr1.shop.service.mapper.GiayMapper;
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
 * Service for executing complex queries for {@link Giay} entities in the database.
 * The main input is a {@link GiayCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link GiayDTO} or a {@link Page} of {@link GiayDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class GiayQueryService extends QueryService<Giay> {

    private final Logger log = LoggerFactory.getLogger(GiayQueryService.class);

    private final GiayRepository giayRepository;

    private final GiayMapper giayMapper;


    public GiayQueryService(GiayRepository giayRepository, GiayMapper giayMapper) {
        this.giayRepository = giayRepository;
        this.giayMapper = giayMapper;

    }

    /**
     * Return a {@link List} of {@link GiayDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<GiayDTO> findByCriteria(GiayCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Giay> specification = createSpecification(criteria);
        return giayMapper.toDto(giayRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link GiayDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<GiayDTO> findByCriteria(GiayCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Giay> specification = createSpecification(criteria);
        return giayRepository.findAll(specification, page).map(giayMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(GiayCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Giay> specification = createSpecification(criteria);
        return giayRepository.count(specification);
    }

    /**
     * Function to convert {@link GiayCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Giay> createSpecification(GiayCriteria criteria) {
        Specification<Giay> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
//            if (criteria.getDistinct() != null) {
//                specification = specification.and(distinct(criteria.getDistinct()));
//            }
            if (criteria.getId() != null) {
                specification = specification.and(buildStringSpecification(criteria.getId(), Giay_.id));
            }
            if (criteria.getTenGiay() != null) {
                specification = specification.and(buildStringSpecification(criteria.getTenGiay(), Giay_.tenGiay));
            }
            if (criteria.getGia() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getGia(), Giay_.gia));
            }
            if (criteria.getMoTa() != null) {
                specification = specification.and(buildStringSpecification(criteria.getMoTa(), Giay_.moTa));
            }
//            if (criteria.getSizeGiayId() != null) {
//                specification =
//                    specification.and(
//                        buildSpecification(criteria.getSizeGiayId(), root -> root.join(Giay_.sizeGiays, JoinType.LEFT).get(SizeGiay_.id))
//                    );
//            }
//            if (criteria.getAnhId() != null) {
//                specification =
//                    specification.and(buildSpecification(criteria.getAnhId(), root -> root.join(Giay_.anhs, JoinType.LEFT).get(Anh_.id)));
//            }
        }
        return specification;
    }
}
