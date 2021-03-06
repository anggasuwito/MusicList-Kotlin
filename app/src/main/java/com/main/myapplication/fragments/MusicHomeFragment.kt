package com.main.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.main.myapplication.recycle_view.MusicRecycleView
import com.main.myapplication.view_model.MusicViewModel
import com.main.myapplication.R
import kotlinx.android.synthetic.main.fragment_music_home.*

class MusicHomeFragment : Fragment(), View.OnClickListener {
    val musicViewModel by activityViewModels<MusicViewModel>()
    lateinit var musicRecycleView: MusicRecycleView
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_music_home, container, false)
    }

    override fun onClick(v: View?) {
        when (v) {
            addNewMusicButton -> {
                navController.navigate(R.id.action_musicHomeFragment_to_newMusicFragment3)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        musicListRecycleView.layoutManager = LinearLayoutManager(activity)
        musicRecycleView =
            MusicRecycleView(musicViewModel.musicLiveData.value!!)
        musicListRecycleView.adapter = musicRecycleView
        musicViewModel.musicLiveData.observe(viewLifecycleOwner, Observer {
            musicRecycleView.notifyDataSetChanged()
        })
        addNewMusicButton.setOnClickListener(this)
        navController = Navigation.findNavController(view)
    }
}