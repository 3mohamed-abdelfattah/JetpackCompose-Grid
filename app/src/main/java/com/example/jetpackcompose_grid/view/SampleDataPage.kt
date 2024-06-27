package com.example.jetpackcompose_grid.view

import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.jetpackcompose_grid.R
import com.example.jetpackcompose_grid.response.SampleDataClass
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@ExperimentalFoundationApi
@Composable
fun SampleDataPage(navController: NavHostController) {
    val context = LocalContext.current
    val dataFileString = getJsonDataFromAsset(context, "SampleData.json")
    val gson = Gson()
    val gridSampleType = object : TypeToken<List<SampleDataClass>>() {}.type
    val sampleData: List<SampleDataClass> = gson.fromJson(dataFileString, gridSampleType)


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LazyVerticalGrid(columns = GridCells.Fixed(3), modifier = Modifier.padding(5.dp)) {
            items(sampleData) { data ->
                SampleDataGridItem(data, navController)
            }
        }
    }

}

fun getJsonDataFromAsset(context: Context, data: String): String {
    return context.assets.open(data).bufferedReader().use { it.readText() }
}

@Composable
fun SampleDataGridItem(data: SampleDataClass, navController: NavHostController) {
    Card(modifier = Modifier
        .clickable {
            val itemVal = Gson().toJson(data)
            navController.navigate("sample_data_detail/$itemVal")
        }
        .padding(5.dp)
        .fillMaxSize()) {
        Column(modifier = Modifier.padding(15.dp)) {
            Column(
                modifier = Modifier.padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painterResource(R.drawable.jetpack),
                    contentDescription = "Photo",
                    modifier = Modifier
                        .width(80.dp)
                        .height(80.dp)
                        .padding(5.dp)
                        .clip(RoundedCornerShape(25.dp))
                )
                Spacer(modifier = Modifier.padding(5.dp))
                Text(
                    text = data.name,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.ExtraBold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.padding(2.dp))
                Text(
                    text = data.dsc,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.W400,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )
            }

        }
    }
}
