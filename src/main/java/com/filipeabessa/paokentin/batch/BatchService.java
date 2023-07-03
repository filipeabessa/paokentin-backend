package com.filipeabessa.paokentin.batch;

import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class BatchService {
    private final BatchRepository batchRepository;

    BatchService(BatchRepository batchRepository) {
        this.batchRepository = batchRepository;
    }

    public BatchEntity create(BatchEntity batchEntity) {
        return batchRepository.create(batchEntity);
    }

    public BatchEntity update(BatchEntity batchEntity) {
        Optional<BatchEntity> batch = batchRepository.findById(batchEntity.getId());


        if (batch.isPresent()) {
            return batchRepository.update(batchEntity);
        }
        return null;
    }

    public void delete(long id) {
        batchRepository.deleteById(id);
    }

    public BatchEntity findById(long id) {
        return batchRepository.findById(id).orElse(null);
    }

    public List<BatchEntity> findAll() {
        return batchRepository.findAll();
    }

}
