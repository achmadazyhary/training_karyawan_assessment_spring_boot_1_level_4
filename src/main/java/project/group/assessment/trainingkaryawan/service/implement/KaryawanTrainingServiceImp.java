package project.group.assessment.trainingkaryawan.service.implement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project.group.assessment.trainingkaryawan.dto.DetailKaryawanDTO;
import project.group.assessment.trainingkaryawan.dto.KaryawanDTO;
import project.group.assessment.trainingkaryawan.dto.KaryawanTrainingDTO;
import project.group.assessment.trainingkaryawan.dto.TrainingDTO;
import project.group.assessment.trainingkaryawan.model.DetailKaryawan;
import project.group.assessment.trainingkaryawan.model.Karyawan;
import project.group.assessment.trainingkaryawan.model.KaryawanTraining;
import project.group.assessment.trainingkaryawan.model.Training;
import project.group.assessment.trainingkaryawan.repository.DetailKaryawanRepository;
import project.group.assessment.trainingkaryawan.repository.KaryawanRepository;
import project.group.assessment.trainingkaryawan.repository.KaryawanTrainingRepository;
import project.group.assessment.trainingkaryawan.repository.TrainingRepository;
import project.group.assessment.trainingkaryawan.service.interfaces.KaryawanTrainingServiceInt;
import project.group.assessment.trainingkaryawan.util.TemplateResponse;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class KaryawanTrainingServiceImp implements KaryawanTrainingServiceInt {

    @Autowired
    KaryawanTrainingRepository karyawanTrainingRepository;

    @Autowired
    KaryawanRepository karyawanRepository;

    @Autowired
    TrainingRepository trainingRepository;

    @Autowired
    DetailKaryawanRepository detailKaryawanRepository;

    @Autowired
    TemplateResponse response;

    private static final Logger log = LoggerFactory.getLogger(KaryawanTrainingServiceImp.class);

    @Override
    public Map create(KaryawanTraining request) {
        log.info("masuk-createKaryawanTraining");
        KaryawanTrainingDTO result = new KaryawanTrainingDTO();
        try {
            KaryawanTraining karyawanTraining = new KaryawanTraining();
            karyawanTraining.setTanggal(request.getTanggal());
            Karyawan getKaryawan = karyawanRepository.getById(request.getKaryawan().getId());
            karyawanTraining.setKaryawan(getKaryawan);
            Training getTraining = trainingRepository.getById(request.getTraining().getId());
            karyawanTraining.setTraining(getTraining);
            karyawanTraining.setCreatedDate(LocalDateTime.now());
            karyawanTraining.setUpdatedDate(LocalDateTime.now());

            KaryawanTraining save = karyawanTrainingRepository.save(karyawanTraining);
            result = response(save);

            return response.success(result);
        } catch (Exception e) {
            log.info("error-createKaryawanTraining ", e);
            return response.error(e);
        }
    }

    @Override
    public KaryawanTrainingDTO response(KaryawanTraining request) {
        log.info("masuk-karyawanTrainingResponse");

        KaryawanTrainingDTO response = new KaryawanTrainingDTO();
        KaryawanDTO karyawan = new KaryawanDTO();
        DetailKaryawanDTO detailKaryawan = new DetailKaryawanDTO();
        TrainingDTO training = new TrainingDTO();

        try {
            response.setCreatedDate(request.getCreatedDate());
            response.setUpdatedDate(request.getUpdatedDate());
            response.setDeletedDate(request.getDeletedDate());
            response.setId(request.getId());

            //SET KARYAWAN
            Karyawan getKaryawan = karyawanRepository.getById(request.getKaryawan().getId());
            karyawan.setCreatedDate(getKaryawan.getCreatedDate());
            karyawan.setUpdatedDate(getKaryawan.getUpdatedDate());
            karyawan.setDeletedDate(getKaryawan.getDeletedDate());
            karyawan.setId(getKaryawan.getId());
            karyawan.setNama(getKaryawan.getNama());
            karyawan.setDob(getKaryawan.getDob());
            karyawan.setStatus(getKaryawan.getStatus());
            karyawan.setAlamat(getKaryawan.getAlamat());

            //SET DETAIL KARYAWAN
            DetailKaryawan getDetailKaryawan = detailKaryawanRepository.getById(getKaryawan.getDetailKaryawan().getId());
            detailKaryawan.setCreatedDate(getDetailKaryawan.getCreatedDate());
            detailKaryawan.setUpdatedDate(getDetailKaryawan.getUpdatedDate());
            detailKaryawan.setDeletedDate(getDetailKaryawan.getDeletedDate());
            detailKaryawan.setId(getDetailKaryawan.getId());
            detailKaryawan.setNik(getDetailKaryawan.getNik());
            detailKaryawan.setNpwp(getDetailKaryawan.getNpwp());
            karyawan.setDetailKaryawan(detailKaryawan);
            response.setKaryawan(karyawan);

            //SET TRAINING
            Training getTraining = trainingRepository.getById(request.getTraining().getId());
            training.setCreatedDate(getTraining.getCreatedDate());
            training.setUpdatedDate(getTraining.getUpdatedDate());
            training.setDeletedDate(getTraining.getDeletedDate());
            training.setId(getTraining.getId());
            training.setTema(getTraining.getTema());
            training.setPengajar(getTraining.getPengajar());
            response.setTraining(training);

            response.setTanggal(request.getTanggal());
        } catch (Exception e) {
            log.error("error-karyawanTrainingResponse ", e);
        }

        return response;
    }

    @Override
    public Map update(KaryawanTraining request) {
        log.info("masuk-updateKaryawanTraining");
        KaryawanTrainingDTO result = new KaryawanTrainingDTO();
        try {
            if (response.checkNull(request.getId())) {
                return response.error("ID Training is required");
            }

            KaryawanTraining getKaryawanTraining = karyawanTrainingRepository.getById(request.getId());
            if (response.checkNull(getKaryawanTraining)) {
                return response.notFound("ID Training Not Found");
            }

            Karyawan getKaryawan = karyawanRepository.getById(request.getKaryawan().getId());
            getKaryawanTraining.setKaryawan(getKaryawan);

            Training getTraining = trainingRepository.getById(request.getTraining().getId());
            getKaryawanTraining.setTraining(getTraining);

            getKaryawanTraining.setTanggal(request.getTanggal());
            getKaryawanTraining.setUpdatedDate(LocalDateTime.now());

            KaryawanTraining save = karyawanTrainingRepository.save(getKaryawanTraining);
            result = response(save);

            return response.success(result);
        } catch (Exception e) {
            log.info("error-updateKaryawanTraining ", e);
            return response.error(e);
        }
    }

    @Override
    public Map getAll(int size, int page) {
        log.info("masuk-listKaryawanTraining");
        try {
            Pageable paging = PageRequest.of(page,size);
            Page<KaryawanTraining> list = karyawanTrainingRepository.getAllData(paging);
            return response.success(list);
        } catch (Exception e) {
            log.info("error-listKaryawanTraining ", e);
            return response.error(e);
        }
    }

    @Override
    public Map findById(Long id) {
        log.info("masuk-getByIDKaryawanTraining");
        try {
            KaryawanTraining getKaryawanTraining = karyawanTrainingRepository.findById(id).get();
            return  response.success(getKaryawanTraining);
        } catch (Exception e) {
            log.info("error-getByIDKaryawanTraining ", e);
            return response.error(e);
        }
    }

    @Override
    public Map delete(Long id) {
        log.info("masuk-deleteKaryawanTraining");
        try {
            if(response.checkNull(id)) {
                response.error("ID Karyawan Training is required");
            }

            KaryawanTraining getKaryawanTraining = karyawanTrainingRepository.findById(id).get();
            if (response.checkNull(getKaryawanTraining)) {
                return response.notFound("ID Karyawan Training not found");
            }
            getKaryawanTraining.setDeletedDate(LocalDateTime.now());
            karyawanTrainingRepository.save(getKaryawanTraining);

            return response.success("Sukses Delete");
        } catch (Exception e) {
            log.info("error-deleteKaryawanTraining ", e);
            return response.error(e);
        }
    }
}
