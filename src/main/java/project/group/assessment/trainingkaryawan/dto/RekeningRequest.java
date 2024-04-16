package project.group.assessment.trainingkaryawan.dto;

import lombok.Data;

@Data
public class RekeningRequest {

    private Long id;
    private String nama;
    private String jenis;
    private String rekening;
    private String alamat;
    private KaryawanRequest karyawan;
}
