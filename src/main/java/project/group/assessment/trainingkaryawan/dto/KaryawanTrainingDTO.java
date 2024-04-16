package project.group.assessment.trainingkaryawan.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import project.group.assessment.trainingkaryawan.model.audit.DateAudit;

import java.time.LocalDateTime;

@Data
public class KaryawanTrainingDTO extends DateAudit {

    private Long id;
    private KaryawanDTO karyawan;
    private TrainingDTO training;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime tanggal;

    public KaryawanTrainingDTO() {

    }

    public KaryawanTrainingDTO(Long id, KaryawanDTO karyawan, TrainingDTO training, LocalDateTime tanggal) {
        this.id = id;
        this.karyawan = karyawan;
        this.training = training;
        this.tanggal = tanggal;
    }
}
