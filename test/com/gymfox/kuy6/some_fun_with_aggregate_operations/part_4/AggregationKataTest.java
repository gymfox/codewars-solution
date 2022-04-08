package com.gymfox.kuy6.some_fun_with_aggregate_operations.part_4;

import com.gymfox.kuy6.some_fun_with_aggregate_operations.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

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
    public void basicTestGetTheNumberOfStudentsByGenderForEachDepartment() throws Exception {

        Map<String, Map<Student.Gender, Long>> actual = AggregationKata.getTheNumberOfStudentsByGenderForEachDepartment(Arrays.stream(students));
        Map<String, Map<Student.Gender, Long>> expected = new HashMap<>();
        Map<Student.Gender, Long> map1 = new HashMap<>();
        Map<Student.Gender, Long> map2 = new HashMap<>();
        map1.put(Student.Gender.MALE, 1L);      // CS - Anton,
        map1.put(Student.Gender.FEMALE, 1L);    // CS - Jane
        map2.put(Student.Gender.MALE, 2L);      // Philology - Jack, Mike
        map2.put(Student.Gender.FEMALE, 1L);    // Philology - Galina

        expected.put("CS", map1);
        expected.put("Philology", map2);

        assertEquals(expected, actual);

    }
}