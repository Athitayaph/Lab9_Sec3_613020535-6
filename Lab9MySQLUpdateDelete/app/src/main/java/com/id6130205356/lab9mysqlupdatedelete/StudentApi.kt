package com.id6130205356.lab9mysqlupdatedelete

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


interface StudentApi {
    @GET("allstd")
    fun retrieveStudent(): Call<List<Student>>

    @GET("std/{std_id}")
    fun retrieveStudentID(
        @Path("std_id") std_id: String
    ): Call<Student>

    @FormUrlEncoded
    @PUT("std/{std_id}")
    fun updateStudent(
        @Path("std_id") std_id: String,
        @Field("std_name") std_name: String,
        @Field("std_age") std_age: Int
    ): Call<Student>

    @DELETE("std/{std_id}")
    fun deleteStudent(
        @Path("std_id") std_id: String
    ): Call<Student>

    companion object {
        fun create(): StudentApi{
            val stdClient: StudentApi = Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(StudentApi::class.java)
            return stdClient
        }
    }
}