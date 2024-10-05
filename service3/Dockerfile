
# base image to build a node 

FROM node:slim

# declare a working directory

WORKDIR /service3

# copy the current from here to WORKDIR

COPY . /service3/

# after copying the code run the below command

RUN npm install

# this shoul run every time the image is started

CMD [ "node", "index.js" ]