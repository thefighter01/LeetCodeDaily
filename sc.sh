#! /usr/bin/bash

echo "enter the commit word"

read commitWord;


git add .

git commit -m $commitWord

git push origin main;