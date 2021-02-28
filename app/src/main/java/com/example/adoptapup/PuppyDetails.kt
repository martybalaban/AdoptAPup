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

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Shapes
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

private val FabSize = 56.dp
private const val ExpandedSheetAlpha = 0.96f

@Composable
fun PuppyDetailCard(
    puppyID: Long,
    selectCourse: (Long) -> Unit,
    upPress: () -> Unit) {
    val puppy = PuppyRepo.getPuppy(puppyID)
    Column() {
        Image(
            painter = painterResource(puppy.imageResource),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .clip(shape = RoundedCornerShape(4.dp)),
            contentScale = ContentScale.Fit
        )
        Text(
            puppy.name,
            modifier = Modifier.padding(8.dp, 10.dp, 8.dp, 0.dp),
            style = TextStyle.Default
        )

        Spacer(modifier = Modifier.height(5.dp))

        for (attribute in puppy.attributes) {
            Text(
                "· $attribute\n",
                modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 0.dp)
            )
        }

        Button(onClick = { /*TODO*/ },
            Modifier
                .fillMaxWidth()
                .padding(10.dp),) {
            Text(text = "Adopt Me")
        }
    }
}
