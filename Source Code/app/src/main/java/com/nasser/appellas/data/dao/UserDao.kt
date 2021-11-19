package com.nasser.appellas.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.nasser.appellas.data.entities.User

@Dao
interface UserDao {
    //Insertar o actualizar usuario
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateUser(user: User)

    //Obtener todos los usuarios
    @Query("SELECT * FROM user_table")
    fun findAllUsers(): LiveData<List<User>>

    //Obtener un usuario
    @Query("SELECT * FROM user_table WHERE username = :query")
    suspend fun searchUser(query: String): User

    //Eliminar usuario
    @Delete
    suspend fun deleteUser(user: User)
}