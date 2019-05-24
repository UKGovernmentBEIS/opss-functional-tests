apt-get update
apt-get install -y sudo
sudo apt-get install -y python-software-properties software-properties-common
sudo add-apt-repository -y ppa:webupd8team/java
sudo apt-get update
echo "oracle-java8-installer shared/accepted-oracle-license-v1-1 select true" | sudo debconf-set-selections
sudo apt-get install -y oracle-java8-installer


echo "JAVA_HOME=$(which java)" | sudo tee -a /etc/environment
source /etc/environment

cd /opt/

wget http://www-eu.apache.org/dist/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.tar.gz

sudo tar -xvzf apache-maven-3.3.9-bin.tar.gz

sudo mv apache-maven-3.3.9 maven
export M2_HOME=/opt/maven
export PATH=${M2_HOME}/bin:${PATH}
sudo apt-get install libfontconfig
