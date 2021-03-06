# microwave-gradle-plugin
A Gradle Plugin that notifies about ending of the build task.

## Usage
Build script snippet for use in all Gradle versions:
```gradle
buildscript {
  repositories {
    maven {
      url "https://plugins.gradle.org/m2/"
    }
  }
  dependencies {
    classpath "gradle.plugin.com.github.rsavin.gradle:gradle-microwave:1.0.0"
  }
}
apply plugin: "com.github.rsavin.gradle.microwave"
```

Build script snippet for new, incubating, plugin mechanism introduced in Gradle 2.1:
```gradle
plugins {
  id "com.github.rsavin.gradle.microwave" version "1.0.0"
}
```

## License

    Copyright 2015 Roman Savin

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
