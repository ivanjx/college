REM Preparing
mkdir bin\WEB-INF\classes
mkdir bin\WEB-INF\lib

REM Compiling
javac -classpath ^
lib\servlet.jar ^
lib\jdbc.jar ^
-d bin\WEB-INF\classes ^
src\WEB-INF\MainServlet.java

REM Copying files
xcopy src bin /h /i /c /k /e /r /y
del /S bin\*.java

REM Copying lib
xcopy lib bin\WEB-INF\lib /h /i /c /k /e /r /y

REM Packaging
cd bin
jar cvf build.war .
move build.war ..\internet-programming-uts1.war
cd ..

REM Cleaning up
rmdir bin /S /Q