package project.group.assessment.trainingkaryawan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.group.assessment.trainingkaryawan.dto.RekeningRequest;
import project.group.assessment.trainingkaryawan.service.implement.RekeningServiceImp;

import java.util.Map;

@RestController
@RequestMapping("/v1/idstar/rekening")
public class RekeningController {

    @Autowired
    RekeningServiceImp rekeningService;

    @PostMapping("/save")
    ResponseEntity<Map> create(@RequestBody RekeningRequest request) {
        Map obj = rekeningService.create(request);
        return new ResponseEntity<Map>(obj, HttpStatus.OK);
    }

    @PutMapping("/update")
    ResponseEntity<Map> update(@RequestBody RekeningRequest request) {
        Map obj = rekeningService.update(request);
        return new ResponseEntity<Map>(obj, HttpStatus.OK);
    }

    @GetMapping("/list")
    ResponseEntity<Map> list(@RequestParam Integer page,
                             @RequestParam Integer size) {
        Map obj = rekeningService.getAll(size,page);
        return new ResponseEntity<Map>(obj, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{rekeningID}")
    ResponseEntity<Map> getById(@PathVariable(value = "rekeningID") Long id) {
        Map obj = rekeningService.findById(id);
        return new ResponseEntity<Map>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    ResponseEntity<Map> delete(@RequestBody RekeningRequest request) {
        Map obj = rekeningService.delete(request.getId());
        return new ResponseEntity<Map>(obj, HttpStatus.OK);
    }
}
