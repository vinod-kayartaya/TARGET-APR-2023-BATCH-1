# Control structures in Java

1. Sequence (of execution)

    - By default the code gets executed from top to bottom, starting from the main() method
    - We can change the sequence by creating methods (or functions) and calling the same.

    ```
        [access-modifier] <return-type> <method-name>([param1, param2, ...]) {
            // method body
            [return] [return-value];
        }
    ```

    For example,

    ```java
        public long square(int n) {
            return n*n;
        }
        void sayHello() {
            System.out.println("Hello, world!");
        }
        public void setAge(int age){
            if(age<1 || age>120){
                System.err.println("Invalid value for age - " + age);
                return;
            }
            this.age=age;
        }
    ```

    ![](./images/stack.dio.png)

1. Selection
1. Iteration
