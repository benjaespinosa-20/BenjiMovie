package com.benjaminespi.benjimovie.ui.di

import com.benjaminespi.benjimovie.ui.data.remote.MovieDataSource
import com.benjaminespi.benjimovie.ui.data.remote.MovieDataSourceImpl
import com.benjaminespi.benjimovie.ui.repository.MovieRepository
import com.benjaminespi.benjimovie.ui.repository.MovieRepositoryImplement
import com.benjaminespi.benjimovie.ui.repository.WebService
import com.benjaminespi.benjimovie.ui.utils.AppConstants
import com.google.gson.GsonBuilder
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MovieModule {

    @Binds
    abstract fun bindMovieDataSource(movieDataSource: MovieDataSourceImpl): MovieDataSource

    @Binds
    abstract fun bindMovieRepository(movieRepository: MovieRepositoryImplement): MovieRepository

    companion object RetrofitModule {

        @Provides
        fun provideRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(AppConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
        }

        @Provides
        fun providesWebService(retrofit: Retrofit) = retrofit.create<WebService>()

    }
}