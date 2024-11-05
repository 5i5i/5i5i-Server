package _i5i.AISecurity.web.domain.location.repository;

import _i5i.AISecurity.web.domain.location.entity.Location;
import _i5i.AISecurity.web.domain.posting.entity.Posting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location,Long> {
    Optional<Location> findByPosting(Posting posting);
}
