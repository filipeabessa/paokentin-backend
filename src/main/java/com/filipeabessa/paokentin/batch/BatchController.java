package com.filipeabessa.paokentin.batch;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/batches")
public class BatchController {
    private final BatchService batchService;

    BatchController(BatchService batchService) {
        this.batchService = batchService;
    }

    @PostMapping
    public ResponseEntity<BatchEntity> create(@RequestBody BatchEntity batchEntity) {
        return ResponseEntity.ok(batchService.create(batchEntity));
    }

    @GetMapping
    public ResponseEntity<List<BatchEntity>> readAll() {
        return ResponseEntity.ok(batchService.findAll());
    }

    @GetMapping("{batchId}")
    public ResponseEntity<BatchEntity> read(@PathVariable long batchId) {
        return ResponseEntity.ok(batchService.findById(batchId));
    }

    @PatchMapping
    public ResponseEntity<BatchEntity> update(@RequestBody BatchEntity batchEntity) {
        return ResponseEntity.ok(batchService.update(batchEntity));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody BatchEntity batchEntity) {
        batchService.delete(batchEntity.getId());
        return ResponseEntity.ok().build();
    }
}
