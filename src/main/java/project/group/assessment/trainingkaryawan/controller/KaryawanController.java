package project.group.assessment.trainingkaryawan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.group.assessment.trainingkaryawan.dto.KaryawanRequest;
import project.group.assessment.trainingkaryawan.service.implement.KaryawanServiceImp;

import java.util.Map;

@RestController
@RequestMapping("/v1/idstar/karyawan")
public class KaryawanController {

    @Autowired
    KaryawanServiceImp karyawanService;

    @PostMapping("/save")
    ResponseEntity<Map> create(@RequestBody KaryawanRequest request) {
        Map obj = karyawanService.create(request);
        return new ResponseEntity<Map>(obj,HttpStatus.OK);
    }

    @PutMapping("/update")
    ResponseEntity<Map> update(@RequestBody KaryawanRequest request) {
        Map map = karyawanService.update(request);
        return new ResponseEntity<Map>(map,HttpStatus.OK);
    }

    @GetMapping("/list")
    ResponseEntity<Map> list(@RequestParam Integer page,
                             @RequestParam Integer size) {
        Map list = karyawanService.getAll(size,page);
        return new ResponseEntity<Map>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{karyawanID}")
    ResponseEntity<Map> getById(@PathVariable(value = "karyawanID") Long id) {
        Map getByID = karyawanService.findById(id);
        return new ResponseEntity<Map>(getByID, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    ResponseEntity<Map> delete(@RequestBody KaryawanRequest request) {
        Map map = karyawanService.delete(request.getId());
        return new ResponseEntity<Map>(map, HttpStatus.OK);
    }
}
