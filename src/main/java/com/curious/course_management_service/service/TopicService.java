package com.curious.course_management_service.service;

import com.curious.course_management_service.entity.Topic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
    // Arrays.asList() retruns an Immutable List -> new ArrayList copies all the List elements and returns a Mutable List
    List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic(1234, "Java", "Java Programming 2"),
            new Topic(1235, "JavaScript", "JavaScript Programming"),
            new Topic(1236, "Spring", "Spring Boot Framework")
    ));
    public List<Topic> getAllTopics() {
        return topics;
    }

    public Topic getTopicById(Integer id) {
        return  topics.stream().filter(topic -> topic.getId() == id).findFirst().orElse(new Topic());
    }

    public void addTopic (Topic newTopic) {
        boolean isExistingTopic = getTopicById(newTopic.getId()).getId() != 0;
        if(!isExistingTopic) {
            topics.add(newTopic);
        }
    }

    public void updateTopic (Topic newTopic) {
//        boolean isExistingTopic = false;
//        for (int i = 0; i < topics.size(); i++) {
//            if (topics.get(i).getId() == newTopic.getId()) {
//                isExistingTopic = true;
//                topics.set(i,newTopic);
//            }
//        }
        topics.stream()
                .filter(topic -> topic.getId() == newTopic.getId())
                .findFirst()
                .ifPresent(existingTopic -> {
                    int index = topics.indexOf(existingTopic);
                    topics.set(index, newTopic);
                });
    }

    public void deleteTopic (Integer id) {
        topics.removeIf(topic -> topic.getId() == id);
    }
}
