package fr.eni.shop_info

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import fr.eni.shop_info.repository.ArticleRepository
import fr.eni.shop_info.ui.screen.ArticleDetailScreen
import fr.eni.shop_info.ui.theme.Shop_InfoTheme

class MainActivity : ComponentActivity() {


    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG,"Démarrage onCreate")
        enableEdgeToEdge()
        setContent {
            Shop_InfoTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                )
                {
                    val article = ArticleRepository().getArticle(1)
                    if (article != null) {
                        ArticleDetailScreen(article = article)
                    }
                }
                }
            }
        }
    }
