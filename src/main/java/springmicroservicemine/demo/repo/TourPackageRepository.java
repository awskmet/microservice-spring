package springmicroservicemine.demo.repo;

import org.springframework.data.repository.CrudRepository;
import springmicroservicemine.demo.domain.TourPackage;

import java.util.Optional;

public interface TourPackageRepository extends CrudRepository<TourPackage, String> { //tourpackage id is string
    //this queries db, can add as, contains, etc in these methods
    Optional<TourPackage> findByName(String name);
}
