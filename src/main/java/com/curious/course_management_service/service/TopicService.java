package com.curious.course_management_service.service;

import com.curious.course_management_service.entity.Topic;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    List<Topic> topics = Arrays.asList(
            new Topic(1234, "Java", "Java Programming 2"),
            new Topic(1235, "JavaScript", "JavaScript Programming"),
            new Topic(1236, "Spring", "Spring Boot Framework")
    );
    public List<Topic> getAllTopics() {
        return topics;
    }

    public Topic getTopicById(Integer id) {
        return  topics.stream().filter(topic -> topic.getId() == id).findFirst().orElse(new Topic());
    }
}
