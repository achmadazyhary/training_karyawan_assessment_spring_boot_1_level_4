package project.group.assessment.trainingkaryawan.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.group.assessment.trainingkaryawan.model.KaryawanTraining;

@Repository
public interface KaryawanTrainingRepository extends JpaRepository<KaryawanTraining, Long> {

    @Query(value = "SELECT kt FROM KaryawanTraining kt ORDER BY kt.createdDate DESC")
    public Page<KaryawanTraining> getAllData(Pageable pageable);
}




