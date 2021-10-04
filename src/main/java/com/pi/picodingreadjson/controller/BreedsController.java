package com.pi.picodingreadjson.controller;

import com.pi.picodingreadjson.model.BreedsModel;
import com.pi.picodingreadjson.service.BreedsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class BreedsController {

    private BreedsService breedsService;

    @Autowired
    public void setBreedsService(BreedsService breedsService) {
        this.breedsService = breedsService;
    }

    @GetMapping("/breeds/list/all")
    public ResponseEntity<BreedsModel> getAllData() throws IOException {
        return new ResponseEntity<>(breedsService.getAllData(), HttpStatus.OK);
    }

}
