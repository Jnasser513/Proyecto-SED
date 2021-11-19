package com.nasser.appellas.repository

import com.nasser.appellas.data.dao.BlogDao
import com.nasser.appellas.data.dao.ContactDao
import com.nasser.appellas.data.dao.UserDao
import com.nasser.appellas.data.entities.Blog
import com.nasser.appellas.data.entities.TrustContacts
import com.nasser.appellas.data.entities.User

class AppRepository(private val userDao: UserDao,
                    private val blogDao: BlogDao,
                    private val contactDao: ContactDao)
{
    //Funciones de usuario
    suspend fun insertOrUpdateUser(user: User) = userDao.insertOrUpdateUser(user)
    suspend fun deleteUser(user: User) = userDao.deleteUser(user)
    suspend fun searchUser(user: String) = userDao.searchUser(user)
    fun findAllUsers() = userDao.findAllUsers()

    //Funciones de blog
    suspend fun insertOrUpdateBlog(blog: Blog) = blogDao.insertOrUpdateBlog(blog)
    suspend fun deleteBlog(blog: Blog) = blogDao.deleteBlog(blog)
    suspend fun searchBlog(id: Int) = blogDao.searchBlog(id)
    fun findAllBlogs() = blogDao.findAllBlogs()

    //Funciones de contactos
    suspend fun insertOrReplaceContact(contact: TrustContacts) = contactDao.insertOrReplaceContanct(contact)
    suspend fun deleteContact(contact: TrustContacts) = contactDao.deleteContact(contact)
    suspend fun searchContact(contact: String) = contactDao.searchContact(contact)
    fun findAllContacts() = contactDao.findAllContacts()
}