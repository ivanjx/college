Write-Output "Preparing"
New-Item -ItemType Directory "bin"
New-Item -ItemType Directory "bin/WEB-INF"
New-Item -ItemType Directory "bin/WEB-INF/classes"
New-Item -ItemType Directory "bin/WEB-INF/lib"

Write-Output "Compiling"
javac `
    -classpath "./lib/servlet.jar;./lib/jdbc.jar" `
    -d "bin/WEB-INF/classes" `
    "src/com/jsp/Category.java" `
    "src/com/jsp/Product.java" `
    "src/com/jsp/CatalogBean.java" `
    "src/com/jsp/CartItem.java" `
    "src/com/jsp/ShoppingCartBean.java"

Copy-Item "src/*" -Destination "bin" -Force -Recurse
Remove-Item "bin/com" -Force -Recurse

Write-Output "Copying lib"
Copy-Item "lib/*" -Destination "bin/WEB-INF/lib" -Force -Recurse

Write-Output "Packaging"
Set-Location "bin"
jar cvf build.war .
Move-Item "build.war" -Destination "../ecommerce.war" -Force
Set-Location ".."
Remove-Item "bin" -Force -Recurse
