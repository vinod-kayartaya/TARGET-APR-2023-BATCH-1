## Variables and data types

-   Variables store values
-   In Java, a variable must be declared of a particular data type before it's usage.
    -   Strongly typed language (or statically typed language)
-   Values can be of a particular data type
-   Variables can be of two kinds of data types
    1. Primitives
        - Keywords built into Java language model
        - Four types of primitives
            1. Integers
                - Always signed (and unlike C, we donot have `signed` and `unsigned` keywords)
                - Because of this, the leading bit is always used for sign, and the remaining bits are used for value
                - If n is the number of bits then the range of values that can be stored in the variable is reprsented by -(2^m) to (2^m)-1 where m=n-1
                - `byte` (1 byte, 8 bits, range is -128 to +127)
                - `short` (2 bytes, 16 bits)
                - `int` (4 bytes, 32 bits)
                - `long` (8 bytes, 64 bits)
            1. Real numbers (decimal values)
                - `float` (4 bytes, single precision)
                - `double` (8 bytes double precision)
            1. Characters
                - single quotes are used to store a single character
                    - 'a', 'A', '5', '\n', '\\'
                - `char` (2 bytes - support UNICODE system)
            1. Boolean
                - `boolean` (1 bit, can be assigned with `true` or `false`
    1. References
        - Variables of any type (class, interface, enum, record) other than the 8 primitives
        - The size of the reference variable is 8 bytes in 64 bit env. (4 bytes in 32 bit env)

### Wrapper classes

-   Java provides one class for each primitive data type, so that you can have an object version of the primitive
-   These warpper classes are in the `java.lang` package
-   `byte` --> `java.lang.Byte`
-   `short` --> `java.lang.Short`
-   `int` --> `java.lang.Integer`
-   `long` --> `java.lang.Long`
-   `float` --> `java.lang.Float`
-   `double` --> `java.lang.Double`
-   `char` --> `java.lang.Character`
-   `boolean` --> `java.lang.Boolean`

### Identifier naming convention

-   Indentifiers - variables, method/function name, class (or any other user defined datatype), package
-   No underscores (generally)
    -   For example, we don't use like - `my_name` or `is_input_year_leap()`
-   TitleCase or PascalCase for - `class`, `interface`, `enum`, `annotation` and `record`
    -   For example, `HelloWorld` or `ArrayIndexOutOfBoundsException`
-   camelCase - first word in lowercase, and rest of the words of the identifier name are in TitleCase
    -   used for variables, methods
    -   For example, `myName`, `isInputYearLeap()`, `main()`, `toUpperCase()`, `parseInt()`, `registerUserAsAccountHolder()`
-   lowercase words delimited with dot
    -   used for packages
    -   For example, `com.targetindia.programs`, `java.lang`,
-   UPPER_CASE_WORDS_DELIMITED_WITH_UNDERSCORES
    -   generally used for constants
    -   For example, Integer.MIN_VALUE or Double.MAX_VALUE
-   Could be exceptions
