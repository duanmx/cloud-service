#!/bin/bash
# 初始化参数
# git提交版本号，作为docker镜像版本号
#git_version=$(git log -1 --pretty=format:"%h")
git_version=$2
# 脚本输入参数
_isEnv=$1
# 构建镜像至k8s集群
doBuildImage () {
    # 镜像名称 1/仓库命名空间<项目名称+环境>，2/服务名称，3/版本号
    image_name=$1
    #harbor_store_target=mingxuduan/$image_name:$git_version
    harbor_store_target=mingxuduan/$image_name:latest
    # 构建镜像
    docker build -t $harbor_store_target -f ./cloud-gateway/Dockerfile --build-arg envType=$_isEnv .
    # 上传镜像到私有仓库
    docker push $harbor_store_target
    # 删除本地镜像缓存
    docker rmi $harbor_store_target
}

# 全部更新
doBuildImage cloud-gateway