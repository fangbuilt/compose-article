package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArticleTheme {
                val title = stringResource(R.string.title)
                val contentA = stringResource(R.string.content_a)
                val contentB = stringResource(R.string.content_b)
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    WithHeader(
                        title, contentA, contentB,
                        modifier = Modifier.padding(innerPadding),
                    )
                }
            }
        }
    }
}

@Composable
fun Article(title: String, contentA: String, contentB: String, modifier: Modifier = Modifier) {
    Column(modifier = Modifier.padding(24.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text(
            text = title,
            modifier = modifier,
            fontSize = 24.sp,
            lineHeight = 24.sp
        )
        Text(
            text = contentA,
            modifier = modifier,
            textAlign = TextAlign.Justify,
            lineHeight = 24.sp
        )
        Text(
            text = contentB,
            modifier = modifier,
            textAlign = TextAlign.Justify,
            lineHeight = 24.sp
        )
    }
}

@Composable
fun WithHeader(title: String, contentA: String, contentB: String, modifier: Modifier = Modifier) {
    val composeBg = painterResource(R.drawable.bg_compose_background)
    Column {
        Image(
            painter = composeBg,
            contentDescription = "Header Background",
            modifier = Modifier.fillMaxWidth()
        )
        Article(title = title, contentA = contentA, contentB = contentB)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val title = stringResource(R.string.title)
    val contentA = stringResource(R.string.content_a)
    val contentB = stringResource(R.string.content_b)
    ComposeArticleTheme {
        WithHeader(
            title, contentA, contentB
        )
    }
}