package com.app.grammarapp.english

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.app.grammarapp.api.ApiService
import com.app.grammarapp.api.model.QueryParams
import com.app.grammarapp.MyViewModelFactory
import com.app.grammarapp.R
import com.app.grammarapp.api.Repository
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import kotlinx.android.synthetic.main.activity_english_improvization.*
import kotlinx.coroutines.launch

class EnglishImprovisationActivity : AppCompatActivity() {

    lateinit var apiService: ApiService
    private lateinit var englishImprovizationViewModel: EnglishImprovizationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_english_improvization)

        apiService = Repository.getClient()!!.create(ApiService::class.java)
        englishImprovizationViewModel = ViewModelProvider(this@EnglishImprovisationActivity,
            MyViewModelFactory(apiService)).get(EnglishImprovizationViewModel::class.java)

        backBtn.setOnClickListener {
            finish()
        }

        submitBtn.setOnClickListener {
            if(textOne.text.toString().equals("")) {
                Toast.makeText(applicationContext, "Please enter a valid text", Toast.LENGTH_LONG).show()
            } else {
                lifecycleScope.launch {
                    val queryParams = QueryParams()
                    queryParams.model = "text-davinci-003"
                    queryParams.prompt = "Correct this to standard English:\\n\\n ${textOne.text}"
                    queryParams.temperature = 0
                    queryParams.max_tokens = 60
                    queryParams.top_p = 1
                    queryParams.frequency_penalty = 0
                    queryParams.presence_penalty = 0
                    englishImprovizationViewModel.ImproEnglishAPI(queryParams)
                }
            }
        }

        englishImprovizationViewModel.response.observe(this@EnglishImprovisationActivity) {
            try {
                answerText.text = it.choices[0].text
            }catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(applicationContext, "Seems like you have given a invalid input", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(
            ViewPumpContextWrapper.wrap(newBase!!))
    }
}

