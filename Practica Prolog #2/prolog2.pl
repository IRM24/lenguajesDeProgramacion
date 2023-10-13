% Definir las muestras y sus características
muestra('Ian','Calvo', [0,1,1,0,0,1,0,0,1,1]).
muestra('Pedro','Perez', [1,1,0,0,0,0,0,0,0,0]).
muestra('Carlos','Arroyo', [1,0,0,1,1,0,1,1,0,0]).
muestra('Jose','Castro', [1,0,1,1,0,0,1,0,0,1]).
muestra('Jill','Webb', [1,0,1,1,1,1,0,0,0,0]).
muestra('Dereck','Viquez', [0,1,0,0,0,1,0,0,0,0]).
muestra('Silvia','Lopes', [0,0,1,1,0,0,1,0,0,1]).
muestra('Marisol','Arias', [0,1,0,1,1,0,1,0,1,0]).
muestra('Sofia','Calvo', [1,1,0,0,1,0,1,1,1,1]).
muestra('Mahia','Calvo', [1,0,1,0,0,0,0,1,1,0]).

% Calcular similitud entre dos listas de características
evaluar_similitud([], [], 0).
evaluar_similitud([A|Lista1], [B|Lista2], Similitud) :-
    evaluar_similitud(Lista1, Lista2, SimilitudRestante),
    Similitud is SimilitudRestante + (A * B).

% Encontrar la muestra con mayor similitud
muestra_mas_parecida(Caracteristicas, Nombre, Apellido, Similitud) :-
    findall(
        (N, A, Sim),
        (
            muestra(N, A, Caracteristicasmuestra),
            evaluar_similitud(Caracteristicas, Caracteristicasmuestra, Sim)
        ),
        ListaSimilitudes
    ),
    encontrar_maxima_similitud(ListaSimilitudes, Nombre, Apellido, Similitud).

% Encontrar la máxima similitud en una lista de similitudes
encontrar_maxima_similitud([(N1, A1, S1)|T], NombreMax, ApellidoMax, SimilitudMax) :-
    encontrar_maxima_similitud(T, N2, A2, S2),
    ((S1 >= S2) -> (NombreMax = N1, ApellidoMax = A1, SimilitudMax = S1); (NombreMax = N2, ApellidoMax = A2, SimilitudMax = S2)).
encontrar_maxima_similitud([], _, _, 0).

%muestra_mas_parecida([1,0,1,0,0,1,0,0,0,1], Nombre, Apellido, Similitud).


conexion(i, a, 60).
conexion(i, b, 25).
conexion(a, b, 15).
conexion(a, c, 35).
conexion(b, f, 45).
conexion(b, c, 8).
conexion(c, f, 20).



ruta_origen_destino(Origen, Destino, [Origen, Destino], Costo) :-
    conexion(Origen, Destino, Costo).

ruta_origen_destino(Origen, Destino, [Origen | RestoRuta], Costo) :-
    conexion(Origen, Siguiente, CostoConexion),
    ruta_origen_destino(Siguiente, Destino, RestoRuta, CostoRestante),
    Costo is CostoConexion + CostoRestante.

rutas_posibles(Origen, Destino, Rutas) :-
    findall([Ruta, Costo], ruta_origen_destino(Origen, Destino, Ruta, Costo), Rutas).

ruta_menor_costo(Origen, Destino, Ruta, Costo) :-
    rutas_posibles(Origen, Destino, Rutas),
    menor_costo(Rutas, [Ruta, Costo]).

menor_costo([[Ruta, Costo]], [Ruta, Costo]).
menor_costo([[R1, C1] | Resto], [R2, C2]) :-
    menor_costo(Resto, [R2, C2]),
    C1 >= C2.
menor_costo([[R1, C1] | Resto], [R1, C1]) :-
    menor_costo(Resto, [_, C2]),
    C1 < C2.

%ruta_menor_costo('i','c',Ruta,Costo).