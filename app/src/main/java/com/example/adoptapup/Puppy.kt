package com.example.adoptapup

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Puppy(@DrawableRes val imageResource: Int, val name: String, val attributes: List<String>, val puppyID: Long) :
    Parcelable

/**
 * A fake repo
 */
object PuppyRepo {
    fun getPuppy(puppyID: Long): Puppy = puppiesList.find { it.puppyID == puppyID }!!
    fun getRelated(@Suppress("UNUSED_PARAMETER") courseId: Long): List<Puppy> = puppiesList
}


private val puppiesList = listOf(
    Puppy(
        R.drawable.header,
        "Rex",
        listOf("Male", "Loves to hunt rabbits", "Enjoys nature"),
        puppyID = 0
    ),
    Puppy(
        R.drawable.ic_launcher_foreground,
        "Sparky",
        listOf("Male", "Energetic", "Really smart"),
        puppyID = 1
    ),
    Puppy(
        R.drawable.ic_launcher_foreground,
        "Fido",
        listOf("Female", "Best with kids", "Energetic", "Love going on walks"),
        puppyID = 2
    )
    ,
    Puppy(
        R.drawable.ic_launcher_foreground,
        "Lassy",
        listOf("Male", "Likes other dogs", "Afraid of cats", "Love chasing squirrels"),
        puppyID = 3
    ),
    Puppy(
        R.drawable.ic_launcher_foreground,
        "Beethoven",
        listOf("Male", "Afraid of cats", "Love to snuggle"),
        puppyID = 4
    ),
    Puppy(
        R.drawable.puppy1,
        "Mozart",
        listOf("Female", "Family dog", "Energetic", "Likes belly rubs"),
        puppyID = 5
    ),
    Puppy(
        R.drawable.puppy1,
        "Spike",
        listOf("Female", "Needs quiet home", "Afraid of cats", "Knows 10 tricks"),
        puppyID = 6
    )
)
