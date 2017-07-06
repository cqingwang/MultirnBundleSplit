#!/bin/bash

mkdir -p build/bundle-output/split
node ./splitppk.js --platform android --output build --config .splitconfig --dev true

mkdir -p android/app/src/main/assets/bundle
rm -rf android/app/src/main/assets/bundle/*
cp -R build/bundle-output/split/* android/app/src/main/assets/bundle
cd android
./gradlew :app:installDebug

    