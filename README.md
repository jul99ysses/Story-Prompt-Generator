# Story-Prompt-Generator


Story Prompt Generator
App, um sich Inspiration für das Schreiben einer Kurzgeschichte zu holen!

* Eigene Farben, Strings und Bilder eingebunden
* Base Block
* Navigation mit Fragments
* Block 2 Toasts
* Block 3 Notification
* 3 Screens:

1. Screen = Start-Fragment: 2 TextViews, 2 ImageViews und 1 Button, der mit Click Listener
                            zur nächsten Seite führt

2. Screen = Create Prompt Fragment: Mehrere Text-Views, die ihren Text durch
Anklicken mittels Zufallsgenerator ändern und 1 Input-Feld, dass der User ausfüllen muss.
Wird eines dieser Felder nicht geklickt/ausgefüllt, erscheint ein Toast + der User kann
nicht weiter gehen.
Beim Klick auf den Button "Save Prompt" erscheint der Toast "Story saved".
Beim Klick auf den Button "Show Prompt" kommt man auf den nächsten Screen, eine Notfication wird ausgelöst.
Man kann durch Klick auf "Home" auch wieder zum Homescreen zurückgehen.

3. Screen: Hier sind die ausgewählten Strings übergeben worden und werden angezeigt.
