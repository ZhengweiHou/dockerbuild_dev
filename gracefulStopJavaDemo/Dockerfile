FROM harbor.hzwod.com/hzwod/centos7_jdk8:v1
MAINTAINER sirius@hzw

RUN mkdir /apphome

COPY ./docker-entrypoint.sh /apphome
ADD ./KillTest*.class /apphome

WORKDIR /apphome

ENTRYPOINT ["/apphome/docker-entrypoint.sh"]

CMD ["java","KillTest"] 
