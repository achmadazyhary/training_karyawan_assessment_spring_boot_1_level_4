package project.group.assessment.trainingkaryawan.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import project.group.assessment.trainingkaryawan.model.audit.DateAudit;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "karyawan")
public class Karyawan extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nama;

    private String status;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime dob;

    private String alamat;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detail_karyawan", referencedColumnName = "id")
    private DetailKaryawan detailKaryawan;

    @JsonIgnore
    @OneToMany (mappedBy = "karyawan", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Rekening> rekening;

    @JsonIgnore
    @OneToMany(mappedBy = "karyawan", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<KaryawanTraining> karyawanTraining;

    public Karyawan() {

    }

    public Karyawan(Long id, String nama, String status, LocalDateTime dob, String alamat, DetailKaryawan detailKaryawan, List<Rekening> rekening, List<KaryawanTraining> karyawanTraining) {
        this.id = id;
        this.nama = nama;
        this.status = status;
        this.dob = dob;
        this.alamat = alamat;
        this.detailKaryawan = detailKaryawan;
        this.rekening = rekening;
        this.karyawanTraining = karyawanTraining;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public DetailKaryawan getDetailKaryawan() {
        return detailKaryawan;
    }

    public void setDetailKaryawan(DetailKaryawan detailKaryawan) {
        this.detailKaryawan = detailKaryawan;
    }

    public List<Rekening> getRekening() {
        return rekening;
    }

    public void setRekening(List<Rekening> rekening) {
        this.rekening = rekening;
    }

    public List<KaryawanTraining> getKaryawanTraining() {
        return karyawanTraining;
    }

    public void setKaryawanTraining(List<KaryawanTraining> karyawanTraining) {
        this.karyawanTraining = karyawanTraining;
    }

    @Override
    public String toString() {
        return "Karyawan{" +
                "id=" + id +
                ", nama='" + nama + '\'' +
                ", status='" + status + '\'' +
                ", dob=" + dob +
                ", alamat='" + alamat + '\'' +
                ", detailKaryawan=" + detailKaryawan +
                ", rekening=" + rekening +
                ", karyawanTraining=" + karyawanTraining +
                '}';
    }
}
