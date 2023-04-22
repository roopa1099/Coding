# Use an official Java runtime as a parent image
FROM openjdk:11-jdk

# Set the working directory to /app
WORKDIR /javaprogram

COPY . /javaprogram

#tells docker to use java 11 for source an target
RUN javac -source 11 -target 11 PrintProductOfTwo.java

CMD [ "java","PrintProductOfTwo" ]

