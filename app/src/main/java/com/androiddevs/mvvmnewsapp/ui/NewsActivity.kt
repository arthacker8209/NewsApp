package com.androiddevs.mvvmnewsapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.androiddevs.mvvmnewsapp.R
import com.androiddevs.mvvmnewsapp.databinding.ActivityNewsBinding
import com.androiddevs.mvvmnewsapp.db.ArticleDatabase
import com.androiddevs.mvvmnewsapp.repository.NewsRepository
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity() {

    lateinit var viewModel: NewsViewModel
    private lateinit var binding: ActivityNewsBinding

    private var isDarkMode = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme)
        setContentView(R.layout.activity_news)

        /*   binding.image.setOnClickListener{
            setupUi()
        }
        settingsManager= SettingsManager(this)
        observeUiContext()


      */

        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(application, newsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(NewsViewModel::class.java)
        bottomNavigationView.setupWithNavController(newsNavHostFragment.findNavController())

    }




    /* private fun setupUi() {
        lifecycleScope.launch {
            when(isDarkMode){
                true->settingsManager.setUiMode(UiMode.LIGHT)
                false-> settingsManager.setUiMode(UiMode.DARK)
            }
        }
    }

    private fun observeUiContext() {
        settingsManager.uiModeFlow.asLiveData().observe(this){
                uiMode ->
            uiMode?.let {
                when(uiMode){
                    UiMode.LIGHT -> onLightMode()
                    UiMode.DARK -> onDarkMode()
                }
            }
        }
    }

    */

    /* private fun onDarkMode() {
        isDarkMode=true
        binding.image.setImageResource(R.drawable.ic_bright)
        binding.image.setBackgroundColor(Color.GRAY)
        setTheme(R.style.DarkTheme)


    }

    private fun onLightMode() {
       isDarkMode=false
        setTheme(R.style.AppTheme)
        binding.image.setImageResource(R.drawable.ic_dark)

    }

    private fun restartActivity() {
        val i = intent
        overridePendingTransition(0, 0)
        i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        finish()
        //restart the activity without animation
        overridePendingTransition(0, 0)
        this.startActivity(i)
    }

    */

}
