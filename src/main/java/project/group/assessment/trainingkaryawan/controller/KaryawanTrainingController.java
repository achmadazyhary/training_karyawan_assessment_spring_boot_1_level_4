package project.group.assessment.trainingkaryawan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.group.assessment.trainingkaryawan.model.KaryawanTraining;
import project.group.assessment.trainingkaryawan.service.implement.KaryawanTrainingServiceImp;

import java.util.Map;

@RestController
@RequestMapping("/v1/idstar/karyawan-training")
public class KaryawanTrainingController {

    @Autowired
    KaryawanTrainingServiceImp karyawanTrainingService;

    @PostMapping("/save")
    ResponseEntity<Map> create(@RequestBody KaryawanTraining request) {
        Map obj = karyawanTrainingService.create(request);
        return new ResponseEntity<Map>(obj, HttpStatus.OK);
    }

    @PutMapping("/update")
    ResponseEntity<Map> update(@RequestBody KaryawanTraining request) {
        Map obj = karyawanTrainingService.update(request);
        return new ResponseEntity<Map>(obj, HttpStatus.OK);
    }

    @GetMapping("/list")
    ResponseEntity<Map> list(@RequestParam Integer page,
                             @RequestParam Integer size) {
        Map obj = karyawanTrainingService.getAll(size,page);
        return new ResponseEntity<Map>(obj, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{karyawanTrainingID}")
    ResponseEntity<Map> getById(@PathVariable(value = "karyawanTrainingID") Long id) {
        Map obj = karyawanTrainingService.findById(id);
        return new ResponseEntity<Map>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    ResponseEntity<Map> delete(@RequestBody KaryawanTraining request) {
        Map obj = karyawanTrainingService.delete(request.getId());
        return new ResponseEntity<Map>(obj, HttpStatus.OK);
    }
}
