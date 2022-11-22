package com.whoslooz.whoslooz.controllers;
import com.whoslooz.whoslooz.entities.LoozItem;
import com.whoslooz.whoslooz.repositories.LoozRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class whosLoozController {
    LoozItem loozItem;
    @Autowired
    LoozRepository loozRepository;

    @GetMapping("/looz")
    public ResponseEntity<List<LoozItem>> getAllLoozItems() {
        try {
            List loozItems = new ArrayList<LoozItem>();
                loozRepository.findAll().forEach(loozItems::add);
            if (loozItems.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(loozItems, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/looz/{id}")
    public ResponseEntity<LoozItem> getLoozItemById(@PathVariable("id") String id) {
        Optional<LoozItem> loozData = loozRepository.findById(id);

        if (loozData.isPresent()) {
            return new ResponseEntity<>(loozData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/looz")
    public ResponseEntity<LoozItem> createLoozItem(@RequestBody LoozItem loozItem) {
        try {

                LoozItem _loozItem = loozRepository.save(new LoozItem(loozItem.getId(),loozItem.getName(),loozItem.getDays()));
            return new ResponseEntity<>(loozItem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/looz/{id}")
    public ResponseEntity<LoozItem> updateLoozItem(@PathVariable("id") String id, @RequestBody LoozItem loozItem) {
        Optional<LoozItem> loozData = loozRepository.findById(id);

        if (loozData.isPresent()) {
            LoozItem _loozItem = loozData.get();
            _loozItem.setId(loozItem.getId());
            _loozItem.setName(loozItem.getName());
            _loozItem.setDays(loozItem.getDays());
            return new ResponseEntity<>(loozRepository.save(_loozItem), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/looz/{id}")
    public ResponseEntity<HttpStatus> deleteLoozItem(@PathVariable("id") String id) {
        try {
            loozRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}