package com.cydeo.repository;

import com.cydeo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Stream;

public interface CourseRepository extends JpaRepository <Course, Long> {

    //find all courses by category select * from courses where category = ....
    List <Course> findByCategory (String category); //In query, we don't need to use course as Spring knows already which table we are.

    //Find all courses by category and order the entities by name
    List<Course> findByCategoryOrderByName(String Category); //we need pass "where" not name, because it will be ordered behind the scene;

    //Checks if a course with the supplied name exists. Return true if exists, false otherwise
    boolean existsCourseByName (String name);

    //Returns the count of courses for the given category
    int countByCategory (String category);

    //Find all the courses that start with the given course name string
    List<Course> findByNameStartingWith(String name);

    ///find All courses by category and returns a stream
    Stream <Course> streamAllByCategory(String category);

    @Query("select c from Course  c where c.category = :category And c.rating > : rating")
    List<Course> retrieveAllByCategoryAndRatingGreaterThan(@Param("category") String category, @Param("rating") int rating);



}
