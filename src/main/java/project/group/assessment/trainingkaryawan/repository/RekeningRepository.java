package project.group.assessment.trainingkaryawan.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.group.assessment.trainingkaryawan.dto.RekeningResponse;
import project.group.assessment.trainingkaryawan.model.Rekening;

@Repository
public interface RekeningRepository extends JpaRepository<Rekening, Long> {
    @Query(value = "SELECT DISTINCT new project.group.assessment.trainingkaryawan.dto.RekeningResponse(" +
            "r.createdDate, " +
            "r.updatedDate, " +
            "r.deletedDate, " +
            "r.id, " +
            "r.nama, " +
            "r.jenis, " +
            "r.rekening, " +
            "k.alamat, " +
            "new project.group.assessment.trainingkaryawan.dto.KaryawanDTO(" +
            "k.id, " +
            "k.nama)) " +
            "FROM Rekening r JOIN r.karyawan k ORDER BY r.createdDate DESC")
    public Page<RekeningResponse> getAllData(Pageable pageable);

}
