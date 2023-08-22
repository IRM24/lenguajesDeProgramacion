package main

import (
	"fmt"
	"sort"
)

type producto struct {
	nombre   string
	cantidad int
	precio   int
}
type listaProductos []producto

var lProductos listaProductos

const existenciaMinima int = 10

func (l *listaProductos) agregarProducto(nombre string, cantidad int, precio int) {
	_, errCode, index := l.buscarProducto(nombre)
	if errCode == 0 {
		(*l)[index].cantidad += cantidad
		if (*l)[index].precio != precio {
			(*l)[index].precio = precio
		}
	} else if errCode == 1 {
		*l = append(*l, producto{nombre: nombre, cantidad: cantidad, precio: precio})
	}
}

func agregarProductosIniciales(productos ...producto) {
	for _, p := range productos {
		lProductos.agregarProducto(p.nombre, p.cantidad, p.precio)
	}
}

func (l *listaProductos) buscarProducto(nombre string) (producto, int, int) {
	var result producto
	var errCode = 0
	var indice = 0
	var i int
	for i = 0; i < len(*l); i++ {
		if (*l)[i].nombre == nombre {
			result = (*l)[i]
			indice = i
			break
		}
	}
	if i == len(*l) {
		errCode = 1
	}
	return result, errCode, indice
}

func (l *listaProductos) venderProducto(nombre string, cantidad int) {
	prod, errCode, index := l.buscarProducto(nombre)
	if errCode == 0 {
		if prod.cantidad != 0 && cantidad <= prod.cantidad {
			prod.cantidad -= cantidad
			if prod.cantidad == 0 {
				// Eliminar producto
				copy((*l)[index:], (*l)[index+1:])
				*l = (*l)[:len(*l)-1]
				fmt.Println("Se eliminó", nombre)
			}
		} else {
			fmt.Println("No hay stock de", nombre, "para vender")
		}
	} else if errCode == 1 {
		fmt.Println("Producto no encontrado:", nombre)
	}
}

func (l *listaProductos) modificaPrecio(nombre string, precio int) {
	_, errCode, index := l.buscarProducto(nombre)
	if errCode == 0 {
		(*l)[index].precio = precio
	} else if errCode == 1 {
		fmt.Println("No se encuentra el producto:", nombre)
	}
}

func (l *listaProductos) listarProductosMínimos() listaProductos {
	var productosMinimos listaProductos

	for _, prod := range *l {
		if prod.cantidad < existenciaMinima {
			productosMinimos = append(productosMinimos, prod)
		}
	}

	return productosMinimos
}

func (l *listaProductos) aumentarInventarioDeMinimos(listaMinimos listaProductos) {
	for _, prodMinimo := range listaMinimos {
		prodActual, errCode, _ := l.buscarProducto(prodMinimo.nombre)
		if errCode == 0 {
			unidadesFaltantes := existenciaMinima - prodActual.cantidad
			if unidadesFaltantes > 0 {
				l.agregarProducto(prodActual.nombre, unidadesFaltantes, prodActual.precio)
				fmt.Printf("Se aumentó el inventario de %s en %d unidades\n", prodActual.nombre, unidadesFaltantes)
			}
		}
	}
}

/*Del paquete sort, era necesario crear las funciones*/
func (l listaProductos) Less(i, j int) bool {
	return l[i].nombre < l[j].nombre
}

func (l listaProductos) Swap(i, j int) {
	l[i], l[j] = l[j], l[i]
}

func (l listaProductos) Len() int {
	return len(l)
}

func llenarDatos() {
	lProductos.agregarProducto("arroz", 15, 2500)
	lProductos.agregarProducto("frijoles", 4, 2000)
	lProductos.agregarProducto("leche", 8, 1200)
	lProductos.agregarProducto("café", 12, 4500)
}

func main() {
	llenarDatos()
	fmt.Println("------------------------------------------------")
	fmt.Println(lProductos)
	fmt.Println("------------------------------------------------")
	lProductos.venderProducto("arroz", 15)
	fmt.Println(lProductos)
	fmt.Println("------------------------------------------------")
	fmt.Println("se modifico el precio de los frijoles")
	lProductos.modificaPrecio("frijoles", 0)
	fmt.Println(lProductos)
	fmt.Println("------------------------------------------------")
	minimos := lProductos.listarProductosMínimos()
	lProductos.aumentarInventarioDeMinimos(minimos)
	fmt.Println(lProductos)
	fmt.Println("------------------------------------------------")
	fmt.Println("se ordeno la lista por orden alfabetico")
	sort.Sort(lProductos)
	fmt.Println(lProductos)
	fmt.Println("------------------------------------------------")
}
