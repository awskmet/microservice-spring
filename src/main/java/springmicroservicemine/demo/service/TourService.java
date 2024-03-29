package springmicroservicemine.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springmicroservicemine.demo.domain.Difficulty;
import springmicroservicemine.demo.domain.Region;
import springmicroservicemine.demo.domain.Tour;
import springmicroservicemine.demo.domain.TourPackage;
import springmicroservicemine.demo.repo.TourPackageRepository;
import springmicroservicemine.demo.repo.TourRepository;

@Service
public class TourService {
    private TourRepository tourRepository;
    private TourPackageRepository tourPackageRepository;

    @Autowired
    public TourService(TourRepository tourRepository, TourPackageRepository tourPackageRepository) {
        this.tourRepository = tourRepository;
        this.tourPackageRepository = tourPackageRepository;
    }

    /**
     * Create a new Tour Object and persist it to the Database.
     *
     * @param title title
     * @param description description
     * @param blurb blurb
     * @param price price
     * @param duration duration
     * @param bullets comma-separated bullets
     * @param keywords keywords
     * @param tourPackageName tour package name
     * @param difficulty difficulty
     * @param region region
     * @return Tour Entity
     */
    public Tour createTour(String title, String description, String blurb, Integer price,
                           String duration, String bullets,
                           String keywords, String tourPackageName, Difficulty difficulty, Region region ) {
        //look up toru package
        TourPackage tourPackage = tourPackageRepository.findByName(tourPackageName)
        //if we can't find it, don't want to create a tour
        .orElseThrow(()->new RuntimeException("tour package doesn't exist: "+tourPackageName));
        //create tour in db
        return tourRepository.save(new Tour(title, description,blurb, price, duration, bullets, keywords, tourPackage, difficulty, region));
    }

    /**
     * Calculate the number of Tours in the Database.
     *
     * @return the total.
     */
    public long total() {
        return tourRepository.count();
    }

}