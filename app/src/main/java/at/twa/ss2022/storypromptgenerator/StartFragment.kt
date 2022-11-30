package at.twa.ss2022.storypromptgenerator

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class StartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val goToGeneratorButton = view.findViewById<Button>(R.id.createPromptButton)
        goToGeneratorButton.setOnClickListener {
            val navHost = findNavController()
            navHost.navigate(StartFragmentDirections.actionStartFragmentToCreateNewPromptFragment())
        }

    }
    override fun onStart() {
        super.onStart()
        Log.e("StartFragment", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("StartFragment", "onResume")
    }

}

