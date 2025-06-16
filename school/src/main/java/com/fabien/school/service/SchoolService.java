package com.fabien.school.service;

import com.fabien.school.client.StudentClient;
import com.fabien.school.model.FullSchoolResponse;
import com.fabien.school.model.School;
import com.fabien.school.model.Student;
import com.fabien.school.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository schoolRepository;
    private final StudentClient studentClient;

    public void saveSchool(School student){
        schoolRepository.save(student);
    }

    public List<School> findAllSchools(){
        return schoolRepository.findAll();
    }

    public FullSchoolResponse findSchoolsWithStudents(Integer schoolId) {
        School school = schoolRepository.findById(schoolId).orElse(School.builder()
                .name("NOT_FOUND")
                .email("NOT_FOUND")
                .build());

        List<Student> students = studentClient.findAllStudentsBySchool(schoolId);
        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }
}
