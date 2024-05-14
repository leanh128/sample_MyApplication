package com.anle.myapplication

import android.app.Application
import android.util.Log
import androidx.core.content.ContextCompat
import com.instabug.bug.BugReporting
import com.instabug.bug.invocation.Option
import com.instabug.library.Instabug
import com.instabug.library.InstabugCustomTextPlaceHolder
import com.instabug.library.invocation.InstabugInvocationEvent
import com.instabug.library.ui.onboarding.WelcomeMessage

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        setupInstabug()
    }

    private fun setupInstabug() {
        Instabug.Builder(this, "INSTABUG-API-KEY").setInvocationEvents(
            InstabugInvocationEvent.NONE
        ).build()
        Instabug.setPrimaryColor(ContextCompat.getColor(applicationContext, com.instabug.library.apmokhttplogger.R.color.instabug_annotation_color_green))
        Instabug.setWelcomeMessageState(WelcomeMessage.State.DISABLED)
        BugReporting.setScreenshotByMediaProjectionEnabled(true)
        BugReporting.setOptions(Option.EMAIL_FIELD_OPTIONAL)

        Log.d("leon", "Registering invocation callback")
        BugReporting.setOnInvokeCallback {
            Log.d("leon", "Screenshot detected")
            handleInstabugInvocation(isShowInstabug = false)
        }

        InstabugCustomTextPlaceHolder().apply {
            setPlaceHoldersMap(
                hashMapOf(
                    InstabugCustomTextPlaceHolder.Key.INVOCATION_HEADER to getString(R.string.instabug_header),
                    InstabugCustomTextPlaceHolder.Key.REPORT_BUG to getString(R.string.instabug_report_bug),
                    InstabugCustomTextPlaceHolder.Key.REPORT_BUG_DESCRIPTION to getString(R.string.instabug_bug_desc),
                    InstabugCustomTextPlaceHolder.Key.REPORT_FEEDBACK to getString(R.string.instabug_feedback),
                    InstabugCustomTextPlaceHolder.Key.REPORT_FEEDBACK_DESCRIPTION to getString(R.string.instabug_feedback_desc),
                    InstabugCustomTextPlaceHolder.Key.REPORT_QUESTION to getString(R.string.instabug_question),
                    InstabugCustomTextPlaceHolder.Key.REPORT_QUESTION_DESCRIPTION to getString(R.string.instabug_question_desc),
                    InstabugCustomTextPlaceHolder.Key.COMMENT_FIELD_HINT_FOR_BUG_REPORT to getString(
                        R.string.instabug_comment
                    ),
                    InstabugCustomTextPlaceHolder.Key.COMMENT_FIELD_HINT_FOR_FEEDBACK to getString(R.string.instabug_comment),
                    InstabugCustomTextPlaceHolder.Key.COMMENT_FIELD_HINT_FOR_QUESTION to getString(R.string.instabug_comment),
                )
            )
        }.let {
            Instabug.setCustomTextPlaceHolders(it)
        }
    }

    fun handleInstabugInvocation(isShowInstabug: Boolean = true) {
        Log.d("testing-instabug", "Instabug boolean: $isShowInstabug")
        Log.d(
            "testing-instabug",
            "The user group is: haha"
        )
        Instabug.setUserAttribute("user_group", "leon-test")

    }

}