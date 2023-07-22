package com.filipeabessa.paokentin.batch;

import com.filipeabessa.paokentin.batch.dtos.CreateBatchDto;
import com.filipeabessa.paokentin.batch.dtos.GetBatchDto;
import com.filipeabessa.paokentin.breadtype.BreadTypeEntity;
import com.filipeabessa.paokentin.breadtype.BreadTypeRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.filipeabessa.paokentin.common.utils.Utils.getDateAfterMinutes;

@Service
public class BatchService {
    private final BatchRepository batchRepository;
    private final BreadTypeRepository breadTypeRepository;

    BatchService(BatchRepository batchRepository, BreadTypeRepository breadTypeRepository) {
        this.breadTypeRepository = breadTypeRepository;
        this.batchRepository = batchRepository;
    }

    public BatchEntity create(CreateBatchDto createBatchDto) {
        BreadTypeEntity breadType = breadTypeRepository.findById(createBatchDto.getBreadTypeId()).orElse(null);
        long timeToBake = breadType.getTimeToBake();

        BatchEntity batch = new BatchEntity();
        batch.setBreadTypeId(createBatchDto.getBreadTypeId());
        batch.setBreadsQuantity(createBatchDto.getQuantity());
        batch.setCreatedAt(new Date());
        batch.setFinishAt(getDateAfterMinutes(batch.getCreatedAt(), timeToBake));
        return batchRepository.create(batch);
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

    public List<GetBatchDto> findAll()  {
        return batchRepository.findAll();
    }

}
