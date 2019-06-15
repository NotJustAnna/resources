# Resources
Lazily-initialized resource loading and Holder-like patterns.

Licensed under the [MIT License](https://github.com/arudiscord/resources/blob/master/LICENSE).

### Installation

![Latest Version](https://api.bintray.com/packages/arudiscord/maven/resources/images/download.svg)

Using in Gradle:

```gradle
repositories {
  jcenter()
}

dependencies {
  compile 'net.notjustanna.libs:resources:LATEST' // replace LATEST with the version above
}
```

Using in Maven:

```xml
<repositories>
  <repository>
    <id>central</id>
    <name>bintray</name>
    <url>http://jcenter.bintray.com</url>
  </repository>
</repositories>

<dependencies>
  <dependency>
    <groupId>net.notjustanna.libs</groupId>
    <artifactId>resources</artifactId>
    <version>LATEST</version> <!-- replace LATEST with the version above -->
  </dependency>
</dependencies>
```

### Usage

- You can wrap already-available resources with ``Resource.of(T)``.
- You can create lazily-loadable resources with ``Resource.of(Callable<T>)``. The lambda will be called on the first invocation.
- You can wrap resources coming from Futures with ``Resource.ofFuture(Future<T>)``.
- You can create settable resources, which let you control the state with the Resource with ``Resource.settable()``.
- You can also make a unavailable resource with ``Resource.unavailable()``.

Expected usage is as follows:

```java
Resource<String> res = Resource.of(() -> "I am".concat(" a computer-expensive").concat(" operation"));

if (res.load()) {
    String computed = res.getValue();
} else {
    System.out.println("Operation errored.");
}
```

### Support




