package _i5i.AISecurity.web.leaked_information.repository;

import _i5i.AISecurity.web.leaked_information.entity.LeakedInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeakedInformationRepository extends JpaRepository<LeakedInformation,Long> {
}
