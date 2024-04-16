package project.group.assessment.trainingkaryawan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import project.group.assessment.trainingkaryawan.model.audit.DateAudit;

import java.util.List;

@Entity
@Table(name = "training")
public class Training extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pengajar;

    private String tema;

    @JsonIgnore
    @OneToMany(mappedBy = "training", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<KaryawanTraining> karyawanTraining;

    public Training() {

    }

    public Training(Long id, String pengajar, String tema, List<KaryawanTraining> karyawanTraining) {
        this.id = id;
        this.pengajar = pengajar;
        this.tema = tema;
        this.karyawanTraining = karyawanTraining;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPengajar() {
        return pengajar;
    }

    public void setPengajar(String pengajar) {
        this.pengajar = pengajar;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    @Override
    public String toString() {
        return "Training{" +
                "id=" + id +
                ", pengajar='" + pengajar + '\'' +
                ", tema='" + tema + '\'' +
                '}';
    }
}
