(ns apartamento  (:gen-class) )
(defn preco [andar area precoPorMetro lazer nAndares]
  (
    if ( == (compare lazer "S") 0) ( * (* ( + ( / andar nAndares) 0.9 ) ( * area precoPorMetro)) 1.15 )  (* ( + ( / andar nAndares) 0.9 ) ( * area precoPorMetro))

  )
)

(defrecord apartamento [ tipo identificador dono nQuartos nVagas andar area precoPorMetro lazer nAndares  preco ] )
