echo"Installing chrome "
apt-get install -y sudo
sudo apt-get install -y libxss1 libappindicator1 libindicator7
wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb

sudo dpkg -i google-chrome*.deb
sudo apt-get install -f

echo "installing chrome driver"
sudo apt-get install -y unzip

wget -N http://chromedriver.storage.googleapis.com/78.0.3904.70/chromedriver_linux64.zip
unzip chromedriver_linux64.zip
chmod +x chromedriver

sudo mv -f chromedriver /usr/local/share/chromedriver
sudo ln -s /usr/local/share/chromedriver /usr/local/bin/chromedriver
sudo ln -s /usr/local/share/chromedriver /usr/bin/chromedriver

sudo apt-get install -y xvfb
