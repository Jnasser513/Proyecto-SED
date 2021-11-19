package com.nasser.appellas.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nasser.appellas.data.entities.User
import com.nasser.appellas.repository.AppRepository
import kotlinx.coroutines.launch

class AppViewModel(private val repository: AppRepository): ViewModel() {

    //Variables utilizadas para el registro de usuarios
    val registerNameInput = MutableLiveData("")
    val registerPhoneInput = MutableLiveData("")
    val registerEmailInput = MutableLiveData("")
    val registerPasswordInput = MutableLiveData("")
    val registerConfirmInput = MutableLiveData("")

    //Variables utilizadas para el login
    val loginEmailInput = MutableLiveData("")
    val loginPassWordInput = MutableLiveData("")

    fun registerUser() {
        viewModelScope.launch {
            try {
                if(registerNameInput.value.isNullOrEmpty() ||
                    registerPhoneInput.value.isNullOrEmpty() ||
                    registerEmailInput.value.isNullOrEmpty() ||
                    registerPasswordInput.value.isNullOrEmpty() ||
                    registerConfirmInput.value.isNullOrEmpty()) {
                    TODO("Mensaje de que falta por llenar espacios")
                }
                else {
                    if(registerPasswordInput.value == registerConfirmInput.value) {
                        val newUser = User(registerNameInput.value!!, registerPhoneInput.value!!,
                                            registerEmailInput.value!!, registerPasswordInput.value!!,
                                            registerConfirmInput.value!!, false)
                        repository.insertOrUpdateUser(newUser)
                        registerNameInput.value = ""
                        registerPhoneInput.value = ""
                        registerEmailInput.value = ""
                        registerPasswordInput.value = ""
                        registerConfirmInput.value = ""
                        TODO("Mostrar mensaje de que el usuario se registro exitosamente" +
                                "Ir al Login")
                    }
                    else {
                        TODO("Mensaje de que la contraseña no coincide")
                    }
                }
            }
            catch (e: Exception){}
        }
    }

    fun login() {
        viewModelScope.launch {
            if(loginEmailInput.value.isNullOrEmpty() || loginPassWordInput.value.isNullOrEmpty()) {
                TODO("Mensaje de que falta rellenar campos")
            }
            else {
                val user = repository.searchUser(loginEmailInput.value!!)
                if(user.password == loginPassWordInput.value) {
                    if(user.type) {
                        TODO("Ir a pagina de inicio de admin")
                    }
                    else {
                        TODO("Ir a pagina de inicio de usuario")
                    }
                }
                else {
                    TODO("Mensaje de la email o contraseña incorrecta")
                }
            }
        }
    }
}