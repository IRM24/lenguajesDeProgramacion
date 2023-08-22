package main

import (
	"bufio"
	"fmt"
	"strings"
)

/*Ejercicio #1*/
var textoQuemado string = `En un rincón del alma, donde suelo soñar,
						   brotan los recuerdos que nunca se van a marchar.
						   El tiempo avanza implacable, sin detenerse jamás,	   
						   pero en este rincón, mis sueños siguen en paz.`

func lineas(textoQuemado string) int {
	scanner := bufio.NewScanner(strings.NewReader(textoQuemado)) //lee texto linea a linea
	linea := 0

	for scanner.Scan() { //devuelve true por cada vez que detecte una linea nueva
		linea++
	}

	return linea
}

func palabras(textoQuemado string) int {
	palabra := strings.Fields(textoQuemado)
	return len(palabra)
}

func caracteres(textoQuemado string) int {
	return len(textoQuemado)
}

func main() {
	fmt.Println(lineas(textoQuemado))
	fmt.Println(palabras(textoQuemado))
	fmt.Println(caracteres(textoQuemado))
}
