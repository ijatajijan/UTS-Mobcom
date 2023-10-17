package com.example.utsmobkom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uts_mobcom.model.Matakuliah
import com.example.uts_mobcom.model.DataMataKuliah
import com.example.uts_mobcom.ui.theme.UTS_MobcomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UTS_MobcomTheme { Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFFFFFFF)
                ) {
                    UTS_Mobcom()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UTS_Mobcom() {
    Column {
        CenterAlignedTopAppBar(
            title = { Text(text = "KRS Semester-119") },
            modifier = Modifier
                .fillMaxWidth(),
        )
        ListMatkul(matkul = DataMataKuliah.matkul)
    }
}

@Composable
fun ListMatkul(matkul: List<Matakuliah>) {
    LazyColumn() {
        items(matkul.size) {
            CardMatkul(
                matkul = matkul[it],
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
fun CardMatkul(matkul: Matakuliah, modifier: Modifier = Modifier) {
    Card(modifier = modifier, colors = CardDefaults.cardColors(
        containerColor = Color(0xFFF0F0F0),
    )) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp)
                .sizeIn(minHeight = 56.dp)
        ) {
            Box(
                modifier = Modifier
                    .sizeIn(minWidth = 56.dp)
                    .padding(8.dp)
            ) {
                Image(
                    painter = painterResource(id = matkul.image),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.size(64.dp)
                )
            }
            Column {
                Text(
                    text = stringResource(id = matkul.matkul),
                    modifier = Modifier.padding(8.dp),
                    fontWeight = FontWeight.Bold

                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = "SKS : " + stringResource(id = matkul.sks),
                        modifier = Modifier.padding(8.dp),
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ListMatkul() {
    UTS_MobcomTheme {
        UTS_Mobcom()
    }
}