let cromosoma1 =[1;2;3;4;5;6;7;8;9;10]

let cromosoma2=[1;2;3;4;10;9;8;7;6;5] //40%
let cromosoma3=[10;9;8;7;6;5;4;3;2;1] //0%
let cromosoma4=[1;2;3;4;5;6;7;8;9;45] //90%
let cromosoma5=[1;2;3;4;5;6;7;10;9;8] //80% 
let cromosoma6=[1;9;8;7;6;5;4;3;2;10] //20%

let muestraCromosomas = [
    cromosoma2;cromosoma3;cromosoma4;cromosoma5;cromosoma6;
]


let cromosoma sujeto candidato =
    let elementosComunes = 
        List.map2 (fun x y -> if x = y then 1 else 0) sujeto candidato
    List.sum elementosComunes

let encontrarCromosomaMasParecido (sujeto: int list) (candidatos: int list list) =
    let compararCromosomas muestra1 muestra2 =
        let porcentaje1 = cromosoma sujeto muestra1
        let porcentaje2 = cromosoma sujeto muestra2
        if porcentaje1 > porcentaje2 then muestra1 else muestra2

    List.fold compararCromosomas (candidatos[0]) (List.tail candidatos)

//let resultado1 = encontrarCromosomaMasParecido cromosoma1 muestraCromosomas
//printf "%A" resultado1



let rec esIsograma (palabra: string) =
    let palabraMod = palabra.ToLower()
    
    let rec repeticiones (lista: char list) =
        match lista with
        | [] -> false
        | cabeza::cola ->
            if List.contains cabeza cola then
                true
            else
                repeticiones cola
    
    not (repeticiones (List.ofSeq palabraMod))


//let resultado2 = esIsograma "murcielago" // Debe devolver true
//printf "%A" resultado2 

let matriz = [
    ['a'; 'b'; 'c'; 'd'; 'e'; 'f']
    ['g'; 'h'; 'i'; 'j'; 'k'; 'l']
    ['m'; 'e'; 'o'; 'p'; 'u'; 't']
    ['s'; 'l'; 'u'; 'v'; 'w'; 'x']
    ['y'; 'l'; 'a'; 'b'; 'c'; 'd']
    ['e'; 'o'; 'g'; 'h'; 'i'; 'j']
]

let encuentraPalabra (palabra: string) (matriz: char list list) =
    let filas = matriz.Length
    let cols = if filas > 0 then matriz.[0].Length else 0

    let rec busquedaCoordenada (coordenada: int * int) (indice: int) (ruta: (int * int) list) =
        match coordenada with
        | (x, y) when x >= 0 && x < filas && y >= 0 && y < cols ->
            if matriz.[x].[y] = palabra.[indice] then
                let nuevaRuta = coordenada :: ruta
                if indice = palabra.Length - 1 then
                    Some(List.rev nuevaRuta) 
                else
                    let adyacentes = [(1, 0); (-1, 0); (0, 1); (0, -1); (1, 1); (-1, -1); (1, -1); (-1, 1)]
                    let rec buscaAdyacentes = function
                        | [] -> None 
                        | (dx, dy)::cola ->
                            let nuevaCoordenada = (x + dx, y + dy)
                            match busquedaCoordenada nuevaCoordenada (indice + 1) nuevaRuta with
                            | Some(r) -> Some(r)
                            | None -> buscaAdyacentes cola
                    buscaAdyacentes adyacentes
            else
                None 
        | _ -> None 

    let rec buscaMatriz fila columna =
        match busquedaCoordenada (fila, columna) 0 [] with
        | Some(ruta) -> ruta 
        | None ->
            if fila = filas - 1 && columna = cols - 1 then
                [] 
            elif columna = cols - 1 then
                buscaMatriz (fila + 1) 0
            else
                buscaMatriz fila (columna + 1)
    
    buscaMatriz 0 0

let palabraBuscada = "aho"
let resultado3 = encuentraPalabra palabraBuscada matriz
printfn "Palabra encontrada en coordenadas: %A" resultado3
