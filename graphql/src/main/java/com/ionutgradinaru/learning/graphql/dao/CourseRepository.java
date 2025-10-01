package com.ionutgradinaru.learning.graphql.dao;

import com.ionutgradinaru.learning.graphql.dao.generated.tables.records.CoursesRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.ionutgradinaru.learning.graphql.dao.generated.Tables.COURSES;
import static com.ionutgradinaru.learning.graphql.dao.generated.Tables.STUDENT_ENROLLMENTS;

@Repository
public class CourseRepository {

    private final DSLContext dsl;

    @Autowired
    public CourseRepository(DSLContext dsl) {
        this.dsl = dsl;
    }

    public Optional<CoursesRecord> findById(int courseId) {
        return dsl.selectFrom(COURSES)
                .where(COURSES.COURSE_ID.eq(courseId))
                .fetchOptional();
    }

    public List<CoursesRecord> findAll() {
        return dsl.selectFrom(COURSES).stream().toList();
    }

    public List<CoursesRecord> findByTeacherId(int teacherId) {
        return dsl.selectFrom(COURSES)
                .where(COURSES.TEACHER_ID.eq(teacherId))
                .stream()
                .toList();
    }

    public List<CoursesRecord> findByStudentId(int studentId) {
        return dsl.selectFrom(
                        COURSES.innerJoin(STUDENT_ENROLLMENTS)
                                .on(COURSES.COURSE_ID.eq(STUDENT_ENROLLMENTS.COURSE_ID))
                )
                .where(STUDENT_ENROLLMENTS.STUDENT_ID.eq(studentId))
                .stream()
                .map(r -> r.into(CoursesRecord.class))
                .toList();
    }
}
