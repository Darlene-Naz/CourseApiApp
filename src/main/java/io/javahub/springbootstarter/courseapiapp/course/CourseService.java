package io.javahub.springbootstarter.courseapiapp.course;

import java.util.ArrayList;
import java.util.List;
// import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    // private List<Topic> courses = new ArrayList<>(
    // Arrays.asList(
    // new Topic("spring", "Spring Framework", "Spring Framework Description"),
    // new Topic("java", "Core Java", "Core Java Description"),
    // new Topic("javascript", "JavaScript", "JavaScript Description")));

    public List<Course> getAllCourses(String topicId) {
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId).forEach(courses::add);
        return courses;

    }

    public Course getCourse(String id) {
        // return courses.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return courseRepository.findById(id).get();
    }

    public void addCourse(Course course) {
        // courses.add(course);
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        // courses.removeIf(t -> t.getId().equals(id));
        courseRepository.deleteById(id);
    }

    public void editCourse(Course course) {
        // courses.forEach((t) -> {
        // if (t.getId() == id) {
        // t = course;
        // return;
        // }
        // });
        courseRepository.save(course);
    }
}
