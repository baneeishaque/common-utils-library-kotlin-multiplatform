# Common Utils Library — Kotlin Multiplatform

<p align="center">
  <img src="https://kotlinlang.org/assets/images/twitter-card/kotlin_800x418.png" alt="Kotlin Multiplatform" width="600"/>
</p>

<p align="center">
  <a href="https://github.com/Baneeishaque/common-utils-library-kotlin-multiplatform/actions/workflows/gradle.yml">
    <img src="https://github.com/Baneeishaque/common-utils-library-kotlin-multiplatform/actions/workflows/gradle.yml/badge.svg" alt="Build Status"/>
  </a>
  <a href="https://kotlinlang.org">
    <img src="https://img.shields.io/badge/kotlin-2.4-blue?logo=kotlin" alt="Kotlin"/>
  </a>
  <a href="https://developer.android.com/studio/releases/gradle-plugin">
    <img src="https://img.shields.io/badge/AGP-9.1.1-green" alt="Android Gradle Plugin"/>
  </a>
  <a href="https://gradle.org/releases">
    <img src="https://img.shields.io/badge/gradle-9.4.1-brightgreen?logo=gradle" alt="Gradle"/>
  </a>
  <a href="LICENSE">
    <img src="https://img.shields.io/badge/license-MIT-blue" alt="MIT License"/>
  </a>
</p>

A **Kotlin Multiplatform (KMP)** library providing shared utility functions, network clients, serialization helpers, and common abstractions that run on **Android**, **JVM**, and **Windows (MinGW x64)** targets.

---

## 📋 Table of Contents

- [Features](#-features)
- [Supported Targets](#-supported-targets)
- [Requirements](#-requirements)
- [Project Structure](#-project-structure)
- [Getting Started](#-getting-started)
- [Dependencies](#-dependencies)
- [Build & CI](#-build--ci)
- [Contributing](#-contributing)
- [License](#-license)

---

## ✨ Features

- 🌐 **Shared HTTP Client** — Ktor-based multiplatform HTTP client with auth, logging, and content negotiation
- 🔄 **Kotlin Serialization** — JSON serialization/deserialization via `kotlinx-serialization-json`
- ⏱  **Date/Time Utilities** — Cross-platform date and time support using Klock
- 🔁 **Coroutines Support** — Async/concurrent utilities via `kotlinx-coroutines-core`
- 📦 **Zero Boilerplate** — Common business logic written once and shared across all targets

---

## 🎯 Supported Targets

| Target | Platform | Status |
|---|---|---|
| `androidMain` | Android (API 24+) | ✅ Supported |
| `jvmMain` | JVM (Desktop / Server) | ✅ Supported |
| `mingwX64Main` | Windows (Native x64) | ✅ Supported |
| `commonMain` | Shared across all | ✅ Supported |

> **Note:** Linux x64 (`linuxX64`) support is scaffolded but currently commented out. PRs welcome.

---

## 🛠 Requirements

| Tool | Version |
|---|---|
| **Java (JDK)** | 21+ |
| **Kotlin** | 2.4.x |
| **Gradle** | 9.4.1 |
| **Android Gradle Plugin (AGP)** | 9.1.1 |
| **Android SDK** | compileSdk 34, minSdk 24 |

---

## 📁 Project Structure

```
common-utils-library-kotlin-multiplatform/
├── lib/                          # Main library module
│   ├── src/
│   │   ├── commonMain/kotlin/    # Shared source code (all targets)
│   │   ├── androidMain/kotlin/   # Android-specific implementations
│   │   ├── jvmMain/kotlin/       # JVM-specific implementations
│   │   └── mingwX64Main/kotlin/  # Windows-native implementations
│   └── build.gradle.kts          # Library build configuration
├── gradle/
│   ├── libs.versions.toml        # Version catalog (dependencies & plugins)
│   └── wrapper/                  # Gradle wrapper binaries
├── build.gradle.kts              # Root build script
├── settings.gradle.kts           # Project settings & repository config
├── gradle.properties             # Gradle performance & feature flags
├── .github/workflows/gradle.yml  # GitHub Actions CI/CD
├── azure-pipelines-windows.yml   # Azure Pipelines (Windows build)
└── renovate.json                 # Automated dependency update config
```

---

## 🚀 Getting Started

### Prerequisites

Install Java 21 using your preferred version manager. If you use [`mise`](https://mise.jdx.dev/):

```bash
mise install java@21
mise exec java@21 -- java -version
```

### Clone the Repository

```bash
git clone --recurse-submodules https://github.com/Baneeishaque/common-utils-library-kotlin-multiplatform.git
cd common-utils-library-kotlin-multiplatform
```

### Build the Library

```bash
# Grant execute permission (first time only)
chmod +x gradlew

# Build all targets
./gradlew assemble

# Or with mise
mise exec java@21 -- ./gradlew assemble
```

### Run Tests

```bash
# JVM tests
./gradlew jvmTest

# All available tests
./gradlew allTests
```

### Clean Build

```bash
./gradlew clean assemble
```

---

## 📦 Dependencies

All dependencies are managed via the Gradle Version Catalog (`gradle/libs.versions.toml`).

**Core dependencies (commonMain):**

| Library | Version | Purpose |
|---|---|---|
| `kotlinx-serialization-json` | `1.11.0` | JSON serialization |
| `kotlinx-coroutines-core` | `1.10.2` | Async/concurrency primitives |
| `ktor-bom` | `3.5.0-eap-1611` | HTTP client (BOM managed) |
| `ktor-client-core` | BOM | HTTP client core |
| `ktor-client-auth` | BOM | Authentication plugin |
| `ktor-client-content-negotiation` | BOM | Content type handling |
| `ktor-client-logging` | BOM | Request/response logging |
| `ktor-serialization-kotlinx-json` | BOM | JSON serialization for Ktor |
| `klock` | `4.0.10` | Multiplatform date/time |

**Platform-specific:**

| Platform | Library | Purpose |
|---|---|---|
| `mingwX64` | `ktor-client-winhttp` | Windows HTTP engine |

**Plugins:**

| Plugin | Version |
|---|---|
| `com.android.kotlin.multiplatform.library` (AGP) | `9.1.1` |
| `kotlin("multiplatform")` | `2.4.x` |
| `kotlin("plugin.serialization")` | `2.4.x` |

---

## 🔧 Build & CI

### GitHub Actions

The project runs CI on every push and pull request targeting `master`:

- **JDK**: Oracle JDK 21
- **Trigger**: `push` / `pull_request` on `master`
- **Steps**: Checkout (with submodules) → Set up JDK → Build with Gradle (`./gradlew assemble`)

See [`.github/workflows/gradle.yml`](.github/workflows/gradle.yml).

### Azure Pipelines (Windows)

A separate Windows-specific build pipeline is configured in [`azure-pipelines-windows.yml`](azure-pipelines-windows.yml) for native Windows target verification.

### Dependency Management

This project uses [Renovate](https://renovateapp.com/) for automated dependency updates (see `renovate.json`). All dependency updates arrive as automated pull requests targeting `master`.

### Build Performance

The following Gradle flags are enabled in `gradle.properties` for faster builds:

```properties
kotlin.native.ignoreDisabledTargets=true
```

---

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

### 1. Fork & Branch

```bash
git checkout -b feat/your-feature-name
```

### 2. Code Standards

- Write shared code in `commonMain` — **never put platform-specific logic there**.
- Use the **`compilerOptions` DSL** (not `kotlinOptions`) for Kotlin 2.x compatibility.
- All new platform targets require corresponding `*Main` source sets.
- Follow the existing source set naming convention.

### 3. Commit Convention

This project uses **Conventional Commits**:

```
feat(scope): short description
fix(scope): short description  
chore(scope): short description
```

### 4. Pull Request Guidelines

- Ensure `./gradlew assemble` passes locally before opening a PR.
- PRs should target the `master` branch.
- PRs authored by bots are opened as **drafts** — review and mark as "Ready for review" before merging.
- Avoid regressing the Kotlin/AGP versions — this project is on **Kotlin 2.4** and **AGP 9.1.1**.

### 5. Adding a New Platform Target

1. Add the target block in `lib/build.gradle.kts` inside `kotlin { ... }`.
2. Create the corresponding source set directory: `lib/src/<targetName>Main/kotlin/`.
3. Add platform-specific Ktor engine dependency in the target's source set.
4. Verify the build passes for the new target.

---

## 📄 License

This project is licensed under the **MIT License** — see the [LICENSE](LICENSE) file for details.

```
MIT License
Copyright (c) 2025 Banee Ishaque K
```
