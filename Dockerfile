FROM maven

ENV DEBIAN_FRONTEND noninteractive
ENV CHROMIUM_DRIVER_VERSION 78.0.3904.70

RUN apt-get update && apt-get install -y \
 sudo \
 libxss1 \
 libappindicator1 \
 libindicator7 \
 wget \
 unzip 

 RUN wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb

RUN sudo dpkg -i google-chrome*.deb
RUN sudo apt-get install -f

RUN echo "installing chrome driver"

RUN wget -N http://chromedriver.storage.googleapis.com/78.0.3904.70/chromedriver_linux64.zip
RUN unzip chromedriver_linux64.zip
RUN chmod +x chromedriver

RUN sudo mv -f chromedriver /usr/local/share/chromedriver
RUN sudo ln -s /usr/local/share/chromedriver /usr/local/bin/chromedriver
RUN sudo ln -s /usr/local/share/chromedriver /usr/bin/chromedriver


WORKDIR /opss-functional-tests

COPY ./selenium-java-framework ./selenium-java-framework
RUN mvn --quiet --file ./selenium-java-framework/pom.xml install

COPY ./cosmetics/cosmetics-web-tests ./cosmetics
RUN mvn --quiet --file ./cosmetics/pom.xml compile test -Dcucumber.options="--tags @none"

COPY ./mspsds/webtests-mspsds ./psd
RUN mvn --quiet --file ./psd/pom.xml compile test -Dcucumber.options="--tags @none"
