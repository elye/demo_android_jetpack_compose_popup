package com.example.myapplication.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import androidx.compose.ui.window.SecureFlagPolicy

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun PopupDemo() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            Modifier.background(Color.Gray)
        ) {
            var popup by remember { mutableStateOf(false) }
            TextButton(onClick = { popup = true }) {
                Text("Open normal popup")
            }

            if (popup) {
                Popup(
                    alignment = Alignment.Center,
                    offset = IntOffset(-80, 600),
                    onDismissRequest = { popup = false },
                    properties = PopupProperties(
                        focusable = true,
                        dismissOnBackPress = false,
                        dismissOnClickOutside = false,
                        securePolicy = SecureFlagPolicy.SecureOn,
                        excludeFromSystemGesture = false,
                        clippingEnabled = false,
                        usePlatformDefaultWidth = true
                    )
                ) {
                    Surface(
                        border = BorderStroke(4.dp, MaterialTheme.colors.secondary),
                        shape = RoundedCornerShape(8.dp),
                        color = Color(0xCCEEEEEE),
                    ) {
                        Column(
                            modifier = Modifier.padding(140.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = "I'm popping up")
                            Spacer(modifier = Modifier.height(32.dp))
                            TextButton(onClick = { popup = false }) {
                                Text(text = "Close Popup")
                            }
                        }
                    }
                }
            }
        }
    }
}
