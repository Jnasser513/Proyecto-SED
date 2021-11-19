package com.nasser.appellas.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.nasser.appellas.data.entities.TrustContacts

@Dao
interface ContactDao {
    //Insertar contact
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrReplaceContanct(contact: TrustContacts)

    //Encontrar todos los contactos
    @Query("SELECT * FROM contacts_table")
    fun findAllContacts(): LiveData<List<TrustContacts>>

    //Buscar un contacto
    @Query("SELECT * FROM contacts_table WHERE name = :query")
    suspend fun searchContact(query: String): TrustContacts

    //Borrar contacto
    @Delete
    suspend fun deleteContact(contact: TrustContacts)
}