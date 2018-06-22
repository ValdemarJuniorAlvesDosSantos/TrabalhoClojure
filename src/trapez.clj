(ns trapez  (:gen-class) )
(defn preco [area precoMet tipo]  (
   if ( == (compare tipo "A") 0) (*(* area precoMet) 0.9)
   (
     if ( == (compare tipo "G") 0) (*(* area precoMet) 1.3 ) (*(* area precoMet) 1.1)
   )

))
(defrecord trapez [ tipo identificador dono solo precoMet base1 base2 altura area preco] )
