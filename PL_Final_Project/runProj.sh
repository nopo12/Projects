#!/bin/sh
# This is a comment!
IS_PIPE=$(eval "echo \$$(($#-1))");
#Make directory for java class files
mkdir -p ./java/OOP/out/production/OOP
mkdir -p ./java/Functional/out/production/Functional
#build C executables
gcc -g -Wall ./C/Functional/grep.c ./C/Functional/linkedList.c -o ./C/Functional/grep
gcc -g -Wall ./C/Imperative/grep.c ./C/Imperative/linkedList.c -o ./C/Imperative/grep
#Build and compile java class files
javac -d ./java/Functional/out/production/Functional ./java/Functional/java/*.java
javac -d ./java/OOP/out/production/OOP ./java/OOP/java/*.java
echo "Running Final Project";
FILE=$(eval "echo \$$(($#-1))");
echo "::: Functional Start :::"
echo "::: python Functional start :::"
python3 ./python/Functional/grep.py $@
echo "::: python functional END :::"
echo ":::"
echo "nodejs Functional start:"
nodejs ./nodejs/Functional/grep.js $@
echo " ::: nodejs Functional END :::"
echo ":::"
echo "::: java Functional start :::"
java -cp ./java/Functional/out/production/Functional/ Functional $@
echo " ::: java Functional END :::"
echo ":::"
echo "C Functional start:"
C/Functional/grep $@
echo "C Functional END"
echo "::: END OF FUNCTIONAL :::"
echo "C Imperative start:"
C/Imperative/grep $@
echo "C Imperative END"
echo ":::"
echo "::: OOP Start :::"
echo "OOP python start"
python3 ./python/OOP/MyMain.py $@
echo "OOP python end"
echo ":::"
echo "OOP nodejs start"
nodejs ./nodejs/OOP/MyMain.js $@
echo "OOP nodejs end"
echo ":::"
echo "OOP java start"
java -cp ./java/OOP/out/production/OOP MyMain $@
echo "OOP java end"
echo "::: END OF OOP :::"

