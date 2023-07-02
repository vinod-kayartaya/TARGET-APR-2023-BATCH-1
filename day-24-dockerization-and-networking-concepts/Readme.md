# Creating docker images

- use a base image
  - another docker image that has at least a OS commands/utilities
  - not always required
    - if you have any executable that can interact with the linux kernel (provided by the docker engine), then we do not need any other commands/utilities
- in most cases we would like to have an environment that is needed to execute our application
  - for example,
    - if we want to run a Java application, then we need the following:
      1. JDK
      1. an OS on which JDK can be (or is already) installed
  - `openjdk:17-alpine`
    - this is an image made up of Alpine linux on which openjdk 17 is already installed
- the command `docker build` can be used to create a custom image using an existing base image along with your application file/s
- the `docker build` command reads instruction from a file called `dockerfile`

example dockerfile content:

```dockerfile
FROM openjdk:17-alpine

WORKDIR /vinod/workspace

ADD ./target/docker-mysql-java-1.0-SNAPSHOT.jar ./app.jar

ENTRYPOINT java -cp ./app.jar com.targetindia.programs.HelloWorld

```

To create the image, run the following command:

```sh
docker build .
```

The created image will not have any name. To give a name/tag for the newly created image, use the following command:

```sh
docker tag 05cb3eee6904 learnwithvinod/hello-world:latest
```

- here `05cb3eee6904` is the id of the image generated using the `docker build` command.
- `learnwithvinod` (optional) repository name/id (if you have an account with hub.docker.com)
- `hello-world` is the image name
- `latest` is the tag

We could have given the name/tag during the creation of the image itself

```sh
docker build -t learnwithvinod/hello-world:latest .
```

```sh
docker run -dp 2345:8080 \
    --name contacts-service-container \
    --link mysql8server \
    -e JDBC_HOST=mysql8server \
    -e JDBC_DB=vinoddb \
    learnwithvinod/contacts-service:latest
```

mysql server:

```sh
docker run -d -p 3306:3306 \
    --name mysql8server \
    -e MYSQL_ROOT_PASSWORD=Welcome#123 \
    -v mysql8data:/var/lib/mysql \
    mysql:latest
```

# Java Socket Programming

- allows you to communicate from one Java application to another java app
- `java.net.Socket` and `java.net.ServerSocket` are the primary classes using which a client can communicate with a server
- server starts and waits for client connections
- client connects to a server
- either client writes and server reads
  - or server writes and client reads
