package com.fragments.app.users_list_part

import androidx.lifecycle.ViewModel

class ContactsViewModel: ViewModel() {
    val usersList = arrayListOf(
        User("https://placebear.com/640/360", "Nikita", "Romanenko", 78937489),
        User("https://placebear.com/640/360", "Roma", "Romanen", 78934895),
        User("https://placebeard.it/640x360", "Olya", "Romanenk", 789398245),
        User("https://placebeard.it/640x360", "Andrey", "Romo", 78290475)
    )
}