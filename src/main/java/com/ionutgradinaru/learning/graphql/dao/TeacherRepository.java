package com.ionutgradinaru.learning.graphql.dao;

import com.ionutgradinaru.learning.graphql.dao.generated.tables.records.TeachersRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.ionutgradinaru.learning.graphql.dao.generated.Tables.TEACHERS;

@Repository
public class TeacherRepository {

    private final DSLContext dsl;

    @Autowired
    public TeacherRepository(DSLContext dsl) {
        this.dsl = dsl;
    }

    public Optional<TeachersRecord> findById(int teacherId) {
        return dsl.selectFrom(TEACHERS)
                .where(TEACHERS.TEACHER_ID.eq(teacherId))
                .fetchOptional();
    }

    public List<TeachersRecord> findAll() {
        return dsl.selectFrom(TEACHERS)
                .stream()
                .toList();
    }
}
