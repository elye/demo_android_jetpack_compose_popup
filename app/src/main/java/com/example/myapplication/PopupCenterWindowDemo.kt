package com.example.myapplication

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.*
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupPositionProvider

@Composable
fun PopupCenterWindowDemo() {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            Modifier.background(Color.Gray),
            contentAlignment = Alignment.Center
        ) {
            var popup by remember { mutableStateOf(false) }
            TextButton(onClick = { popup = true }) {
                Text("Open window popup")
            }

            if (popup) {
                Popup(
                    popupPositionProvider = WindowCenterOffsetPositionProvider(),
                    onDismissRequest = { popup = false },
                ) {
                    Surface(
                        border = BorderStroke(1.dp, MaterialTheme.colors.secondary),
                        shape = RoundedCornerShape(8.dp),
                        color = Color(0xCCEEEEEE),
                    ) {
                        Column(
                            modifier = Modifier.padding(100.dp),
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

class WindowCenterOffsetPositionProvider(
    private val x: Int = 0,
    private val y: Int = 0
) : PopupPositionProvider {
    override fun calculatePosition(
        anchorBounds: IntRect,
        windowSize: IntSize,
        layoutDirection: LayoutDirection,
        popupContentSize: IntSize
    ): IntOffset {
        return IntOffset(
            (windowSize.width - popupContentSize.width) / 2 + x,
            (windowSize.height - popupContentSize.height) / 2 + y
        )
    }
}
