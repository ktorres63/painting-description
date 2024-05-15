package com.danp.paintingdescription

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.danp.paintingdescription.ui.theme.PaintingDescriptionTheme

class mapActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            viewContainerMap()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun viewContainerMap() {
    PaintingDescriptionTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = colorResource(id = R.color.backgroundApp),
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                    title = {
                        Text("Map Information")
                    }
                )
            },
            bottomBar = {
                BottomAppBar(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    containerColor = colorResource(id = R.color.backgroundApp),

                    actions = {
                        IconButton(onClick = { /* do something */ }) {
                            Icon(Icons.Filled.Home, contentDescription = "Localized description")
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        IconButton(onClick = { /* do something */ }) {
                            Icon(
                                Icons.Filled.LocationOn,
                                contentDescription = "Localized description"
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        IconButton(onClick = { /* do something */ }) {
                            Icon(Icons.Filled.Person, contentDescription = "Localized description")
                        }
                    },
                )
            }
        ) { innerPadding ->
            ContentMap(Modifier.padding(innerPadding))
        }
    }
}

@Composable
fun ContentMap(mod: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxHeight()) {
        Spacer(modifier = Modifier.padding(50.dp))
        Image(
            painter = painterResource(id = R.drawable.interior_map),
            contentDescription = null,
            modifier = Modifier
                .size(620.dp)
        )
    }

}


