  
echo Preparing
mkdir bin
mkdir bin/WEB-INF
mkdir bin/WEB-INF/lib

echo Compiling
javac \
  -classpath "./lib/servlet.jar:./lib/jdbc.jar" \
  -d bin \
  src/Applet1.java

cp -R src/* bin
rm bin/*.java

echo Copying lib
cp -R lib/* bin/WEB-INF/lib

echo Packaging
cd bin
jar cvf build.war .
mv build.war ../task13.war
cd ..
rm -rf bin