package project.group.assessment.trainingkaryawan.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project.group.assessment.trainingkaryawan.dto.KaryawanRequest;
import project.group.assessment.trainingkaryawan.model.DetailKaryawan;
import project.group.assessment.trainingkaryawan.model.Karyawan;
import project.group.assessment.trainingkaryawan.repository.DetailKaryawanRepository;
import project.group.assessment.trainingkaryawan.repository.KaryawanRepository;
import project.group.assessment.trainingkaryawan.service.interfaces.KaryawanServiceInt;
import project.group.assessment.trainingkaryawan.util.TemplateResponse;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class KaryawanServiceImp implements KaryawanServiceInt {

    @Autowired
    KaryawanRepository karyawanRepository;

    @Autowired
    DetailKaryawanRepository detailKaryawanRepository;

    @Autowired
    TemplateResponse response;

    @Override
    public Map getAll(int size, int page) {
        try {
            Pageable paging = PageRequest.of(page,size);
            Page<Karyawan> list = karyawanRepository.getAllData(paging);
            return response.success(list);
        } catch (Exception e) {
            return response.error(e);
        }
    }

    @Override
    public Map findById(Long id) {
        try {
            return response.success(karyawanRepository.findById(id));
        } catch (Exception e) {
            return response.error(e);
        }
    }

    @Override
    public Map create(KaryawanRequest req) {
        try {
            DetailKaryawan detailKaryawan = new DetailKaryawan();
            detailKaryawan.setNik(req.getDetailKaryawan().getNik());
            detailKaryawan.setNpwp(req.getDetailKaryawan().getNpwp());
            detailKaryawan.setCreatedDate(LocalDateTime.now());
            detailKaryawan.setUpdatedDate(LocalDateTime.now());
            DetailKaryawan dkSave = detailKaryawanRepository.save(detailKaryawan);

            Karyawan karyawan = new Karyawan();
            karyawan.setNama(req.getNama());
            karyawan.setDob(req.getDob());
            karyawan.setStatus(req.getStatus());
            karyawan.setAlamat(req.getAlamat());
            karyawan.setDetailKaryawan(dkSave);
            karyawan.setCreatedDate(LocalDateTime.now());
            karyawan.setUpdatedDate(LocalDateTime.now());
            Karyawan kSave = karyawanRepository.save(karyawan);

            return response.success(kSave);
        } catch (Exception e) {
            return response.error(e);
        }
    }

    @Override
    public Map update(KaryawanRequest req) {
        try {
            if (response.checkNull(req.getId()) && response.checkNull(req.getDetailKaryawan().getId())) {
                return response.error("ID Karyawan is required");
            }

            Karyawan getKaryawan = karyawanRepository.getById(req.getId());
            DetailKaryawan getDetailKaryawan = detailKaryawanRepository.getById(req.getDetailKaryawan().getId());
            if (response.checkNull(getKaryawan) && response.checkNull(getDetailKaryawan)) {
                return response.notFound("ID Karyawan Not Found");
            }

            getDetailKaryawan.setNik(req.getDetailKaryawan().getNik());
            getDetailKaryawan.setNpwp(req.getDetailKaryawan().getNpwp());
            getDetailKaryawan.setUpdatedDate(LocalDateTime.now());
            DetailKaryawan dkSave = detailKaryawanRepository.save(getDetailKaryawan);

            getKaryawan.setNama(req.getNama());
            getKaryawan.setDob(req.getDob());
            getKaryawan.setStatus(req.getStatus());
            getKaryawan.setAlamat(req.getAlamat());
            getKaryawan.setDetailKaryawan(dkSave);
            getKaryawan.setUpdatedDate(LocalDateTime.now());
            Karyawan kSave = karyawanRepository.save(getKaryawan);

            return response.success(kSave);
        } catch (Exception e) {
            return response.error(e);
        }
    }

    @Override
    public Map delete(Long id) {
        try {
            if (response.checkNull(id)) {
                response.error("Karyawan ID is required");
            }

            Karyawan getKaryawan = karyawanRepository.getById(id);
            DetailKaryawan getDetailKaryawan = detailKaryawanRepository.getById(getKaryawan.getDetailKaryawan().getId());

            if (response.checkNull(getKaryawan)) {
                return response.notFound("Karyawan ID not found");
            }

            getDetailKaryawan.setDeletedDate(LocalDateTime.now());
            detailKaryawanRepository.save(getDetailKaryawan);

            getKaryawan.setDeletedDate(LocalDateTime.now());
            karyawanRepository.save(getKaryawan);

            return response.success("sukses deleted");
        } catch (Exception e) {
            return response.error(e);
        }
    }


}
