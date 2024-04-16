package project.group.assessment.trainingkaryawan.model;

import jakarta.persistence.*;
import project.group.assessment.trainingkaryawan.model.audit.DateAudit;

@Entity
@Table(name = "rekening")
public class Rekening extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String jenis;

    private String nama;

    private String rekening;

    @ManyToOne(targetEntity = Karyawan.class, cascade = CascadeType.ALL)
    private Karyawan karyawan;

    public Rekening() {

    }

    public Rekening(Long id, String jenis, String nama, String rekening, Karyawan karyawan) {
        this.id = id;
        this.jenis = jenis;
        this.nama = nama;
        this.rekening = rekening;
        this.karyawan = karyawan;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getRekening() {
        return rekening;
    }

    public void setRekening(String rekening) {
        this.rekening = rekening;
    }

    public Karyawan getKaryawan() {
        return karyawan;
    }

    public void setKaryawan(Karyawan karyawan) {
        this.karyawan = karyawan;
    }

    @Override
    public String toString() {
        return "Rekening{" +
                "id=" + id +
                ", jenis='" + jenis + '\'' +
                ", nama='" + nama + '\'' +
                ", rekening='" + rekening + '\'' +
                ", karyawan=" + karyawan +
                '}';
    }
}
