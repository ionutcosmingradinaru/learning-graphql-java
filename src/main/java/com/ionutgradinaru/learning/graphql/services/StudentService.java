package com.ionutgradinaru.learning.graphql.services;

import com.ionutgradinaru.learning.graphql.dao.StudentRepository;
import com.ionutgradinaru.learning.graphql.dao.generated.tables.pojos.Students;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public Optional<Students> findById(int courseId) {
        var entity = this.studentRepository.findById(courseId);
        return entity
                .map(e -> e.into(Students.class));
    }

    public List<Students> findAll() {
        var entities = this.studentRepository.findAll();
        return entities.stream()
                .map(e -> e.into(Students.class))
                .toList();
    }

    public List<Students> findByCourseId(int courseId) {
        var entities = this.studentRepository.findByCourseId(courseId);
        return entities.stream()
                .map(e -> e.into(Students.class))
                .toList();
    }
}
