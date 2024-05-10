package com.example.nunettine.data.remote.service.library_study

import android.util.Log
import com.example.nunettine.data.local.QuizReq
import com.example.nunettine.data.remote.dto.library.QuizListRes
import com.example.nunettine.data.remote.dto.library.QuizRes
import com.example.nunettine.data.remote.dto.study.QuizGradeRes
import com.example.nunettine.data.remote.dto.study.QuizSolveRes
import com.example.nunettine.data.remote.dto.study.StudyCategoryRes
import com.example.nunettine.data.remote.dto.study.StudyDetailRes
import com.example.nunettine.data.remote.dto.study.StudyListRes
import com.example.nunettine.data.remote.retrofit.LibraryRetrofitInterface
import com.example.nunettine.data.remote.retrofit.StudyRetrofitInterface
import com.example.nunettine.data.remote.view.library.QuizListView
import com.example.nunettine.data.remote.view.library.QuizView
import com.example.nunettine.data.remote.view.study.QuizGradeView
import com.example.nunettine.data.remote.view.study.QuizSolveView
import com.example.nunettine.data.remote.view.study.StudyCategoryView
import com.example.nunettine.data.remote.view.study.StudyDetailView
import com.example.nunettine.data.remote.view.study.StudyListView
import com.example.nunettine.utils.getRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuizService {
    private lateinit var quizView: QuizView
    private lateinit var quizSolveView:QuizSolveView
    private lateinit var quizListView: QuizListView
    private lateinit var quizGradeView: QuizGradeView

    private lateinit var studyListView: StudyListView
    private lateinit var studyDetailView: StudyDetailView
    private lateinit var studyCategoryView: StudyCategoryView

    fun setQuizView(quizView: QuizView) {
        this.quizView = quizView
    }

    fun setQuizSolveView(quizSolveView: QuizSolveView) {
        this.quizSolveView = quizSolveView
    }

    fun setQuizListView(quizListView: QuizListView) {
        this.quizListView = quizListView
    }

    fun setQuizGradeView(quizGradeView: QuizGradeView) {
        this.quizGradeView = quizGradeView
    }

    fun getStudyDetailView(studyDetailView: StudyDetailView) {
        this.studyDetailView = studyDetailView
    }

    fun getStudyListView(studyListView: StudyListView) {
        this.studyListView = studyListView
    }

    fun getStudyCategoryView(studyCategoryView: StudyCategoryView) {
        this.studyCategoryView = studyCategoryView
    }

    fun setPrevQuizSolve(category: String, textId: Int, quizType: String) {
        val quizPrevService = getRetrofit().create(StudyRetrofitInterface::class.java)
        quizPrevService.postPrevTextQuiz(category, textId, quizType).enqueue(object : Callback<QuizSolveRes> {
            override fun onResponse(call: Call<QuizSolveRes>, response: Response<QuizSolveRes>) {
                if (response.isSuccessful) {
                    val resp: QuizSolveRes? = response.body()
                    if (resp != null) {
                        quizSolveView.onGetQuizSolveSuccess(resp)
                    } else {
                        Log.e("PREV-QUIZ-SOLVE-SUCCESS", "Response body is null")
                        quizSolveView.onGetQuizSolveFailure(response.code())
                    }
                } else {
                    Log.e("PREV-QUIZ-SOLVE-SUCCESS", "Response not successful: ${response.code()}")
                    quizSolveView.onGetQuizSolveFailure(response.code())
                }
            }

            override fun onFailure(call: Call<QuizSolveRes>, t: Throwable) {
                Log.d("PREV-QUIZ-SOLVE-FAILURE", t.toString())
            }
        })
    }

    fun setMyQuizSolve(category: String, textId: Int, quizType: String) {
        val quizMyService = getRetrofit().create(StudyRetrofitInterface::class.java)
        quizMyService.postMyTextQuiz(category, textId, quizType).enqueue(object : Callback<QuizSolveRes> {
            override fun onResponse(call: Call<QuizSolveRes>, response: Response<QuizSolveRes>) {
                if (response.isSuccessful) {
                    val resp: QuizSolveRes? = response.body()
                    if (resp != null) {
                        quizSolveView.onGetQuizSolveSuccess(resp)
                    } else {
                        Log.e("MY-QUIZ-SOLVE-SUCCESS", "Response body is null")
                        quizSolveView.onGetQuizSolveFailure(response.code())
                    }
                } else {
                    Log.e("MY-QUIZ-SOLVE-SUCCESS", "Response not successful: ${response.code()}")
                    quizSolveView.onGetQuizSolveFailure(response.code())
                }
            }

            override fun onFailure(call: Call<QuizSolveRes>, t: Throwable) {
                Log.d("MY-QUIZ-SOLVE-FAILURE", t.toString())
            }
        })
    }

    fun getPrevText(category: String, textId: Int) {
        val quizPrevService = getRetrofit().create(StudyRetrofitInterface::class.java)
        quizPrevService.getPrevText(category, textId).enqueue(object : Callback<StudyDetailRes> {
            override fun onResponse(call: Call<StudyDetailRes>, response: Response<StudyDetailRes>) {
                if (response.isSuccessful) {
                    val resp: StudyDetailRes? = response.body()
                    if (resp != null) {
                        studyDetailView.onGetStudyDetailSuccess(resp)
                    } else {
                        Log.e("PREV-TEXT-GET-SUCCESS", "Response body is null")
                        studyDetailView.onGetStudyDetailFailure(response.code())
                    }
                } else {
                    Log.e("PREV-TEXT-GET-SUCCESS", "Response not successful: ${response.code()}")
                    studyDetailView.onGetStudyDetailFailure(response.code())
                }
            }

            override fun onFailure(call: Call<StudyDetailRes>, t: Throwable) {
                Log.d("PREV-TEXT-GET-FAILURE", t.toString())
            }
        })
    }

    fun getMyText(category: String, textId: Int) {
        val quizMyService = getRetrofit().create(StudyRetrofitInterface::class.java)
        quizMyService.getMyText(category, textId).enqueue(object : Callback<StudyDetailRes> {
            override fun onResponse(call: Call<StudyDetailRes>, response: Response<StudyDetailRes>) {
                if (response.isSuccessful) {
                    val resp: StudyDetailRes? = response.body()
                    if (resp != null) {
                        studyDetailView.onGetStudyDetailSuccess(resp)
                    } else {
                        Log.e("MY-TEXT-GET-SUCCESS", "Response body is null")
                        studyDetailView.onGetStudyDetailFailure(response.code())
                    }
                } else {
                    Log.e("MY-TEXT-GET-SUCCESS", "Response not successful: ${response.code()}")
                    studyDetailView.onGetStudyDetailFailure(response.code())
                }
            }

            override fun onFailure(call: Call<StudyDetailRes>, t: Throwable) {
                Log.d("MY-TEXT-GET-FAILURE", t.toString())
            }
        })
    }

    fun getPrevTextCategory() {
        val prevTextCategoryService = getRetrofit().create(StudyRetrofitInterface::class.java)
        prevTextCategoryService.getPrevTextType().enqueue(object : Callback<StudyCategoryRes> {
            override fun onResponse(call: Call<StudyCategoryRes>, response: Response<StudyCategoryRes>) {
                if (response.isSuccessful) {
                    val resp: StudyCategoryRes? = response.body()
                    if (resp != null) {
                        studyCategoryView.onGetStudyCategorySuccess(resp)
                    } else {
                        Log.e("TEXT-TYPE-GET-SUCCESS", "Response body is null")
                        studyCategoryView.onGetStudyCategoryFailure(response.code())
                    }
                } else {
                    Log.e("TEXT-TYPE-GET-SUCCESS", "Response not successful: ${response.code()}")
                    studyCategoryView.onGetStudyCategoryFailure(response.code())
                }
            }

            override fun onFailure(call: Call<StudyCategoryRes>, t: Throwable) {
                Log.d("TEXT-TYPE-GET-FAILURE", t.toString())
            }
        })
    }

    fun getPrevTextList(category: String) {
        val textListService = getRetrofit().create(StudyRetrofitInterface::class.java)
        textListService.getPrevTextList(category).enqueue(object : Callback<StudyListRes> {
            override fun onResponse(call: Call<StudyListRes>, response: Response<StudyListRes>) {
                if (response.isSuccessful) {
                    val resp: StudyListRes? = response.body()
                    if (resp != null) {
                        studyListView.onGetStudyListSuccess(resp)
                    } else {
                        Log.e("TEXT-LIST-GET-SUCCESS", "Response body is null")
                        studyListView.onGetStudyListFailure(response.code())
                    }
                } else {
                    Log.e("TEXT-LIST-GET-SUCCESS", "Response not successful: ${response.code()}")
                    studyListView.onGetStudyListFailure(response.code())
                }
            }

            override fun onFailure(call: Call<StudyListRes>, t: Throwable) {
                Log.d("TEXT-LIST-GET-FAILURE", t.toString())
            }
        })
    }

    fun getQuizList() {
        val quizListService = getRetrofit().create(LibraryRetrofitInterface::class.java)
        quizListService.getQuizList().enqueue(object : Callback<QuizListRes> {
            override fun onResponse(call: Call<QuizListRes>, response: Response<QuizListRes>) {
                if (response.isSuccessful) {
                    val resp: QuizListRes? = response.body()
                    if (resp != null) {
                        quizListView.onGetQuizListSuccess(resp)
                    } else {
                        Log.e("QUIZ-LIST-GET-SUCCESS", "Response body is null")
                        quizListView.onGetQuizListFailure(response.code())
                    }
                } else {
                    Log.e("QUIZ-LIST-GET-SUCCESS", "Response not successful: ${response.code()}")
                    quizListView.onGetQuizListFailure(response.code())
                }
            }

            override fun onFailure(call: Call<QuizListRes>, t: Throwable) {
                Log.d("QUIZ-LIST-GET-FAILURE", t.toString())
            }
        })
    }

    fun getQuiz(quizId: Int) {
        val quizService = getRetrofit().create(LibraryRetrofitInterface::class.java)
        quizService.getQuiz(quizId).enqueue(object : Callback<QuizRes> {
            override fun onResponse(call: Call<QuizRes>, response: Response<QuizRes>) {
                if (response.isSuccessful) {
                    val resp: QuizRes? = response.body()
                    if (resp != null) {
                        quizView.onGetQuizSuccess(resp)
                    } else {
                        Log.e("QUIZ-GET-SUCCESS", "Response body is null")
                        quizView.onGetQuizFailure(response.code())
                    }
                } else {
                    Log.e("QUIZ-GET-SUCCESS", "Response not successful: ${response.code()}")
                    quizView.onGetQuizFailure(response.code())
                }
            }

            override fun onFailure(call: Call<QuizRes>, t: Throwable) {
                Log.d("QUIZ-GET-FAILURE", t.toString())
            }
        })
    }

    fun setGradePrevQuiz(category: String, textId: Int, quizReq: QuizReq) {
        val quizPrevGradeService = getRetrofit().create(StudyRetrofitInterface::class.java)
        quizPrevGradeService.postPrevTextCheckQuiz(category, textId, quizReq).enqueue(object : Callback<QuizGradeRes> {
            override fun onResponse(call: Call<QuizGradeRes>, response: Response<QuizGradeRes>) {
                if (response.isSuccessful) {
                    val resp: QuizGradeRes? = response.body()
                    if (resp != null) {
                        quizGradeView.onGetQuizGradeSuccess(resp)
                    } else {
                        Log.e("PREV-QUIZ-GRADE-SUCCESS", "Response body is null")
                        quizGradeView.onGetQuizGradeFailure(response.code())
                    }
                } else {
                    Log.e("PREV-QUIZ-GRADE-SUCCESS", "Response not successful: ${response.code()}")
                    quizGradeView.onGetQuizGradeFailure(response.code())
                }
            }

            override fun onFailure(call: Call<QuizGradeRes>, t: Throwable) {
                Log.d("PREV-QUIZ-GRADE-FAILURE", t.toString())
            }
        })
    }

    fun setGradeMyQuiz(category: String, textId: Int, quizReq: QuizReq) {
        val quizPrevGradeService = getRetrofit().create(StudyRetrofitInterface::class.java)
        quizPrevGradeService.postPrevTextCheckQuiz(category, textId, quizReq).enqueue(object : Callback<QuizGradeRes> {
            override fun onResponse(call: Call<QuizGradeRes>, response: Response<QuizGradeRes>) {
                if (response.isSuccessful) {
                    val resp: QuizGradeRes? = response.body()
                    if (resp != null) {
                        quizGradeView.onGetQuizGradeSuccess(resp)
                    } else {
                        Log.e("MY-QUIZ-GRADE-SUCCESS", "Response body is null")
                        quizGradeView.onGetQuizGradeFailure(response.code())
                    }
                } else {
                    Log.e("MY-QUIZ-GRADE-SUCCESS", "Response not successful: ${response.code()}")
                    quizGradeView.onGetQuizGradeFailure(response.code())
                }
            }

            override fun onFailure(call: Call<QuizGradeRes>, t: Throwable) {
                Log.d("MY-QUIZ-GRADE-FAILURE", t.toString())
            }
        })
    }
}