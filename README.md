# Project-Template

Template to quickly have a project scaffolding. Ideal for Pet projects, technical assessments, etc.

This template includes some of the most common dependencies when working on Android projects, and also a set of custom plugins
to avoid repetitive tasks when creating modules (configuring kotlin, java android libs, etc)

## What´s Included

### JavaCompatibility Plugin

Sets Java target and source compatibility to version ``` 1.8```. 
Works for java modules and android modules.

### Kotlin Plugin

Configures Kotlin on the modules:

For android modules: 

  * Applies  ```kotlin-android``` plugin
  
  * Applies  ```kotlin-kapt``` plugin
  
  * Adds ```"src/main/kotlin/", "src/test/kotlin/" and "src/androidTest/kotlin/"``` as source sets.
  
  * Sets the jvm target to ``` 1.8```
  
  * Adds the koltin standar library 8 as a dependency.
  
  
For java/kotlin modules: 


  * Applies  ```kotlin``` plugin.
  
  * Applies  ```kotlin-kapt``` plugin.
  
  * Adds ```"src/main/kotlin/", "src/test/kotlin/"``` as source sets.
  
  * Sets the jvm target to ``` 1.8```.
  
  * Adds the koltin standar library 8 as a dependency.
  
### Android Plugin  


Configures the following options for the ```DefaultConfiguration``` provided by the AGP:

  * ```compileSdkVersion```.
  
  * ```buildToolsVersion```.
  
  * ```targetSdkVersion```.
  
  * ```minSdkVersion```.
  
  * ```testInstrumentationRunner```.
  
### Ktlint Plugin  

Enables [Ktlint](https://github.com/pinterest/ktlint) and register the following tasks:

  * ```ktlint``` to check kotlin code style
  
  * ```ktlintFormat```to fix kotlin code style deviations
  
### Coverage Plugin

Adds the [Jacoco gradle plugin](https://docs.gradle.org/current/userguide/jacoco_plugin.html)  and register the tasks for generating coverage reports. On Android modules, the tasks are generated per variants and work for debug build types.


### Module Plugin

Convenience plugin that applies all of the plugins mentioned above.
