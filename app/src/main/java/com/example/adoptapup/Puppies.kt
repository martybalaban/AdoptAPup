/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.adoptapup

import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController


@Composable()
fun Puppies(selectCourse: (Long) -> Unit){
    val puppies = remember(0) { PuppyRepo.getRelated(0) }
    PuppyList(puppies = puppies,selectCourse)
}

@Composable
fun PuppyList(puppies: List<Puppy>, selectCourse: (Long) -> Unit) {
    LazyColumn(modifier = Modifier.fillMaxHeight()) {
        items(items = puppies, itemContent = { item ->
            PuppyCard(puppy = item,selectCourse)
        })
    }
}


@Composable
fun PuppyCard(puppy: Puppy, selectCourse: (Long) -> Unit) {
    val navController = rememberNavController()

    Column() {
        Row(modifier = Modifier
            .clickable {
                val options = Bundle()
                options.putParcelable("puppy", puppy)
                selectCourse(puppy.puppyID)
            }
            .fillMaxWidth()) {
            Image(
                painter = painterResource(R.drawable.ic_baseline_pets_24),
                contentDescription = null,
                modifier = Modifier
                    .width(180.dp)
                    .height(180.dp)
                    .clip(shape = RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(Modifier.height(16.dp))

            Text(
                puppy.name,
                modifier = Modifier.padding(8.dp, 0.dp, 8.dp, 0.dp),
                style = MaterialTheme.typography.h3,
                textAlign = TextAlign.Center
            )
        }
    }
}