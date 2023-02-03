package com.example.composearticle

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composearticle.ui.theme.ComposearticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposearticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    ComposeArticleApp()
                }
            }
        }
    }
}

@Composable
fun ComposeArticleApp(){
	ArticleCard(
		title = stringResource(R.string.title_jeptack_compose_course),
		shortDescription = stringResource(R.string.compose_description),
		longDescription = stringResource(R.string.compose_long_description),
		imagePainter = painterResource(R.drawable.ic_launcher_background),
	)
}

@Composable
private fun ArticleCard(
	title: String,
	shortDescription: String,
	longDescription: String,
	imagePainter: Painter,
	modifier: Modifier = Modifier
) {
	Column(modifier = modifier){
		Image(painter = imagePainter, contentDescription = null)
		Text(
			text = shortDescription,
			textAlign = TextAlign.Justify,
			modifier = Modifier.padding(start = 16.dp, end= 16.dp)
		)
		Text(
			text = longDescription,
			textAlign = TextAlign.Justify,
			modifier = Modifier.padding(16.dp)
		)
	}
}

@Preview(showBackground = true)
@Composable
fun ComposeArticleAppPreview(){
	ComposearticleTheme{
		Surface {
			ComposeArticleApp()
		}
	}
}
