package project.group.assessment.trainingkaryawan.model;

import jakarta.persistence.*;
import project.group.assessment.trainingkaryawan.model.audit.DateAudit;

@Entity
@Table(name = "detail_karyawan")
public class DetailKaryawan extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nik;

    private String npwp;

    @OneToOne(mappedBy = "detailKaryawan")
    private Karyawan karyawan;

    public DetailKaryawan() {

    }

    public DetailKaryawan(Long id, String nik, String npwp) {
        this.id = id;
        this.nik = nik;
        this.npwp = npwp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNik() {
        return this.nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNpwp() {
        return npwp;
    }

    public void setNpwp(String npwp) {
        this.npwp = npwp;
    }

    @Override
    public String toString() {
        return "DetailKaryawan{" +
                "id=" + id +
                ", nik='" + nik + '\'' +
                ", npwp='" + npwp + '\'' +
                '}';
    }
}
