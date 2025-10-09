# **Android Compose Starter Template**

A ready-to-use Android starter template with all the essential dependencies and configurations for building modern Compose applications. Perfect for developers who want to skip the initial setup and jump straight into development.

## **🎯 Purpose**

This template provides a solid foundation with commonly used libraries and best practices pre-configured, saving you hours of initial setup time. Whether you're starting a new project or learning Android development, this template has you covered.

## **✨ What's Included**

### **🎨 UI Framework**

* **Jetpack Compose** \- Modern declarative UI  
* **Material 3** \- Latest Material Design components  
* **Compose Navigation** \- Type-safe navigation between screens  
* **Coil** \- Efficient image loading with Compose support  
* **Custom Design Tokens** \- An extensible, theme-aware custom color system implemented using CompositionLocal to handle design-specific colors outside the standard Material 3 slots.

### **🏗️ Architecture Components**

* **Hilt** \- Dependency injection (fully configured)  
* **ViewModel** \- Lifecycle-aware state management  
* **Room Database** \- Local data persistence with KSP  
* **DataStore** \- Modern key-value storage (replaces SharedPreferences)

### **🌐 Networking**

* **Retrofit** \- REST API client  
* **OkHttp** \- HTTP client with logging interceptor  
* **Kotlin Serialization** \- Type-safe JSON parsing

### **⚡ Async & Background Tasks**

* **Coroutines** \- Structured concurrency  
* **Flow** \- Reactive data streams  
* **WorkManager** \- Reliable background task scheduling

### **🛠️ Developer Tools**

* **Timber** \- Better logging  
* **Compose Preview** \- UI preview tools  
* **Room Schema Export** \- Database version management

### **🧪 Testing Setup**

* **JUnit** \- Unit testing  
* **Espresso** \- UI testing  
* **Compose Test** \- Compose-specific testing utilities

## **📋 Requirements**

* Android Studio Hedgehog or later  
* Minimum SDK: 24 (Android 7.0)  
* Target SDK: 36  
* JDK 17

## **🚀 Quick Start**

### **1\. Use This Template**

Click the "Use this template" button on GitHub or clone the repository:

git clone \[https://github.com/sulmanyousaf/SulmanFirstCompose.git\](https://github.com/sulmanyousaf/SulmanFirstCompose.git)  
cd SulmanFirstCompose

### **2\. Customize Package Name**

Update the package name in:

* build.gradle.kts (namespace and applicationId)  
* Refactor package structure in Android Studio

### **3\. Sync & Build**

./gradlew build

### **4\. Start Coding\! 🎉**

You're all set\! Start building your app with all essential dependencies ready to use.

## **🎨 Custom Design Tokens with CompositionLocal**

This template goes beyond the standard 26 Material 3 color slots by providing an extensible custom color system. This is crucial for large projects where you need unique design-specific colors (like "SuccessGreen", "ChatBubbleBlue", or "DangerRed") that must switch automatically between light and dark themes.

### **✨ Why CompositionLocal?**

Standard Material 3 colors are excellent, but they are limited to specific roles (primary, surface, etc.). By using **CompositionLocal**, we inject our own custom color data structure (AppTextColors) directly into the MaterialTheme's composition tree, allowing us to access any number of custom, theme-aware tokens without modifying the standard Compose framework.

### **📁 Custom Color Files (The System Blueprint)**

The entire custom color system is managed across three specialized files in the ui/theme package:

| File | Role | Key Content |
| :---- | :---- | :---- |
| **Color.kt** | **Palette** | Holds all raw color hex codes (e.g., val OwnBlack \= Color(0xFF000000)). |
| **AppTextColors.kt** | **Tokens & Access** | Defines the custom slots (data class AppTextColors), the light/dark themes for these slots, and the **MaterialTheme.appTextColors** extension property. |
| **Theme.kt** | **Injection** | Uses CompositionLocalProvider within SulmanFirstComposeTheme to **inject** the correct light or dark AppTextColors set into the UI hierarchy. |

### **🛠️ Using the Custom Colors**

Instead of calling MaterialTheme.colorScheme.primary, you now access your custom tokens through the extension property, ensuring theming consistency:

| Access Method | Purpose | Example Token Role |  
| MaterialTheme.appTextColors.body | Main, high-contrast text color. | Default text |  
| MaterialTheme.appTextColors.headline | Prominent text color (e.g., titles). | High-emphasis title |  
| MaterialTheme.appTextColors.subheading | Medium-emphasis text (e.g., captions). | Secondary information |  
| MaterialTheme.appTextColors.backgroundAlt | Secondary surface color (e.g., for cards or dialogs). | Card background |  
| MaterialTheme.appTextColors.warningIcon | Semantic color for warning or error indicators. | Status icon |  
**Example Usage in a Composable:**

@Composable  
fun CustomCard() {  
    // 1\. Use a custom background color  
    Surface(color \= MaterialTheme.appTextColors.backgroundAlt) {   
        Text(  
            text \= "Semantic Warning",  
            // 2\. Use a custom text color  
            color \= MaterialTheme.appTextColors.warningIcon,   
            style \= MaterialTheme.typography.labelMedium  
        )  
    }  
}

### **➕ Extending the System (Adding a New Color Slot)**

Adding a new custom color is a simple, theme-safe three-step process:

#### **Step 1: Define the Slot (in AppTextColors.kt)**

Add a new property to the AppTextColors data class.

data class AppTextColors(  
    // ... existing colors ...  
    val success: Color \= Color.Unspecified // ✨ Add your new token here  
)

#### **Step 2: Define the Light/Dark Values (in AppTextColors.kt)**

Define the theme-specific colors for the slot.

val LightAppTextColors \= AppTextColors(  
    // ... existing colors ...  
    success \= Color(0xFF00C853) // 🟢 Bright Green for Light Theme  
)

val DarkAppTextColors \= AppTextColors(  
    // ... existing colors ...  
    success \= Color(0xFF69F0AE) // 🟡 Lighter Green for Dark Theme  
)

#### **Step 3: Use the New Color Anywhere**

@Composable  
fun SuccessMessage(text: String) {  
    Text(  
        text \= text,  
        color \= MaterialTheme.appTextColors.success // 🎉 Use the token\!  
    )  
}

This structure guarantees that your custom colors will automatically switch their value when the user changes their system theme, maintaining design consistency across both dark and light modes.

## **📁 Suggested Project Structure**

app/  
├── src/main/java/com/yourapp/  
│   ├── data/  
│   │   ├── local/          \# Room database, DAOs  
│   │   ├── remote/         \# Retrofit API services  
│   │   ├── repository/     \# Repository implementations  
│   ├── di/                 \# Hilt modules  
│   ├── domain/  
│   │   ├── model/          \# Domain models  
│   │   └── usecase/        \# Business logic  
│   └── ui/  
│       ├── screens/        \# Composable screens  
│       ├── components/     \# Reusable UI components  
│       ├── navigation/     \# Navigation setup  
│       └── theme/          \# Material theme configuration  
└── schemas/                \# Room database schemas

## **🔧 Key Configurations**

### **Hilt Setup**

Dependency injection is pre-configured. Just add @HiltAndroidApp to your Application class:

@HiltAndroidApp  
class MyApplication : Application()

### **Room Database**

Schema export is configured. Your database schemas will be saved in /schemas directory for version control.

### **Kotlin Serialization**

JSON parsing is ready to use with Retrofit. Just annotate your data classes with @Serializable.

### **Desugaring Enabled**

Java 8+ APIs are available on all supported Android versions.

## **📚 Documentation Links**

* [Jetpack Compose](https://developer.android.com/jetpack/compose)  
* [Hilt](https://dagger.dev/hilt/)  
* [Room](https://developer.android.com/training/data-storage/room)  
* [Retrofit](https://square.github.io/retrofit/)  
* [Coroutines](https://kotlinlang.org/docs/coroutines-overview.html)

## **🎓 Perfect For**

* Rapid prototyping  
* Learning Android development  
* Starting new production projects  
* Code interviews and technical assessments  
* Hackathons

## **🤝 Contributing**

Found a bug or want to add a commonly used library? Contributions are welcome\! Please feel free to submit a Pull Request.

## **📝 License**

**MIT License**

## **💡 Tips**

* Keep dependencies updated using Android Studio's version catalog  
* Remove unused dependencies to reduce app size  
* Customize ProGuard rules for release builds  
* Add your own .gitignore rules as needed

**Built with ❤️ for the Android developer community**

Star ⭐ this repo if you find it helpful\!