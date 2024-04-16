package project.group.assessment.trainingkaryawan.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.format.annotation.DateTimeFormat;
import project.group.assessment.trainingkaryawan.model.audit.DateAudit;

import java.time.LocalDateTime;

public class KaryawanDTO extends DateAudit {
    private Long id;
    private String nama;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime dob;

    private String status;

    private String alamat;

    private DetailKaryawanDTO detailKaryawan;

    public KaryawanDTO() {

    }

    public KaryawanDTO(Long id, String nama, LocalDateTime dob, String status, String alamat, DetailKaryawanDTO detailKaryawan) {
        this.id = id;
        this.nama = nama;
        this.dob = dob;
        this.status = status;
        this.alamat = alamat;
        this.detailKaryawan = detailKaryawan;
    }

    public KaryawanDTO(Long id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public DetailKaryawanDTO getDetailKaryawan() {
        return detailKaryawan;
    }

    public void setDetailKaryawan(DetailKaryawanDTO detailKaryawan) {
        this.detailKaryawan = detailKaryawan;
    }
}
