package com.filipeabessa.paokentin.breadtype;

import com.filipeabessa.paokentin.common.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreadTypeService {
    private final BreadTypeRepository breadTypeRepository;

    public BreadTypeService(BreadTypeRepository breadTypeRepository) {
        this.breadTypeRepository = breadTypeRepository;
    }

    public BreadTypeEntity create(BreadTypeEntity breadTypeEntity) {
        return breadTypeRepository.save(breadTypeEntity);
    }

    public BreadTypeEntity update(BreadTypeEntity breadTypeEntity) {
        return breadTypeRepository.save(breadTypeEntity);
    }

    public void delete(Long id) {
        if (!breadTypeRepository.existsById(id)) {
            throw new NotFoundException("Bread type with id" + id + "not found");
        }
        breadTypeRepository.deleteById(id);
    }

    public BreadTypeEntity findById(Long id) throws NotFoundException {
        if (!breadTypeRepository.existsById(id)) {
            throw new NotFoundException("Bread type with id" + id + "not found");
        }
        return breadTypeRepository.findById(id).orElse(null);
    }

    public List<BreadTypeEntity> findAll() {
        return breadTypeRepository.findAll();
    }
}
