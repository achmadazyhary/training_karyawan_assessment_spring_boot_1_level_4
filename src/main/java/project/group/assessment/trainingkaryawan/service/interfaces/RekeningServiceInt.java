package project.group.assessment.trainingkaryawan.service.interfaces;

import project.group.assessment.trainingkaryawan.dto.RekeningRequest;
import project.group.assessment.trainingkaryawan.dto.RekeningResponse;
import project.group.assessment.trainingkaryawan.model.Rekening;

import java.util.Map;

public interface RekeningServiceInt {
    Map create(RekeningRequest request);
    RekeningResponse rekeningResponse(Rekening request);
    Map update(RekeningRequest request);
    Map getAll(int size, int page);
    Map findById(Long id);
    Map delete(Long id);

}
