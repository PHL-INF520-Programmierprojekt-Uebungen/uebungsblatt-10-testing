package de.phl.programmingproject.arrayutils;

import de.phl.programmingproject.TestUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

/**
 * Test class for the {@link ArrayUtilitiesTest} exercise.
 */
public class ArrayUtilitiesTestTest {

    static List<Method> testMethods;
    static Object testObject;

    static MockedStatic<ArrayUtilities> dummyStatic = mockStatic(ArrayUtilities.class);

    @BeforeAll
    static void prepare() {
        testMethods = new LinkedList<>();

        Class<?> arrayUtilitiesTestClass = TestUtils.getClassForName("ArrayUtilitiesTest", "de.phl.programmingproject.arrayutils");
        testObject = TestUtils.createInstance(arrayUtilitiesTestClass);

        // extract all test methods
        Method[] methods = arrayUtilitiesTestClass.getDeclaredMethods();
        for (Method method : methods) {
            if (Arrays.stream(method.getAnnotations()).anyMatch(annotation -> annotation.annotationType().equals(Test.class))) {
                testMethods.add(method);
            }
        }

    }

    @BeforeEach
    void reset() {
        dummyStatic.reset();
        dummyStatic.when(() -> ArrayUtilities.sum(Mockito.any(int[].class))).thenCallRealMethod();
        dummyStatic.when(() -> ArrayUtilities.reverse(Mockito.any(int[].class))).thenCallRealMethod();
        dummyStatic.when(() -> ArrayUtilities.contains(Mockito.any(int[].class), Mockito.anyInt())).thenCallRealMethod();
    }

    static void executeAllTests() {
        for (Method method : testMethods) {
            try {
                method.invoke(testObject);
            } catch (Exception e) {
                e.printStackTrace();
                fail(String.format("The test method '%s' threw an exception: %s", method.getName(), e.getMessage()));
            }
        }
    }

    @Test
    void task_1_all_tests_pass() {
        executeAllTests();
    }

    @Test
    void task_1_sum_method_is_tested() {
        executeAllTests();
        dummyStatic.verify(() -> ArrayUtilities.sum(Mockito.any(int[].class)), atLeast(1));
    }

    @Test
    void task_3_reverse_method_with_empty_array_tested() {
        executeAllTests();
        try {
            dummyStatic.verify(() -> ArrayUtilities.reverse(argThat(argument -> argument.length == 0)), atLeast(1));
        } catch (Exception e) {
            fail("The 'reverse' method of the ArrayUtilities class is not tested with an empty array.");
        }
    }

    @Test
    void task_3_reverse_method_with_single_element_array_tested() {
        executeAllTests();
        try {
            dummyStatic.verify(() -> ArrayUtilities.reverse(argThat(argument -> argument.length == 1)), atLeast(1));
        } catch (Exception e) {
            fail("The 'reverse' method of the ArrayUtilities class is not tested with an array with a single element.");
        }
    }

    @Test
    void task_3_sum_method_with_empty_array_tested() {
        executeAllTests();
        try {
            dummyStatic.verify(() -> ArrayUtilities.sum(argThat(argument -> argument.length == 0)), atLeast(1));
        } catch (Exception e) {
            fail("The 'sum' method of the ArrayUtilities class is not tested with an empty array.");
        }
    }

    @Test
    void task_3_contains_method_with_empty_array_tested() {
        executeAllTests();
        try {
            dummyStatic.verify(() -> ArrayUtilities.contains(argThat(argument -> argument.length == 0), Mockito.anyInt()), atLeast(1));
        } catch (Exception e) {
            fail("The 'contains' method of the ArrayUtilities class is not tested with an empty array.");
        }
    }

    @Test
    void task_3_contains_method_with_array_with_single_element_tested() {
        executeAllTests();
        try {
            dummyStatic.verify(() -> ArrayUtilities.contains(argThat(argument -> argument.length == 1), Mockito.anyInt()), atLeast(1));
        } catch (Exception e) {
            fail("The 'contains' method of the ArrayUtilities class is not tested with an array with a single element.");
        }
    }

    @Test
    void task_5_reverse_method_is_tested_with_an_array_with_an_odd_number_of_elements() {
        executeAllTests();
        try {
            dummyStatic.verify(() -> ArrayUtilities.reverse(argThat(argument -> argument.length > 0 && argument.length % 2 == 1)), atLeast(1));
        } catch (Exception e) {
            fail("The 'reverse' method of the ArrayUtilities class is not tested with an array with an odd number of elements.");
        }
    }

    @Test
    void task_5_reverse_method_is_tested_with_an_array_with_an_even_number_of_elements() {
        executeAllTests();
        try {
            dummyStatic.verify(() -> ArrayUtilities.reverse(argThat(argument -> argument.length > 0 && argument.length % 2 == 0)), atLeast(1));
        } catch (Exception e) {
            fail("The 'reverse' method of the ArrayUtilities class is not tested with an array with an even number of elements.");
        }
    }
}
