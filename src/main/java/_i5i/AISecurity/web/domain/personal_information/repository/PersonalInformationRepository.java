package _i5i.AISecurity.web.domain.personal_information.repository;

import _i5i.AISecurity.web.domain.member.entity.Member;
import _i5i.AISecurity.web.domain.personal_information.entity.PersonalInformation;
import _i5i.AISecurity.web.domain.posting.entity.Posting;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface PersonalInformationRepository extends JpaRepository<PersonalInformation,Long> {
     Optional<PersonalInformation> findByMember(Member member);
}
