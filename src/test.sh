mkdir out
javac -d out BinaryTree.java
javac -d out -cp out:junit-platform-console-standalone-1.7.0-all.jar BinaryTreeTest.java
java -jar junit-platform-console-standalone-1.7.0-all.jar --class-path out --scan-class-path
rm -r out
