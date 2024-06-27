package com.example.jetpackcompose_grid.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose_grid.R
import com.example.jetpackcompose_grid.response.SampleDataClass

@Composable
fun SampleDataDetailPage(data: SampleDataClass) {

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painterResource(R.drawable.jetpack),
            contentDescription = "Photo",
            modifier = Modifier
                .width(400.dp)
                .height(400.dp)
                .clip(RoundedCornerShape(25.dp))
        )
        Spacer(modifier = Modifier.padding(5.dp))
        Text(
            text = data.name,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 35.sp,
            fontWeight = FontWeight.ExtraBold,
        )
        Spacer(modifier = Modifier.padding(2.dp))
        Text(
            text = data.description,
            fontSize = 25.sp,
            fontWeight = FontWeight.W400,
        )
    }
}