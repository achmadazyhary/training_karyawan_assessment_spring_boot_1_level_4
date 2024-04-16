package project.group.assessment.trainingkaryawan.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.group.assessment.trainingkaryawan.model.Training;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {
    @Query(value = "SELECT t FROM Training t ORDER BY t.createdDate DESC")
    public Page<Training> getAllData(Pageable pageable);
}
