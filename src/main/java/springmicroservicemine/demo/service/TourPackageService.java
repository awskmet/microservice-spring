package springmicroservicemine.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springmicroservicemine.demo.domain.TourPackage;
import springmicroservicemine.demo.repo.TourPackageRepository;

@Service
public class TourPackageService {
    private TourPackageRepository tourPackageRepository;

    @Autowired
    public TourPackageService(TourPackageRepository tourPackageRepository) {
        this.tourPackageRepository = tourPackageRepository;
    }

    /**
     * Create a Tour Package
     *
     * @param code code of the package
     * @param name name of the package
     *
     * @return new or existing tour package
     */
    public TourPackage createTourPackage(String code, String name) {
        //create new tour[ackage if one doesnt already exist
        return tourPackageRepository.findById(code).orElse(tourPackageRepository.save(new TourPackage(code, name)));
    }

    /**
     * Lookup All Tour packages
     *
     * @return all tour packages
     */
    public Iterable<TourPackage> lookup(){
        //returns all of them in db
        return tourPackageRepository.findAll();
    }

    public long total() {
        return tourPackageRepository.count();
    }
}