package project.group.assessment.trainingkaryawan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.group.assessment.trainingkaryawan.model.Training;
import project.group.assessment.trainingkaryawan.service.implement.TrainingServiceImp;

import java.util.Map;

@RestController
@RequestMapping("/v1/idstar/training")
public class TrainingController {

    @Autowired
    TrainingServiceImp trainingService;

    @PostMapping("/save")
    ResponseEntity<Map> create(@RequestBody Training request) {
        Map obj = trainingService.create(request);
        return new ResponseEntity<Map>(obj, HttpStatus.OK);
    }

    @PutMapping("/update")
    ResponseEntity<Map> update(@RequestBody Training request) {
        Map obj = trainingService.update(request);
        return new ResponseEntity<Map>(obj, HttpStatus.OK);
    }

    @GetMapping("/list")
    ResponseEntity<Map> list(@RequestParam Integer page,
                             @RequestParam Integer size) {
        Map obj = trainingService.getAll(size,page);
        return new ResponseEntity<Map>(obj, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{trainingID}")
    ResponseEntity<Map> getById(@PathVariable(value = "trainingID") Long id) {
        Map obj = trainingService.findById(id);
        return new ResponseEntity<Map>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    ResponseEntity<Map> delete(@RequestBody Training request) {
        Map obj = trainingService.delete(request.getId());
        return new ResponseEntity<Map>(obj, HttpStatus.OK);
    }
}
