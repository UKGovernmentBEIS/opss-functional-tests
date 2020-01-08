FROM maven

ENV DEBIAN_FRONTEND noninteractive
ENV CHROMIUM_DRIVER_VERSION 78.0.3904.70

RUN curl -sS https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add -
RUN echo "deb http://dl.google.com/linux/chrome/deb/ stable main"  | tee /etc/apt/sources.list.d/google.list

RUN apt-get update && apt-get install -y \
  google-chrome-stable \
  unzip

RUN apt-get update && apt-get install -y libnss3 libgconf-2-4
RUN apt-get update && apt-get install -y libxss1 libappindicator1 libindicator7

RUN curl -o /tmp/chromedriver.zip http://chromedriver.storage.googleapis.com/$CHROMIUM_DRIVER_VERSION/chromedriver_linux64.zip \
  && unzip /tmp/chromedriver.zip chromedriver -d /usr/bin/ \
  && rm /tmp/chromedriver.zip \
  && chmod ugo+rx /usr/bin/chromedriver

WORKDIR /opss-functional-tests




COPY ./selenium-java-framework ./selenium-java-framework
RUN mvn --quiet --file ./selenium-java-framework/pom.xml install

COPY ./cosmetics/cosmetics-web-tests ./cosmetics
RUN mvn --quiet --file ./cosmetics/pom.xml compile test -Dcucumber.options="--tags @none"

COPY ./mspsds/webtests-mspsds ./psd
RUN mvn --quiet --file ./psd/pom.xml compile test -Dcucumber.options="--tags @none"

COPY ./par-web-tests ./par
RUN mvn --quiet --file ./par/pom.xml compile test -Dcucumber.options="--tags @none"


RUN curl -o  ./cosmetics/src/test/resources/testdata/Multi-componentFrameformulationNano-notification.zip -J -L https://opss-zipfile-generator.london.cloudapps.digital/testfiles/Multi-componentFrameformulationNano-notification \
 	&& curl -o  ./cosmetics/src/test/resources/testdata/SingleItem-RangeFormulation-harmful-Ingredients.zip -J -L https://opss-zipfile-generator.london.cloudapps.digital/testfiles/SingleItem-RangeFormulation-harmful-Ingredients \
 	&& curl -o  ./cosmetics/src/test/resources/testdata/multi-components-nano-materials.zip -J -L https://opss-zipfile-generator.london.cloudapps.digital/testfiles/multi-components-nano-materials \
 	&& curl -o  ./cosmetics/src/test/resources/testdata/SingleItem-CMRs-Nano.zip -J -L https://opss-zipfile-generator.london.cloudapps.digital/testfiles/SingleItem-CMRs-Nano \
  	&& curl -o  ./cosmetics/src/test/resources/testdata/SingleItem-Nano-ExactFormulation-pHRange.zip -J -L https://opss-zipfile-generator.london.cloudapps.digital/testfiles/SingleItem-Nano-ExactFormulation-pHRange \
   	&& curl -o  ./cosmetics/src/test/resources/testdata/SingleItem-Nano-Only.zip -J -L https://opss-zipfile-generator.london.cloudapps.digital/testfiles/SingleItem-Nano-Only \
   	&& curl -o  ./cosmetics/src/test/resources/testdata/SingleItem-Rangeformulation-Nanomaterial.zip -J -L https://opss-zipfile-generator.london.cloudapps.digital/testfiles/SingleItem-Rangeformulation-Nanomaterial \
   	&& curl -o  ./cosmetics/src/test/resources/testdata/Multi-Item-NanoOnly.zip -J -L https://opss-zipfile-generator.london.cloudapps.digital/testfiles/Multi-Item-NanoOnly

