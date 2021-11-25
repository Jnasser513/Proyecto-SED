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
    val registerUserNameInput = MutableLiveData("")
    val registerPhoneInput = MutableLiveData("")
    val registerEmailInput = MutableLiveData("")
    val registerPasswordInput = MutableLiveData("")
    val registerConfirmInput = MutableLiveData("")

    //Variables utilizadas para el login
    val loginUserInput = MutableLiveData("")
    val loginPassWordInput = MutableLiveData("")

    //Variables para navegar entre fragmentos
    private val _goLogin = MutableLiveData<Boolean?>()
    val goLogin: LiveData<Boolean?> = _goLogin

    private val _goHomePage = MutableLiveData<Boolean?>()
    val goHomePage: LiveData<Boolean?> = _goHomePage

    private val _goAdminHomePage = MutableLiveData<Boolean?>()
    val goAdminHomePage: LiveData<Boolean?> = _goAdminHomePage

    private val _goRegister = MutableLiveData<Boolean?>()
    val goRegister: LiveData<Boolean?> = _goRegister

    private val _goRecoveryPassword = MutableLiveData<Boolean?>()
    val goRecoveryPassword: LiveData<Boolean?> = _goRecoveryPassword

    //Variables para mostrar mensajes
    private val _showMissingRegister = MutableLiveData<Boolean?>()
    val showMissingRegister: LiveData<Boolean?> = _showMissingRegister

    private val _showSuccedRegister = MutableLiveData<Boolean?>()
    val showSuccedRegister: LiveData<Boolean?> = _showSuccedRegister

    private val _showIncorrectRegister = MutableLiveData<Boolean?>()
    val showIncorrectRegister: LiveData<Boolean?> = _showIncorrectRegister

    private val _showMissingLogin = MutableLiveData<Boolean?>()
    val showMissingLogin: LiveData<Boolean?> = _showMissingLogin

    private val _showInitUserLogin = MutableLiveData<Boolean?>()
    val showInitUserLogin: LiveData<Boolean?> = _showInitUserLogin

    private val _showErrorLogin = MutableLiveData<Boolean?>()
    val showErrorLogin: LiveData<Boolean?> = _showErrorLogin

    private fun startShowErrorLogin() {
        _showErrorLogin.value = true
    }

    fun endShowErrorLogin() {
        _showErrorLogin.value = null
    }

    private fun startShowInitUserLogin() {
        _showInitUserLogin.value = true
    }

    fun endShowInitUserLogin() {
        _showInitUserLogin.value = null
    }

    private fun startShowMissingLogin() {
        _showMissingLogin.value = true
    }

    fun endShowMissingLogin() {
        _showMissingLogin.value = null
    }

    private fun startShowIncorrectRegister() {
        _showIncorrectRegister.value = true
    }

    fun endShowIncorrectMessage() {
        _showIncorrectRegister.value = null
    }

    private fun startShowMissingRegister() {
        _showMissingRegister.value = true
    }

    fun endShowMissingRegister() {
        _showMissingRegister.value = null
    }

    private fun startShowSuccedRegister() {
        _showSuccedRegister.value = true
    }

    fun endShowSuccedRegister() {
        _showSuccedRegister.value = null
    }

    //Funciones observables para navegar a los fragmentos
    fun goLoginFragment() {
        _goLogin.value = true
    }

    fun endGoLoginFragment() {
        _goLogin.value = null
    }

    private fun goHomePageFragment() {
        _goHomePage.value = true
    }

    fun endGoHomePageFragment() {
        _goHomePage.value = null
    }

    fun goRegisterFragment() {
        _goRegister.value = true
    }

    fun endGoRegisterFragment() {
        _goRegister.value = null
    }

    fun goRecoveryFragment() {
        _goRecoveryPassword.value = true
    }

    fun endGoRecoveryFragment() {
        _goRecoveryPassword.value = null
    }

    private fun goAdminHomePageFragment() {
        _goAdminHomePage.value = true
    }

    fun endGoAdminHomePageFragment() {
        _goAdminHomePage.value = null
    }

    fun registerUser() {
        viewModelScope.launch {
            try {
                if(registerUserNameInput.value.isNullOrEmpty() ||
                    registerPhoneInput.value.isNullOrEmpty() ||
                    registerEmailInput.value.isNullOrEmpty() ||
                    registerPasswordInput.value.isNullOrEmpty() ||
                    registerConfirmInput.value.isNullOrEmpty()) {
                    startShowMissingRegister()
                }
                else {
                    if(registerPasswordInput.value == registerConfirmInput.value) {
                        val newUser = User(registerUserNameInput.value!!, registerPhoneInput.value!!,
                                            registerEmailInput.value!!, registerPasswordInput.value!!,
                                            registerConfirmInput.value!!, true)
                        repository.insertOrUpdateUser(newUser)
                        registerUserNameInput.value = ""
                        registerPhoneInput.value = ""
                        registerEmailInput.value = ""
                        registerPasswordInput.value = ""
                        registerConfirmInput.value = ""
                        startShowSuccedRegister()
                        goLoginFragment()
                    }
                    else {
                        startShowIncorrectRegister()
                    }
                }
            }
            catch (e: Exception){}
        }
    }

    fun login() {
        viewModelScope.launch {
            try {
                if(loginUserInput.value.isNullOrEmpty() || loginPassWordInput.value.isNullOrEmpty()) {
                    startShowMissingLogin()
                }
                else {
                    val user = repository.searchUser(loginUserInput.value!!)
                    if(user.password == loginPassWordInput.value) {
                        if(!user.type) {
                            goHomePageFragment()
                            startShowInitUserLogin()
                        } else {
                            goAdminHomePageFragment()
                            startShowInitUserLogin()
                        }
                    }
                    else {
                        startShowErrorLogin()
                    }
                }
            } catch (e: Exception) {}
        }
    }
}