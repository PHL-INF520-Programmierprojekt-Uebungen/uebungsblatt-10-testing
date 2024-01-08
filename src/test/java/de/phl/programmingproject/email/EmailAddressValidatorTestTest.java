package de.phl.programmingproject.email;

import bsh.EvalError;
import bsh.Interpreter;
import de.phl.programmingproject.TestUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Base64;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.internal.verification.VerificationModeFactory.atLeast;

/**
 * Test class for the {@link EmailAddressValidatorTest} exercise.
 */
public class EmailAddressValidatorTestTest {

    static List<Method> testMethods;
    static Object testObject;

    static MockedStatic<EmailAddressValidator> dummyStatic = mockStatic(EmailAddressValidator.class);

    @BeforeAll
    static void prepare() {
        testMethods = new LinkedList<>();

        Class<?> emailaddressValidatorTestClass = TestUtils.getClassForName("EmailAddressValidatorTest", "de.phl.programmingproject.email");
        testObject = TestUtils.createInstance(emailaddressValidatorTestClass);

        // extract all test methods
        Method[] methods = emailaddressValidatorTestClass.getDeclaredMethods();
        for (Method method : methods) {
            if (Arrays.stream(method.getAnnotations()).anyMatch(annotation -> annotation.annotationType().equals(Test.class))) {
                testMethods.add(method);
            }
        }
    }

    @BeforeEach
    void reset() {
        dummyStatic.reset();
        dummyStatic.when(() -> EmailAddressValidator.validate(Mockito.any(String.class))).thenCallRealMethod();
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
    void task_1_email_address_validator_implemented(){
        Interpreter i = new Interpreter();

        String secret = TestUtils.getFileContentForFileInRootOrSrcDirectory("secretb64.txt");
        String code = new String(Base64.getDecoder().decode(secret));
        try {
            i.eval(code);
        } catch (EvalError e) {
            e.printStackTrace();
            fail("The 'validate' method of the EmailAddressValidator class failed to (in-)validate, i.e., tests failed.");
        }
    }

    @Test
    void task_2_all_tests_pass(){
        executeAllTests();
    }

    @Test
    void task_2_validate_method_is_tested(){
        executeAllTests();
        dummyStatic.verify(() -> EmailAddressValidator.validate(Mockito.any(String.class)), atLeast(3));
    }

    @Test
    void task_2_validate_method_with_string_containing_multiple_at_signs_tested(){
        executeAllTests();
        try{
            dummyStatic.verify(() -> EmailAddressValidator.validate(argThat(argument -> argument.contains("@") && argument.indexOf("@") != argument.lastIndexOf("@"))), atLeast(1));
        }
        catch (Exception e){
            fail("The 'validate' method of the EmailAddressValidator class is not tested with a string containing multiple at signs.");
        }
    }

    @Test
    void task_2_validate_method_with_string_containing_at_sign_at_start_tested(){
        executeAllTests();
        try{
            dummyStatic.verify(() -> EmailAddressValidator.validate(argThat(argument -> argument.startsWith("@"))), atLeast(1));
        }
        catch (Exception e){
            fail("The 'validate' method of the EmailAddressValidator class is not tested with a string containing an at sign at the start.");
        }
    }

    @Test
    void task_2_validate_method_with_string_containing_at_sign_at_end_tested(){
        executeAllTests();
        try{
            dummyStatic.verify(() -> EmailAddressValidator.validate(argThat(argument -> argument.endsWith("@"))), atLeast(1));
        }
        catch (Exception e){
            fail("The 'validate' method of the EmailAddressValidator class is not tested with a string containing an at sign at the end.");
        }
    }

    @Test
    void task_2_validate_method_with_string_containing_spaces_tested(){
        executeAllTests();
        try{
            dummyStatic.verify(() -> EmailAddressValidator.validate(argThat(argument -> argument.contains(" "))), atLeast(1));
        }
        catch (Exception e){
            fail("The 'validate' method of the EmailAddressValidator class is not tested with a string containing spaces.");
        }
    }

}


