package project.group.assessment.trainingkaryawan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.group.assessment.trainingkaryawan.model.DetailKaryawan;

@Repository
public interface DetailKaryawanRepository extends JpaRepository<DetailKaryawan, Long> {
}
