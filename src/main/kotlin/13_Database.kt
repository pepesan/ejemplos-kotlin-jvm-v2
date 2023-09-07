package com.cursosdedesarrollo.kotlin

import java.sql.*
import java.util.*

data class User(
    var id: Long = 0L,
    var name: String = "",
    var email: String = ""){

}

fun showDatabases(conn: Connection?){
    var stmt: Statement? = null
    var resultset: ResultSet? = null

    try {
        stmt = conn?.createStatement()
        resultset = stmt?.executeQuery("SHOW DATABASES;")

        if (stmt?.execute("SHOW DATABASES;") == true) {
            resultset = stmt.resultSet
        }

        while (resultset?.next() == true) {
            println(resultset.getString("Database"))
        }
    } catch (ex: SQLException) {
        // handle any errors
        ex.printStackTrace()
    }catch (ex: Exception) {
        // handle any errors
        ex.printStackTrace()
    }
}

fun showTables(conn: Connection?){
    var stmt: Statement? = null
    var resultset: ResultSet? = null

    try {
        // Consulta SQL para obtener el listado de tablas en la base de datos
        val sql = "SHOW TABLES"

        // Ejecutar la consulta
        val statement = conn?.createStatement()

        var resultSet: ResultSet? = statement?.executeQuery(sql)
        // Iterar a través del resultado para obtener los nombres de las tablas
        while (resultSet?.next() == true) {
            val tableName = resultSet.getString(1)
            println("Tabla: $tableName")
        }

    } catch (ex: SQLException) {
        // handle any errors
        ex.printStackTrace()
    }
}

fun createTable(conn: Connection?){
    val ddlSQL= """
        CREATE TABLE `test`.`usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL,
  `email` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL,
  PRIMARY KEY (`id`));
    """.trimIndent()

    try {
        val statement = conn?.createStatement()
        val resultSet = statement?.execute(ddlSQL)



    } catch (ex: SQLException) {
        // handle any errors
        ex.printStackTrace()
    } catch (ex: Exception) {
        // handle any errors
        ex.printStackTrace()
    }
}

fun deleteTable(conn: Connection?){
    val ddlSQL= """
        DROP TABLE usuario;
    """.trimIndent()

    try {
        val statement = conn?.createStatement()
        val resultSet = statement?.execute(ddlSQL)


    } catch (ex: SQLException) {
        // handle any errors
        ex.printStackTrace()
    } catch (ex: Exception) {
        // handle any errors
        ex.printStackTrace()
    }
}

fun getAllUsers(connection: Connection?): MutableList<User> {
    val sql = "SELECT * FROM test.usuario;"
    val statement = connection?.createStatement()
    val users = mutableListOf<User>()
    try {
        val resultSet = statement?.executeQuery(sql)


        if (resultSet != null) {
            while (resultSet.next()) {
                val id = resultSet.getLong("id")
                val name = resultSet.getString("name")
                val email = resultSet.getString("email")
                val user = User(id, name, email)
                users.add(user)
            }
        }


    } catch (ex: SQLException) {
        // handle any errors
        ex.printStackTrace()
    } catch (ex: Exception) {
        // handle any errors
        ex.printStackTrace()
    }

    return users
}

fun insertUser(connection: Connection?): Int?{
    // Definir los valores del nuevo registro
    val name = "Ejemplo"
    val email = "ejemplo@example.com"

    // Query SQL para insertar un nuevo registro en la tabla "usuario"
    val insertQuery = "INSERT INTO usuario (name, email) VALUES (?, ?)"
    var rowsAffected: Int? = 0
    try {
        // Prepara la sentencia SQL
        val preparedStatement: PreparedStatement? = connection?.prepareStatement(insertQuery)
        preparedStatement?.setString(1, name)
        preparedStatement?.setString(2, email)

        // Ejecuta la inserción
        rowsAffected= preparedStatement?.executeUpdate()


        if (rowsAffected!! > 0) {
           println("Registro insertado correctamente.")
        } else {
           println("No se pudo insertar el registro.")
        }

    } catch (e: Exception) {
        e.printStackTrace()
    }
    return rowsAffected
}

fun updateUser(conn: Connection?, id: Long): Int? {
    // Definir los valores actualizados y el ID del registro que deseas actualizar
    val newName = "Nuevo Nombre"
    val newEmail = "nuevo_email@example.com"

    // Query SQL para actualizar el registro en la tabla "usuario"
    val updateQuery = "UPDATE usuario SET name = ?, email = ? WHERE id = ?"
    var rowsAffected: Int? = 0
    try {
        // Prepara la sentencia SQL
        val preparedStatement: PreparedStatement? = conn?.prepareStatement(updateQuery)
        preparedStatement?.setString(1, newName)
        preparedStatement?.setString(2, newEmail)
        preparedStatement?.setLong(3, id)

        // Ejecuta la actualización
        rowsAffected = preparedStatement?.executeUpdate()

        if (rowsAffected!! > 0) {
            println("Registro actualizado correctamente.")
        } else {
            println("No se pudo actualizar el registro. Es posible que el ID no exista.")
        }

    } catch (e: Exception) {
        e.printStackTrace()
        rowsAffected = 0
    }
    // Cierra la conexión a la base de datos
    return rowsAffected

}

fun getUserById(conn: Connection?, id: Long): User {
    val sql = "SELECT id, name, email FROM test.usuario Where id = ?"
    val preparedStatement: PreparedStatement?
    var user = User()
    try {
        preparedStatement = conn?.prepareStatement(sql)
        preparedStatement?.setLong(1, id)
        val resultSet = preparedStatement?.executeQuery()

        if (resultSet != null) {
            while (resultSet.next()) {
                val id = resultSet.getLong("id")
                val name = resultSet.getString("name")
                val email = resultSet.getString("email")
                user = User(id, name, email)
            }
        }


    } catch (ex: SQLException) {
        // handle any errors
        ex.printStackTrace()
    } catch (ex: Exception) {
        // handle any errors
        ex.printStackTrace()
    }

    return user
}

fun deleteUserById(conn: Connection?, id: Long): Int? {
// Query SQL para actualizar el registro en la tabla "usuario"
    val updateQuery = "DELETE FROM usuario WHERE id = ?"
    var rowsAffected: Int? = 0
    try {
        // Prepara la sentencia SQL
        val preparedStatement: PreparedStatement? = conn?.prepareStatement(updateQuery)
        preparedStatement?.setLong(1, id)

        // Ejecuta la actualización
        rowsAffected = preparedStatement?.executeUpdate()

        if (rowsAffected != null) {
            if (rowsAffected > 0) {
                println("Registro actualizado correctamente.")
            } else {
                println("No se pudo actualizar el registro. Es posible que el ID no exista.")
            }
        }
    } catch (e: Exception) {
        e.printStackTrace()
        rowsAffected = 0
    }
    // Cierra la conexión a la base de datos
    return rowsAffected
}
fun main() {
    val connectionProps = Properties()
    connectionProps.put("user", "root")
    connectionProps.put("password", "root")
    var conn: Connection? = null
    try {
        // Class.forName("com.mysql.jdbc.Driver").newInstance()
        conn = DriverManager.getConnection(
            "jdbc:" + "mysql" + "://" +
                    "127.0.0.1" +
                    ":" + "3306" + "/" +
                    "test",
            connectionProps)
        println("Conexión realizada")
    } catch (ex: SQLException) {
        // handle any errors
        ex.printStackTrace()
    } catch (ex: Exception) {
        // handle any errors
        ex.printStackTrace()
    }
    showDatabases(conn)
    showTables(conn)
    //createTable(conn)
    //deleteTable(conn)
//
    var users: MutableList<User> = getAllUsers(conn)
    println(users)
    var rowsAffected = insertUser(conn)
    println(rowsAffected)
    users = getAllUsers(conn)
    println(users)
    val id: Long = users[0].id
    println("id: $id")
    rowsAffected = updateUser(conn, id)
    println(rowsAffected)
    val user = getUserById(conn, id)
    println(user)
    rowsAffected = deleteUserById(conn, id)
    println(rowsAffected)
    conn?.close()
}


