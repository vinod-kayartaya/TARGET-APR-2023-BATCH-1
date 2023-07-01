JDBC DriverManager as a factory for manufacturing Connection objects:

```java

Connection conn; // interface
// String url = "jdbc:mysql://localhost/mydb"; // discriminator
String url = "jdbc:oracle:thin:@localhost:orcl"; 

conn = DriverManager.getConnection(url, username, password);
// conn would refer to an object of Oracle Connection class (that implements Connection interface)
```

# Unit testing

- Junit is the most popular framework or library for testing Java code
    - others include: TestNG, Cucumber (BDD)