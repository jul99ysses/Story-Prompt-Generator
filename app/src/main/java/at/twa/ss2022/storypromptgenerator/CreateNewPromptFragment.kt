package at.twa.ss2022.storypromptgenerator

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController

class CreateNewPromptFragment : Fragment() {


    private val genreList = mutableListOf("a Horror Story", "a Fantasy Novel", "a Romance Novel", "a Drama", "a Comedy", "a Science Fiction Novel")
    private val mainCharacterList = mutableListOf("a stuck up lawyer", "a dainty Dog lady", "a sweet chaotic student", "a snarky Ex-Physicist")
    private val locationList = mutableListOf("the deep dark woods.", "a small town in Poland.", "an old stinky Rec center.", "the ancient ruins of a temple.")
    private val eventsList = mutableListOf("a Nuclear war", "an unfortunate wedding", "a big Summer sale", "an important dance contest")
    private val keyElementList = mutableListOf("an old, rusty key", "the cane of Uncle Louis", "a magical mystery book", "a plain glass of water")

    var generatedTitle:String =""
    var generatedGenre:String = ""
    var generatedMainCharacter:String = ""
    var generatedLocation:String = ""
    var generatedEvent:String = ""
    var generatedKeyElement:String = ""

    var status:Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_new_prompt, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val sharedPref = requireContext().getSharedPreferences("saved_story", Context.MODE_PRIVATE)
        val edit = sharedPref.edit()


        val genreTV = view.findViewById<TextView>(R.id.genreTextView)
        val mainCharacterTV = view.findViewById<TextView>(R.id.mainCharacterTextView)
        val locationTV = view.findViewById<TextView>(R.id.locationTextView)
        val eventsTV = view.findViewById<TextView>(R.id.eventTextView)
        val keyElementTV = view.findViewById<TextView>(R.id.keyElementTextView)
        val titleText = view.findViewById<EditText>(R.id.title_tv)

        val saveButton = view.findViewById<Button>(R.id.savePromptButton)
        val homeButton = view.findViewById<Button>(R.id.goToHomeButton)
        val toDetailsButton = view.findViewById<Button>(R.id.goToDetails)


        genreTV.setOnClickListener{
            val random = (0 until(genreList.size)).random()
            genreTV.text = genreList[random]
            generatedGenre = genreTV.text.toString()
        }
        mainCharacterTV.setOnClickListener{
            val random = (0 until(mainCharacterList.size)).random()
            mainCharacterTV.text = mainCharacterList[random]
            generatedMainCharacter = mainCharacterTV.text.toString()
        }
        locationTV.setOnClickListener{
            val random = (0 until(locationList.size)).random()
            locationTV.text = locationList[random]
            generatedLocation = locationTV.text.toString()
        }
        eventsTV.setOnClickListener{
            val random = (0 until(eventsList.size)).random()
            eventsTV.text = eventsList[random]
            generatedEvent = eventsTV.text.toString()
        }
        keyElementTV.setOnClickListener{
            val random = (0 until(keyElementList.size)).random()
            keyElementTV.text = keyElementList[random]
            generatedKeyElement = keyElementTV.text.toString()
        }

        saveButton.setOnClickListener {
            generatedTitle = titleText.text.toString()

            if (generatedTitle.trim().isEmpty() || generatedGenre.trim().isEmpty() ||
                generatedLocation.trim().isEmpty() ||
                generatedMainCharacter.trim().isEmpty() ||
                generatedEvent.trim().isEmpty() ||
                generatedKeyElement.trim().isEmpty()
            ) {

                Toast.makeText(
                    context,
                    "Please click on every field & choose a title!!!!!!!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {

                edit.putString("Story Title", generatedTitle)
                edit.putString("Genre", generatedGenre)
                edit.putString("Main Character", generatedMainCharacter)
                edit.putString("Location", generatedLocation)
                edit.putString("Event", generatedEvent)
                edit.putString("Key Element", generatedKeyElement)
                edit.apply()
                Toast.makeText(context, "Story saved", Toast.LENGTH_SHORT).show()
                status = true
            }
        }
        homeButton.setOnClickListener {
            val navHost = findNavController()
            navHost.navigate(CreateNewPromptFragmentDirections.actionCreateNewPromptFragmentToStartFragment())
        }

        toDetailsButton.setOnClickListener {

            if (status) {
                status = false
                val navHost = findNavController()
                navHost.navigate(
                    CreateNewPromptFragmentDirections.actionCreateNewPromptFragmentToDetailFragment(
                        generatedGenre,
                        generatedTitle,
                        generatedMainCharacter,
                        generatedLocation,
                        generatedEvent,
                        generatedKeyElement,
                    )
                )
            }
            else {
                Toast.makeText(context, "Input missing", Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onStart() {
        super.onStart()
        Log.e("CreateNewPromptFragment", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("CreateNewPromptFragment", "onResume")
    }
 }


