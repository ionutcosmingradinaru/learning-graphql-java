# Getting Started

## GraphGL Schema
```graphql
type Query {
    teacherById(id: ID!): Teacher
    studentById(id: ID!): Student
    courseById(id: ID!): Course

    teachers: [Teacher!]!
    students: [Student!]!
    courses: [Course!]!
}

# ----- Teacher -----
type Teacher {
    teacherId: ID!
    firstName: String!
    lastName: String!
    email: String!
    hireDate: String
    courses: [Course!]
}

# ----- Student -----
type Student {
    studentId: ID!
    firstName: String!
    lastName: String!
    email: String!
    enrollmentDate: String
    courses: [Course!]
}

# ----- Course -----
type Course {
    courseId: ID!
    title: String!
    description: String
    startDate: String
    endDate: String
    teacherId: ID

    teacher: Teacher!
    students: [Student!]
}

```

## Examples of GraphQL queries
```graphql
query GetAllTeachers {
    teachers {
        teacherId
        firstName
        lastName
        email
        hireDate
    }
}

query GetAllTeachersWithCourseTitles {
    teachers {
        teacherId
        firstName
        lastName
        courses {
            courseId
            title
            description
        }
    }
}

query GetTeacherById {
    teacherById(id: 1) {
        teacherId
        firstName
        lastName
        courses {
            courseId
            title
            description
        }
    }
}

query GetAllStudents {
    students {
        studentId
        firstName
        lastName
        email
        enrollmentDate
    }
}

query GetAllStudentsWithCourseTitles {
    students {
        studentId
        firstName
        lastName
        enrollmentDate
        email
        courses {
            courseId
            title
        }
    }
}

query GetStudentById {
    studentById(id: 1) {
        studentId
        firstName
        lastName
        email
        enrollmentDate
        courses {
            courseId
            title
            description
        }
    }
}

query GetAllCourses {
    courses {
        courseId
        title
        description
        startDate
        endDate
        teacher {
            teacherId
            firstName
            lastName
        }
        students {
            studentId
            firstName
            lastName
            enrollmentDate
        }
    }
}

query GetCourseById {
    courseById(id: 1) {
        courseId
        title
        description
        startDate
        endDate
        teacher {
            teacherId
            firstName
            lastName
        }
        students {
            studentId
            firstName
            lastName
            enrollmentDate
        }
    }
}
```
