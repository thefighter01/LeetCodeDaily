#! /usr/bin/bash

echo "i am gonna add all the files to github $1";
git add .
git commit -m "$1th day"
git push origin main