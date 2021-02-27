package com.example.adoptapup

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.coroutineScope

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PuppyList(puppies = listOf(Puppy(R.drawable.ic_launcher_foreground,"Name1",listOf(" ", "f", "fs"))))
        }
    }

    @Composable
    fun PuppyList(puppies: List<Puppy>){
        Column(modifier = Modifier.fillMaxWidth()) {
            for (puppy in puppies) {
                PuppyCard(puppy)
            }
        }
    }

    @Composable
    fun PuppyCard(puppy: Puppy) {
            Surface(Modifier.fillMaxWidth().clickable {
                Toast.makeText(applicationContext,puppy.name,Toast.LENGTH_LONG)
            }) {
                Column() {
                Text(puppy.name,
                modifier = Modifier.padding(16.dp),
                style = TextStyle.Default)
                for(attribute in puppy.attributes){
                        Text("* $attribute\n",
                        modifier = Modifier.padding(4.dp))
                    }
                }
            }
    }
}

data class Puppy(
    @DrawableRes val imageResource: Int,
    val name: String,
    val attributes: List<String>
)
