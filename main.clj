(ns main (:require [triang]) (:require [retang]) (:require [trapez]) (:require [casa]) (:require [apartamento]) (:gen-class) )

 (defn adiciona [ imoveis  linhas i ]
   (if ( == (compare (nth linhas i) "triang") 0)

     (
       def imoveis( conj imoveis (triang/->triang "triang" (Integer. ( re-find #"\d+" (nth linhas (+ i 1)) ))
          (nth linhas (+ i 2))
          (nth linhas (+ i 3))
          (Double/valueOf (nth linhas (+ i 4)))
          (Double/valueOf (nth linhas (+ i 5)))
          (Double/valueOf (nth linhas (+ i 6)))
          (/(* (Double/valueOf (nth linhas (+ i 5))) (Double/valueOf (nth linhas (+ i 6))))2)
          (triang/preco (/ (* (Double/valueOf (nth linhas (+ i 5))) (Double/valueOf (nth linhas (+ i 6))))2) (Double/valueOf (nth linhas (+ i 4))) (nth linhas (+ i 3))) ))
     )

     (
       if ( == (compare (nth linhas i) "retang") 0)

         (
           def imoveis( conj imoveis (retang/->retang "retang" (Integer. ( re-find #"\d+" (nth linhas (+ i 1)) ))
              (nth linhas (+ i 2))
              (nth linhas (+ i 3))
              (Double/valueOf (nth linhas (+ i 4)))
              (Double/valueOf (nth linhas (+ i 5)))
              (Double/valueOf (nth linhas (+ i 6)))
              ( * (Double/valueOf (nth linhas (+ i 5))) (Double/valueOf (nth linhas (+ i 6))))
              (retang/preco (* (Double/valueOf (nth linhas (+ i 5))) (Double/valueOf (nth linhas (+ i 6)))) (Double/valueOf (nth linhas (+ i 4))) (nth linhas (+ i 3))) ))
         )
         (
           if ( == (compare (nth linhas i) "trapez") 0)

              (
                def imoveis( conj imoveis (trapez/->trapez "trapez" (Integer. ( re-find #"\d+" (nth linhas (+ i 1)) ))
                  (nth linhas (+ i 2))
                  (nth linhas (+ i 3))
                  (Double/valueOf (nth linhas (+ i 4)))
                  (Double/valueOf (nth linhas (+ i 5)))
                  (Double/valueOf (nth linhas (+ i 6)))
                  (Double/valueOf (nth linhas (+ i 7)))
                  ( / ( * (+ (Double/valueOf (nth linhas (+ i 5))) (Double/valueOf (nth linhas (+ i 6)))) (Double/valueOf (nth linhas (+ i 7))) ) 2 )
                  (trapez/preco (/ ( * (+ (Double/valueOf (nth linhas (+ i 5))) (Double/valueOf (nth linhas (+ i 6)))) (Double/valueOf (nth linhas (+ i 7))) ) 2) (Double/valueOf (nth linhas (+ i 4))) (nth linhas (+ i 3))) )

                )

             )
             (
               if ( == (compare (nth linhas i) "casa") 0)

                 (

                   def imoveis ( conj imoveis (casa/->casa "casa" (Integer. ( re-find #"\d+" (nth linhas (+ i 1)) ))
                      (nth linhas (+ i 2))
                      (Integer. ( re-find #"\d+" (nth linhas (+ i 3)) ))
                      (Integer. ( re-find #"\d+" (nth linhas (+ i 4)) ))
                      (Integer. ( re-find #"\d+" (nth linhas (+ i 5)) ))
                      (Double/valueOf (nth linhas (+ i 6)))
                      (Double/valueOf (nth linhas (+ i 7)))
                      (Double/valueOf (nth linhas (+ i 8)))
                      (Double/valueOf (nth linhas (+ i 9)))
                      (casa/preco (Integer. ( re-find #"\d+" (nth linhas (+ i 5)) )) (Double/valueOf (nth linhas (+ i 6))) (Double/valueOf (nth linhas (+ i 7))) (Double/valueOf (nth linhas (+ i 8))) (Double/valueOf (nth linhas (+ i 9))) )
                      ( * (Integer. ( re-find #"\d+" (nth linhas (+ i 5)) )) (Double/valueOf (nth linhas (+ i 6))) ) )
                    )

                 )
                 (
                   if (==(compare (nth linhas i) "apto") 0 )(
                     def imoveis ( conj imoveis (apartamento/->apartamento "apto" (Integer. ( re-find #"\d+" (nth linhas (+ i 1)) ))
                        (nth linhas (+ i 2))
                        (Integer. ( re-find #"\d+" (nth linhas (+ i 3)) ))
                        (Integer. ( re-find #"\d+" (nth linhas (+ i 4)) ))
                        (Integer. ( re-find #"\d+" (nth linhas (+ i 5)) ))
                        (Double/valueOf (nth linhas (+ i 6)))
                        (Double/valueOf (nth linhas (+ i 7)))

                        (nth linhas (+ i 8))
                        (Integer. ( re-find #"\d+" (nth linhas (+ i 9)) ))

                        (apartamento/preco (Integer. ( re-find #"\d+" (nth linhas (+ i 5)) )) (Double/valueOf (nth linhas (+ i 6))) (Double/valueOf (nth linhas (+ i 7))) (nth linhas (+ i 8)) (Integer. ( re-find #"\d+" (nth linhas (+ i 9)) )) ))                    )
                      )
                 );fim do if apartamento

             );fim do if casa


         );fim do if trapez

     );fim do if de retangulo

   );fim do if de triangulo

)
(defn retira [ imoveis n ] ( def imoveis (remove #( = (:identificador %)  n) imoveis)))

(defn geraArg[imoveis argi] ())


(def imoveis(list))
(def argilosos(list))
(def casa(list))
(def z (slurp "espec.txt"))
(def a (clojure.string/split-lines z))
(def nImov (Integer. ( re-find #"\d+" (nth a 0))))
(def nArg (Integer. ( re-find #"\d+" (nth a 1))))
(def precCasa (Double/valueOf (nth a 3)))
(def  areaCasa (Double/valueOf (nth a 2)))

(def p (Integer. ( re-find #"\d+"(nth a 4))))
(def j (Integer. ( re-find #"\d+"(nth a 5))))
(def k (Integer. ( re-find #"\d+"(nth a 6))))
(def linhas (clojure.string/split-lines (slurp "catalogo.txt")))



(loop [i 0]
  (when (< i (count linhas))

    (adiciona imoveis linhas i)

    (recur (inc i))
  )

)

(def linhasAtu (clojure.string/split-lines (slurp "atual.txt")))

(loop [i 0]
  (when (< i (count linhasAtu))
    (if (== (compare (nth linhasAtu i) "i") 0) (adiciona imoveis linhasAtu (+ i 1))
    (
      if (== (compare (nth linhasAtu i) "a") 0) (
        do
          (retira imoveis (Integer. ( re-find #"\d+" (nth linhasAtu (+ i 2)) )) )
          (adiciona imoveis linhasAtu (+ i 1) )

        )(

            if (== (compare (nth linhasAtu i) "e") 0)(
                   retira imoveis (Integer. ( re-find #"\d+" (nth linhasAtu (+ i 1)) ))
            )


        )

    ))


    (recur (inc i))
  )

)
;imoveis
(def imoveis  (sort-by (juxt :preco :identificador) imoveis))
;argilosos
(def argi (filter  #( = (:solo %) "G")  imoveis))
(def argi (reverse (sort-by (juxt :area :identificador) argi )))
;casas
(def casas (filter  #( = (:tipo %) "casa") imoveis))
(def casas (filter  #( > (:area %) areaCasa) casas ) )
(def casas (filter  #( < (:preco %) precCasa) casas ) )

(def casas (sort-by (juxt :nQuartos :identificador) casas) )
(def tamA (long (/ ( * nImov (count imoveis)) 100)) )

(def listaA (list))

(
  loop [ i (- (count imoveis) tamA)  ]
    (when (< i (count imoveis))
      (def listaA (conj listaA (:identificador (nth imoveis i))) )
      ;(println (:identificador (nth imoveis i) ))
    (recur (inc i))
  )
)

(def listaA (reverse listaA))
(def stringListaA (clojure.string/join ", " listaA ))
;(println stringListaA)

(def tamB (long (/ ( * nArg (count argi)) 100)) )
(def listaB (list))
;
(
  loop [ i (- (count argi) tamB) ]
    (when (< i (count argi))
      (def listaB (conj listaB (:identificador (nth argi i))) )
    (recur (inc i))
  )
)
(def listaB (reverse listaB))
(def stringB (clojure.string/join ", " listaB ))
;(println stringB)

(def listaC (list))
(
  loop [ i 0 ]
    (when (< i (count casas))
      (def listaC (conj listaC (:identificador (nth casas i))) )
    (recur (inc i))
  )
)

(def stringC (clojure.string/join ", " listaC))
;(println stringC)
(spit "stuff.txt" "" :append false)
(spit "stuff.txt"  stringListaA :append true)
(spit "stuff.txt" "\n" :append true)
(spit "stuff.txt" stringB :append true)
(spit "stuff.txt" "\n" :append true)
(spit "stuff.txt" stringC :append true)
(spit "stuff.txt" "\n" :append true)
(def soma 0)
(
  if (> (count listaA) (- p 1) ) (if (> p 0)(def soma (+ soma (nth listaA (- p 1)) )))

)
(
  if (> (count listaB) (- j 1) ) (if (> j 0)(def soma (+ soma (nth listaB (- j 1)) )))

)

(
  if (> (count listaC) (- k 1) ) (if (> k 0)(def soma (+ soma (nth listaC (- k 1)) )))

)
(spit "result2.txt" soma :append false)
(println soma)
