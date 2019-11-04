# JMH Benchmarks

A collection of JMH micro-benchmarks used during performance investigations on the Eclipse OpenJ9 JVM. The benchmarks
are based off the `jmh-java-benchmark-archetype` and are created using the following Maven command:

```
> mvn archetype:generate -DinteractiveMode=false -DarchetypeGroupId=org.openjdk.jmh -DarchetypeArtifactId=jmh-java-benchmark-archetype -DgroupId=org.openj9 -DartifactId=indexof-jmh -Dversion=1.0
```

To compile and run all the benchmarks simply build and run:

```
> mvn clean install
> java -jar target/benchmarks.jar
```
