package project.group.assessment.trainingkaryawan.service.interfaces;

import project.group.assessment.trainingkaryawan.dto.KaryawanRequest;
import java.util.Map;

public interface KaryawanServiceInt {
    Map getAll(int size, int page);
    Map findById(Long id);
    Map create(KaryawanRequest req);
    Map update(KaryawanRequest req);
    Map delete(Long id);

}
