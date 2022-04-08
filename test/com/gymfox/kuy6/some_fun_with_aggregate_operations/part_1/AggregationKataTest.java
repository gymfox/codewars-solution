package com.gymfox.kuy6.some_fun_with_aggregate_operations.part_1;

import com.gymfox.kuy6.some_fun_with_aggregate_operations.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class AggregationKataTest {
    private Student[] students;

    @Before
    public void setUp() {

        //Generate a basic array of students:
        Student galina = new Student("Galina", 95, "Philology", Student.Gender.FEMALE);
        Student jack = new Student("Jack", 82, "Philology", Student.Gender.MALE);
        Student mike = new Student("Mike", 60, "Philology", Student.Gender.MALE);
        Student anton = new Student("Anton", 90, "CS", Student.Gender.MALE);
        Student jane = new Student("Jane", 65, "CS", Student.Gender.FEMALE);

        students = new Student[]{galina, anton, jack, mike, jane};
    }

    @Test
    public void basicTestGetAverageGradeByDepartment() throws Exception {

        Map<String, Double> actual = AggregationKata.getAverageGradeByDepartment(Arrays.stream(students));
        Map<String, Double> expected = new HashMap<>();
        expected.put("CS", 77.5);
        expected.put("Philology", 79.0);

        assertEquals(expected, actual);
}
}