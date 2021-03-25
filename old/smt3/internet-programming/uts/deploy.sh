sudo rm /usr/share/apache-tomcat-9.0.39/webapps/internet-programming-uts1.war
sudo cp internet-programming-uts1.war /usr/share/apache-tomcat-9.0.39/webapps
sudo /usr/share/apache-tomcat-9.0.39/bin/shutdown.sh
sudo /usr/share/apache-tomcat-9.0.39/bin/startup.sh