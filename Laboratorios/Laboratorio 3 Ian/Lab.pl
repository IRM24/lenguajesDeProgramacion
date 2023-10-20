:- use_module(library(lists)).

%Ian Calvo Madrigal 2022136902
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Ejercicio 1 Estudiantes
%estudiantes
estudiante(pablo, [evaluacion(1, 100, 0.20), evaluacion(1, 100, 0.20), evaluacion(3, 100, 0.10)]).
estudiante(ana, [evaluacion(1, 80, 0.20), evaluacion(2, 95, 0.15)]).
estudiante(pedro, [evaluacion(1, 90, 0.20), evaluacion(2, 85, 0.15)]).
estudiante(maria, [evaluacion(3, 100, 0.10), evaluacion(3, 100, 0.10), evaluacion(3, 100, 0.10)]).
estudiante(juan, [evaluacion(1, 75, 0.15), evaluacion(2, 88, 0.15)]).
estudiante(laura, [evaluacion(1, 92, 0.20), evaluacion(3, 78, 0.10)]).

probabilidad_aprobacion(Estudiante, Probabilidad) :-
    estudiante(Estudiante, Evaluaciones),
    verificar_porcentaje(Evaluaciones),
    calcular_probabilidad(Evaluaciones, Probabilidad).

verificar_porcentaje(Evaluaciones) :-
    sumar_porcentajes(Evaluaciones, Suma),
    Suma =< 0.5.

sumar_porcentajes([], 0).
sumar_porcentajes([evaluacion(_, _, Porcentaje)|Resto], Suma) :-
    sumar_porcentajes(Resto, SumaResto),
    Suma is Porcentaje + SumaResto.

calcular_probabilidad([], 0).
calcular_probabilidad([evaluacion(Tipo, Nota, Porcentaje)|Resto], Probabilidad) :-
    calcular_probabilidad(Resto, ProbabilidadResto),
    % Asignar pesos según el tipo de evaluación
    (Tipo = 1 -> Peso = 1.9;
     Tipo = 2 -> Peso = 1.7;
     Tipo = 3 -> Peso = 1.5;
     Peso = 1), % En caso de otros tipos, el peso es 1
    ProbabilidadParcial is (Nota * Porcentaje * Peso) + ProbabilidadResto,
    ProbabilidadParcialRounded is round(ProbabilidadParcial), % Redondear a entero
    Probabilidad is min(100, max(0, ProbabilidadParcialRounded)). % Asegurar que esté entre 0 y 100

ordenar_estudiantes(ListaOrdenada) :-
    setof(Prob-Estudiante, probabilidad_aprobacion(Estudiante, Prob), ListaAscendente),
    reverse(ListaAscendente, ListaOrdenada).

% Consulta
% ?- ordenar_estudiantes(Lista).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Ejercicio 2 Cuadricula 1
%   1 2 3 4 5
% 1 - - - - -
% 2 - - X X -
% 3 - X X - -
% 4 - - - X X
% 5 - - - - -

casilla_ocupada(2, 3).
casilla_ocupada(2, 4).
casilla_ocupada(3, 2).
casilla_ocupada(3, 3).
casilla_ocupada(4, 4).
casilla_ocupada(4, 5).

conexiones_entre_casillas(X1, Y1, X2, Y2) :-
    casilla_ocupada(X1, Y1),
    casilla_ocupada(X2, Y2),
    (X1 =:= X2, abs(Y1 - Y2) =:= 1; Y1 =:= Y2, abs(X1 - X2) =:= 1).

encontrar_grupo_a_partir_de_casilla(X, Y, Grupo) :-
    busquedaP(X, Y, [], Grupo),
    !.  

busquedaP(X, Y, Visitadas, Grupo) :-
    casilla_ocupada(X, Y),
    \+ member([X, Y], Visitadas),
    findall([X1, Y1], (conexiones_entre_casillas(X, Y, X1, Y1), \+ member([X1, Y1], Visitadas)), Vecinos),
    append(Visitadas, [[X, Y]], NuevasVisitadas),
    encontrar_grupos(Vecinos, NuevasVisitadas, Grupo).

encontrar_grupos([], Visitadas, Grupo) :-
    sort(0, @<, Visitadas, Grupo).

encontrar_grupos([[X1, Y1] | Resto], Visitadas, Grupo) :-
    busquedaP(X1, Y1, Visitadas, NuevasVisitadas),
    encontrar_grupos(Resto, NuevasVisitadas, Grupo).

grupos_en_la_cuadricula(G) :-
    findall(Grupo, (casilla_ocupada(X, Y), encontrar_grupo_a_partir_de_casilla(X, Y, Grupo)), Grupos),
    eliminar_grupos_duplicados(Grupos, G),
    !.  

eliminar_grupos_duplicados([], []).
eliminar_grupos_duplicados([X|Xs], Resultado) :-
    sort(0, @<, X, XOrdenado),
    member(XOrdenado, Xs),
    eliminar_grupos_duplicados(Xs, Resultado),
    !.  
eliminar_grupos_duplicados([X|Xs], [X|Resto]) :-
    sort(0, @<, X, XOrdenado),
    \+ member(XOrdenado, Xs),
    eliminar_grupos_duplicados(Xs, Resto),
    !.  

ordenar_grupos_por_tamano(Grupos, GruposOrdenados) :-
    predsort(compare_grupos, Grupos, GruposOrdenados).

compare_grupos(Resultado, Grupo1, Grupo2) :-
    length(Grupo1, Tamano1),
    length(Grupo2, Tamano2),
    (Tamano1 > Tamano2 -> Resultado = (<); Tamano1 < Tamano2 -> Resultado = (>); Resultado = (=)).

grupos_organizados_por_tamano(G) :-
    grupos_en_la_cuadricula(Grupos),
    ordenar_grupos_por_tamano(Grupos, G).

% Consulta
%grupos_organizados_por_tamano(GruposOrdenados).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Ejercicio 2 Cuadricula 2
%  1 2 3 4 5
%  1 - - - - -
%  2 - X X - -
%  3 - X - - X
%  4 - - - - -
%  5 - - - - -

casilla_ocupadaV2(2, 2).
casilla_ocupadaV2(2, 3).
casilla_ocupadaV2(3, 2).
casilla_ocupadaV2(3, 5).

conexiones_entre_casillasV2(X1, Y1, X2, Y2) :-
    casilla_ocupadaV2(X1, Y1),
    casilla_ocupadaV2(X2, Y2),
    (X1 =:= X2, abs(Y1 - Y2) =:= 1; Y1 =:= Y2, abs(X1 - X2) =:= 1).

encontrar_grupo_a_partir_de_casillaV2(X, Y, Grupo) :-
    busquedaPV2(X, Y, [], Grupo),
    !.  

busquedaPV2(X, Y, Visitadas, Grupo) :-
    casilla_ocupadaV2(X, Y),
    \+ member([X, Y], Visitadas),
    findall([X1, Y1], (conexiones_entre_casillasV2(X, Y, X1, Y1), \+ member([X1, Y1], Visitadas)), Vecinos),
    append(Visitadas, [[X, Y]], NuevasVisitadas),
    encontrar_gruposV2(Vecinos, NuevasVisitadas, Grupo).

encontrar_gruposV2([], Visitadas, Grupo) :-
    sort(0, @<, Visitadas, Grupo).

encontrar_gruposV2([[X1, Y1] | Resto], Visitadas, Grupo) :-
    busquedaPV2(X1, Y1, Visitadas, NuevasVisitadas),
    encontrar_gruposV2(Resto, NuevasVisitadas, Grupo).

grupos_en_la_cuadriculaV2(G) :-
    findall(Grupo, (casilla_ocupadaV2(X, Y), encontrar_grupo_a_partir_de_casillaV2(X, Y, Grupo)), Grupos),
    eliminar_grupos_duplicadosV2(Grupos, G),
    !.  

eliminar_grupos_duplicadosV2([], []).
eliminar_grupos_duplicadosV2([X|Xs], Resultado) :-
    sort(0, @<, X, XOrdenado),
    member(XOrdenado, Xs),
    eliminar_grupos_duplicadosV2(Xs, Resultado),
    !. 
eliminar_grupos_duplicadosV2([X|Xs], [X|Resto]) :-
    sort(0, @<, X, XOrdenado),
    \+ member(XOrdenado, Xs),
    eliminar_grupos_duplicadosV2(Xs, Resto),
    !. 

ordenar_grupos_por_tamanoV2(Grupos, GruposOrdenados) :-
    predsort(compare_gruposV2, Grupos, GruposOrdenados).

compare_gruposV2(Resultado, Grupo1, Grupo2) :-
    length(Grupo1, Tamano1),
    length(Grupo2, Tamano2),
    (Tamano1 > Tamano2 -> Resultado = (<); Tamano1 < Tamano2 -> Resultado = (>); Resultado = (=)).

grupos_organizados_por_tamanoV2(G) :-
    grupos_en_la_cuadriculaV2(Grupos),
    ordenar_grupos_por_tamanoV2(Grupos, G).

% Consulta
% grupos_organizados_por_tamanoV2(GruposOrdenados).

