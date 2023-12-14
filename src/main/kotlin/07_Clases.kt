package com.cursosdedesarrollo.kotlin

class Factura {
}

/*
Código Java
class Clase{
    String nombre;
    Clase(String nombre){
        this.nombre = nombre;
    }
}
 */
class Clase constructor(var nombre: String = ""){

}


class Persona {
    var nombre: String? = null

    constructor() {
        this.nombre = ""
    }

    constructor(nombre: String) {
        this.nombre = nombre
    }

    override fun toString(): String {
        return "Persona[nombre: ${nombre}]"
    }
}

class Girl {
    var age: Int = 0
        // comportamiento por defecto
        // get() = field
        // set(value) {field = value}
        set(value) {
            field = if (value < 18)
                18
            else if (value in 18..30)
                value
            else
                value-3
        }

    var actualAge: Int = 0
        // get() = field
        set(value) {
            field = value+1
        }
}

class Contador{
    private var contador:Int=0

    constructor(contador:Int =0){
        this.contador=contador
    }
    fun getContador():Int{
        return this.contador
    }
    fun inc(valor:Int=1){
        this.contador+=valor
    }
}
data class Person(var name: String="") {

}

data class Person2(var name: String="") {
    var age: Int = 0
}

open class Madre{
    var nombre: String? = null

    constructor(nombre: String = ""){
        this.nombre=nombre
    }
    override fun toString():String{
        return "Madre[nombre:"+this.nombre+"]"
    }
}

class Hija: Madre {
    var herencia:String? = null

    constructor(nombre:String = "",herencia:String =""){
        super.nombre=nombre
        this.herencia=herencia
    }
    override fun toString():String{
        return "Hija[herencia:"+this.herencia+",nombre:"+this.nombre+"]"
    }
}

open class Madre2(nombre: String = "") {
    var nombre: String? = nombre

    override fun toString():String{
        return "Madre[nombre:"+this.nombre+"]"
    }
}

class Hija3(nombre: String = "", herencia: String = "") : Madre() {
    var herencia:String? = herencia

    init {
        super.nombre=nombre
    }
    override fun toString():String{
        return "Hija3[herencia:"+this.herencia+",nombre:"+this.nombre+"]"
    }
}


class Hija2: Madre  {
    var herencia:String? = null

    constructor(nombre:String = "",herencia:String = "") : super (){
        this.herencia=herencia
    }
    override fun toString():String{
        return "Hija2[herencia:"+this.herencia+",nombre:"+this.nombre+"]"
    }
}

class Hija4(
    nombre: String = "",
    herencia: String = "")
    : Madre(nombre) {
    var herencia:String? = herencia
    override fun toString():String{
        return "Hija4[herencia:"+this.herencia+",nombre:"+this.nombre+"]"
    }
}

interface MyInterface {
    val prop: Int // abstract
    fun bar()
    fun foo() {
        println("foo")
    }
}
class Child : MyInterface {
    override val prop: Int = 29
    override fun bar() {
        println("bar")
    }
}

interface A {
    fun foo() { print("A") }
    fun bar()
}

interface B {
    fun foo() { print("B") }
    fun bar() { print("bar") }
}

class C : A {
    override fun bar() { print("bar") }
}

class D : A, B {
    override fun foo() {
        super<A>.foo()
        super<B>.foo()
    }

    override fun bar() {
        super<B>.bar()
    }
}


interface Base {
    fun print()
}

class BaseImpl(val x: Int) : Base {
    override fun print() { println("BaseImpl : $x") }
}
class BaseImpl2(val x: Int) : Base {
    override fun print() { println("BaseImpl2 : $x") }
}

// Esta clase usa un objeto de tipo : Base (interfaz)
// Inicializo el objeto en base a un objeto que una impl concreta
class Delegadora(b: Base): Base by b{
    // aquí van los métodos y atributos de la clase delegadora
}


fun main(args : Array<String>) {
    var objeto=Factura()
    println(objeto)

    var clase=Clase("nombre")
    println(clase.nombre)
    var persona=Persona()
    println(persona)
    persona=Persona("Pepe")
    println(persona)
    persona.nombre="Juan"
    println(persona)

    println("Chicas")
    //getters y setters
    val maria = Girl()
    maria.actualAge = 15
    maria.age = 15
    println("Maria: edad actual = ${maria.actualAge}")
    println("Maria: edad fingida = ${maria.age}")


    val angela = Girl()
    angela.actualAge = 35
    angela.age = 35
    println("Angela: edad actual = ${angela.actualAge}")
    println("Angela: edad fingida = ${angela.age}")

    var contador=Contador(2)
    contador.inc(2)
    println(contador.getContador())

    var person: Person= Person()
    println(person)
    println(person.name)

    person= Person("Pepe")
    println(person)
    println(person.name)

    var person2: Person2= Person2()
    println(person2)
    println(person2.name)
    println(person2.age)

    person2= Person2("Pepe")
    println(person2)
    println(person2.name)


    var padre=Madre("Pepe")
    println(padre)
    var hija=Hija()
    println(hija)
    hija=Hija("Luisa")
    println(hija)
    hija=Hija("Luisa","Total")
    println(hija)
    // Uso de interfaces
    var child=Child()
    child.foo()
    child.bar()
    println(child.prop)
    println("Delegacion")
    val b = BaseImpl(10)
    // b.print()
    val objeto1 = Delegadora(b)
    objeto1.print()

    val b2 = BaseImpl2(10)
    // b2 es un objeto de Interfaz Base
    val objeto2 = Delegadora(b2)
    objeto2.print()

    var hija2 = Hija2("Nuria")
    println(hija2)
    var hija4 = Hija4("Pepita")
    println(hija4)


}


