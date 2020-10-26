echo Preparing
mkdir bin
mkdir bin/WEB-INF
mkdir bin/WEB-INF/classes
mkdir bin/WEB-INF/lib

echo Compiling
javac -classpath \
  ".:lib/servlet.jar:lib/jdbc.jar" \
  -d bin/WEB-INF/classes \
  src/WEB-INF/MainServlet.java \
  src/logic/models/BookCategory.java \
  src/logic/models/Book.java
  
cp -R src/* bin
find ./bin -type f -name '*.java' -exec rm {} +
rm -rf bin/logic

echo Copying lib
cp -R lib/* bin/WEB-INF/lib

echo Packaging
cd bin
jar cvf build.war .
mv build.war ../internet-programming-uts1.war
cd ..
rm -rf bin