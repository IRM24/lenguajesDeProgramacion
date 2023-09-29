:- use_module(library(strings)).

sumlist([], 0).     
sumlist([X|Resto], S) :-
    sumlist(Resto, SResto),  
    S is X + SResto.        


subconj(_,[]).


subconj(S,[H|T]) :-
    member(H, S),
    subconj(S, T).



aplanar([], []).


aplanar([H|T], L2) :-
    is_list(H),
    aplanar(H, H1),
    aplanar(T, T1),
    append(H1, T1, L2).


aplanar([H|T], [H|T1]) :-
    \+ is_list(H),
    aplanar(T, T1).



partir([], _, [], []).


partir([H|T], Umbral, [H|Menores], Mayores) :-
    H < Umbral,
    partir(T, Umbral, Menores, Mayores).


partir([H|T], Umbral, Menores, [H|Mayores]) :-
    H >= Umbral,
    partir(T, Umbral, Menores, Mayores).


sub_cadenas(_, [], []).


sub_cadenas(Sub, [H|T], [H|Filtradas]) :-
    sub_string(H, _, _, _, Sub),
    sub_cadenas(Sub, T, Filtradas).


sub_cadenas(Sub, [H|T], Filtradas) :-
    \+ sub_string(H, _, _, _, Sub),
    sub_cadenas(Sub, T, Filtradas).
