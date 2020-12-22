echo Preparing
mkdir bin
mkdir bin/WEB-INF
mkdir bin/WEB-INF/classes
mkdir bin/WEB-INF/lib

echo Compiling
cp -R src/* bin

echo Copying lib
cp -R lib/* bin/WEB-INF/lib

echo Packaging
cd bin
jar cvf build.war .
mv build.war ../task12.war
cd ..
rm -rf bin