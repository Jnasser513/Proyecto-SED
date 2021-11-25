package com.nasser.appellas.data.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey var username: String,
    var phone: String,
    var email: String,
    var password: String,
    var confirmPassword: String,
    var type: Boolean
)

@Entity(tableName = "blog_table",foreignKeys = [ForeignKey(
        entity = User::class,
        parentColumns = arrayOf("username"),
        childColumns = arrayOf("user_name"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class Blog(
    @PrimaryKey(autoGenerate = true) var id: Int,
    var title: String,
    var subTitle: String,
    var description: String,
    var user_name: String
)


@Entity(tableName = "contacts_table",
    foreignKeys = [ForeignKey(
        entity = User::class,
        parentColumns = arrayOf("username"),
        childColumns = arrayOf("user_name")
    )])
data class TrustContacts(
    @PrimaryKey(autoGenerate = true) var id: Int,
    var name: String,
    var number: Int,
    var user_name: String
)