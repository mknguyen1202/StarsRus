#!/bin/bash

if [[ $(uname -s) == Linux ]]
then
    echo "Linux detected. Running script for MacOS..."
else if [[ $(uname -s) == Darwin ]]
then
    echo "MacOS detected. Running script for MacOS..."
else if [[ $(uname -s) == Windows ]]
then
    echo "Windows detected. Running script for Windows..."
else
    echo "Not OS detected. Running script for Windows by default."
fi

