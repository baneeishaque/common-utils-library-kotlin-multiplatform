# GitHub Topics and Tags for Common-Utils-Library-Kotlin-Multiplatform

This document provides recommended GitHub topics and tags for this repository, along with instructions on how to add them.

## Recommended GitHub Topics

Based on the analysis of this repository, the following topics are recommended:

### Core Technology Topics
- `kotlin` - Primary programming language
- `kotlin-multiplatform` - Uses Kotlin Multiplatform for cross-platform development
- `kmp` - Short form for Kotlin Multiplatform
- `kotlin-library` - This is a library project

### Platform Target Topics
- `jvm` - Supports JVM platform
- `android` - Supports Android platform
- `windows` - Supports Windows via MinGW
- `mingw` - Uses MinGW for Windows native builds
- `native` - Supports native platform targets
- `cross-platform` - Works across multiple platforms

### Framework & Library Topics
- `ktor` - Uses Ktor for HTTP client functionality
- `ktor-client` - Specifically uses Ktor HTTP client
- `kotlinx-serialization` - Uses KotlinX Serialization
- `kotlinx-coroutines` - Uses coroutines for async operations

### Feature Topics
- `utilities` - Provides utility functions
- `utility-library` - A utility library
- `common-utils` - Common utility functions
- `datetime` - Includes date/time utilities
- `github-gist` - Includes GitHub Gist API integration
- `klock` - Uses Klock library for date/time

### Build & Development Topics
- `gradle` - Uses Gradle build system
- `gradle-kotlin-dsl` - Uses Kotlin DSL for Gradle

## Complete List of Suggested Topics

```
kotlin
kotlin-multiplatform
kmp
kotlin-library
jvm
android
windows
mingw
native
cross-platform
ktor
ktor-client
kotlinx-serialization
kotlinx-coroutines
utilities
utility-library
datetime
github-gist
gradle
gradle-kotlin-dsl
klock
```

## How to Add GitHub Topics

### Method 1: GitHub Web Interface (Easiest)

1. Go to the repository: https://github.com/Baneeishaque/Common-Utils-Library-Kotlin-Multiplatform
2. Click on the gear icon (⚙️) next to "About" in the right sidebar
3. In the "Topics" field, add topics separated by spaces or commas
4. Click "Save changes"

### Method 2: GitHub CLI (gh)

Install GitHub CLI if not already installed:
```bash
# macOS
brew install gh

# Windows
winget install GitHub.cli

# Ubuntu/Debian
curl -fsSL https://cli.github.com/packages/githubcli-archive-keyring.gpg | sudo dd of=/usr/share/keyrings/githubcli-archive-keyring.gpg
echo "deb [arch=$(dpkg --print-architecture) signed-by=/usr/share/keyrings/githubcli-archive-keyring.gpg] https://cli.github.com/packages stable main" | sudo tee /etc/apt/sources.list.d/github-cli-stable.list > /dev/null
sudo apt update
sudo apt install gh
```

Authenticate with GitHub:
```bash
gh auth login
```

#### Add All Topics at Once

```bash
gh repo edit Baneeishaque/Common-Utils-Library-Kotlin-Multiplatform --add-topic kotlin --add-topic kotlin-multiplatform --add-topic kmp --add-topic kotlin-library --add-topic jvm --add-topic android --add-topic windows --add-topic mingw --add-topic native --add-topic cross-platform --add-topic ktor --add-topic ktor-client --add-topic kotlinx-serialization --add-topic kotlinx-coroutines --add-topic utilities --add-topic utility-library --add-topic datetime --add-topic github-gist --add-topic gradle --add-topic gradle-kotlin-dsl --add-topic klock
```

#### Add Topics Individually

```bash
# Core Technology Topics
gh repo edit --add-topic kotlin
gh repo edit --add-topic kotlin-multiplatform
gh repo edit --add-topic kmp
gh repo edit --add-topic kotlin-library

# Platform Target Topics
gh repo edit --add-topic jvm
gh repo edit --add-topic android
gh repo edit --add-topic windows
gh repo edit --add-topic mingw
gh repo edit --add-topic native
gh repo edit --add-topic cross-platform

# Framework & Library Topics
gh repo edit --add-topic ktor
gh repo edit --add-topic ktor-client
gh repo edit --add-topic kotlinx-serialization
gh repo edit --add-topic kotlinx-coroutines

# Feature Topics
gh repo edit --add-topic utilities
gh repo edit --add-topic utility-library
gh repo edit --add-topic datetime
gh repo edit --add-topic github-gist
gh repo edit --add-topic klock

# Build & Development Topics
gh repo edit --add-topic gradle
gh repo edit --add-topic gradle-kotlin-dsl
```

### Method 3: GitHub REST API

Using cURL:
```bash
curl -X PUT \
  -H "Accept: application/vnd.github+json" \
  -H "Authorization: Bearer YOUR_GITHUB_TOKEN" \
  https://api.github.com/repos/Baneeishaque/Common-Utils-Library-Kotlin-Multiplatform/topics \
  -d '{"names":["kotlin","kotlin-multiplatform","kmp","kotlin-library","jvm","android","windows","mingw","native","cross-platform","ktor","ktor-client","kotlinx-serialization","kotlinx-coroutines","utilities","utility-library","datetime","github-gist","gradle","gradle-kotlin-dsl","klock"]}'
```

Using JavaScript/Node.js with Octokit:
```javascript
const { Octokit } = require("@octokit/rest");

const octokit = new Octokit({
  auth: "YOUR_GITHUB_TOKEN"
});

async function setTopics() {
  await octokit.repos.replaceAllTopics({
    owner: "Baneeishaque",
    repo: "Common-Utils-Library-Kotlin-Multiplatform",
    names: [
      "kotlin",
      "kotlin-multiplatform",
      "kmp",
      "kotlin-library",
      "jvm",
      "android",
      "windows",
      "mingw",
      "native",
      "cross-platform",
      "ktor",
      "ktor-client",
      "kotlinx-serialization",
      "kotlinx-coroutines",
      "utilities",
      "utility-library",
      "datetime",
      "github-gist",
      "gradle",
      "gradle-kotlin-dsl",
      "klock"
    ]
  });
}

setTopics();
```

Using Python with PyGithub:
```python
from github import Github

# Authenticate with GitHub
g = Github("YOUR_GITHUB_TOKEN")

# Get the repository
repo = g.get_repo("Baneeishaque/Common-Utils-Library-Kotlin-Multiplatform")

# Set topics
topics = [
    "kotlin",
    "kotlin-multiplatform",
    "kmp",
    "kotlin-library",
    "jvm",
    "android",
    "windows",
    "mingw",
    "native",
    "cross-platform",
    "ktor",
    "ktor-client",
    "kotlinx-serialization",
    "kotlinx-coroutines",
    "utilities",
    "utility-library",
    "datetime",
    "github-gist",
    "gradle",
    "gradle-kotlin-dsl",
    "klock"
]

repo.replace_topics(topics)
```

### Method 4: GitHub GraphQL API

```graphql
mutation {
  updateRepository(input: {
    repositoryId: "REPOSITORY_NODE_ID",
    topics: [
      "kotlin",
      "kotlin-multiplatform",
      "kmp",
      "kotlin-library",
      "jvm",
      "android",
      "windows",
      "mingw",
      "native",
      "cross-platform",
      "ktor",
      "ktor-client",
      "kotlinx-serialization",
      "kotlinx-coroutines",
      "utilities",
      "utility-library",
      "datetime",
      "github-gist",
      "gradle",
      "gradle-kotlin-dsl",
      "klock"
    ]
  }) {
    repository {
      repositoryTopics(first: 25) {
        nodes {
          topic {
            name
          }
        }
      }
    }
  }
}
```

To get the repository node ID, you can use:
```bash
gh api repos/Baneeishaque/Common-Utils-Library-Kotlin-Multiplatform --jq '.node_id'
```

## Viewing Current Topics

### Using GitHub CLI
```bash
gh repo view Baneeishaque/Common-Utils-Library-Kotlin-Multiplatform --json repositoryTopics
```

### Using REST API
```bash
curl -H "Accept: application/vnd.github+json" \
  https://api.github.com/repos/Baneeishaque/Common-Utils-Library-Kotlin-Multiplatform/topics
```

## Removing Topics

### Using GitHub CLI
```bash
gh repo edit --remove-topic topic-name
```

### Using REST API
Simply call the PUT endpoint with the updated list of topics (excluding the ones you want to remove).

## Notes

- GitHub topics must be lowercase
- Topics can contain letters, numbers, and hyphens
- Maximum 20 topics per repository
- Topics help users discover your repository through search and topic pages

## Priority Topics (Top 10)

If you can only add 10 topics, prioritize these:
1. `kotlin`
2. `kotlin-multiplatform`
3. `android`
4. `ktor`
5. `kotlinx-serialization`
6. `utility-library`
7. `cross-platform`
8. `gradle`
9. `jvm`
10. `native`
