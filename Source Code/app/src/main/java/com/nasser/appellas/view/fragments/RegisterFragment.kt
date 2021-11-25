package com.nasser.appellas.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.nasser.appellas.R
import com.nasser.appellas.databinding.RegisterFragmentBinding
import com.nasser.appellas.viewmodels.AppViewModel

class RegisterFragment: Fragment() {

    private var mBinding: RegisterFragmentBinding? = null
    private val binding get() = mBinding!!

    private val appViewModel: AppViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = RegisterFragmentBinding.inflate(inflater, container, false)
            .apply {
                viewmodel = appViewModel
                lifecycleOwner = viewLifecycleOwner
            }

        binding.registerInputEditName.doAfterTextChanged { message ->
            appViewModel.registerNameInput.value = message.toString()
        }

        binding.registerInputEditEmail.doAfterTextChanged { message ->
            appViewModel.registerEmailInput.value = message.toString()
        }

        binding.registerInputEditPhone.doAfterTextChanged { message ->
            appViewModel.registerPhoneInput.value = message.toString()
        }

        binding.registerInputEditPassword.doAfterTextChanged { message ->
            appViewModel.registerPasswordInput.value = message.toString()
        }

        binding.registerInputEditConfirmPassword.doAfterTextChanged { message ->
            appViewModel.registerConfirmInput.value = message.toString()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpObservers()
    }

    private fun setUpObservers() {
        missingMessageObserver()
        succedMessageObserver()
        incorrectMessageObserver()
        goLoginObserver()
    }

    private fun incorrectMessageObserver() {
        appViewModel.showIncorrectRegister.observe(viewLifecycleOwner, Observer {
            it?.let {
                if(it) {
                    Toast.makeText(requireContext(), "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                }
                appViewModel.endShowIncorrectMessage()
            }
        })
    }

    private fun missingMessageObserver() {
        appViewModel.showMissingRegister.observe(viewLifecycleOwner, Observer {
            it?.let {
                if(it) {
                    Toast.makeText(requireContext(), "Faltan espacios por llenar", Toast.LENGTH_SHORT).show()
                }
                appViewModel.endShowMissingRegister()
            }
        })
    }

    private fun succedMessageObserver() {
        appViewModel.showSuccedRegister.observe(viewLifecycleOwner, Observer {
            it?.let {
                if(it) {
                    Toast.makeText(requireContext(), "Usuario registrado exitosamente!", Toast.LENGTH_SHORT).show()
                }
                appViewModel.endShowSuccedRegister()
            }
        })
    }

    private fun goLoginObserver() {
        appViewModel.goLogin.observe(viewLifecycleOwner, Observer {
            it?.let{
                if(it) {
                    activity?.supportFragmentManager?.beginTransaction()
                        ?.replace(android.R.id.content, LoginFragment.newInstance())
                        ?.commit()
                }
                appViewModel.endGoLoginFragment()
            }
        })
    }

    companion object {
        fun newInstance() = RegisterFragment()
    }

}