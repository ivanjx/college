Write-Output "Preparing"
New-Item -ItemType directory "bin"
New-Item -ItemType directory "bin/WEB-INF"
New-Item -ItemType directory "bin/WEB-INF/lib"

Write-Output "Compiling"
javac `
    -classpath "./lib/servlet.jar;./lib/jdbc.jar" `
    -d "bin" `
    "src/Applet1.java"

Copy-Item "src/*" -Destination "bin" -Force -Recurse
Remove-Item "bin/*.java" -Force -Recurse

Write-Output "Copying lib"
Copy-Item "lib/*" -Destination "bin/WEB-INF/lib" -Force -Recurse

Write-Output "Packaging"
Set-Location "bin"
jar cvf build.war .
Move-Item "build.war" -Destination "../task13.war" -Force
Set-Location ".."
Remove-Item "bin" -Force -Recurse
