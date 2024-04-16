package project.group.assessment.trainingkaryawan.service.implement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project.group.assessment.trainingkaryawan.dto.KaryawanDTO;
import project.group.assessment.trainingkaryawan.dto.RekeningRequest;
import project.group.assessment.trainingkaryawan.dto.RekeningResponse;
import project.group.assessment.trainingkaryawan.model.Karyawan;
import project.group.assessment.trainingkaryawan.model.Rekening;
import project.group.assessment.trainingkaryawan.repository.KaryawanRepository;
import project.group.assessment.trainingkaryawan.repository.RekeningRepository;
import project.group.assessment.trainingkaryawan.service.interfaces.RekeningServiceInt;
import project.group.assessment.trainingkaryawan.util.TemplateResponse;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class RekeningServiceImp implements RekeningServiceInt {

    @Autowired
    RekeningRepository rekeningRepository;

    @Autowired
    KaryawanRepository karyawanRepository;

    @Autowired
    TemplateResponse response;

    private static final Logger log = LoggerFactory.getLogger(RekeningServiceImp.class);

    @Override
    public Map create(RekeningRequest request) {
        log.info("masuk-createRekening");
        RekeningResponse results = new RekeningResponse();
        try {
            Rekening rekening = new Rekening();
            rekening.setJenis(request.getJenis());
            rekening.setNama(request.getNama());
            rekening.setRekening(request.getRekening());
            Karyawan getKaryawan = karyawanRepository.getById(request.getKaryawan().getId());
            rekening.setKaryawan(getKaryawan);
            rekening.setCreatedDate(LocalDateTime.now());
            rekening.setUpdatedDate(LocalDateTime.now());

            Rekening save = rekeningRepository.save(rekening);
            results = rekeningResponse(save);

            return response.success(results);
        } catch (Exception e) {
            log.info("error-createRekening ", e);
            return response.error(e);
        }
    }

    @Override
    public RekeningResponse rekeningResponse(Rekening request) {
        log.info("masuk-rekeningResponse");

        RekeningResponse result = new RekeningResponse();
        KaryawanDTO karyawan = new KaryawanDTO();

        try {
            result.setCreatedDate(request.getCreatedDate());
            result.setUpdatedDate(request.getUpdatedDate());
            result.setDeletedDate(request.getDeletedDate());
            result.setId(request.getId());
            result.setNama(request.getNama());
            result.setJenis(request.getJenis());
            result.setRekening(request.getRekening());
            result.setAlamat(request.getKaryawan().getAlamat());
            Karyawan getKaryawan = karyawanRepository.getById(request.getKaryawan().getId());
            karyawan.setId(getKaryawan.getId());
            karyawan.setNama(getKaryawan.getNama());
            result.setKaryawan(karyawan);
        } catch (Exception e) {
            log.error("error-rekeningResponse ", e);
        }

        return result;
    }

    @Override
    public Map update(RekeningRequest request) {
        log.info("masuk-updateRekening");
        RekeningResponse results = new RekeningResponse();
        try {
            if (response.checkNull(request.getId())) {
                return response.error("ID Rekening is required");
            }

            Rekening getRekening = rekeningRepository.getById(request.getId());
            if (response.checkNull(getRekening)) {
                return response.notFound("ID Rekening Not Found");
            }

            getRekening.setNama(request.getNama());
            getRekening.setJenis(request.getJenis());
            getRekening.setRekening(request.getRekening());
            Karyawan getKaryawan = karyawanRepository.getById(request.getKaryawan().getId());
            getRekening.setKaryawan(getKaryawan);
            getRekening.setUpdatedDate(LocalDateTime.now());
            Rekening save = rekeningRepository.save(getRekening);

            results = rekeningResponse(save);
            return response.success(results);
        } catch (Exception e) {
            log.info("error-updateRekening ");
            return response.error(e);
        }
    }

    @Override
    public Map getAll(int size, int page) {
        log.info("masuk-listRekening");
        try {
            Pageable paging = PageRequest.of(page,size);
            Page<RekeningResponse> list = rekeningRepository.getAllData(paging);
            return response.success(list);
        } catch (Exception e) {
            log.info("error-listRekening ", e);
            return response.error(e);
        }
    }

    @Override
    public Map findById(Long id) {
        log.info("masuk-getByIDRekening");
        RekeningResponse results = new RekeningResponse();
        try {
            Rekening getRekening = rekeningRepository.findById(id).get();
            results = rekeningResponse(getRekening);
            return response.success(results);
        } catch (Exception e) {
            log.info("error-getByIDRekening ", e);
            return response.error(e);
        }
    }

    @Override
    public Map delete(Long id) {
        log.info("masuk-deleteRekening");
        try {
            if(response.checkNull(id)) {
                response.error("ID Rekening is required");
            }

            Rekening getRekening = rekeningRepository.findById(id).get();
            if (response.checkNull(getRekening)) {
                return response.notFound("ID Rekening not found");
            }

            getRekening.setDeletedDate(LocalDateTime.now());
            rekeningRepository.save(getRekening);

            return response.success("Sukses delete");
        } catch (Exception e) {
            log.info("error-deleteRekening ", e);
            return response.error(e);
        }
    }
}
