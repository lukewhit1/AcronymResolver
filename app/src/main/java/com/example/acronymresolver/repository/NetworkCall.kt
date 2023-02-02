package com.example.acronymresolver.repository

import com.example.acronymresolver.model.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

//http://www.nactem.ac.uk/software/acromine/dictionary.py?lf=antibody
interface NetworkCall {
    @GET("dictionary.py")
    suspend fun getAcronym(
        @QueryMap
    parameter : Map<String, String>
    ): List<Response>
}