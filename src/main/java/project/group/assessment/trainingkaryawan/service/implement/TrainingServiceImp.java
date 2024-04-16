package project.group.assessment.trainingkaryawan.service.implement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project.group.assessment.trainingkaryawan.model.Training;
import project.group.assessment.trainingkaryawan.repository.TrainingRepository;
import project.group.assessment.trainingkaryawan.service.interfaces.TrainingServiceInt;
import project.group.assessment.trainingkaryawan.util.TemplateResponse;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class TrainingServiceImp implements TrainingServiceInt {

    @Autowired
    TrainingRepository trainingRepository;

    @Autowired
    TemplateResponse response;

    private static final Logger log = LoggerFactory.getLogger(TrainingServiceImp.class);

    @Override
    public Map create(Training request) {
        log.info("masuk-createTraining");
        try {
            Training training = new Training();
            training.setTema(request.getTema());
            training.setPengajar(request.getPengajar());
            training.setCreatedDate(LocalDateTime.now());
            training.setUpdatedDate(LocalDateTime.now());

            Training save = trainingRepository.save(training);
            return response.success(save);
        } catch (Exception e) {
            log.info("error-createTraining ", e);
            return response.error(e);
        }
    }

    @Override
    public Map update(Training request) {
        log.info("masuk-updateTraining");
        try {
            if (response.checkNull(request.getId())) {
                return response.error("ID Training is required");
            }

            Training getTraining = trainingRepository.getById(request.getId());
            if (response.checkNull(getTraining)) {
                return response.notFound("ID Training Not Found");
            }
            getTraining.setTema(request.getTema());
            getTraining.setPengajar(request.getPengajar());
            getTraining.setUpdatedDate(LocalDateTime.now());

            Training save = trainingRepository.save(getTraining);
            return response.success(save);
        } catch (Exception e) {
            log.info("error-updateTraining ", e);
            return response.error(e);
        }
    }

    @Override
    public Map getAll(int size, int page) {
        log.info("masuk-listTraining");
        try {
            Pageable paging = PageRequest.of(page,size);
            Page<Training> list = trainingRepository.getAllData(paging);
            return response.success(list);
        } catch (Exception e) {
            log.info("error-listTraining ", e);
            return response.error(e);
        }
    }

    @Override
    public Map findById(Long id) {
        log.info("masuk-getByIDTraining");
        try {
            Training getTraining = trainingRepository.findById(id).get();
            return response.success(getTraining);
        } catch (Exception e) {
            log.info("error-getByIDTraining ", e);
            return response.error(e);
        }
    }

    @Override
    public Map delete(Long id) {
        log.info("masuk-deleteTraining");
        try {
            if(response.checkNull(id)) {
                response.error("ID Training is required");
            }

            Training getTraining = trainingRepository.findById(id).get();
            if (response.checkNull(getTraining)) {
                return response.notFound("ID Training not found");
            }
            getTraining.setDeletedDate(LocalDateTime.now());
            trainingRepository.save(getTraining);

            return response.success("Sukses delete");
        } catch (Exception e) {
            log.info("error-deleteTraining ", e);
            return response.error(e);
        }
    }
}
