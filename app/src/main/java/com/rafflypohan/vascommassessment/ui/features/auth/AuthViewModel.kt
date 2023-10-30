package com.rafflypohan.vascommassessment.ui.features.auth

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rafflypohan.vascommassessment.core.data.source.remote.request.LoginRequest
import com.rafflypohan.vascommassessment.core.domain.usecase.LoginUseCase
import com.rafflypohan.vascommassessment.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(AuthState())
    val state: StateFlow<AuthState> = _state.asStateFlow()

    fun login(loginRequest: LoginRequest){
        _state.update {
            it.copy(isLoading = true)
        }
        loginUseCase(loginRequest).onEach { data ->
            when(data){
                is Resource.Success -> {
                    _state.update {
                        it.copy(token = data.data!!.token!!, isLoading = false)
                    }
                }
                is Resource.Loading -> {
                    _state.update {
                        it.copy(isLoading = true)
                    }
                }
                is Resource.Error -> {
                    _state.update {
                        it.copy(isLoading = false, errorMessage = data.message)
                    }
                }
            }
        }.launchIn(viewModelScope)
        Log.d("Auth VM", state.value.toString())
    }
}

data class AuthState(
    val email: String = "",
    val password: String = "",
    val token: String? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)