package com.example.razikgames_dndgame

import android.os.Bundle
import com.badlogic.gdx.backends.android.AndroidApplication
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration
//import com.google.android.gms.common.api.GoogleApiClient



class AndroidLauncher : AndroidApplication() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val config = AndroidApplicationConfiguration().apply {
            useAccelerometer = false
            useCompass = false
            useGyroscope = false
            useRotationVectorSensor = false
        }
        //activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        initialize(MyGame(), config)
    }

}

/*fun aaa(){
    val database = DatabaseManager.getInstance()?.openDatabase()
    database?.insert("Class", null, null)
    DatabaseManager.getInstance()?.closeDatabase()
}*/