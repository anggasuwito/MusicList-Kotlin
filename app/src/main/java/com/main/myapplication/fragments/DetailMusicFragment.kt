package com.main.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import coil.api.load
import com.main.myapplication.R
import com.main.myapplication.model.SongViewModel
import com.main.myapplication.recycle_view.SongRecycleView
import kotlinx.android.synthetic.main.fragment_detail_music.*
import kotlinx.android.synthetic.main.fragment_music_home.*
import kotlinx.android.synthetic.main.song_list_recycle_view_layout.*

class DetailMusicFragment : Fragment() ,View.OnClickListener{
    val songViewModel by activityViewModels<SongViewModel>()
    lateinit var songRecycleView: SongRecycleView
    lateinit var navController: NavController
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

    override fun onClick(v: View?) {
        val musicId = arguments?.getString("musicId")
        when(v){
            addNewSongButton->{
                println("INI2 = $musicId")
                navController.navigate(R.id.action_musicHomeFragment_to_newSongFragment, bundleOf(
                    "musicId" to musicId
                ))
            }
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val musicTitle = arguments?.getString("musicTitle")
        val musicArtistName = arguments?.getString("musicArtistName")
        val musicImageURL = arguments?.getString("musicImageURL")
        val musicId = arguments?.getString("musicId")!!.toInt()
        musicImageDetail.load(musicImageURL)
        musicArtistNameDetail.text = musicArtistName
        musicTitleDetail.text = musicTitle
        songListRecycleView.layoutManager = LinearLayoutManager(this.context)
        songViewModel.songList(musicId).observe(viewLifecycleOwner, Observer {
            songRecycleView = SongRecycleView(it)
            songListRecycleView.adapter = songRecycleView
        })
        addNewSongButton.setOnClickListener(this)
        navController = Navigation.findNavController(view)
    }
}
