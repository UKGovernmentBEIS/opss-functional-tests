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

RUN curl -sS https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add -
RUN echo "deb http://dl.google.com/linux/chrome/deb/ stable main"  | tee /etc/apt/sources.list.d/google.list

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
