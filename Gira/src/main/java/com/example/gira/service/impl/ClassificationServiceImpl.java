package com.example.gira.service.impl;

import com.example.gira.model.entity.ClassificationEntity;
import com.example.gira.model.entity.enums.ClassificationNameEnum;
import com.example.gira.repository.ClassificationRepository;
import com.example.gira.service.ClassificationService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ClassificationServiceImpl implements ClassificationService {
    private final ClassificationRepository classificationRepository;

    public ClassificationServiceImpl(ClassificationRepository classificationRepository) {
        this.classificationRepository = classificationRepository;
    }

    @Override
    public void initClassifications() {
        if (classificationRepository.count() == 0) {
            Arrays.stream(ClassificationNameEnum.values())
                    .forEach(classificationNameEnum -> classificationRepository.save(new ClassificationEntity(classificationNameEnum,
                            "Description for " + classificationNameEnum.name())));
        }
    }

    @Override
    public ClassificationEntity findTaskByClassificationName(ClassificationNameEnum name) {
        return classificationRepository.findByName(name)
                .orElse(null);
    }
}
