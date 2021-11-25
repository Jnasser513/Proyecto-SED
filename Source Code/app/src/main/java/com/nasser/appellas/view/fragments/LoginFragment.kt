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
import com.nasser.appellas.databinding.LoginFragmentBinding
import com.nasser.appellas.viewmodels.AppViewModel

class LoginFragment: Fragment() {

    private var mBinding: LoginFragmentBinding? = null
    private val binding get() = mBinding!!

    private val appViewModel: AppViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = LoginFragmentBinding.inflate(inflater, container, false)
            .apply {
                viewmodel = appViewModel
                lifecycleOwner = viewLifecycleOwner
            }

        binding.loginInputEditEmail.doAfterTextChanged { message ->
            appViewModel.loginUserInput.value = message.toString()
        }

        binding.loginInputEditPassword.doAfterTextChanged { message ->
            appViewModel.loginPassWordInput.value = message.toString()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpObservers()
    }

    private fun setUpObservers() {
        showMissingObserver()
        showErrorObserver()
        showLoggedUserObserver()
        goHomePageFragment()
        goRegisterFragment()
        goRecoveryPassword()
        goAdminHomePageFragmnet()
    }

    private fun showLoggedUserObserver() {
        appViewModel.showInitUserLogin.observe(viewLifecycleOwner, Observer {
            it?.let {
                if(it) {
                    Toast.makeText(requireContext(), "Bienvenido!", Toast.LENGTH_SHORT).show()
                }
                appViewModel.endShowInitUserLogin()
            }
        })
    }

    private fun showErrorObserver() {
        appViewModel.showErrorLogin.observe(viewLifecycleOwner, Observer {
            it?.let {
                if(it) {
                    Toast.makeText(requireContext(), "Email o contraseña incorrecto", Toast.LENGTH_SHORT).show()
                }
                appViewModel.endShowErrorLogin()
            }
        })
    }

    private fun showMissingObserver() {
        appViewModel.showMissingLogin.observe(viewLifecycleOwner, Observer {
            it?.let {
                if(it) {
                    Toast.makeText(requireContext(), "Faltan espacios por llenar", Toast.LENGTH_SHORT).show()
                }
                appViewModel.endShowMissingLogin()
            }
        })
    }

    private fun goRegisterFragment() {
        appViewModel.goRegister.observe(viewLifecycleOwner, Observer {
            it?.let {
                if(it) {
                    activity?.supportFragmentManager?.beginTransaction()
                        ?.replace(android.R.id.content, RegisterFragment.newInstance())
                        ?.addToBackStack(null)
                        ?.commit()
                }
                appViewModel.endGoRegisterFragment()
            }
        })
    }

    private fun goRecoveryPassword() {
        appViewModel.goRecoveryPassword.observe(viewLifecycleOwner, Observer {
            it?.let {
                if(it) {
                    activity?.supportFragmentManager?.beginTransaction()
                        ?.replace(android.R.id.content, ChangePasswordFragment.newInstance())
                        ?.addToBackStack(null)
                        ?.commit()
                }
                appViewModel.endGoRecoveryFragment()
            }
        })
    }

    private fun goHomePageFragment() {
        appViewModel.goHomePage.observe(viewLifecycleOwner, Observer {
          it?.let {
              if(it) {
                  activity?.supportFragmentManager?.beginTransaction()
                      ?.replace(android.R.id.content, HomePageFragment.newInstance())
                      ?.addToBackStack(null)
                      ?.commit()
              }
              appViewModel.endGoHomePageFragment()
          }
        })
    }

    private fun goAdminHomePageFragmnet() {
        appViewModel.goAdminHomePage.observe(viewLifecycleOwner, Observer {
            it?.let {
                if(it) {
                    activity?.supportFragmentManager?.beginTransaction()
                        ?.replace(android.R.id.content, AdminHomePageFragment.newInstance())
                        ?.addToBackStack(null)
                        ?.commit()
                }
                appViewModel.endGoAdminHomePageFragment()
            }
        })
    }

    companion object {
        fun newInstance() = LoginFragment()
    }

}