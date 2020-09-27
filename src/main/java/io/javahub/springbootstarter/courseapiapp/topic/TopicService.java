package io.javahub.springbootstarter.courseapiapp.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
    private List<Topic> topics = Arrays.asList(new Topic("spring", "Spring Framework", "Spring Framework Description"),
            new Topic("java", "Core Java", "Core Java Description"),
            new Topic("javascript", "JavaScript", "JavaScript Description"));

    public List<Topic> getAllTopics() {
        return topics;
    }

    public Topic getTopic(String id) {
        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public boolean addTopic(Topic topic) {
        return topics.add(topic);
    }

    public boolean deleteTopic(String id, String name) {
        return topics.removeIf(t -> t.getId().equals(id) && t.getName().equals(name));
    }

    public void editTopic(String id, String name, String desc) {
        Topic topic = topics.stream().filter(t -> t.getId().equals(id) && t.getName().equals(name)).findFirst().get();
        topic.setName(name);
        topic.setDescription(desc);
        topics.notify();
    }

}
