package com.example.tvremotecontroller


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tvremotecontroller.ui.theme.TVRemoteControllerTheme


private val RemoteBackground = Color(0xFF111318)
private val RemoteSurface = Color(0xFF22252D)
private val RemoteAccent = Color(0xFF6C8DFF)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TVRemoteControllerTheme {
                Scaffold (
                    modifier = Modifier.fillMaxSize(),
                    containerColor = RemoteBackground
                    ){innerPadding ->
                        RemoteScreen(
                            modifier = Modifier.padding(innerPadding)
                        )

                }
                }
        }
    }

    @Composable
    fun RemoteScreen(modifier:Modifier = Modifier){
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(RemoteBackground)
                .padding(horizontal = 24.dp, vertical = 20.dp),
            horizontalAlignment  = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ){
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = "LG Remote",
                    color = Color.White,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Ir",
                    color = RemoteAccent,
                    fontWeight = FontWeight.Bold
                )
            }

            Text(
                text = "Control remoto infrarrojo",
                color = Color.LightGray,
                fontSize =  14.sp
            )

            Spacer(modifier = Modifier.height(4.dp))

            Button(
                onClick = { /* Turn on */ },
                modifier = Modifier.size(76.dp),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFB83245)
                )
            ) {
                Text("⏻", fontSize = 32.sp)
            }
            Text(
                text = "POWER",
                color = Color.LightGray,
                fontSize = 12.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            NavigationPad()

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                RemoteButton("VOL −") {}
                RemoteButton("MUTE") {}
                RemoteButton("VOL +") {}
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                RemoteButton("BACK") {}
                RemoteButton("HOME") {}
                RemoteButton("CH +") {}
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                RemoteButton("MENU") {}
                RemoteButton("INPUT") {}
                RemoteButton("CH −") {}
            }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "Televisor no conectado",
                color = Color.Gray,
                fontSize = 12.sp
            )
        }


    }


    @Composable
    private fun NavigationPad() {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            RemoteButton("▲") {}

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                RemoteButton("◀") {}
                Button(
                    onClick = { /* remot ebutton */ },
                    modifier = Modifier.size(76.dp),
                    shape = CircleShape
                ) {
                    Text("OK", fontWeight = FontWeight.Bold)
                }
                RemoteButton("▶") {}
            }

            RemoteButton("▼") {}
        }
    }


    @Composable
    private fun RemoteButton(
        label: String,
        onClick: () -> Unit
    ) {
        Button(
            onClick = onClick,
            modifier = Modifier.size(width = 82.dp, height = 48.dp),
            shape = RoundedCornerShape(14.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = RemoteSurface,
                contentColor = Color.White
            )
        ) {
            Text(
                text = label,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                maxLines = 1
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    private fun RemoteScreenPreview() {
        TVRemoteControllerTheme {
            Surface(color = RemoteBackground) {
                RemoteScreen()
            }
        }
    }
}
