package com.example.acronymresolver.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.acronymresolver.ItemDisplayAdapter
import com.example.acronymresolver.databinding.FragmentDashboardBinding
import com.example.acronymresolver.viewmodel.AcronymViewModel

class DashboardFragment : Fragment(), TextWatcher {

    private lateinit var binding: FragmentDashboardBinding
    private lateinit var adapter: ItemDisplayAdapter
    private lateinit var  viewModel : AcronymViewModel

    @SuppressLint("CheckResult")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        adapter = ItemDisplayAdapter(listOf())
        binding.rvCards.adapter = adapter
        binding.rvCards.layoutManager = LinearLayoutManager(context)
        binding.edInput.addTextChangedListener(this)
        viewModel = ViewModelProvider(requireActivity())[AcronymViewModel::class.java]
        viewModel.lDisplayList.observe(viewLifecycleOwner) {
            adapter.changeData(it)
        }
        return binding.root
    }
    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        if(p0 != null){
            viewModel.inputEmitter?.onNext(p0)
        }
    }

    override fun afterTextChanged(p0: Editable?) {
    }

    companion object {
        @JvmStatic
        fun newInstance() = DashboardFragment()
    }


}