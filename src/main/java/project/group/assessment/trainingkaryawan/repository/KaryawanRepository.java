package project.group.assessment.trainingkaryawan.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.group.assessment.trainingkaryawan.model.Karyawan;

@Repository
public interface KaryawanRepository extends JpaRepository<Karyawan, Long> {

    @Query("SELECT k FROM Karyawan k")
    public Page<Karyawan> getAllData(Pageable pageable);
}
