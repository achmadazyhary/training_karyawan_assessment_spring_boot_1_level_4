package project.group.assessment.trainingkaryawan.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import project.group.assessment.trainingkaryawan.model.audit.DateAudit;

import java.time.LocalDateTime;

@Entity
@Table(name = "karyawan_training")
public class KaryawanTraining extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime tanggal;

    @ManyToOne(targetEntity = Karyawan.class, cascade = CascadeType.ALL)
    private Karyawan karyawan;

    @ManyToOne(targetEntity = Training.class, cascade = CascadeType.ALL)
    @JoinColumn
    private Training training;

    public KaryawanTraining() {

    }

    public KaryawanTraining(Long id, LocalDateTime tanggal, Karyawan karyawan, Training training) {
        this.id = id;
        this.tanggal = tanggal;
        this.karyawan = karyawan;
        this.training = training;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTanggal() {
        return tanggal;
    }

    public void setTanggal(LocalDateTime tanggal) {
        this.tanggal = tanggal;
    }

    public Karyawan getKaryawan() {
        return karyawan;
    }

    public void setKaryawan(Karyawan karyawan) {
        this.karyawan = karyawan;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    @Override
    public String toString() {
        return "KaryawanTraining{" +
                "id=" + id +
                ", tanggal=" + tanggal +
                ", karyawan=" + karyawan +
                ", training=" + training +
                '}';
    }
}
