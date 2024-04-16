package project.group.assessment.trainingkaryawan.dto;

import lombok.Data;
import project.group.assessment.trainingkaryawan.model.audit.DateAudit;

@Data
public class TrainingDTO extends DateAudit {
    private Long id;
    private String pengajar;
    private String tema;

    public TrainingDTO() {

    }
}
