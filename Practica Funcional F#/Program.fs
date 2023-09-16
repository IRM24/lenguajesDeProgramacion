open FSharp.Core.Operators

//1
let desplazar direccion n lista =
    if n > List.length lista || n < 0 then
        List.replicate (List.length lista) 0
    else
        match direccion with
        | "izq" -> List.append (List.skip n lista) (List.replicate n 0)
        | "der" -> List.append (List.replicate n 0) (List.take (List.length lista - n) lista)
        | _ -> lista

let n = -1

printfn "%A" (desplazar "der" n [1;2;3;4;5]) 
printfn "%A" (desplazar "izq" n [1;2;3;4;5])  

//2
let subCadena (substring: string) (list: string list) =
    List.filter (fun (s: string) -> s.Contains(substring)) list

let resultado2 = subCadena "pe" ["la casa"; "el perro"; "pintando la cerca"]
printfn "%A" resultado2

//3
let nesimo arr n =
    let mapFunction i elem =
        if i = n then [elem]
        else []

    List.mapi mapFunction arr
    |> List.concat

let arreglo = [1; 2; 3; 4; 5]
let resultado3 = nesimo arreglo 5
printfn "%A" resultado3

//4
let grafoP = [
    ("i", [("a", 2); ("b", 3); ("c", 5)]);
    ("a", [("i", 2); ("d", 4)]);
    ("b", [("i", 3); ("d", 1)]);
    ("c", [("i", 5); ("x", 3)]);
    ("d", [("a", 4); ("b", 1); ("f", 2)]);
    ("f", [("d", 2)]);
    ("x", [("c", 3)]);
]

let rec encuentraNodo nodo lista =
    match lista with
    | [] -> None
    | (key, value) :: rest ->
        if key = nodo then Some (key, value)
        else encuentraNodo nodo rest

let vecinos nodo grafo =
    match encuentraNodo nodo grafo with
    | Some (_, neighbors) -> neighbors
    | None -> []

let extender ruta grafo = 
    let curr = fst (List.head ruta)
    let vecinos = vecinos curr grafo
    let rutaSinRepetidos = List.filter (fun (vecino, _) -> not (List.exists (fun (nodo, _) -> nodo = vecino) ruta)) vecinos
    List.map (fun (vecino, peso) -> (vecino, peso + (snd (List.head ruta)))) rutaSinRepetidos

let rec prof2 ini fin grafo =
    let rec prof_aux fin ruta grafo =
        if List.isEmpty ruta then []
        elif (fst (List.head ruta)) = fin then
            List.rev (List.map fst ruta)
        else
            let ext = extender ruta grafo
            match ext with
            | [] -> prof_aux fin (ruta.Tail) grafo
            | _ ->
                let rutaMod = List.map (fun (vecino, peso) -> (vecino, peso + (snd (List.head ruta)))) ext
                prof_aux fin (rutaMod @ ruta) grafo
    prof_aux fin [(ini, 0)] grafo


let rutaCorta = prof2 "i" "d" grafoP
printfn "%A" rutaCorta

//5
let rec vecinos2 nodo grafo =
    match grafo with
    | [] -> []
    | (head, neighbors) :: rest ->
        if head = nodo then neighbors
        else vecinos2 nodo rest

let BuscaCamino ini fin grafo =
    let rec BuscaCaminoAux finCola visitados =
        match finCola with
        | [] -> [] // No se encontró un camino
        | (nodo, ruta) :: residuo ->
            if nodo = fin then
                List.rev (fin :: ruta) // Se encontró un camino
            else
                let nodosAdyacentes = vecinos2 nodo grafo
                let vecinosActualizados =
                    nodosAdyacentes
                    |> List.filter (fun vecino -> not (List.contains vecino visitados))
                let rutaActualizada =
                    vecinosActualizados
                    |> List.map (fun vecino2 -> (vecino2, vecino2 :: ruta))
                let nuevosVisitados = visitados @ vecinosActualizados
                BuscaCaminoAux (residuo @ rutaActualizada) nuevosVisitados
    let resultado = BuscaCaminoAux [(ini, [])] [ini]
    match resultado with
    | [] -> None 
    | _ -> Some resultado 

let grafo =
    [("i", ["a"; "b"]);
     ("a", ["i"; "c"; "d"]);
     ("b", ["i"; "c"; "d"]);
     ("c", ["a"; "b"; "x"]);
     ("d", ["a"; "b"; "f"]);
     ("f", ["d"]);
     ("x", ["c"])]


let resutl = BuscaCamino "i" "f" grafo 
printfn "%A" resutl
