# Common-Utils-Library-Kotlin-Multiplatform

A Kotlin Multiplatform library providing common utility functions for cross-platform development.

## Overview

This library provides reusable utility functions and models that work across multiple platforms:

- **JVM** - Java Virtual Machine applications
- **Android** - Android applications
- **Windows (MinGW-w64)** - Native Windows applications

## Features

- **GitHub Gist Integration** - HTTP client utilities for GitHub Gist API using Ktor
- **DateTime Utilities** - Date and time formatting utilities using Korlibs Klock
- **Key-List Utilities** - Data structure utilities for working with key-list pairs
- **Common Constants** - Shared constants and utility strings

## Technologies

- [Kotlin Multiplatform](https://kotlinlang.org/docs/multiplatform.html)
- [Ktor Client](https://ktor.io/docs/client.html) - Asynchronous HTTP client
- [Kotlinx Serialization](https://github.com/Kotlin/kotlinx.serialization) - JSON serialization
- [Kotlinx Coroutines](https://github.com/Kotlin/kotlinx.coroutines) - Asynchronous programming
- [Korlibs Klock](https://korlibs.soywiz.com/klock/) - Date/time library

## Build

```bash
# Build all platforms
./gradlew assemble

# Build Windows shared library
./gradlew linkDebugSharedMingwX64

# Run tests
./gradlew test
```

## Project Structure

```
lib/
├── src/
│   └── commonMain/
│       └── kotlin/
│           └── common/
│               └── utils/
│                   └── library/
│                       ├── constants/    # Common constants
│                       ├── enums/        # Enum definitions
│                       ├── models/       # Data models
│                       └── utils/        # Utility functions
```

## Repository Topics

For information about the repository topics and how to add them, see [GITHUB_TOPICS_AND_TAGS.md](GITHUB_TOPICS_AND_TAGS.md).

## License

See repository for license information.
