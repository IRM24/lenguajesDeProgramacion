package main

import (
	"fmt"
)

/*Ejercicio #2*/

func imprimeFigura(num int) {
	for i := 1; i <= num; i += 2 {
		for k := 0; k < (num-i)/2; k++ {
			fmt.Print(" ")
		}
		for j := 1; j <= i; j++ {
			fmt.Print("*")
		}
		fmt.Println("")
	}
	for n := num - 2; n > 0; n -= 2 {
		for k := 0; k < (num-n)/2; k++ {
			fmt.Print(" ")
		}
		for m := 1; m <= n; m++ {
			fmt.Print("*")
		}
		fmt.Println("")
	}
}

func main() {
	imprimeFigura(5)
}
