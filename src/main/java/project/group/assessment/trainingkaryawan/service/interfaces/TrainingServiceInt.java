package project.group.assessment.trainingkaryawan.service.interfaces;

import project.group.assessment.trainingkaryawan.model.Training;

import java.util.Map;

public interface TrainingServiceInt {
    Map create(Training request);
    Map update(Training request);
    Map getAll(int size, int page);
    Map findById(Long id);
    Map delete(Long id);
}
