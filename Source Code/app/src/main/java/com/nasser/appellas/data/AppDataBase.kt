package com.nasser.appellas.data

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.nasser.appellas.data.dao.BlogDao
import com.nasser.appellas.data.dao.ContactDao
import com.nasser.appellas.data.dao.UserDao
import com.nasser.appellas.data.entities.Blog
import com.nasser.appellas.data.entities.TrustContacts
import com.nasser.appellas.data.entities.User

@Database(version = 1, entities = [User::class, Blog::class, TrustContacts::class])
abstract class AppDataBase: RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun blogDao(): BlogDao
    abstract fun contactDao(): ContactDao

    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDatabase(context: Context) = INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context,
                AppDataBase::class.java,
                "appellas_db"
            ).build()

            INSTANCE = instance
            instance
        }
    }
}