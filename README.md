# Spring-Boot-Docker-Aws-Deployment
A complete deployment flow of Simple Spring boot application using Docker and Jenkins on AWS EC2 instance.

#### 1. Configure Jenkins and Docker on local system
* Follow [Steps](https://www.jenkins.io/download/) to download and install Jenkins on Windows
* Install all recommended plugins required for github, pipeline and docker on Jenkins
* Configure maven, docker, git and jdk in Global Tool Configuration
* Add credentials for docker-hub and github in Manage Jenkins -> Security -> Credentials
* Follow [Steps](https://docs.docker.com/docker-for-windows/install/) to install docker desktop for windows

#### 2. Configure AWS
- Create an EC2 ubuntu instance on AWS
- Follow [Steps](https://docs.docker.com/engine/install/ubuntu/) to install docker in ubuntu
- Update `/lib/systemd/system/docker.service` file <br/><br />
    - Replace below code<br/>
  `ExecStart=/usr/bin/dockerd -H fd:// --containerd=/run/containerd/containerd.sock`
  <br/><br/>with<br/><br/>
  `ExecStart=/usr/bin/dockerd -H tcp://0.0.0.0:4245 -H unix:///var/run/docker.sock`
- Restart docker<br>
  `sudo systemctl daemon-reload`</n>
   `sudo systemctl restart docker`
  
#### 3. Configure and Run Build on Jenkins
- Create a new pipeline project in jenkins
- Provide Github repo url in Github Project and Pipeline Definition
- Configure Jenkins script path and save the project.
- Press build now to execute and run spring boot app on your aws ec2 environment.   