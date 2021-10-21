# cinema-app by KODAK

In order to get Movie info, for now, the movies will be hardcoded until the following solution can be implemented:

Using an open-source (available to all) database of movies that is published online, we will extract the relevant
data for all movies that the theater(s) is currently showing and display it in the endpoint (what you as the user will see).

#install docker
#!/bin/bash
echo "installing Docker."
sudo apt update
sudo apt upgrade
wget -o- https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
sudo add-apt-repository "deb [arc=amd64] http://download.docker.com/linux/ubuntu $(lsb_release -cs) stable"
sudo apt update
sudo apt upgrade
sudo apt install docker-ce

#install java jre
echo "installing java."
sudo apt install default-jre

#install jenkins
echo "installing jenkins"
wget -o- https://pkg.jenkins.io/debian/jenkins.io.key | sudo apt-key add -
echo "deb http://pkg.jenkins.io/debian-stable binary" > /etc/apt/sources.list.d/jenkins.list
sudo chmod 777 /etc/apt/sources.list.d
sudo apt update
sudo apt upgrade
sudo apt install jenkins

#Use this if the first jenkins install doesn't work 
#!/bin/bash
wget -q -O - https://pkg.jenkins.io/debian-stable/jenkins.io.key |
sudo apt-key add -
sudo sh -c 'echo deb https://pkg.jenkins.io/debian-stable binary/ > \
/etc/apt/sources.list.d/jenkins.list'
sudo apt-get update
sudo apt-get install jenkins


