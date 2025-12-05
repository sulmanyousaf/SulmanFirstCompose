package com.applico.sulmanfirstcompose.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

/**
 * 1. Define the custom color structure (Data Class)
 * This class holds all your custom, theme-aware color properties.
 */
@Immutable
data class AppTextColors(
    // 1. Primary Text Colors
    val body: Color = Color.Unspecified,
    val headline: Color = Color.Unspecified,

    // 2. Custom Text Slots (Medium-emphasis text)
    val subheading: Color = Color.Unspecified,

    // 3. Custom Surface Slots (Contrasting background)
    val backgroundAlt: Color = Color.Unspecified,

    // 4. Custom Icon/Semantic Slots (Warning status)
    val warningIcon: Color = Color.Unspecified,
)


/**
 * 2. Define the concrete color sets for each theme
 */

// --- Light Theme Custom Colors ---
val LightAppTextColors = AppTextColors(
    // Primary Text
    body = OwnWhite,
    headline = Purple40,
    // Custom Text Slot
    subheading = LightSubheading,
    // Custom Surface Slot
    backgroundAlt = LightBackgroundAlt,
    // Custom Icon/Semantic Slot
    warningIcon = LightWarning
)

// --- Dark Theme Custom Colors ---
val DarkAppTextColors = AppTextColors(
    // Primary Text
    body = OwnBlack,
    headline = Purple80,
    // Custom Text Slot
    subheading = DarkSubheading,
    // Custom Surface Slot
    backgroundAlt = DarkBackgroundAlt,
    // Custom Icon/Semantic Slot
    warningIcon = DarkWarning
)


/**
 * 3. Define the CompositionLocal
 * This is the mechanism that carries the color set down the UI tree.
 * We use staticCompositionLocalOf because theme colors rarely change at runtime.
 */
val LocalAppTextColors = staticCompositionLocalOf { AppTextColors() }


/**
 * 4. Define the MaterialTheme Extension Property (CRITICAL for clean usage)
 * This allows you to access the custom colors like MaterialTheme.appTextColors.body
 */
val MaterialTheme.appTextColors: AppTextColors
    @Composable
    @ReadOnlyComposable
    get() = LocalAppTextColors.current