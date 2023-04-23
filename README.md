# MNR_Commons
<h2>To get a Git project into your build:</h1>

> Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:
```
allprojects {
  repositories {
      ...
      maven { url 'https://jitpack.io' }
  }
}
```

> Step 2. Add the dependency
```
dependencies {
  implementation 'com.github.BillyMRX1:MNR_Commons:Tag'
}
```

Current Version:

[![](https://jitpack.io/v/BillyMRX1/MNR_Commons.svg)](https://jitpack.io/#BillyMRX1/MNR_Commons)
