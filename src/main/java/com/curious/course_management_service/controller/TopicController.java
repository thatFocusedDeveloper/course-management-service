package com.curious.course_management_service.controller;

import com.curious.course_management_service.entity.Topic;
import com.curious.course_management_service.service.TopicService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {
    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }


    @GetMapping
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    // Using Request Param
    @GetMapping("/topic")
    public Topic getTopicById(@RequestParam Integer id) {
        return topicService.getTopicById(id);

    }

//    // Using same Path Variable name
//    @GetMapping("/{id}")
//    public Topic getTopicByIdUsingSamePathVariable(@PathVariable Integer id) {
//        // Path Variable generally match by name, if the name is different, we can provide the path variable name
//        return topicService.getTopicById(id);
//
//    }
//
//    // Using Different Path Variable name
//    @GetMapping("/{topicId}")
//    public Topic getTopicByIdUsingDiffPathVariable(@PathVariable("topicId") Integer id) {
//        // Path Variable generally match by name, if the name is different, we can provide the path variable name
//        return topicService.getTopicById(id);
//
//    }

    @PostMapping
    public void addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);
    }
}
