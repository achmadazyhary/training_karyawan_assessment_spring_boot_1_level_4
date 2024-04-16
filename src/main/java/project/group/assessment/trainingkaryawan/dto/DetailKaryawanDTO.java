package project.group.assessment.trainingkaryawan.dto;

import lombok.Data;
import project.group.assessment.trainingkaryawan.model.audit.DateAudit;

@Data
public class DetailKaryawanDTO extends DateAudit {
    private Long id;
    private String nik;
    private String npwp;
}
