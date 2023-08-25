package main

import (
	"fmt"
	"math/rand"
	"strings"
)

type TipoMatriz [][]string

func generaMatriz() TipoMatriz { //Funcion que genera matriz
	filas := rand.Intn(8-3+1) + 3 //establece que puede tener dimensiones mayores o iguales a 3 pero menores o iguales a 8
	columnas := filas
	matriz := make(TipoMatriz, filas)
	for i := range matriz {
		matriz[i] = make([]string, columnas)
		for j := range matriz[i] {
			matriz[i][j] = string(rand.Intn(26) + 'a')
		}
	}
	return matriz
}

func imprimeMatriz(matriz TipoMatriz) { //Funcion que da formato para imprimir la matriz
	for _, fila := range matriz {
		fmt.Println(strings.Join(fila, " "))
	}
	fmt.Println()
}

func Vertical(matriz TipoMatriz, x, y, n int) []string { //Busca la cantidad de elemetnos en la fila y columna solicitados de forma vertical
	if x+n > len(matriz) {
		return nil
	}
	r := make([]string, n)
	for i := 0; i < n; i++ {
		r[i] = matriz[x+i][y]
	}
	return r
}

func Horizontal(matriz TipoMatriz, x, y, n int) []string { //Busca la cantidad de elemetnos en la fila y columna solicitados de forma horizontal
	if y+n > len(matriz[0]) {
		return nil
	}
	r := make([]string, n)
	for i := 0; i < n; i++ {
		r[i] = matriz[x][y+i]
	}
	return r
}

func Diagonal(matriz TipoMatriz, x, y, n int) []string { //Busca la cantidad de elemetnos en la fila y columna solicitados de forma diagonal
	if x+n > len(matriz) || y+n > len(matriz[0]) {
		return nil
	}
	r := make([]string, n)
	for i := 0; i < n; i++ {
		r[i] = matriz[x+i][y+i]
	}
	return r
}

func map3(matMuestra []*TipoMatriz, funcion func(*TipoMatriz, int, int, int) []string, x, y, n int) [][]string { //funcion map3 generica, esta se encarga de recibir una matriz y una funcion, aplica la funcion para cada
	r := make([][]string, len(matMuestra)) //elemento de la matriz
	for i, valor := range matMuestra {
		if valor == nil || *valor == nil {
			r[i] = nil
			continue
		}
		r[i] = funcion(valor, x, y, n)
	}
	return r
}

func main() {

	var fila = 0    //definir a gusto, no mayor a 8 y menor a 3
	var columna = 0 //definir a gusto, no mayor a 8 y menor a 3
	var cant = 3    //definir a gusto, no mayor a 8 y menor a 3

	//generar tres matrices aleatorias
	matriz1 := generaMatriz()
	matriz2 := generaMatriz()
	matriz3 := generaMatriz()

	//Imprimir las matrices generadas
	fmt.Println("----Matriz 1----")
	imprimeMatriz(matriz1)
	fmt.Println("------------------------")

	fmt.Println("----Matriz 2----")
	imprimeMatriz(matriz2)
	fmt.Println("------------------------")

	fmt.Println("----Matriz 3----")
	imprimeMatriz(matriz3)
	fmt.Println("------------------------")

	//slice de punteros a las matrices
	punteroMat := []*TipoMatriz{&matriz1, &matriz2, &matriz3}

	//se hacen llamadas a map3 con los 3 metodos para las 3 matrices. Muestra resultaados
	Verticalr := map3(punteroMat, func(valor *TipoMatriz, x, y, n int) []string {
		return Vertical(*valor, x, y, n)
	}, fila, columna, cant)

	Horizontalr := map3(punteroMat, func(valor *TipoMatriz, x, y, n int) []string {
		return Horizontal(*valor, x, y, n)
	}, fila, columna, cant)

	Diagonalr := map3(punteroMat, func(valor *TipoMatriz, x, y, n int) []string {
		return Diagonal(*valor, x, y, n)
	}, fila, columna, cant)

	//imprime los resultados
	fmt.Println("Vertical:", Verticalr)
	fmt.Println("Horizontal:", Horizontalr)
	fmt.Println("Diagonal:", Diagonalr)
}
