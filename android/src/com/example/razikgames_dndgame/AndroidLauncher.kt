package com.example.razikgames_dndgame


import android.os.Bundle
import android.widget.ArrayAdapter
import com.badlogic.gdx.backends.android.AndroidApplication
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration



//import com.google.android.gms.common.api.GoogleApiClient



class AndroidLauncher : AndroidApplication() {
    //val db = DataBaseHelper(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val config = AndroidApplicationConfiguration().apply {
            useAccelerometer = false
            useCompass = false
            useGyroscope = false
            useRotationVectorSensor = false
        }

        //activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        initialize(MyGame(test), config)
        /*val helper = DataBaseHelper(this)
        try {
            helper.createDataBase()
        } catch (ioe: IOException) {
            throw Error("Не возможно инициализировать базу данных")
        }
        try {
            helper.openDataBase()
        } catch (sqle: SQLException) {
            throw sqle
        }*/
        /*val repository = DbRepository(this.applicationContext)
        //val adapter = ArrayAdapter(this, R.layout.simple_list_item_1, repository.data)
        //adapter.setDropDownViewResource(R.layout.simple_list_item_1)
        //dataList.setAdapter(adapter)
        aaa= repository.data*/

    }

    companion object {
        //var aaa: ArrayList<String>? = null
        val test = TestAndroid()
    }


}


class TestData {
    var a = "Name"
    fun submitVar (): String {
        return a
    }
}


class TestAndroid : ITest {
    private val data: TestData
    init {
        data = TestData()
    }
    override fun submitVar () {
        data.submitVar()
    }
}