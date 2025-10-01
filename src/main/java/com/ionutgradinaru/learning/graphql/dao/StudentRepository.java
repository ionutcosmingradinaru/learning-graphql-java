package com.ionutgradinaru.learning.graphql.dao;

import com.ionutgradinaru.learning.graphql.dao.generated.tables.records.StudentsRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.ionutgradinaru.learning.graphql.dao.generated.Tables.STUDENTS;
import static com.ionutgradinaru.learning.graphql.dao.generated.Tables.STUDENT_ENROLLMENTS;

@Repository
public class StudentRepository {

    private final DSLContext dsl;

    @Autowired
    public StudentRepository(DSLContext dsl) {
        this.dsl = dsl;
    }

    public Optional<StudentsRecord> findById(int id) {
        return dsl.selectFrom(STUDENTS)
                .where(STUDENTS.STUDENT_ID.eq(id))
                .fetchOptional();
    }

    public List<StudentsRecord> findAll() {
        return dsl.selectFrom(STUDENTS)
                .stream()
                .toList();
    }

    public List<StudentsRecord> findByCourseId(int courseId) {
        return dsl.selectFrom(
                        STUDENTS.innerJoin(STUDENT_ENROLLMENTS)
                                .on(STUDENTS.STUDENT_ID.eq(STUDENT_ENROLLMENTS.STUDENT_ID))
                )
                .where(STUDENT_ENROLLMENTS.COURSE_ID.eq(courseId))
                .stream()
                .map(r -> r.into(StudentsRecord.class))
                .toList();
    }
}
