# Android Compose Starter Template

A ready-to-use Android starter template with all the essential dependencies and configurations for building modern Compose applications. Perfect for developers who want to skip the initial setup and jump straight into development.

## 🎯 Purpose

This template provides a solid foundation with commonly used libraries and best practices pre-configured, saving you hours of initial setup time. Whether you're starting a new project or learning Android development, this template has you covered.

## ✨ What's Included

### 🎨 UI Framework
- **Jetpack Compose** - Modern declarative UI
- **Material 3** - Latest Material Design components
- **Compose Navigation** - Type-safe navigation between screens
- **Coil** - Efficient image loading with Compose support

### 🏗️ Architecture Components
- **Hilt** - Dependency injection (fully configured)
- **ViewModel** - Lifecycle-aware state management
- **Room Database** - Local data persistence with KSP
- **DataStore** - Modern key-value storage (replaces SharedPreferences)

### 🌐 Networking
- **Retrofit** - REST API client
- **OkHttp** - HTTP client with logging interceptor
- **Kotlin Serialization** - Type-safe JSON parsing

### ⚡ Async & Background Tasks
- **Coroutines** - Structured concurrency
- **Flow** - Reactive data streams
- **WorkManager** - Reliable background task scheduling

### 🛠️ Developer Tools
- **Timber** - Better logging
- **Compose Preview** - UI preview tools
- **Room Schema Export** - Database version management

### 🧪 Testing Setup
- **JUnit** - Unit testing
- **Espresso** - UI testing
- **Compose Test** - Compose-specific testing utilities

## 📋 Requirements

- Android Studio Hedgehog or later
- Minimum SDK: 24 (Android 7.0)
- Target SDK: 36
- JDK 17

## 🚀 Quick Start

### 1. Use This Template

Click the "Use this template" button on GitHub or clone the repository:

```bash
git clone https://github.com/sulmanyousaf/SulmanFirstCompose.git
cd SulmanFirstCompose
```

### 2. Customize Package Name

Update the package name in:
- `build.gradle.kts` (namespace and applicationId)
- Refactor package structure in Android Studio

### 3. Sync & Build

```bash
./gradlew build
```

### 4. Start Coding! 🎉

You're all set! Start building your app with all essential dependencies ready to use.

## 📁 Suggested Project Structure

```
app/
├── src/main/java/com/yourapp/
│   ├── data/
│   │   ├── local/          # Room database, DAOs
│   │   ├── remote/         # Retrofit API services
│   │   └── repository/     # Repository implementations
│   ├── di/                 # Hilt modules
│   ├── domain/
│   │   ├── model/          # Domain models
│   │   └── usecase/        # Business logic
│   └── ui/
│       ├── screens/        # Composable screens
│       ├── components/     # Reusable UI components
│       ├── navigation/     # Navigation setup
│       └── theme/          # Material theme configuration
└── schemas/                # Room database schemas
```

## 🔧 Key Configurations

### Hilt Setup
Dependency injection is pre-configured. Just add `@HiltAndroidApp` to your Application class:

```kotlin
@HiltAndroidApp
class MyApplication : Application()
```

### Room Database
Schema export is configured. Your database schemas will be saved in `/schemas` directory for version control.

### Kotlin Serialization
JSON parsing is ready to use with Retrofit. Just annotate your data classes with `@Serializable`.

### Desugaring Enabled
Java 8+ APIs are available on all supported Android versions.

## 📚 Documentation Links

- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- [Hilt](https://dagger.dev/hilt/)
- [Room](https://developer.android.com/training/data-storage/room)
- [Retrofit](https://square.github.io/retrofit/)
- [Coroutines](https://kotlinlang.org/docs/coroutines-overview.html)

## 🎓 Perfect For

- Rapid prototyping
- Learning Android development
- Starting new production projects
- Code interviews and technical assessments
- Hackathons

## 🤝 Contributing

Found a bug or want to add a commonly used library? Contributions are welcome! Please feel free to submit a Pull Request.

## 📝 License
**MIT License**

## 💡 Tips

- Keep dependencies updated using Android Studio's version catalog
- Remove unused dependencies to reduce app size
- Customize ProGuard rules for release builds
- Add your own `.gitignore` rules as needed

---

**Built with ❤️ for the Android developer community**

Star ⭐ this repo if you find it helpful!
