package com.danp.paintingdescription

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danp.paintingdescription.ui.theme.PaintingDescriptionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            viewContainer()
        }
    }
}

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun viewContainer() {
    PaintingDescriptionTheme {
        Scaffold(
            topBar = { toolbar() },
            bottomBar = { bottombar() }
        ) { innerPadding ->
            Content(Modifier.padding(innerPadding))
        }
    }
}

@Composable
fun Content(mod: Modifier = Modifier) {
    Box(modifier = mod.fillMaxWidth()) {
        Card(
            modifier = Modifier
                .width(350.dp)
                .align(Alignment.Center)
        ) {
            Content()
        }
    }

}

@Composable
fun Content() {
    var counter by rememberSaveable {
        mutableStateOf(1)
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(horizontal = 16.dp)
    ) {
        item {
            Card {
                Row(modifier = Modifier.padding(8.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_favorite),
                        contentDescription = "favorites"
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_share),
                        contentDescription = "favorites"
                    )
                }
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(280.dp),
                    painter = painterResource(id = R.drawable.cypresses),
                    contentDescription = "cipreses"
                )
            }
        }
        item {
            Text(
                text = stringResource(id = R.string.paintTitle),
                fontSize = 32.sp,
                color = Color.Black,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Text(
                text = stringResource(id = R.string.paintDescription), color = Color.Black
            )
        }
    }

}

@Preview
@Composable
fun bottombar() {
    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
//        contentColor = MaterialTheme.colorScheme.primary,
        contentColor = colorResource(id = R.color.teal_200),

        ) {
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = "Bottom app bar",
        )

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun toolbar() {
    TopAppBar(
        colors = topAppBarColors(
            containerColor = colorResource(id = R.color.backgroundApp),
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Text("painting information")
        }
    )
}