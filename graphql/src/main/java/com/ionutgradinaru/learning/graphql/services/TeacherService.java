package com.ionutgradinaru.learning.graphql.services;

import com.ionutgradinaru.learning.graphql.dao.TeacherRepository;
import com.ionutgradinaru.learning.graphql.dao.generated.tables.pojos.Teachers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public Optional<Teachers> findById(int teacherId) {
        var entity = this.teacherRepository.findById(teacherId);
        return entity.map(e -> e.into(Teachers.class));
    }

    public List<Teachers> findAll() {
        var entities = this.teacherRepository.findAll();
        return entities.stream()
                .map(e -> e.into(Teachers.class))
                .toList();
    }
}
