package com.filipeabessa.paokentin.breadtype;

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
//            exceção
        }
        breadTypeRepository.deleteById(id);
    }

    public BreadTypeEntity findById(Long id) {
        return breadTypeRepository.findById(id).orElse(null);
    }

    public List<BreadTypeEntity> findAll() {
        return breadTypeRepository.findAll();
    }
}
