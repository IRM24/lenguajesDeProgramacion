package main

import (
	"fmt"
)

/*Ejercico #3*/

func rotaNum(p *[]string, direccion int, rotaciones int) []string {
	slice := *p
	inicio := 0
	fin := len(slice)
	if direccion == 1 {
		for i := 0; i < rotaciones; i++ {
			slice = append(slice, slice[inicio])
			slice = append(slice[:inicio], slice[inicio+1:]...)
		}
	}
	if direccion == 0 {
		for i := 0; i < rotaciones; i++ {
			ultimoValor := slice[len(slice)-1]
			slice = append([]string{ultimoValor}, slice...)
			slice = append(slice[:fin], slice[fin+1:]...)
		}
	}
	return slice
}

func main() {
	slicePrueba := []string{"a", "b", "c", "d", "e", "f", "g", "h"}
	fmt.Println(slicePrueba)
	fmt.Println(rotaNum(&slicePrueba, 0, 3))
	fmt.Println(rotaNum(&slicePrueba, 1, 3))
}
