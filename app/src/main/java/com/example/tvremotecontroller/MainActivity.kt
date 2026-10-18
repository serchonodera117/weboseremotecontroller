package com.example.tvremotecontroller


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tvremotecontroller.ui.theme.TVRemoteControllerTheme
import  com.example.tvremotecontroller.ui.RemoteScreen_Draw
import  com.example.tvremotecontroller.ui.RemoteBackground


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TVRemoteControllerTheme {
                Scaffold (
                    modifier = Modifier.fillMaxSize(),
                    containerColor = RemoteBackground
                    ){innerPadding ->
                        RemoteScreen_Draw(
                            modifier = Modifier.padding(innerPadding)
                        )

                }
            }
        }
    }
}
