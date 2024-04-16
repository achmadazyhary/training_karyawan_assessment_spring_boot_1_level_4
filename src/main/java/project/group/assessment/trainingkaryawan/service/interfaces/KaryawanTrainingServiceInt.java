package project.group.assessment.trainingkaryawan.service.interfaces;

import project.group.assessment.trainingkaryawan.dto.KaryawanTrainingDTO;
import project.group.assessment.trainingkaryawan.model.KaryawanTraining;

import java.util.Map;

public interface KaryawanTrainingServiceInt {
    Map create(KaryawanTraining request);
    KaryawanTrainingDTO response(KaryawanTraining request);
    Map update(KaryawanTraining request);
    Map getAll(int size, int page);
    Map findById(Long id);
    Map delete(Long id);
}
