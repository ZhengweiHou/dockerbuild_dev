FROM houzw/cenots7_jdk8_202:v1
MAINTAINER sirius@hzw

RUN /bin/bash -c 'localedef -f UTF-8 -i zh_CN /usr/lib/locale/zh_CN.UTF-8'
RUN mkdir /app

ENV LANG="zh_CN.UTF-8"

WORKDIR /app

ENV JAVA_OPTS=""
ENV JAVA_ARGS=""
ENV run="PrintXmxXms"

COPY ./PrintXmxXms.java /app
COPY ./JvmInfo.java /app

RUN javac /app/PrintXmxXms.java -d /app
RUN javac /app/JvmInfo.java     -d /app



CMD java $JAVA_OPTS -cp /app $run $JAVA_ARGS
