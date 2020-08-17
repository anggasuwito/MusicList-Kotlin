package com.main.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.api.load
import com.main.myapplication.R
import kotlinx.android.synthetic.main.fragment_detail_music.*

class DetailMusicFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_music, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val musicTitle = arguments?.getString("musicTitle")
        val musicArtistName = arguments?.getString("musicArtistName")
        val musicImageURL = arguments?.getString("musicImageURL")
        musicImageDetail.load(musicImageURL)
        musicArtistNameDetail.text = musicArtistName
        musicTitleDetail.text = musicTitle
    }
}
