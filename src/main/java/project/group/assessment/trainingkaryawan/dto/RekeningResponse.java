package project.group.assessment.trainingkaryawan.dto;

import java.time.LocalDateTime;

public class RekeningResponse{
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private LocalDateTime deletedDate;
    private Long id;
    private String nama;
    private String jenis;
    private String rekening;
    private String alamat;
    private KaryawanDTO karyawan;

    public RekeningResponse() {

    }

    public RekeningResponse(LocalDateTime createdDate, LocalDateTime updatedDate, LocalDateTime deletedDate, Long id, String nama, String jenis, String rekening, String alamat, KaryawanDTO karyawan) {
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.deletedDate = deletedDate;
        this.id = id;
        this.nama = nama;
        this.jenis = jenis;
        this.rekening = rekening;
        this.alamat = alamat;
        this.karyawan = karyawan;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public LocalDateTime getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(LocalDateTime deletedDate) {
        this.deletedDate = deletedDate;
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

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getRekening() {
        return rekening;
    }

    public void setRekening(String rekening) {
        this.rekening = rekening;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public KaryawanDTO getKaryawan() {
        return karyawan;
    }

    public void setKaryawan(KaryawanDTO karyawan) {
        this.karyawan = karyawan;
    }
}
