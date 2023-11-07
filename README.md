# Troubleshooting Lab

## Setup the lab environment

Today we will be using helm to demonstrate installing a set of applications.  The helm chart and templates out of the box are broken, you will have to troubleshoot why it is not working.

### Install Lab
1. Install the web terminal so you can use helm
1. Navigate to Operators -> operator hub
1. Search for "web terminal"
1. Click on Web Terminal tile
1. Click on Install
1. Leave the defaults
1. Click on the "Install" button
1. Wait for "Installed operator:  ready for use"
1. Click on the >_ icon to the right of the + in the upper right corner of the console
1. In the shell checkout this repo
1. `git clone https://github.com/mathianasj/troubleshooting-lab`
1. `oc new-project troubleshooting`
1. `cd troubleshooting-lab`
1. `helm install -n troubleshooting troubleshooting ./helm_deploy`
1. Get the route to navigate in your browser to for the next steps of troubleshooting
1. `oc get route -n troubleshooting troubleshooting-frontend -o jsonpath --template='{.spec.host}{"/status\n"}'`
1. Hint this url will have a failure state this is your first task to troubleshoot why it is not working, feel free to review the helm chart templates and also the openshift console