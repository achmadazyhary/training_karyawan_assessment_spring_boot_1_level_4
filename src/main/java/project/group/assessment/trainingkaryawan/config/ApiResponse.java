package project.group.assessment.trainingkaryawan.config;

import lombok.Data;

@Data
public class ApiResponse<T> {
    private String code;
    private String status;
    private T data;
}
