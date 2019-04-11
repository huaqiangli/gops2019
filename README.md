# gops2019

############################
GOPS2019深圳 搭建工作坊环境以及学习指导

1. 参考ppt及视频回顾理解

2. jenkins环境使用docker容器快速部署，已经内置示例jobs
   docker pull huaqiangli/jenkins:gops2019-sz-4
   docker run -d -p 8080:8080 -p 50000:50000  huaqiangli/jenkins:gops2019-sz-4
   访问Jenkins ：http://<your ip>:8080/
   登录: admin/jenkins2019
   修改全局配置的 Jenkins URL 为 http://<your ip>:8080/

3. pipeline 内置jobs使用的pipeline脚本 ，可以访问 https://github.com/huaqiangli/gops2019

4. pipeline 中共享库示例源码，可以访问 https://github.com/huaqiangli/jenkins-libs

5. 更多示例参考 https://github.com/jenkinsci/pipeline-examples

6. 其他学习链接
    https://jenkins.io/doc/book/pipeline/syntax/
	  https://jenkins.io/doc/book/pipeline/
    https://github.com/jenkinsci/pipeline-examples
    https://jenkins.io/doc/book/blueocean/creating-pipelines/
    https://jenkins.io/doc/book/blueocean/pipeline-editor/
    https://jenkins.io/doc/book/pipeline/shared-libraries/
  
