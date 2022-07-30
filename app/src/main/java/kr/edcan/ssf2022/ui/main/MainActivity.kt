package kr.edcan.ssf2022.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kr.edcan.ssf2022.R
import kr.edcan.ssf2022.model.data.User
import kr.edcan.ssf2022.model.remote.AuthRepositoryImpl
import kr.edcan.ssf2022.ui.login.LoginActivity

class MainActivity : AppCompatActivity() {
    val auth = AuthRepositoryImpl()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userData = intent.getParcelableExtra<User>("userData")
        findViewById<TextView>(R.id.txt1).text = userData.toString()

        findViewById<TextView>(R.id.logout).setOnClickListener{
            auth.auth_.signOut()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

            finish()
        }
    }
}