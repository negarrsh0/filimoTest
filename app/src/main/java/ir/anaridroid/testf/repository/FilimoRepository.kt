package ir.anaridroid.testf.repository

import io.reactivex.Observable
import ir.anaridroid.testf.data.model.Attributes
import ir.anaridroid.testf.data.model.Data
import ir.anaridroid.testf.data.remote.api.ApiInterface
import javax.inject.Inject

class FilimoRepository @Inject constructor(val apiInterface: ApiInterface) {



    fun getAllMovies() : Observable<List<Attributes>> = apiInterface.getAllMovies()


}