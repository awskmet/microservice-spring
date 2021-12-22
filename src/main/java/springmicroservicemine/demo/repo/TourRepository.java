package springmicroservicemine.demo.repo;

import org.springframework.data.repository.CrudRepository;
import springmicroservicemine.demo.domain.Tour;

import java.util.List;

public interface TourRepository extends CrudRepository<Tour, Integer> { //type of id or tour is integer
    List<Tour> findByTourPackageCode(String code);
}
