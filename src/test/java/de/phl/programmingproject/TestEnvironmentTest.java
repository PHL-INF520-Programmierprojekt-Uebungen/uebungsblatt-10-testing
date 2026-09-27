package de.phl.programmingproject;

import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;
import org.mockito.MockedStatic;
import java.nio.charset.StandardCharsets;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/** Technische Selbstprüfung: unabhängig von noch offenen Übungsaufgaben. */
class TestEnvironmentTest {
    static class Example {
        String value() { return "original"; }
        static String staticValue() { return "original"; }
    }

    @Test
    void utf8_source_and_output() {
        String text = "äöüÄÖÜß – „Java“";
        assertEquals(228, text.codePointAt(0));
        assertEquals(223, text.codePointAt(6));
        assertEquals(8211, text.codePointAt(8));
        assertEquals(StandardCharsets.UTF_8, java.nio.charset.Charset.defaultCharset());
        assertEquals(text, TestUtils.runActionAndGetSystemOut(() -> System.out.print(text)));
    }

    @Test
    void normal_and_static_mock() {
        Example example = mock(Example.class);
        when(example.value()).thenReturn("Mock");
        assertEquals("Mock", example.value());
        try (MockedStatic<Example> mocked = mockStatic(Example.class)) {
            mocked.when(Example::staticValue).thenReturn("statisch");
            assertEquals("statisch", Example.staticValue());
        }
        assertEquals("original", Example.staticValue());
    }

    @Test
    void constructor_mock() {
        try (MockedConstruction<Example> mocked = mockConstruction(Example.class,
                (mock, context) -> when(mock.value()).thenReturn("Konstruktor"))) {
            assertEquals("Konstruktor", new Example().value());
            assertEquals(1, mocked.constructed().size());
        }
        assertEquals("original", new Example().value());
    }
}
