package com.nasser.appellas

import android.app.Application
import com.nasser.appellas.data.AppDataBase
import com.nasser.appellas.repository.AppRepository

class AppApplication: Application() {
    private val database by lazy {
        AppDataBase.getDatabase(this)
    }

    val appRepository by lazy {
        val userDao = database.userDao()
        val blogDao = database.blogDao()
        val contactDao = database.contactDao()
        AppRepository(userDao, blogDao, contactDao)
    }
}