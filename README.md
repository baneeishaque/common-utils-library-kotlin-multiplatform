# Common-Utils-Library-Kotlin-Multiplatform

[![Java CI with Gradle](https://github.com/Baneeishaque/Common-Utils-Library-Kotlin-Multiplatform/actions/workflows/gradle.yml/badge.svg)](https://github.com/Baneeishaque/Common-Utils-Library-Kotlin-Multiplatform/actions/workflows/gradle.yml)

A Kotlin Multiplatform library providing common utility functions for cross-platform development. This library supports JVM, Android, and Windows Native (via MinGW) targets.

## Features

- **DateTime Utilities**: Date and time manipulation and formatting using Klock
- **GitHub Gist Integration**: HTTP client utilities for interacting with GitHub Gist API using Ktor
- **Collection Utilities**: Key-List pair management and manipulation
- **Common Constants**: Reusable constants and regex patterns

## Supported Platforms

| Platform | Status |
|----------|--------|
| JVM | ✅ Supported |
| Android | ✅ Supported |
| Windows (MinGW) | ✅ Supported |
| Linux | 🚧 Planned |

## Dependencies

This library uses the following key dependencies:

- [Ktor Client](https://ktor.io/) - HTTP client for making API requests
- [KotlinX Serialization](https://github.com/Kotlin/kotlinx.serialization) - JSON serialization/deserialization
- [KotlinX Coroutines](https://github.com/Kotlin/kotlinx.coroutines) - Asynchronous programming
- [Klock](https://github.com/korlibs/korlibs) - Date and time utilities

## Project Structure

```
lib/src/commonMain/kotlin/common/utils/library/
├── constants/
│   └── ConstantsCommonNative.kt    # Common constants and regex patterns
├── enums/
│   ├── TimePartManipulationEnum.kt # Time manipulation operations
│   └── TimePartSpecificationEnum.kt # Time part specifications
├── models/
│   └── GistResponseModel.kt        # GitHub Gist response models
└── utils/
    ├── CommonGistUtils.kt          # GitHub Gist API utilities
    ├── DateTimeUtils.kt            # Date/time utilities
    └── KeyListUtils.kt             # Collection utilities
```

## Building

```bash
# Build all targets
./gradlew assemble

# Build specific targets
./gradlew jvmJar
./gradlew linkDebugSharedMingwX64
```

## Usage

### Gradle (Kotlin DSL)

```kotlin
// Add to your dependencies
implementation("ndk.banee:common-utils-library:1.0-SNAPSHOT")
```

### DateTime Utilities

```kotlin
import common.utils.library.utils.DateTimeUtils

val dateFormat = DateTimeUtils.normalDatePattern
```

### GitHub Gist Integration

```kotlin
import common.utils.library.utils.CommonGistUtils

val client = CommonGistUtils.getHttpClientForGitHub(
    accessToken = "your-token",
    isDevelopmentMode = false
)

val gistContents = CommonGistUtils.getGistContents(
    client = client,
    gistId = "your-gist-id",
    isDevelopmentMode = false
)
```

### Collection Utilities

```kotlin
import common.utils.library.utils.KeyListUtils

val keyList = LinkedHashMap<String, MutableList<Int>>()
val updatedList = KeyListUtils.addElementToKeyListPair(
    keyList = keyList,
    desiredKey = "myKey",
    desiredElement = 42
)
```

## CI/CD

- **GitHub Actions**: Automated builds on Ubuntu
- **Azure Pipelines**: Windows builds for MinGW target

## License

This project is open source. Please check the repository for license details.

## Topics

This repository covers:
`kotlin` `kotlin-multiplatform` `kmp` `kotlin-library` `android` `jvm` `windows` `mingw` `native` `ktor` `ktor-client` `kotlinx-serialization` `kotlinx-coroutines` `utility-library` `cross-platform` `gradle` `gradle-kotlin-dsl` `datetime` `github-gist` `klock`

See [GITHUB_TOPICS.md](GITHUB_TOPICS.md) for detailed instructions on how to add GitHub topics to this repository.
