package springmicroservicemine.demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import springmicroservicemine.demo.domain.Tour;

import java.util.List;

public interface TourRepository extends PagingAndSortingRepository<Tour, Integer> { //type of id or tour is integer
    List<Tour> findByTourPackageCode(String code);
}
