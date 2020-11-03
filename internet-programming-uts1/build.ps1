Write-Output "Preparing"
mkdir bin
mkdir bin/WEB-INF
mkdir bin/WEB-INF/classes
mkdir bin/WEB-INF/lib

Write-Output "Compiling"
javac `
    -classpath "./lib/servlet.jar;./lib/jdbc.jar" `
    -d "bin/WEB-INF/classes" `
    "src/logic/DI.java" `
    "src/logic/Helper.java" `
    "src/logic/models/BookCategory.java" `
    "src/logic/models/Book.java" `
    "src/logic/models/Customer.java" `
    "src/logic/models/Order.java" `
    "src/logic/repositories/DB.java" `
    "src/logic/repositories/IBookCategoryRepository.java" `
    "src/logic/repositories/BookCategoryRepository.java" `
    "src/logic/repositories/IBookRepository.java" `
    "src/logic/repositories/BookRepository.java" `
    "src/logic/repositories/ICustomerRepository.java" `
    "src/logic/repositories/CustomerRepository.java" `
    "src/logic/repositories/IOrderRepository.java" `
    "src/logic/repositories/OrderRepository.java" `
    "src/logic/services/BookCategoryService.java" `
    "src/logic/services/BookService.java" `
    "src/logic/services/CustomerService.java" `
    "src/logic/services/OrderService.java" `
    "src/logic/controllers/kategori/KategoriCreateServlet.java" `
    "src/logic/controllers/kategori/KategoriUpdateServlet.java" `
    "src/logic/controllers/kategori/KategoriDeleteServlet.java" `
    "src/logic/controllers/buku/BukuCreateServlet.java" `
    "src/logic/controllers/buku/BukuUpdateServlet.java" `
    "src/logic/controllers/buku/BukuDeleteServlet.java" `
    "src/logic/controllers/pembeli/PembeliCreateServlet.java" `
    "src/logic/controllers/pembeli/PembeliUpdateServlet.java" `
    "src/logic/controllers/pembeli/PembeliDeleteServlet.java" `
    "src/logic/controllers/pesanan/PesananCreateServlet.java" `
    "src/logic/controllers/pesanan/PesananDeleteServlet.java" `
    "src/logic/controllers/pesanan/PesananUpdateServlet.java"

Copy-Item "src/*" -Destination "bin" -Force -Recurse
Remove-Item "bin/logic" -Force -Recurse

Write-Output "Copying lib"
Copy-Item "lib/*" -Destination "bin/WEB-INF/lib" -Force -Recurse

Write-Output "Packaging"
Set-Location "bin"
jar cvf build.war .
Move-Item "build.war" -Destination "../internet-programming-uts1.war" -Force
Set-Location ".."
Remove-Item "bin" -Force -Recurse
