package main

import (
	"fmt"
)

/*Ejercicio #4 Almacen de Zapatos*/
type calzado struct {
	modelo   string
	precio   int
	talla    int
	cantidad int
}

type lZapatos []calzado

var almacenZapatos lZapatos

func (z *lZapatos) agregaZapato(modelo string, precio int, talla int, cantidad int) {
	var prod = almacenZapatos.encuentraZapato(modelo)
	if talla >= 34 && talla <= 44 {
		if prod != -1 {
			(*z)[prod].cantidad += cantidad
		} else {
			*z = append(*z, calzado{modelo: modelo, precio: precio, talla: talla, cantidad: cantidad})
		}
	} else {
		fmt.Println("la talla de", modelo, "no cabe dentro de nuestros estandares")
	}
}

func (z *lZapatos) encuentraZapato(modelo string) int {
	var resultado = -1
	var i int
	for i = 0; i < len(*z); i++ {
		if (*z)[i].modelo == modelo {
			resultado = i
		}
	}
	return resultado
}

func (z *lZapatos) vendeZapatos(modelo string, cantidad int) {
	var prod = almacenZapatos.encuentraZapato(modelo)
	if prod != -1 && cantidad <= (*z)[prod].cantidad {
		(*z)[prod].cantidad -= cantidad
	} else if (*z)[prod].cantidad == 0 {
		fmt.Println("out of stock :( )")
	} else {
		fmt.Println("no existe la cantidad de pares, trate con un numero menor")
	}
}

// datos quemados
func llenaInventario() {
	almacenZapatos.agregaZapato("nike", 50000, 44, 1)
	almacenZapatos.agregaZapato("adidas", 75000, 38, 1)
	almacenZapatos.agregaZapato("puma", 45000, 40, 1)
	almacenZapatos.agregaZapato("reebok", 55000, 42, 1)
	almacenZapatos.agregaZapato("converse", 48000, 44, 1)
}

func main() {
	llenaInventario()
	fmt.Println(almacenZapatos)
	almacenZapatos.agregaZapato("nike", 50000, 44, 5)
	fmt.Println(almacenZapatos)
	almacenZapatos.vendeZapatos("nike", 6)
	fmt.Println(almacenZapatos)
	almacenZapatos.vendeZapatos("nike", 1)
	fmt.Println(almacenZapatos)
}
