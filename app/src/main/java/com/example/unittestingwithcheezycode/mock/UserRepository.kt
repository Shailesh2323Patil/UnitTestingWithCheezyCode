package com.example.unittestingwithcheezycode.mock

class UserRepository {
    val users = listOf<User>(
        User(1, "John", "john@gmail.com","ABC"),
        User(1, "John", "wein@gmail.com","ABC"),
        User(1, "John", "emily@gmail.com","ABC"),
    )

    fun loginUser(email: String, password: String): LOGIN_STATUS {
        val users = users.filter { user -> user.email == email }
        return if (users.size == 1) {
            if(users[0].password == password) {
                LOGIN_STATUS.SUCCESS
            } else {
                LOGIN_STATUS.INVALID_PASSWORD
            }
        } else {
            LOGIN_STATUS.INVALID_USER
        }
    }
}