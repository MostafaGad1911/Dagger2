package mostafa.projects.dagger2.ui.activities

import android.content.SharedPreferences
import android.util.Log
import mostafa.projects.dagger2.R
import mostafa.projects.dagger2.helper.Constants.TEST_VALUE_NAME
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun init() {
       dagComponent().inject(this)

        sharedPreferences.edit()?.putString(TEST_VALUE_NAME, "mostafa elsayed gad")?.apply()

        val name = sharedPreferences.getString(TEST_VALUE_NAME , "")
        Log.i(TEST_VALUE_NAME , "$name")
    }

    override fun initViews() {

    }

    override fun getRes(): Int = R.layout.activity_main

}