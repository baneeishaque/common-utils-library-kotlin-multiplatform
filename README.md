# Common Utils Library - Kotlin Multiplatform

[![Java CI with Gradle](https://github.com/Baneeishaque/Common-Utils-Library-Kotlin-Multiplatform/actions/workflows/gradle.yml/badge.svg)](https://github.com/Baneeishaque/Common-Utils-Library-Kotlin-Multiplatform/actions/workflows/gradle.yml)
[![Build Status](https://dev.azure.com/AXtreme/Kotlin%20Experiments/_apis/build/status%2FBaneeishaque.Common-Utils-Library-Kotlin-Multiplatform?branchName=master)](https://dev.azure.com/AXtreme/Kotlin%20Experiments/_build)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.21--315-blue.svg?style=flat&logo=kotlin)](https://kotlinlang.org)
[![Gradle](https://img.shields.io/badge/Gradle-8.14-green.svg?style=flat&logo=gradle)](https://gradle.org)

A **Kotlin Multiplatform** library providing common utility functions and helpers for cross-platform Kotlin development. This library targets **JVM**, **Android**, and **Windows (MinGW-w64)** platforms, enabling code sharing across different environments.

---

## ✨ Features

- **Cross-Platform Compatibility**: Write once, run on JVM, Android, and Windows Native platforms
- **Date & Time Utilities**: Comprehensive date/time manipulation with pattern formatting
- **GitHub Gist Integration**: Built-in HTTP client utilities for GitHub API interactions
- **Data Structure Helpers**: Utility functions for common data structure operations
- **Constants & Enums**: Reusable constants and enumerations for common use cases
- **Coroutines Support**: Full Kotlin Coroutines integration for async operations
- **Serialization Ready**: kotlinx.serialization support for JSON parsing

---

## 🏗️ Architecture & Platform Targets

### Supported Platforms

| Platform | Target | Engine/Runtime |
|----------|--------|----------------|
| **JVM** | `jvm` | JDK 17+ |
| **Android** | `androidTarget` | API Level 34 |
| **Windows Native** | `mingwX64` | MinGW-w64 |

### Tech Stack

- **Language**: Kotlin 2.1.21-315 (Dev Build)
- **Build Tool**: Gradle 8.14 with Kotlin DSL
- **HTTP Client**: Ktor 3.2.0-eap-1315
- **Serialization**: kotlinx.serialization 1.8.1
- **Async**: kotlinx.coroutines 1.10.2
- **Date/Time**: Klock 4.0.10

---

## 📁 Project Structure

```
Common-Utils-Library-Kotlin-Multiplatform/
├── build.gradle.kts              # Root project configuration
├── settings.gradle.kts           # Project settings & repository configuration
├── gradle.properties             # Gradle build properties
├── gradle/
│   ├── libs.versions.toml        # Version catalog for dependencies
│   └── wrapper/                  # Gradle wrapper files
├── lib/                          # Main library module
│   ├── build.gradle.kts          # Library build configuration
│   └── src/
│       └── commonMain/           # Shared common source code
│           └── kotlin/
│               └── common/utils/library/
│                   ├── constants/    # Common constants
│                   ├── enums/        # Enumerations
│                   ├── models/       # Data models
│                   └── utils/        # Utility functions
├── .github/                      # GitHub Actions & configurations
│   ├── workflows/
│   │   └── gradle.yml           # CI workflow
│   └── delete-merged-branch-config.yml
├── azure-pipelines-windows.yml   # Azure DevOps pipeline for Windows builds
└── renovate.json                 # Dependency update bot configuration
```

---

## 📦 Core Components

### Constants (`common.utils.library.constants`)

**`ConstantsCommonNative`** - Common application constants:
- `dashedLineSeparator` - Visual separator for console output
- `railwayTimeRegexPattern` - Regex for 24-hour time validation (HH:mm:ss)
- `digitIncrementOrDecrementRegexPattern` - Pattern for increment/decrement operations
- Default time reset values and common text constants

### Enums (`common.utils.library.enums`)

**`TimePartManipulationEnum`** - Time arithmetic operations:
- `ADDITION` - Add time parts
- `SUBTRACTION` - Subtract time parts

**`TimePartSpecificationEnum`** - Time part types:
- `HOUR`, `MINUTE`, `SECOND`, `DAY`

### Models (`common.utils.library.models`)

**`GistResponseModel`** - Data classes for GitHub Gist API responses:
- `Root` - Main response container
- `Files` - File collection wrapper
- `MainTxt` - File content holder

### Utilities (`common.utils.library.utils`)

**`CommonGistUtils`** - GitHub Gist API utilities:
```kotlin
// Create HTTP client for GitHub API
val client = CommonGistUtils.getHttpClientForGitHub(
    accessToken = "your-token",
    isDevelopmentMode = true
)

// Fetch gist contents
val gistContent = CommonGistUtils.getGistContents(
    client = client,
    gistId = "your-gist-id",
    isDevelopmentMode = false
)
```

**`DateTimeUtils`** - Date/time formatting utilities:
```kotlin
// Standard date/time pattern
val pattern = DateTimeUtils.normalDateTimePatternAsText  // "dd/MM/yyyy HH:mm:ss"

// Get date pattern for parsing
val dateFormat = DateTimeUtils.normalDatePattern  // PatternDateFormat for "dd/MM/yyyy"
```

**`KeyListUtils`** - Data structure helpers:
```kotlin
// Add element to a key-list pair structure
val keyList = LinkedHashMap<String, MutableList<Int>>()
KeyListUtils.addElementToKeyListPair(keyList, "numbers", 42)
```

---

## 🛠️ Prerequisites

Before getting started, ensure you have the following installed:

| Requirement | Version | Purpose |
|-------------|---------|---------|
| **JDK** | 17 or higher | Kotlin compilation and JVM target |
| **Android SDK** | API 34 | Android target compilation |
| **MinGW-w64** | Latest | Windows native compilation (optional) |
| **Gradle** | 8.14 (via wrapper) | Build automation |

### Platform-Specific Requirements

#### For JVM/Android Development
- JDK 17+ (Oracle JDK or OpenJDK)
- Android SDK with API Level 34 (for Android target)

#### For Windows Native Development
- MinGW-w64 toolchain
- Windows OS with WinHTTP support

---

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/Baneeishaque/Common-Utils-Library-Kotlin-Multiplatform.git
cd Common-Utils-Library-Kotlin-Multiplatform
```

### 2. Build the Project

#### Build All Targets
```bash
# Linux/macOS
./gradlew assemble

# Windows
gradlew.bat assemble
```

#### Build Specific Targets

```bash
# JVM only
./gradlew jvmJar

# Android AAR
./gradlew assembleRelease

# Windows shared library (requires Windows)
./gradlew linkDebugSharedMingwX64
```

### 3. Run Tests

```bash
# Run all tests
./gradlew allTests

# Run JVM tests only
./gradlew jvmTest

# Run Android unit tests
./gradlew testDebugUnitTest
```

---

## 📥 Installation

### Add as a Git Submodule

```bash
git submodule add https://github.com/Baneeishaque/Common-Utils-Library-Kotlin-Multiplatform.git libs/common-utils
git submodule update --init --recursive
```

Then in your `settings.gradle.kts`:
```kotlin
include(":libs:common-utils:lib")
```

### Using JitPack (Recommended for JVM/Android)

Add JitPack repository to your `settings.gradle.kts`:
```kotlin
dependencyResolutionManagement {
    repositories {
        maven { url = uri("https://jitpack.io") }
    }
}
```

Add the dependency in your module's `build.gradle.kts`:
```kotlin
dependencies {
    implementation("com.github.Baneeishaque:Common-Utils-Library-Kotlin-Multiplatform:Tag")
}
```

### For Kotlin Multiplatform Projects

In your `build.gradle.kts`:
```kotlin
kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("com.github.Baneeishaque:Common-Utils-Library-Kotlin-Multiplatform:Tag")
            }
        }
    }
}
```

---

## 💻 Development

### IDE Setup

1. **IntelliJ IDEA** (Recommended) or **Android Studio**
2. Open the project root directory
3. Wait for Gradle sync to complete
4. Configure JDK 17+ in Project Structure

### Gradle Properties

The project uses optimized Gradle settings in `gradle.properties`:

| Property | Value | Purpose |
|----------|-------|---------|
| `org.gradle.parallel` | `true` | Parallel task execution |
| `org.gradle.caching` | `true` | Build cache enabled |
| `org.gradle.configuration-cache` | `true` | Configuration cache |
| `kotlin.code.style` | `official` | Kotlin official code style |
| `org.gradle.jvmargs` | `-Xmx1024M` | JVM heap size |

### Useful Gradle Commands

```bash
# Clean build
./gradlew clean build

# Check for dependency updates
./gradlew dependencyUpdates

# Generate dependency report
./gradlew dependencies

# Stop Gradle daemon
./gradlew --stop
```

---

## 🔄 CI/CD Pipelines

### GitHub Actions

Located in `.github/workflows/gradle.yml`:
- **Trigger**: Push/PR to `master` branch
- **Environment**: Ubuntu Latest with JDK 21 (Oracle)
- **Tasks**: Assemble all targets

### Azure Pipelines

Located in `azure-pipelines-windows.yml`:
- **Environment**: Windows Latest
- **Tasks**: Build Windows shared library (`linkDebugSharedMingwX64`)
- **Features**: Gradle build caching

---

## 🤝 Contributing

We welcome contributions! Please follow these guidelines:

### Getting Started

1. **Fork** the repository
2. **Clone** your fork locally
3. Create a **feature branch**: `git checkout -b feature/amazing-feature`
4. **Commit** your changes: `git commit -m 'Add amazing feature'`
5. **Push** to the branch: `git push origin feature/amazing-feature`
6. Open a **Pull Request**

### Code Style

- Follow [Kotlin Coding Conventions](https://kotlinlang.org/docs/coding-conventions.html)
- Use `kotlin.code.style=official` (already configured)
- Add `@JvmStatic` annotation for JVM interoperability where applicable
- Document public APIs with KDoc comments

### Pull Request Guidelines

- Ensure all tests pass: `./gradlew allTests`
- Update documentation for new features
- Add tests for new functionality
- Keep commits focused and atomic
- Write clear commit messages

### Branch Naming

- `feature/` - New features
- `bugfix/` - Bug fixes
- `docs/` - Documentation updates
- `refactor/` - Code refactoring

### Dependency Updates

The project uses [Renovate Bot](https://renovatebot.com/) for automated dependency updates. Configuration is in `renovate.json`.

---

## 📋 Dependencies

### Core Dependencies

| Dependency | Version | Purpose |
|------------|---------|---------|
| kotlinx-serialization-json | 1.8.1 | JSON serialization/deserialization |
| kotlinx-coroutines-core | 1.10.2 | Asynchronous programming |
| ktor-client-core | 3.2.0-eap-1315 | HTTP client for API calls |
| ktor-client-auth | 3.2.0-eap-1315 | Authentication support |
| ktor-client-content-negotiation | 3.2.0-eap-1315 | Content type handling |
| ktor-client-logging | 3.2.0-eap-1315 | HTTP request/response logging |
| ktor-serialization-kotlinx-json | 3.2.0-eap-1315 | JSON serialization for Ktor |
| klock | 4.0.10 | Cross-platform date/time library |

### Platform-Specific Dependencies

| Platform | Dependency | Purpose |
|----------|------------|---------|
| Windows (mingwX64) | ktor-client-winhttp | HTTP client engine for Windows |

### Build Plugins

| Plugin | Version | Purpose |
|--------|---------|---------|
| Kotlin Multiplatform | 2.1.21-315 | KMP support |
| Kotlin Serialization | 2.1.21-315 | Serialization compiler plugin |
| Android Library (AGP) | 8.10.0 | Android library support |

---

## 📄 License

This project is open source. Please check with the repository owner for specific licensing terms.

---

## 📞 Support

- **Issues**: [GitHub Issues](https://github.com/Baneeishaque/Common-Utils-Library-Kotlin-Multiplatform/issues)
- **Discussions**: Open an issue for questions or feature requests

---

## 🙏 Acknowledgements

- [Kotlin Multiplatform](https://kotlinlang.org/docs/multiplatform.html) - Cross-platform development framework
- [Ktor](https://ktor.io/) - Asynchronous HTTP client
- [kotlinx.serialization](https://github.com/Kotlin/kotlinx.serialization) - Multiplatform serialization library
- [Klock](https://korlibs.soywiz.com/klock/) - Cross-platform date/time library

---

<p align="center">
  Made with ❤️ by <a href="https://github.com/Baneeishaque">Baneeishaque</a>
</p>
