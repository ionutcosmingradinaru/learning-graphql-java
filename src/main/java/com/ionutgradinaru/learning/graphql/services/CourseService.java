package com.ionutgradinaru.learning.graphql.services;

import com.ionutgradinaru.learning.graphql.dao.CourseRepository;
import com.ionutgradinaru.learning.graphql.dao.generated.tables.pojos.Courses;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public Optional<Courses> findById(int courseId) {
        var entity = this.courseRepository.findById(courseId);
        return entity
                .map(e -> e.into(Courses.class));
    }

    public List<Courses> findAll() {
        var entities = this.courseRepository.findAll();
        return entities.stream()
                .map(e -> e.into(Courses.class))
                .toList();
    }

    public List<Courses> findByTeacherId(int teacherId) {
        var entities = this.courseRepository.findByTeacherId(teacherId);
        return entities.stream()
                .map(e -> e.into(Courses.class))
                .toList();
    }

    public List<Courses> findByStudentId(int studentId) {
        var entities = this.courseRepository.findByStudentId(studentId);
        return entities.stream()
                .map(e -> e.into(Courses.class))
                .toList();
    }
}
