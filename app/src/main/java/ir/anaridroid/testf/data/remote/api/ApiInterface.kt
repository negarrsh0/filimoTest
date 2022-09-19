package ir.anaridroid.testf.data.remote.api

import io.reactivex.Observable
import ir.anaridroid.testf.data.model.Attributes
import ir.anaridroid.testf.data.model.Data
import retrofit2.http.GET

interface ApiInterface {

    @GET("api/en/v1/movie/movie/list/tagid/1000300/text/%7BQuery%7D/sug/on")
    fun getAllMovies(): Observable<List<Attributes>>
}