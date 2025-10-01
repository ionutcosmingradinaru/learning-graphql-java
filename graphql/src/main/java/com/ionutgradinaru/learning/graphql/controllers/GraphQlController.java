package com.ionutgradinaru.learning.graphql.controllers;

import com.ionutgradinaru.learning.graphql.dao.generated.tables.pojos.Courses;
import com.ionutgradinaru.learning.graphql.dao.generated.tables.pojos.Students;
import com.ionutgradinaru.learning.graphql.dao.generated.tables.pojos.Teachers;
import com.ionutgradinaru.learning.graphql.services.CourseService;
import com.ionutgradinaru.learning.graphql.services.StudentService;
import com.ionutgradinaru.learning.graphql.services.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class GraphQlController {

    public final TeacherService teacherService;
    public final StudentService studentService;
    public final CourseService courseService;

    // ----- Teachers -----
    @QueryMapping(
            name = "teachers"
    )
    public List<Teachers> findAllTeachers() {
        return teacherService.findAll();
    }

    @QueryMapping(
            name = "teacherById"
    )
    public Teachers findTeacherById(@Argument Integer id) {
        return teacherService.findById(id).orElseThrow();
    }

    @SchemaMapping(
            typeName = "Teacher",
            field = "courses"
    )
    public List<Courses> findCoursesByTeacher(Teachers teacher) {
        return courseService.findByTeacherId(teacher.getTeacherId());
    }

    // ----- Students -----
    @QueryMapping(
            name = "students"
    )
    public List<Students> findAllStudents() {
        return studentService.findAll();
    }

    @QueryMapping(
            name = "studentById"
    )
    public Students findStudentById(@Argument Integer id) {
        return studentService.findById(id).orElseThrow();
    }

    @SchemaMapping(
            typeName = "Student",
            field = "courses"
    )
    public List<Courses> findCoursesByStudent(Students student) {
        return courseService.findByStudentId(student.getStudentId());
    }

    // ----- Courses -----
    @QueryMapping(
            name = "courses"
    )
    public List<Courses> findAllCourses() {
        return courseService.findAll();
    }

    @QueryMapping(
            name = "courseById"
    )
    public Courses findCourseById(@Argument Integer id) {
        return courseService.findById(id).orElseThrow();
    }

    @SchemaMapping(
            typeName = "Course",
            field = "teacher"
    )
    public Teachers findTeacherByCourse(Courses course) {
        return teacherService.findById(course.getTeacherId()).orElseThrow();
    }

    @SchemaMapping(
            typeName = "Course",
            field = "students"
    )
    public List<Students> findStudentsByCourse(Courses course) {
        return studentService.findByCourseId(course.getCourseId());
    }
}
