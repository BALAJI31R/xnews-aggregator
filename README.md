# XNews - News Aggregator

A CLI application that fetches news articles from the NewsAPI based on user preferences loaded from a JSON configuration file.

## Overview

XNews reads user preferences (topics, language, sort order) from a JSON file and fetches relevant news articles from the NewsAPI. It demonstrates HTTP client usage, JSON parsing, and file I/O in Java.

## Tech Stack

- Java
- Gradle 7.4.2
- OkHttp 4.12 (HTTP client)
- Jackson 2.17 (JSON parsing)
- JUnit 5

## Project Structure

```
app/src/main/java/com/crio/xnews/
├── App.java              # Entry point, reads preferences & orchestrates
├── NewsApiClient.java    # HTTP client for NewsAPI
├── NewsParser.java       # JSON response parser
├── NewsArticle.java      # Article model (title, author, url, publishedAt)
├── NewsApiResponse.java  # API response wrapper
├── UserPreference.java   # User preference model (name, language, sortBy)
└── Source.java           # News source model
```

## Features

- Load user preferences from JSON file
- Fetch news articles from NewsAPI with configurable parameters
- Support for language and sort order filters
- Input validation for API queries
- Error handling for HTTP failures and empty responses

## Build & Run

```bash
# Build the project
./gradlew build

# Run with preferences file
./gradlew run --args="path/to/preferences.json"

# Run tests
./gradlew test
```

## Input Format

User preferences JSON file:

```json
[
  {
    "name": "technology",
    "language": "en",
    "sortBy": "publishedAt"
  }
]
```

## API

Uses [NewsAPI](https://newsapi.org/) (`/v2/everything`) with parameters:
- `q` — Search query (from user preference name)
- `language` — Article language filter
- `sortBy` — Sort order (relevancy, popularity, publishedAt)

## Author

Balaji R — Crio.Do
