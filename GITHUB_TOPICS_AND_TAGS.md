# GitHub Topics and Tags for Common-Utils-Library-Kotlin-Multiplatform

This document provides recommendations for GitHub topics and tags, along with various methods to add them to the repository.

## Recommended GitHub Topics

Based on the analysis of this repository, the following topics are recommended:

### Primary Topics (Core Technologies)
| Topic | Description |
|-------|-------------|
| `kotlin` | Primary programming language |
| `kotlin-multiplatform` | Cross-platform development framework |
| `kotlin-library` | This is a reusable Kotlin library |
| `multiplatform` | Supports multiple platforms |

### Platform-Specific Topics
| Topic | Description |
|-------|-------------|
| `android` | Supports Android platform |
| `jvm` | Supports JVM platform |
| `windows` | Supports Windows (MinGW-w64) |
| `mingw` | Uses MinGW for Windows native builds |

### Framework and Library Topics
| Topic | Description |
|-------|-------------|
| `ktor` | Uses Ktor for HTTP client |
| `ktor-client` | Specifically uses Ktor Client |
| `kotlinx-serialization` | Uses Kotlin Serialization |
| `kotlinx-coroutines` | Uses Kotlin Coroutines |
| `gradle` | Build system used |

### Functionality Topics
| Topic | Description |
|-------|-------------|
| `utility-library` | Provides utility functions |
| `github-api` | Integrates with GitHub API (Gist) |
| `datetime` | Provides date/time utilities |
| `http-client` | Contains HTTP client functionality |

---

## Methods to Add GitHub Topics

### Method 1: GitHub Web Interface (Easiest)

1. Navigate to https://github.com/Baneeishaque/Common-Utils-Library-Kotlin-Multiplatform
2. Click the **gear icon (⚙️)** next to "About" on the right sidebar
3. In the "Topics" field, add topics separated by spaces or commas
4. Click **Save changes**

### Method 2: GitHub CLI (`gh`)

Install GitHub CLI if not already installed:
```bash
# macOS
brew install gh

# Windows
winget install GitHub.cli

# Linux (Debian/Ubuntu)
sudo apt install gh
```

Authenticate with GitHub:
```bash
gh auth login
```

Add topics using the GitHub CLI:
```bash
# Add multiple topics at once
gh repo edit Baneeishaque/Common-Utils-Library-Kotlin-Multiplatform --add-topic kotlin --add-topic kotlin-multiplatform --add-topic kotlin-library --add-topic multiplatform --add-topic android --add-topic jvm --add-topic windows --add-topic mingw --add-topic ktor --add-topic ktor-client --add-topic kotlinx-serialization --add-topic kotlinx-coroutines --add-topic gradle --add-topic utility-library --add-topic github-api --add-topic datetime --add-topic http-client
```

Or add topics one at a time:
```bash
gh repo edit Baneeishaque/Common-Utils-Library-Kotlin-Multiplatform --add-topic kotlin
gh repo edit Baneeishaque/Common-Utils-Library-Kotlin-Multiplatform --add-topic kotlin-multiplatform
gh repo edit Baneeishaque/Common-Utils-Library-Kotlin-Multiplatform --add-topic kotlin-library
gh repo edit Baneeishaque/Common-Utils-Library-Kotlin-Multiplatform --add-topic android
gh repo edit Baneeishaque/Common-Utils-Library-Kotlin-Multiplatform --add-topic jvm
gh repo edit Baneeishaque/Common-Utils-Library-Kotlin-Multiplatform --add-topic windows
gh repo edit Baneeishaque/Common-Utils-Library-Kotlin-Multiplatform --add-topic ktor
gh repo edit Baneeishaque/Common-Utils-Library-Kotlin-Multiplatform --add-topic kotlinx-serialization
gh repo edit Baneeishaque/Common-Utils-Library-Kotlin-Multiplatform --add-topic utility-library
gh repo edit Baneeishaque/Common-Utils-Library-Kotlin-Multiplatform --add-topic github-api
```

To remove a topic:
```bash
gh repo edit Baneeishaque/Common-Utils-Library-Kotlin-Multiplatform --remove-topic <topic-name>
```

### Method 3: GitHub REST API (cURL)

Using the GitHub REST API directly with cURL:

```bash
# First, create a personal access token with 'repo' scope
# Then use this command to replace ALL topics:

curl -X PUT \
  -H "Accept: application/vnd.github+json" \
  -H "Authorization: Bearer YOUR_GITHUB_TOKEN" \
  -H "X-GitHub-Api-Version: 2022-11-28" \
  https://api.github.com/repos/Baneeishaque/Common-Utils-Library-Kotlin-Multiplatform/topics \
  -d '{"names":["kotlin","kotlin-multiplatform","kotlin-library","multiplatform","android","jvm","windows","mingw","ktor","ktor-client","kotlinx-serialization","kotlinx-coroutines","gradle","utility-library","github-api","datetime","http-client"]}'
```

### Method 4: GitHub GraphQL API

```graphql
mutation {
  updateTopics(input: {
    repositoryId: "YOUR_REPOSITORY_ID",
    topicNames: [
      "kotlin",
      "kotlin-multiplatform",
      "kotlin-library",
      "multiplatform",
      "android",
      "jvm",
      "windows",
      "mingw",
      "ktor",
      "ktor-client",
      "kotlinx-serialization",
      "kotlinx-coroutines",
      "gradle",
      "utility-library",
      "github-api",
      "datetime",
      "http-client"
    ]
  }) {
    repository {
      repositoryTopics(first: 20) {
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

To get the repository ID:
```graphql
query {
  repository(owner: "Baneeishaque", name: "Common-Utils-Library-Kotlin-Multiplatform") {
    id
  }
}
```

### Method 5: Using Python with PyGithub

```python
from github import Github

# Authenticate
g = Github("YOUR_GITHUB_TOKEN")

# Get the repository
repo = g.get_repo("Baneeishaque/Common-Utils-Library-Kotlin-Multiplatform")

# Set topics
topics = [
    "kotlin",
    "kotlin-multiplatform",
    "kotlin-library",
    "multiplatform",
    "android",
    "jvm",
    "windows",
    "mingw",
    "ktor",
    "ktor-client",
    "kotlinx-serialization",
    "kotlinx-coroutines",
    "gradle",
    "utility-library",
    "github-api",
    "datetime",
    "http-client"
]

repo.replace_topics(topics)
print(f"Topics set: {repo.get_topics()}")
```

### Method 6: Using JavaScript/Node.js with Octokit

```javascript
const { Octokit } = require("@octokit/rest");

const octokit = new Octokit({
  auth: "YOUR_GITHUB_TOKEN"
});

async function setTopics() {
  const response = await octokit.rest.repos.replaceAllTopics({
    owner: "Baneeishaque",
    repo: "Common-Utils-Library-Kotlin-Multiplatform",
    names: [
      "kotlin",
      "kotlin-multiplatform",
      "kotlin-library",
      "multiplatform",
      "android",
      "jvm",
      "windows",
      "mingw",
      "ktor",
      "ktor-client",
      "kotlinx-serialization",
      "kotlinx-coroutines",
      "gradle",
      "utility-library",
      "github-api",
      "datetime",
      "http-client"
    ]
  });
  console.log("Topics set:", response.data.names);
}

setTopics();
```

---

## About GitHub Tags (Git Tags vs Repository Topics)

**Important Distinction:**

1. **GitHub Topics** (covered above) - These are metadata labels for repository discoverability
2. **Git Tags** - These are version markers in Git history

### Git Tags (Version Tags)

Git tags are typically used for marking release versions. Here are commands to manage git tags:

```bash
# Create a lightweight tag
git tag v1.0.0

# Create an annotated tag (recommended for releases)
git tag -a v1.0.0 -m "Release version 1.0.0"

# Push tags to GitHub
git push origin --tags

# Push a specific tag
git push origin v1.0.0

# List all tags
git tag

# Delete a local tag
git tag -d v1.0.0

# Delete a remote tag
git push origin --delete v1.0.0
```

### Using GitHub CLI for Releases (with Tags)

```bash
# Create a release with a new tag
gh release create v1.0.0 --title "Release v1.0.0" --notes "Release notes here"

# Create a release from an existing tag
gh release create v1.0.0 --title "Release v1.0.0" --notes "Release notes here"

# List releases
gh release list
```

---

## Quick Start - One Command to Add All Topics

Copy and paste this single command to add all recommended topics at once:

```bash
gh repo edit Baneeishaque/Common-Utils-Library-Kotlin-Multiplatform \
  --add-topic kotlin \
  --add-topic kotlin-multiplatform \
  --add-topic kotlin-library \
  --add-topic multiplatform \
  --add-topic android \
  --add-topic jvm \
  --add-topic windows \
  --add-topic mingw \
  --add-topic ktor \
  --add-topic ktor-client \
  --add-topic kotlinx-serialization \
  --add-topic kotlinx-coroutines \
  --add-topic gradle \
  --add-topic utility-library \
  --add-topic github-api \
  --add-topic datetime \
  --add-topic http-client
```

---

## Verification

After adding topics, verify them using:

```bash
# Using GitHub CLI
gh repo view Baneeishaque/Common-Utils-Library-Kotlin-Multiplatform --json repositoryTopics

# Using cURL
curl -H "Accept: application/vnd.github+json" \
  https://api.github.com/repos/Baneeishaque/Common-Utils-Library-Kotlin-Multiplatform/topics
```

---

## Summary of Recommended Topics (Copy-Paste Ready)

```
kotlin, kotlin-multiplatform, kotlin-library, multiplatform, android, jvm, windows, mingw, ktor, ktor-client, kotlinx-serialization, kotlinx-coroutines, gradle, utility-library, github-api, datetime, http-client
```
