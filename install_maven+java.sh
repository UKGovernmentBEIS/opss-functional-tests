#!/bin/bash
apt-get update
apt-get install -y sudo
apt-get install -y wget
sudo apt install -y openjdk-8-jdk
sudo apt-get update
echo "JAVA_HOME=$(which java)" | sudo tee -a /etc/environment
source /etc/environment
cd /opt/
wget http://www-eu.apache.org/dist/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.tar.gz
sudo tar -xvzf apache-maven-3.3.9-bin.tar.gz
sudo mv apache-maven-3.3.9 maven
apt-get update
export M2_HOME=/opt/maven
export PATH=${M2_HOME}/bin:${PATH}
