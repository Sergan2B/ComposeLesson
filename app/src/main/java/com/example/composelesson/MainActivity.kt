package com.example.composelesson

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                ListItem(name = "Sergan", profession = "Programmer")
                ListItem(name = "Sergan", profession = "Programmer")
                ListItem(name = "Sergan", profession = "Programmer")
                ListItem(name = "Sergan", profession = "Programmer")
            }
        }
    }

    @Composable
    private fun ListItem(name: String, profession: String) {
        val counter = remember { mutableStateOf(0) }
        val color = remember { mutableStateOf(Color.Magenta) }
        val stateCounter = remember { mutableStateOf(true) }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .clickable {

                },
            /*.pointerInput(Unit) {
                /*detectDragGesturesAfterLongPress { change, dragAmount ->
                    Toast
                        .makeText(this@MainActivity, "Long press: $dragAmount", Toast.LENGTH_SHORT)
                        .show()
                    Toast
                        .makeText(this@MainActivity, "Long press: ${change.position}", Toast.LENGTH_SHORT)
                        .show()
                }*/
                /*detectTapGestures {
                    Toast
                        .makeText(this@MainActivity, "Long press: $it", Toast.LENGTH_SHORT)
                        .show()
                }*/
                /*detectHorizontalDragGestures { change, dragAmount ->
                                    Toast
                                        .makeText(this@MainActivity, "Long press: $dragAmount", Toast.LENGTH_SHORT)
                                        .show()
                }*/
            },*/
            shape = RoundedCornerShape(15.dp),
            elevation = 5.dp
        ) {
            Box(modifier = Modifier.background(Color.Green)) {
                Row(
                    modifier = Modifier.background(Color.Yellow),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_2bx2),
                        contentDescription = "Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(5.dp)
                            .size(64.dp)
                            .clip(CircleShape)
                            .clickable { startActivity(Intent(this@MainActivity, MainActivity2::class.java)) }
                    )
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .background(Color.Red)
                    ) {
                        Text(
                            text = name, style = TextStyle(
                                color = Color.Blue
                            )
                        )
                        Text(text = profession, modifier = Modifier)
                        Text(text = counter.value.toString())
                    }
                    Button(
                        onClick = {
                            when (stateCounter.value) {
                                true -> {
                                    counter.value++
                                    if (counter.value == 20) stateCounter.value = false
                                }
                                false -> {
                                    counter.value--
                                    if (counter.value == 0) stateCounter.value = true
                                }
                            }
                            when (counter.value) {
                                0 -> color.value = Color.Magenta
                                10 -> color.value = Color.Transparent
                                20 -> color.value = Color.Cyan
                            }
                        },
                        modifier = Modifier.background(color.value)
                    ) {
                        Text(text = "GO")
                    }
                }
            }
        }
    }
}