# 基于Java8镜像
FROM openjdk:11

#入参
#ARG envType=default
#ENV envType ${envType}

# 将本地文件夹挂在到当前容器
#docker build -t mingxuduan/cloud-user-center:latest .do
VOLUME /tmp

# 复制文件到容器
#ADD ./electronic_fence-service/target/electronic_fence-service.jar electronic_fence-service.jar
ADD ./target/cloud-user-center-service.jar cloud-user-center-service.jar
# RUN bash -c 'touch /copote-uaa-api.jar'
RUN mkdir -p /home/data/template/gitlab/ && \
    /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && \
        echo "Asia/Shanghai" > /etc/timezone

# 声明需要暴露的端口
EXPOSE 9110

# 配置容器启动后执行的命令
#"-jar","-server","-Xms90m","-Xmx2000m","-XX:CompressedClassSpaceSize=128m","-XX:MetaspaceSize=100m","-XX:MaxMetaspaceSize=200m",
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/copote-postal-management-car-service.jar","--spring.profiles.active=${envType}",">","/copote-postal-management-car-service.log"]
ENTRYPOINT ["java","-jar","/cloud-user-center-service.jar","--spring.profiles.active=dev",">","/cloud-user-center-service.log"]

