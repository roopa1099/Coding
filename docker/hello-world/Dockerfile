# base image
FROM ubuntu

# install gcc and g++
RUN apt update -y && apt-get -y install gcc g++

#copy the cpp file
COPY a.cpp b.cpp

# compile the cpp code
RUN g++ b.cpp 

# run the binary
ENTRYPOINT [ "./a.out" ]

