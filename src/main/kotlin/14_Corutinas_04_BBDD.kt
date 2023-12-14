package com.cursosdedesarrollo.kotlin

import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import java.sql.DriverManager

data class Item(val id: Int, val name: String)

fun createDatabaseSchema() {
    val connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root")
    connection.use { conn ->
        conn.createStatement().use { statement ->
            // Crear el esquema y la tabla
            statement.execute("CREATE DATABASE IF NOT EXISTS your_database")
            statement.execute("USE test")
            statement.execute("CREATE TABLE IF NOT EXISTS items (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255))")
        }
    }
}

suspend fun insertItem(item: Item) {
    val connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "your_username", "your_password")
    connection.use { conn ->
        conn.prepareStatement("INSERT INTO items (name) VALUES (?)").use { preparedStatement ->
            preparedStatement.setString(1, item.name)
            preparedStatement.executeUpdate()
        }
    }
}

suspend fun getAllItems(): List<Item> {
    val connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "your_username", "your_password")
    return connection.use { conn ->
        conn.createStatement().use { statement ->
            val resultSet = statement.executeQuery("SELECT * FROM items")
            val items = mutableListOf<Item>()
            while (resultSet.next()) {
                val id = resultSet.getInt("id")
                val name = resultSet.getString("name")
                items.add(Item(id, name))
            }
            items
        }
    }
}

fun main() = runBlocking {
    createDatabaseSchema() // Crear el esquema de la base de datos
    val newItem = Item(1, "Ejemplo")
    var ret = async {insertItem(newItem)}
    var ret2 = async {insertItem(newItem)}

    println(ret.await())
    println(ret2.await())
    // Imprimir los resultados
    println("Resultado Uno: $ret")
    println("Resultado Dos: $ret2")
}

