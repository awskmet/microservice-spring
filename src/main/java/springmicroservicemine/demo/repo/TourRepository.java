package springmicroservicemine.demo.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import springmicroservicemine.demo.domain.Tour;

import java.util.List;

public interface TourRepository extends PagingAndSortingRepository<Tour, Integer> { //type of id or tour is integer
    Page<Tour> findByTourPackageCode(@Param("code")String code, Pageable pageable);
}
