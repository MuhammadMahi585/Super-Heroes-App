package com.example.superhero

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.superhero.model.Hero
import com.example.superhero.model.heroes
import com.example.superhero.ui.theme.SuperheroesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperheroesTheme {

            }
        }
    }
}
@Composable
fun HeroesList(){
    Scaffold(
        topBar = {
            TopAppBarHero()
        }
    ) {it->
 LazyColumn(contentPadding = it) {
    items(heroes){
        HeroDisplay(
            hero = it,
            )
                }
           }
        }
    }
@Composable
fun HeroDisplay(
    hero: Hero,

) {
    Card(
        elevation = CardDefaults.cardElevation(dimensionResource(id = R.dimen.card_elevation)),
        modifier = Modifier
            .clip(MaterialTheme.shapes.medium)
            .padding(
                top=dimensionResource(id = R.dimen.small_padding),
                bottom =dimensionResource(id = R.dimen.small_padding),
                start = dimensionResource(id = R.dimen.medium_padding),
                end = dimensionResource(id = R.dimen.medium_padding)
            )
    ) {
        Row (
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.medium_padding))
                .height(dimensionResource(id = R.dimen.image_size))
        ){
            Column(
                modifier = Modifier
                  .weight(2f)
            ) {
                Text(
                    text = stringResource(id = hero.nameRes),
                    style = MaterialTheme.typography.displaySmall,
                    onTextLayout = {}
                )
                Text(
                    text = stringResource(id = hero.description),
                    style = MaterialTheme.typography.bodyLarge,
                    onTextLayout = {}
                )
            }
            Image(
                painter = painterResource(id = hero.imageRes),
                contentDescription = "heroes image",
                modifier = Modifier
                    .clip(MaterialTheme.shapes.small)
                    .padding(start = dimensionResource(id = R.dimen.medium_padding)),
            )
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarHero(){
    CenterAlignedTopAppBar(title = {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.app_tittle),
                style = MaterialTheme.typography.headlineLarge,
                onTextLayout = {}
            )
        }
    })
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SuperheroesTheme(darkTheme = true) {
        HeroesList()
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    SuperheroesTheme(darkTheme = false) {
        HeroesList()
    }
}