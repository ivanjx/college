echo Preparing
mkdir bin
mkdir bin/WEB-INF
mkdir bin/WEB-INF/classes
mkdir bin/WEB-INF/lib

echo Compiling
javac \
  -classpath "./lib/servlet.jar:./lib/jdbc.jar" \
  -d bin/WEB-INF/classes \
  src/com/infobean/Category.java \
  src/com/infobean/Product.java \
  src/com/infobean/Promotion.java \
  src/com/infobean/CatalogBean.java \
  src/com/infobean/CartItem.java \
  src/com/infobean/ShoppingCartBean.java

cp -R src/* bin
rm -rf bin/com

echo Copying lib
cp -R lib/* bin/WEB-INF/lib

echo Packaging
cd bin
jar cvf build.war .
mv build.war ../ecommerce.war
cd ..
rm -rf bin