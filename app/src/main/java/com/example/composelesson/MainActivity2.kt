package com.example.composelesson

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Row(
                modifier = Modifier.background(Color.Yellow),
                horizontalArrangement = Arrangement.Center
            ) {
                LazyColumn(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.wrapContentHeight().wrapContentWidth()
                ) {
                    items(count = 100) {
                        Text(
                            text = "item $it",
                            fontSize = 30.sp,
                            modifier = Modifier.padding(vertical = 10.dp)
                        )
                    }
                }
                LazyColumn(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.wrapContentHeight().wrapContentWidth().padding(horizontal = 100.dp )
                ) {
                    itemsIndexed(listOf("item 1", "item 2", "End", "Finish")) {index, item ->
                        Text(
                            text = item,
                            fontSize = 30.sp,
                            modifier = Modifier.padding(vertical = 10.dp)
                        )
                    }
                }
            }

        }
    }
}