# PROJ-FFM

Demo App for showing a PoC using:
* Java 25 Foreign Function & Memory API
* [jextract](https://jdk.java.net/jextract/)
* [PROJ](https://proj.org/en/stable/)

## Why

Java and coordinate transformations have a complicated past...

## Our selfish goals

Using the (C/C++) PROJ stack in Java, so we can "level" the internal playing
field in how transformations are done. In other words, only through the use of
PROJ. If this is done through pyproj, georust, and so on. We can standardise the
used configruation and parameters so we have minimal deviations in our
transformtion, regardless of programming language.

## JNI vs FFM

Maybe not specifically JNI vs FFM, but more a way of us how we can start
explaining and implementing a Java solution that can be comprehended by everyone
(read: developers).

There is currently a mix of different (older) geotools/deegree/and custom
solutions with or without PROJ-JNI implemented in multiple Java stacks. These
solutions are now recognised as technical debt for multiple reasons, like: 
* using wrong assumptions
* deprecated libs
* and so on. 

Instead of understanding and trying to fixing these one by one, we
use this opportunity to try and replace these different implementations with one
single solution. So all Java stacks that need to execute coordinate
transformations do it in the same.

## jextract

```sh
wget https://download.java.net/java/early_access/jextract/25/1/openjdk-25-jextract+1-1_linux-aarch64_bin.tar.gz
tar -xvf openjdk-25-*
```

```sh
./jextract-25/bin/jextract \
  --include-dir /usr/local/include \
  --output src \
  --target-package org.jextract.proj \
  --library proj \
  /usr/local/include/proj.h
```

## compare

Direct proj calc

```sh
projinfo

Rel. 9.3.1, December 1st, 2023
usage: projinfo ...
```

```sh
cs2cs -f %9f EPSG:28992 EPSG:9067 <<< "155000 463000"
52.155173        5.387204  0.000000
```
