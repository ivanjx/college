REM Preparing
mkdir bin\WEB-INF\classes
mkdir bin\WEB-INF\lib

REM Compiling
javac -classpath lib\servlet.jar -d bin\WEB-INF\classes src\WEB-INF\HelloServlet.java

REM Copying files
xcopy src bin /h /i /c /k /e /r /y
del /S bin\*.java

REM Copying lib
xcopy lib bin\WEB-INF\lib /h /i /c /k /e /r /y

REM Packaging
cd bin
jar cvf test.war .
move test.war ..\test.war
cd ..

REM Cleaning up
rmdir bin /S /Q