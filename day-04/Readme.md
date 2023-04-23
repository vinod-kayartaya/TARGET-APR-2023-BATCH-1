# Interfaces

- A user defined data type
- Can contain variables and methods
  - variables must be (or going to be) `public static final`
  - methods must be (or going to be) `public abstract`
    - Java 8 introduced the concept of `default` methods
    - default methods contain method body - and hence they are not abstract!!
- An interface does not have a constructor
  - and hence we cannot create an object of an interface
- We can **realize** an object of an interface in the form of an object of a class that implements the interface

![](../out/day-04/interfaces/interfaces.png)

## Difference between and **abstract class** and an **interface**

- An abstract class is used for ineritance
  - the intension here is **code reusability**
- An interface is used for polymorphism
  - the intension here is to enforce common contract across unrelated classes
  - For example, `SmartPhone` and `DigitalCamera` and `Laptop` are totally unrelated classes, but all of them can be used as a `Camera` provided they all implement the `Camera` interface.
- An abstract class may have non-static member variables
- An interface cannot have non-static member variables
- The default methods in the interface should not be used in the context of inheritance, but should only be a fallback method.
- An abstract methods may contain methods that are private/protected or public
- An interface methods must be public

_When a class implements an interface, it is equivalent to extending an abstract class with only abstract methods_

Also, a class can implement multiple interfaces. Because of this, it is often said that Java supports multiple inheritance (WRONG!!).

Implementing multiple interfaces must be done with great caution.

![](../out/day-04/interface-problem/interface-problem.png)

Problem - _What to implement / overrid in class C?_

Solution - _Choose between interface A and interface B_
