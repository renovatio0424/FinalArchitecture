package com.charlezz.finalarchitecture.ui.remote

import android.os.Bundle
import com.charlezz.finalarchitecture.R
import com.charlezz.finalarchitecture.databinding.ActivityRemoteBinding
import com.charlezz.finalarchitecture.extension.replaceFragment
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class RemoteActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var binding: ActivityRemoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(savedInstanceState==null){
            replaceFragment(R.id.container, RemoteFragment())
        }
    }
}