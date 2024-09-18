package _i5i.AISecurity.web.domain.personal_information.repository;

import _i5i.AISecurity.web.domain.personal_information.entity.PersonalInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalInformationRepository extends JpaRepository<PersonalInformation,Long> {
}
