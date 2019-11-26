REM Compiling
javac -classpath src\WEB-INF\lib\servlet.jar src\WEB-INF\HelloServlet.java

REM Moving to classes
mkdir src\WEB-INF\classes
move src\WEB-INF\HelloServlet.class src\WEB-INF\classes\HelloServlet.class