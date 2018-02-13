package com.mehuba.nearby.controller;

import com.mehuba.nearby.dao.mongo.ColleagueRepository;
import com.mehuba.nearby.model.Colleague;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhaoyibin on 17:27 13/02/2018
 */

@RestController
public class RecognitionController {

    @Resource
    private ColleagueRepository repository;

    @RequestMapping("/colleague/{name}")
    public List<Colleague> getRecognition(@PathVariable("name") String name) {
        return repository.findByName(name);
    }

    @RequestMapping("/colleagues")
    public List<Colleague> getColleagues(){
        return repository.findAll();
    }

    @PostMapping("/colleagues")
    public ResponseEntity<String> addColleague(@RequestBody Colleague colleague){
        repository.save(colleague);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //This is of course a very naive implementation! We are assuming unique names...
    @DeleteMapping("/colleagues/{name}")
    public ResponseEntity<String> deleteColleague(@PathVariable  String name){
        List<Colleague> colleagues = repository.findByName(name);
        if(colleagues.size() == 1) {
            Colleague colleague = colleagues.get(0);
            repository.delete(colleague);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
