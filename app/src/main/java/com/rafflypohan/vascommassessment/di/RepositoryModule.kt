package com.rafflypohan.vascommassessment.di

import com.rafflypohan.vascommassessment.core.data.repository.DataRepositoryImpl
import com.rafflypohan.vascommassessment.core.data.repository.LoginRepositoryImpl
import com.rafflypohan.vascommassessment.core.domain.repository.DataRepository
import com.rafflypohan.vascommassessment.core.domain.repository.LoginRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindLoginRepository(
        loginRepositoryImpl: LoginRepositoryImpl
    ): LoginRepository

    @Binds
    @Singleton
    abstract fun bindDataRepository(
        dataRepositoryImpl: DataRepositoryImpl
    ): DataRepository
}