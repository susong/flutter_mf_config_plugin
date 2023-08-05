#!/usr/bin/env bash

mkdir -p ./android/src/main/java/com/mf/flutter_mf_config_plugin
mkdir -p ./lib/src/
flutter pub run pigeon \
  --input ./pigeons/config_api.dart \
  --dart_out ./lib/src/config_library_api.dart \
  --java_out ./android/src/main/java/com/mf/flutter_mf_config_plugin/ConfigLibraryApi.java \
  --java_package "com.mf.flutter_mf_config_plugin"

# 输出当前时间
time=$(date "+%Y-%m-%d %H:%M:%S")
echo "Finish at ${time}"