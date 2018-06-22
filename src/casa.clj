(ns casa  (:gen-class) )
(defn preco [nPavi areaPavi precoMetro areaLivre livrePreco]
  (+
      (*
        (* nPavi areaPavi)
          precoMetro
      )

      (* areaLivre livrePreco)
  )
)

(defrecord casa [ tipo identificador dono nQuartos nVagas nPavi areaPavi precoMetro areaLivre livrePreco preco area] )
