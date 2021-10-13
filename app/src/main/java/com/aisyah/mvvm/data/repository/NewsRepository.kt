package com.aisyah.mvvm.data.repository

import com.aisyah.mvvm.data.model.ResponseNews
import com.aisyah.mvvm.data.source.APIService
import com.aisyah.mvvm.utils.Constant
import com.aisyah.mvvm.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

//menggunakan di utk menginject api kedalam news respository
class NewsRepository @Inject constructor(private val apiService: APIService){
    //flow = ansycronous programming exclusif buat kotlin (corotine)
    suspend fun fetchDataNews(): Flow<Resource<ResponseNews>>{  //flow coroutines
        return flow {
            val response = apiService.fetchNews(
                Constant.COUNTRY,
                Constant.CATEGORY,
                Constant.API_KEY
            )
            //bisnis logic
            try {
                //jika sukses dikirim state sukses
                if (response.articles.isNotEmpty()){
                    emit(Resource.Success(response))
                }else {
                    //kalau empty kirim state empty
                    emit(Resource.Empty)
                }
            }catch (e: HttpException){
                //kalao gagal kirim state error
                emit(Resource.Error(e.toString(), response))
            }
        }
    }
}