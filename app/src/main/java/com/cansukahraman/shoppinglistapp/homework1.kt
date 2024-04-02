package com.cansukahraman.shoppinglistapp.com.cansukahraman.shoppinglistapp

open class Item(val name: String, val price: Double)

class Food(name: String, price: Double, val weight: String) : Item(name, price)

class Cloth(name: String, price: Double, val type: String) : Item(name, price)

class ShoppingList {
    val list = mutableListOf<Item>()

    //listeye ürün ekleme
    fun addItem(item: Item) {
        list.add(item)
        println("${item.name} eklendi")
    }

    //listedeki ürünler
    fun displayItem() {
        for (i in list) {
            if (i is Food) {
                println("${i.name} ,${i.weight}kg, ${i.price}$ ")
            }

            if (i is Cloth) {
                println("${i.name} , ${i.price}$, ${i.type}")
            }
        }
    }

    //listeden ürün çıkarma
    fun deleteItem(index: Int) {
        if (index >= 0 && index < list.size) {
            val deletedItem = list.removeAt(index)
            println("${deletedItem.name} silindi.")
        } else {
            println("Geçersiz değer")
        }
    }
}

fun main() {
    val shoppingList = ShoppingList()

    var secim: Int
    do {
        println("1) Add Item")
        println("2) Display Item")
        println("3) Delete Item")
        println("4) Exit")
        print("Secim yapiniz: ")
        secim = readLine()!!.toInt()
        when (secim) {
            1 -> {
                println("Urun cesidi: ")
                println("1:Food")
                println("2:Cloth")
                print("Secim yapin: ")
                val itemType = readLine()!!.toInt()
                if (itemType != 1 && itemType != 2) {
                    println("Hatalı secim")
                }
                when (itemType) {
                    1 -> {
                        print("Meyve-Sebze girin: ")
                        val name = readLine()!!.toString()
                        print("Kilosunu girin: ")
                        val weight = readLine()!!.toDouble()
                        print("Fiyatını girin: ")
                        val price = readLine()!!.toString()
                        shoppingList.addItem(Food(name, weight, price))
                    }
                    2 -> {
                        print("Kıyafet girin: ")
                        val name = readLine()!!.toString()
                        print("Türünü girin: ")
                        val type = readLine()!!.toString()
                        print("Fiyatını girin: ")
                        val price = readLine()!!.toDouble()
                        shoppingList.addItem(Cloth(name, price, type))
                    }
                }
            }
            2 -> {
                println("Alışveriş Listesi: ")
                shoppingList.displayItem()
            }
            3 -> {
                println("Kaçınıcı ürünü silmek istiyorsun? : ")
                val index = readLine()!!.toInt() - 1
                shoppingList.deleteItem(index)
            }
        }
    } while (secim != 4)
}
