package com.curious.course_management_service.controller;

import com.curious.course_management_service.entity.Course;
import com.curious.course_management_service.entity.Topic;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @GetMapping
    public List<Course> getAllCoursesForTopic (@RequestParam(required = false) String topic ) {
        Topic java = new Topic(1234, "Java", "Java Programming");
        return List.of(new Course(2345,"JavaBrains", "by Java Brains Guy",java));
    }
}
