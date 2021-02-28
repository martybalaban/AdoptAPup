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

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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

        Text(
            puppy.name,
            modifier = Modifier.padding(8.dp, 0.dp, 8.dp, 0.dp),
            style = TextStyle.Default
        )

        for (attribute in puppy.attributes) {
            Text(
                "* $attribute\n",
                modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 0.dp)
            )
        }

        Button(onClick = { /*TODO*/ },) {
            Text(text = "Adopt Me")
        }
    }
}
