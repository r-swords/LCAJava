mkdir out
javac -d out DAG.java
javac -d out -cp out:junit-platform-console-standalone-1.7.0-all.jar DAGTest.java
java -jar junit-platform-console-standalone-1.7.0-all.jar --class-path out --scan-class-path
rm -r out
