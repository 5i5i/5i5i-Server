package _i5i.AISecurity.web.domain.leaked_information.repository;

import _i5i.AISecurity.web.domain.leaked_information.entity.LeakedInformation;
import _i5i.AISecurity.web.domain.posting.entity.Posting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LeakedInformationRepository extends JpaRepository<LeakedInformation,Long> {
    Optional<LeakedInformation> findByPosting(Posting posting);
}
