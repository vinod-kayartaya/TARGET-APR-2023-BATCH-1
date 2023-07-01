# Thread safety, synchronization and dead locks

- this is an issue only when multiple threads are trying to update (mutate) common data
  - for example, collections or Output streams shared by multiple threads

# Introduction to basics of RDBMS

- Relational database management system
  - Relation = table
  - perceive data in tabular format
  - a table/relation is a group of rows (horizontal entries)
  - each row is a group of columns (vertical entries)
  - a row represents information about one instance of an entity
  - a column represents all values of a particular interest of the entity

## Data models

- Relational - Relation = table - perceive data in tabular format
- Hierarchical
  - tree like structure
  - one record has references to one ore more child records - each child record may act as a parent to it's child records - this may go on for any record - tree of records
- Network
  - similar to hierarchical, but child can also have references to any parent records
  - looks like a graph
- NoSQL
  - not only SQL
  - document oriented (mongodb)
  - key/value based (redis, elasticsearch)

## SQL (Structured Query Language)

- used for communicating with a RDBMS from any application that is capable of sending SQL commands
- standardized by ANSI
  - different RDBMS softwares (such as Oracle, PostgreSQL, SQL-Server, etc) provide additional SQL commands, some of which will be specific to their databases only.
- popular RDBMS softwares:
  - Oracle (Oracle corp)
  - DB2 (IBM)
  - MySQL (originally from Sun microsystems, now acquired by Oracle)
  - MariaDB (during the sale of Sun microsystems, JBoss cloned the then open source MySQL and started a new development)
  - MS-Access (optional part of MS-office suite)
  - MS-SQL server (enterprise RDBMS from Microsoft)
  - SQLite (in memory RDBMS, simple and lightweight, stores the data in a file)
    - zero installation
  - H2
    - in memory,
    - open source and free.
    - zero installation.
    - popularly used for testing
