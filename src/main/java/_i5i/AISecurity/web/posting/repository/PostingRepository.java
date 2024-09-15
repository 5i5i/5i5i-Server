package _i5i.AISecurity.web.posting.repository;

import _i5i.AISecurity.web.posting.entity.Posting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostingRepository extends JpaRepository<Posting,Long> {
}
