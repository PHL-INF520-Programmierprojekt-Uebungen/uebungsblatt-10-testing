# Exercise Sheet: Testing with JUnit 5
[Link to German Version](./README.md)

[![Open in GitHub Codespaces](https://github.com/codespaces/badge.svg)](https://github.com/codespaces/new)

**Work in the browser:** After clicking, select your own repository under **Repository** (its name ends with your GitHub username), not the template. Alternatively, open your repository on GitHub and choose **Code → Codespaces → Create codespace on main**. How to work locally and run the tests is described in [TESTEN.md](./TESTEN.md) (German).


In this exercise sheet, you will learn to test source code with JUnit 5 to solve various exercises.

## Naming your tests

For naming your tests, you can follow the following guideline:
https://enterprisecraftsmanship.com/posts/you-naming-tests-wrong/

**Summary:**
* Don't use a rigid test naming policy.
* Name the tests as if you were describing the scenario in it to a non-programmer familiar with the problem domain.
* Separate words in the test name by underscores.
* Don't include the name of the method under test in the test name.

For example, you can name a test case for the `validate` operation in the `EmailAddressValidator` class as follows:
``` Java
@Test
void email_address_without_at_sign_is_invalid(){...}
```

## Exercise: Testing an Email Address Validator with JUnit

In this exercise, you will write a JUnit test suite for a Java class named `EmailAddressValidator`, which provides an operation to validate an email address.

1. In the `EmailAddressValidator` class, located in the package `de.phl.programmingproject.email`, implement the email address validation logic as per the following requirements:
   - An email address must contain a single "@" character.
   - The "@" character cannot be the first or last character in the email address.
   - The email address must have a valid top-level domain (e.g., ".com", ".edu", ".org").
   - The email address cannot contain any spaces.

*Note 1*: Please implement all logic in the `public static boolean validate(final String email)` method and do not add any additional methods to the `EmailAddressValidator` class.
This is to ensure that the test cases can be executed correctly. A solution with additional methods may very well be correct, but it will not be accepted by the test cases.

*Note 2*: you can try to implement the email address validation logic yourself, or you can use a regular expression to validate the email address.

2. Create a new Java file named `EmailAddressValidatorTest.java` in the respective test folder in your gradle project (if it does not exist), and write test cases for the `validate` operation of the `EmailAddressValidator` class. You should include test cases that cover the following scenarios:
   - Valid email addresses that meet all the validation requirements.
   - Invalid email addresses that fail one or more of the validation requirements, such as email addresses with multiple "@" characters, or email addresses with invalid top-level domains.
   - Edge cases, such as email addresses with only one character, or email addresses with the longest possible length.

*Note*: your implementation can be wrong at first and be repaired over time by identifying bugs via testing.

3. Run the JUnit test suite, and ensure that all tests pass.
4. Add more test cases to the `EmailAddressValidatorTest` class to cover additional edge cases and scenarios that you think may not have been covered in step 2 and 3.

Make sure that your test cases are well-organized, easy to read, and cover all possible scenarios for the `validate` operation in the `EmailAddressValidator` class.


## Exercise: Testing an ArrayUtilities with JUnit

In the package `de.phl.programmingproject.arrayutils`, you will find the `ArrayUtilities` class that contains various utility operations for working with arrays. Your task is to write a JUnit test suite that thoroughly tests all of the operations in this class.

1. Create a new Java file named `ArrayUtilitiesTest.java` in the gradle project's test folder (if it does not exist) and write test cases for the `sum` operation in the `ArrayUtilities` class.
2. Run the JUnit test suite, and ensure that all tests pass.
3. Add more test cases to the `ArrayUtilitiesTest` class to test the remaining operations in the `ArrayUtilities` class:
   * A test case for the `reverse` operation that tests an empty array.
   * A test case for the `reverse` operation that tests an array with a single element.
   * A test case for the `sum` operation that tests an empty array, if not already done in task 1.
   * A test case for the `contains` operation that tests an array that does not contain the specified value.
   * A test case for the `contains` operation that tests an empty array.
   * A test case for the `contains` operation that tests an array with a single element.
4. Add more test cases to the `ArrayUtilitiesTest` class to test edge cases and corner cases for the operations.
   * A test case for the `reverse` operation that tests an array with an odd number of elements (at least 3 elements).
   * A test case for the `reverse` operation that tests an array with an even number of elements (at least 2 elements).
   * A test case for the `sum` operation that tests an array with negative numbers if not already done in task 1.
