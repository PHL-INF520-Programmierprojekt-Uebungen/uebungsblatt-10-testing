# Übungsblatt: Testen mit JUnit 5
[Link to English version](./README_en.md)


In diesem Übungsblatt lernen Sie, Quellcode mit JUnit 5 zu testen, um verschiedene Übungen zu lösen.

## Hinweis: Benennung von Testfällen

Für die Benennung Ihrer Tests können Sie der folgenden Richtlinie folgen:
https://enterprisecraftsmanship.com/posts/you-naming-tests-wrong/

**Zusammenfassung:**
* Verwenden Sie keine starre Testbenennungspolitik.
* Benennen Sie die Tests so, als ob Sie das getestete Szenario einem Nicht-Programmierer, der mit dem Problemgebiet vertraut ist, beschreiben würden.
* Trennen Sie Wörter im Testnamen durch Unterstriche.
* Fügen Sie den Namen der zu testenden Methode nicht in den Testnamen ein (Ausnahmen bestätigen die Regel).

Zum Beispiel können Sie einen Testfall für die `validate`-Operation in der Klasse `EmailAddressValidator` wie folgt benennen:
``` Java
@Test
void email_address_without_at_sign_is_invalid(){...}
```

## Übung: Testen eines E-Mail-Adressvalidators mit JUnit

In dieser Übung schreiben Sie eine JUnit-Test-Suite für eine Java-Klasse namens `EmailAddressValidator`, die eine Operation zur Validierung einer E-Mail-Adresse bereitstellt.

1. Implementieren Sie in der Klasse `EmailAddressValidator`, die sich im Paket `de.phl.programmingproject.email` befindet, die Logik zur Validierung von E-Mail-Adressen gemäß den folgenden Anforderungen:
    - Eine E-Mail-Adresse muss ein einzelnes "@"-Zeichen enthalten.
    - Das "@"-Zeichen darf nicht das erste oder letzte Zeichen in der E-Mail-Adresse sein.
    - Die E-Mail-Adresse muss eine gültige Top-Level-Domain haben (z.B. ".com", ".edu", ".org").
    - Die E-Mail-Adresse darf keine Leerzeichen enthalten.

*Hinweis 1*: Bitte implementieren Sie die gesamte Logik in der  `public static boolean validate(final String email)` Methode und fügen Sie keine zusätzlichen Methoden zur `EmailAddressValidator`-Klasse hinzu.
Damit stellen Sie sicher, dass die Testfälle dieser Übungsaufgabe richtig ausgeführt werden. Eine Lösung mit weiteren Methoden kann durchaus richtig sein, wird aber von den Testfällen nicht akzeptiert.

*Hinweis 2*: Sie können versuchen, die Logik zur Validierung von E-Mail-Adressen selbst zu implementieren, oder Sie können einen regulären Ausdruck verwenden, um die E-Mail-Adresse zu validieren.

2. Erstellen Sie eine neue Java-Datei namens `EmailAddressValidatorTest.java` im entsprechenden Testordner Ihres Gradle-Projekts (falls sie nicht bereits existiert) und schreiben Sie Testfälle für die `validate`-Operation der Klasse `EmailAddressValidator`. Sie sollten Testfälle einschließen, die die folgenden Szenarien abdecken:
    - Gültige E-Mail-Adressen, die alle Validierungsanforderungen erfüllen.
    - Ungültige E-Mail-Adressen, die eine oder mehrere der Validierungsanforderungen nicht erfüllen, wie z.B. E-Mail-Adressen mit mehreren "@"-Zeichen oder E-Mail-Adressen mit ungültigen Top-Level-Domains.
    - Randfälle, wie z.B. E-Mail-Adressen mit nur einem Zeichen oder E-Mail-Adressen mit der längstmöglichen Länge.

*Hinweis*: Ihre Implementierung kann zunächst falsch sein und im Laufe der Zeit durch das Identifizieren von Fehlern durch Tests repariert werden.

3. Führen Sie die JUnit-Test-Suite aus und stellen Sie sicher, dass alle Tests bestehen.
4. Fügen Sie weitere Testfälle zur Klasse `EmailAddressValidatorTest` hinzu, um zusätzliche Randfälle und Szenarien abzudecken, von denen Sie denken, dass sie in Schritt 2 und 3 möglicherweise nicht abgedeckt wurden.

Stellen Sie sicher, dass Ihre Testfälle gut organisiert, leicht zu lesen und alle möglichen Szenarien für die `validate`-Operation in der Klasse `EmailAddressValidator` abdecken.


## Übung: Testen eines ArrayUtilities mit JUnit

Im Paket `de.phl.programmingproject.arrayutils` finden Sie die Klasse `ArrayUtilities`, die verschiedene Hilfsoperationen für die Arbeit mit Arrays enthält. Ihre Aufgabe ist es, eine JUnit-Test-Suite zu schreiben, die alle Operationen in dieser Klasse gründlich testet.

1. Erstellen Sie eine neue Java-Datei namens `ArrayUtilitiesTest.java` im Testordner des Gradle-Projekts (falls sie nicht bereits existiert) und schreiben Sie Testfälle für die `sum`-Operation in der Klasse `ArrayUtilities`.
2. Führen Sie die JUnit-Test-Suite aus und stellen Sie sicher, dass alle Tests bestehen ("durchlaufen").
3. Fügen Sie weitere Testfälle zur Klasse `ArrayUtilitiesTest` hinzu, um die verbleibenden Operationen in der Klasse `ArrayUtilities` zu testen:
    * Ein Testfall für die `reverse`-Operation, der ein leeres Array testet.
    * Ein Testfall für die `reverse`-Operation, der ein Array mit einem einzigen Element testet.
    * Ein Testfall für die `sum`-Operation, der ein leeres Array testet, falls dies nicht bereits in Aufgabe 1 geschehen ist.
    * Ein Testfall für die `contains`-Operation, der ein Array testet, das den angegebenen Wert nicht enthält.
    * Ein Testfall für die `contains`-Operation, der ein leeres Array testet.
    * Ein Testfall für die `contains`-Operation, der ein Array mit einem einzigen Element testet.
4. Fügen Sie weitere Testfälle zur Klasse `ArrayUtilitiesTest` hinzu, um Grenz- und Eckfälle für die Operationen zu testen.
    * Ein Testfall für die `reverse`-Operation, der ein Array mit einer ungeraden Anzahl von Elementen testet (mindestens 3 Elemente).
    * Ein Testfall für die `reverse`-Operation, der ein Array mit einer geraden Anzahl von Elementen testet (mindestens 2 Elemente).
    * Ein Testfall für die `sum`-Operation, der ein Array mit negativen Zahlen testet, falls dies nicht bereits in Aufgabe 1 geschehen ist.