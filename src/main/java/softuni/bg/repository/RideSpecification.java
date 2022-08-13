package softuni.bg.repository;

import org.springframework.data.jpa.domain.Specification;
import softuni.bg.model.dto.SearchRideDto;
import softuni.bg.model.entity.RideEntity;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class RideSpecification implements Specification<RideEntity> {
    private final SearchRideDto searchRideDto;

    public RideSpecification(SearchRideDto searchRideDto) {
        this.searchRideDto = searchRideDto;
    }

    @Override
    public Predicate toPredicate(Root<RideEntity> root,
                                 CriteriaQuery<?> query,
                                 CriteriaBuilder cb) {

        Predicate p = cb.conjunction();
//        p.getExpressions().add(cb.and(cb.isTrue(root.get("active"))));

        if (searchRideDto.getDeparture() != null && !searchRideDto.getDeparture().isEmpty()) {
            p.getExpressions().add(
                    cb.and(cb.equal(root.get("departure"), searchRideDto.getDeparture() + ", Bulgaria"))
            );
        }

        if (searchRideDto.getArrival() != null && !searchRideDto.getArrival().isEmpty()) {
            p.getExpressions().add(
                    cb.and(cb.equal(root.get("arrival"), searchRideDto.getArrival() + ", Bulgaria"))
            );
        }

        if (searchRideDto.getDepartureDate() != null) {
            p.getExpressions().add(
                    cb.and(cb.equal(root.get("departureDate"), searchRideDto.getDepartureDate()))
            );
        }


        if (searchRideDto.getDepartureTime() != null) {
            p.getExpressions().add(
                    cb.and(cb.greaterThanOrEqualTo(root.get("departureTime"), searchRideDto.getDepartureTime()))
            );
        }

        return p;
    }
}
