package at.twa.ss2022.storypromptgenerator

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.navigation.fragment.navArgs

class DetailFragment : Fragment() {

    val navargs: DetailFragmentArgs by navArgs()
    private val CHANNEL_ID = "channel_id_07"
    private val notificationId = 110


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var receivedGenre = view.findViewById<TextView>(R.id.showGenre)
        var receivedTitle = view.findViewById<TextView>(R.id.showTitle)
        var receivedMainCharacter = view.findViewById<TextView>(R.id.showMainCharacter)
        var receivedLocation = view.findViewById<TextView>(R.id.showLocation)
        var receivedEvent = view.findViewById<TextView>(R.id.showEvent)
        var receivedKeyElement = view.findViewById<TextView>(R.id.showKeyElement)

        receivedGenre.text = navargs.genre
        receivedTitle.text = navargs.title
        receivedMainCharacter.text = navargs.mainCharacter
        receivedLocation.text = navargs.location
        receivedEvent.text = navargs.event
        receivedKeyElement.text = navargs.keyElement

        createNotificationChannel()
        sendNotification()
    }

    private fun createNotificationChannel() {
           if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
               val name = "Test"
               val descriptionText = "Test test"
               val importance = NotificationManager.IMPORTANCE_DEFAULT
               val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                   description = descriptionText
               }
               val notificationManager = requireContext().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
               notificationManager.createNotificationChannel(channel)
           }
       }

       private fun sendNotification(){
           var builder = NotificationCompat.Builder(requireContext(),CHANNEL_ID)
               .setSmallIcon(R.drawable.ic_launcher_foreground)
               .setContentTitle("New Story")
               .setContentText("Good job! You created another story prompt titled ${navargs.title}")
               .setPriority(NotificationCompat.PRIORITY_DEFAULT)

           with(NotificationManagerCompat.from(requireContext())){
               notify(notificationId, builder.build())
           }
       }

    override fun onStart() {
        super.onStart()
        Log.e("CreateDetailFragment", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("CreateDetailFragment", "onResume")
    }

}