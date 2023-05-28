# PreparedStatement, ResultSet, ResultSetMetadata and DatabaseMetadata

## PreparedStatement

```java
    String sql = "insert into employees (id, first_name, last_name, email, phone, salary, department) " +
        "values (?, ?, ?, ?, ?, ?, ?)";
    PreparedStatement stmt = conn.prepareStatement(sql);
```

When we execute the above statement, the JDBC driver sends the SQL statement to the db server for `preparation`. The preparation process involves several steps performed by the DB server:

- **Parsing**: the DB server receives the command sent by the client, and begins the parsing process. It breaks the sql command into its parts such as keywords, table names, column names, operators, parameters, values etc. This step ensures that the db server understand the structure and the syntax of the statement given
- **Syntax validation**: after parsing, the db server performs syntax validation. This ensures that the sql command adheres to the rules of the database's dialect. It checks for proper syntax, correct keyword usage, valid identifiers. If any syntax errors are detected, an exception is raised.
- **Semantic analysis**: existence of tables and columns, column count, etc are being checked
- **Security checks**: Checks the user's privileges for the requested operation on the requested table
- **Generate execution plan**: An execution plan may involve selecting an appropriate index, join tables in an optimal order, using cached data. The goal is to execute the statement in the most efficient manner possible, considering the factors like - performance, resource utilization and query complexity
- **Parameter placeholder recognition**: Reserves memory for the `?` placeholders, so that at later point in time, those memory areas can be filled with values, and then the command can be executed

### ResultSet

![](./resultset.dio.png)
