package com.filipeabessa.paokentin.breadtype;

import com.filipeabessa.paokentin.common.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@RequestMapping("/breadtypes")
public class BreadTypeController {
    private final BreadTypeService breadTypeService;
    BreadTypeController(BreadTypeService breadTypeService) {
        this.breadTypeService = breadTypeService;
    }

    @PostMapping()
    public ResponseEntity<BreadTypeEntity> create(@RequestBody BreadTypeEntity breadTypeEntity) {
        try {
            return ResponseEntity.ok(breadTypeService.create(breadTypeEntity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{breadTypeId}")
    public ResponseEntity<BreadTypeEntity> read(@PathVariable long breadTypeId) {
        return ResponseEntity.ok(breadTypeService.findById(breadTypeId));
    }

    @GetMapping()
    public ResponseEntity<List<BreadTypeEntity>> readAll() {
        try {
            return ResponseEntity.ok(breadTypeService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PatchMapping()
    public ResponseEntity<BreadTypeEntity> update(@RequestBody BreadTypeEntity breadTypeEntity) {
        return ResponseEntity.ok(breadTypeService.update(breadTypeEntity));
    }

    @DeleteMapping("/{breadTypeId}")
    public ResponseEntity<Void> delete(@PathVariable Long breadTypeId) {
        try {
            breadTypeService.delete(breadTypeId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
}
